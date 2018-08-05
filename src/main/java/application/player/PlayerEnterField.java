package application.player;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import plain.contract.entity.VoidTaskOfEntity;

public final class PlayerEnterField implements VoidTaskOfEntity<Player> {

	public PlayerEnterField(final Pane field) {
		this.field = field;
	}
	
	@Override
	public void handle(final Player player) {
		final Node playerBody = player.body.value();
		if (!this.field.getChildren().contains(playerBody)) {
			this.field.getChildren().add(playerBody);
		}
		
		player.spawnEvents.forEach(event -> {
			event.handle(player);
		});
	}

	private final Pane field;
}
