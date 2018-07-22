package application.player;

import java.util.ArrayList;
import java.util.List;

import javafx.node.MovingNode;
import javafx.scene.layout.StackPane;
import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.ParamEvent;
import plain.map.FlagMap;
import plain.map.FormalMap;
import plain.value.CachedValue;
import plain.value.EventValue;

public final class Player implements MyEntity<Player> {

	public Player(final FlagMap<String, FormalMap<String, Boolean>> flagMap) {
		this.flagMap = flagMap;
	}

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
	
	final FlagMap<String, FormalMap<String, Boolean>> flagMap;
	
	final CachedValue<MovingNode> cachedMovingNode = new CachedValue<>(() -> {
		final StackPane pane = new StackPane();
		pane.setMaxSize(50, 50);
		pane.setStyle("-fx-background-color: red");
		
		final MovingNode movingNode = new MovingNode(pane);
		
		return movingNode;
	});
	
	final EventValue<Double> speed = new EventValue<>(0.5);
	final List<ParamEvent<Player>> spawnEvents = new ArrayList<>();
	final List<ParamEvent<Player>> moveEvents = new ArrayList<>();
}
