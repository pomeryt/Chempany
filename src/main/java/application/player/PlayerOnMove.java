package application.player;

import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.ParamEvent;

public final class PlayerOnMove implements VoidTaskOfEntity<Player> {

	@SafeVarargs
	public PlayerOnMove(final ParamEvent<Player>...events) {
		this.events = events;
	}
	
	@Override
	public void handle(final Player player) {
		for (ParamEvent<Player> event: this.events) {
			player.moveEvents.add(event);
		}
	}
	
	private final ParamEvent<Player>[] events;
}
