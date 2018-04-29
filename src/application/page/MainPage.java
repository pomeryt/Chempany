package application.page;

import java.util.ArrayList;
import java.util.List;

import application.page.component.EscScreen;
import application.page.component.EventScene;
import application.player.Player;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import plain.map.FlagMap;
import plain.map.FormalMap;

public final class MainPage {

	public MainPage(final Stage stage, final Player player, final FlagMap<String, FormalMap<String, Boolean>> flagMap) {
		this(stage, player, new EscScreen(flagMap));
	}
	
	public MainPage(final Stage stage, final Player player, final EscScreen escScreen) {
		this.stage = stage;
		this.player = player;
		this.escScreen = escScreen;
	}
	
	public void display() {
		this.eventScene().workWithScene(scene -> {
			this.stage.setScene(scene);
		});
		this.player.spawn(this.eventScene(), this.root());
	}
	
	private Pane root() {
		if (this.cachedRoot.isEmpty() == false) {
			return this.cachedRoot.get(0);
		}
		
		// Test.
		final StackPane block = new StackPane();
		block.setMaxSize(150, 150);
		block.setStyle("-fx-border-color: blue");
		
		final StackPane root = new StackPane();
		root.getChildren().add(block);
		
		this.cachedRoot.add(root);
		return cachedRoot.get(0);
	}
	
	private EventScene eventScene() {
		if(this.cachedScene.isEmpty() == false) {
			return this.cachedScene.get(0);
		}
		
		final Scene scene = new Scene(this.root());
		
		final EventScene eventScene = new EventScene(scene);
		eventScene.addKeyPressedEvent(keyEvent -> {
			if(keyEvent.getCode().equals(KeyCode.ESCAPE)) {
				// Move Options to camera.
				this.escScreen.workWithPane(pane -> {
					pane.setTranslateX(scene.getCamera().getTranslateX());
					pane.setTranslateY(scene.getCamera().getTranslateY());
				});
				
				// Display Options.
				this.escScreen.toggleEsc(this.root());
			}
		});
		
		this.cachedScene.add(eventScene);
		
		return this.cachedScene.get(0);
	}
	
	private final Stage stage;
	private final Player player;
	private final EscScreen escScreen;
	private final List<Pane> cachedRoot = new ArrayList<>();
	private final List<EventScene> cachedScene = new ArrayList<>();
}
