package application.player;

import java.util.ArrayList;
import java.util.List;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;
import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.ParamEvent;
import plain.map.FormalMap;
import plain.value.CachedValue;
import plain.value.EventValue;

public final class Player implements MyEntity<Player> {
	
	/**
	 * @param task All types of this task have the prefix 'Player'.
	 */
	@Override
	public void workOn(final VoidTaskOfEntity<Player> task) {
		task.handle(this);
	}

	/**
	 * @param task All types of this task have the prefix 'Player'.
	 */
	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, Player> task) {
		return task.handle(this);
	}
	
	final CachedValue<Node> body = new CachedValue<>(() -> {
		final StackPane pane = new StackPane();
		
		this.actionMap.register("up", () -> {});
		this.actionMap.register("down", () -> {});
		this.actionMap.register("left", () -> {});
		this.actionMap.register("right", () -> {});
		final Timeline timeLine = new Timeline();
		final KeyFrame keyFrame = new KeyFrame(Duration.ONE, e -> {
			this.actionMap.keys().forEach(key -> {
				this.actionMap.value(key).run();
			});
		});
		timeLine.getKeyFrames().add(keyFrame);
		timeLine.setCycleCount(Animation.INDEFINITE);
		timeLine.play();
		
		pane.setMaxSize(50, 50);
		pane.setStyle("-fx-background-color: red");
		
		return pane;
	});
	final FormalMap<String, Runnable> actionMap = new FormalMap<>();
	final EventValue<Double> speed = new EventValue<>(0.5);
	final List<ParamEvent<Player>> spawnEvents = new ArrayList<>();
	final List<ParamEvent<Player>> moveEvents = new ArrayList<>();
}
