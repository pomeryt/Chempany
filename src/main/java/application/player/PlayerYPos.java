package application.player;

import javafx.scene.Node;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.value.EventValue;

public final class PlayerYPos implements ReturnTaskOfEntity<Double, Player> {

	public PlayerYPos() {
		this(new EventValue<Node>());
	}
	
	public PlayerYPos(final Node body) {
		this.body = new EventValue<Node>(body);
	}
	
	public PlayerYPos(final EventValue<Node> body) {
		this.body = body;
	}
	
	@Override
	public Double handle(final Player player) {
		return this.body.value(memory -> {
			if (memory.isEmpty()) {
				return player.body.value();
			}
			return memory.get(0);
		}).getTranslateY();
	}
	
	private final EventValue<Node> body;
}
