package application.player;

import javafx.node.task.SwitchPane;
import javafx.scene.layout.Pane;
import plain.contract.entity.VoidTaskOfEntity;

public final class PlayerEnterField implements VoidTaskOfEntity<Player> {

	public PlayerEnterField(final Pane field) {
		this.field = field;
	}
	
	@Override
	public void handle(final Player player) {
		player.cachedMovingNode.value().execute(new SwitchPane(this.field));
		player.spawnEvents.forEach(event -> {
			event.handle(player);
		});
	}

	private final Pane field;
}
