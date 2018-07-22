package application.player;

import plain.contract.entity.ReturnTaskOfEntity;
import plain.value.EventValue;

public final class PlayerXPos implements ReturnTaskOfEntity<Double, Player> {

	@Override
	public Double handle(final Player player) {
		final EventValue<Double> xPos = new EventValue<>();
		player.cachedMovingNode.value().execute(node -> {
			xPos.update(node.getTranslateX());
		});
		return xPos.value();
	}

}
