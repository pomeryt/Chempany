package application.player;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.value.EventValue;

public final class PlayerXPos implements ReturnTaskOfEntity<Double, Player> {

	public PlayerXPos() {
		this(new EventValue<Node>());
	}
	
	public PlayerXPos(final Pane body) {
		this.body = new EventValue<Node>(body);
	}
	
	public PlayerXPos(final EventValue<Node> body) {
		this.body = body;
	}
	
	@Override
	public Double handle(final Player player) {
		return this.body.value(memory -> {
			if (memory.isEmpty()) {
				return player.body.value();
			}
			return memory.get(0);
		}).getTranslateX();
	}
	
	private final EventValue<Node> body;

}
