package application.event.plain;

import application.player.Player;
import application.player.PlayerEnterField;
import javafx.scene.layout.Pane;
import plain.contract.event.PlainEvent;

public final class SpawnPlayerToField implements PlainEvent {

	public SpawnPlayerToField(final Player player, final Pane field) {
		this.player = player;
		this.field = field;
	}
	
	@Override
	public void handle() {
		this.player.workOn(new PlayerEnterField(this.field));
	}
	
	private final Player player;
	private final Pane field;
}
