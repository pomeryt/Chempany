package application.player;

import plain.contract.entity.ReturnTaskOfEntity;

public final class PlayerSpeed implements ReturnTaskOfEntity<Double, Player> {

	@Override
	public Double handle(final Player player) {
		return player.speed.value();
	}

}
