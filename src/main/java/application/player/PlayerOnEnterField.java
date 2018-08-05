package application.player;

import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.ParamEvent;

public final class PlayerOnEnterField implements VoidTaskOfEntity<Player> {

	@SafeVarargs
	public PlayerOnEnterField(final ParamEvent<Player>... events) {
		this.events = events;
	}
	
	@Override
	public void handle(final Player player) {
		for (ParamEvent<Player> event: this.events) {
			player.spawnEvents.add(event);
		}
	}

	private final ParamEvent<Player>[] events;
}
