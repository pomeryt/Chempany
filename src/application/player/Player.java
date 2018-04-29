package application.player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import application.page.component.EventScene;
import javafx.node.MovingNode;
import javafx.node.task.SwitchPane;
import javafx.node.task.movement.Down2DWithCamera;
import javafx.node.task.movement.Left2DWithCamera;
import javafx.node.task.movement.Right2DWithCamera;
import javafx.node.task.movement.Up2DWithCamera;
import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import plain.map.FlagMap;
import plain.map.FormalMap;
import plain.map.task.ConditionalRunForMap;
import plain.validation.map.IsAllFalseInMap;

public final class Player {
	public Player(final FlagMap<String, FormalMap<String, Boolean>> flagMap) {
		this.flagMap = flagMap;
	}
	
	public void spawn(final EventScene eventScene, final Pane field) {
		this.body().execute(new SwitchPane(field));
		
		eventScene.workWithScene(scene -> {
			scene.setCamera(this.camera);
		});

		// Move.
		eventScene.addKeyPressedEvent(keyEvent -> {
			final Runnable runnable = () -> {
				// Go up.
				if (keyEvent.getCode().equals(KeyCode.W)) {
					this.body().move(new Up2DWithCamera(this.camera, this.speed));
					return;
				}

				// Go down.
				if (keyEvent.getCode().equals(KeyCode.S)) {
					this.body().move(new Down2DWithCamera(this.camera, this.speed));
					return;
				}

				// Go left.
				if (keyEvent.getCode().equals(KeyCode.A)) {
					this.body().move(new Left2DWithCamera(this.camera, this.speed));
					return;
				}

				// Go right.
				if (keyEvent.getCode().equals(KeyCode.D)) {
					this.body().move(new Right2DWithCamera(this.camera, this.speed));
					return;
				}
			};
			
			this.flagMap.run(new ConditionalRunForMap<>(runnable, new IsAllFalseInMap<>(Arrays.asList("esc"))));
		});
		
		// Stop.
		eventScene.addKeyReleasedEvent(keyEvent -> {
			// Go up.
			if (keyEvent.getCode().equals(KeyCode.W)) {
				this.body().move(new Up2DWithCamera(this.camera, 0));
				return;
			}

			// Go down.
			if (keyEvent.getCode().equals(KeyCode.S)) {
				this.body().move(new Down2DWithCamera(this.camera, 0));
				return;
			}

			// Go left.
			if (keyEvent.getCode().equals(KeyCode.A)) {
				this.body().move(new Left2DWithCamera(this.camera, 0));
				return;
			}

			// Go right.
			if (keyEvent.getCode().equals(KeyCode.D)) {
				this.body().move(new Right2DWithCamera(this.camera, 0));
				return;
			}
		});

		// Zoom in/out.
		eventScene.addScrollEvent(scroll -> {
			this.camera.setTranslateZ(this.camera.getTranslateZ()+scroll.getDeltaY());
		});
	}
	
	private MovingNode body() {
		if (this.cache.isEmpty() == false) {
			return this.cache.get(0);
		}
		
		final StackPane pane = new StackPane();
		pane.setMaxSize(50, 50);
		pane.setStyle("-fx-background-color: red");
		
		final MovingNode movingNode = new MovingNode(pane);
		
		this.cache.add(movingNode);
		
		return this.cache.get(0);
	}
	
	private final double speed = 0.5;
	private final List<MovingNode> cache = new ArrayList<>();
	private final Camera camera = new PerspectiveCamera();
	private final FlagMap<String, FormalMap<String, Boolean>> flagMap;
}
