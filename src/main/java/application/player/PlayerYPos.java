package application.player;

import plain.contract.entity.ReturnTaskOfEntity;
import plain.value.EventValue;

public final class PlayerYPos implements ReturnTaskOfEntity<Double, Player> {

	@Override
	public Double handle(final Player player) {
		final EventValue<Double> yPos = new EventValue<>();
		player.cachedMovingNode.value().execute(node -> {
			yPos.update(node.getTranslateY());
		});
		return yPos.value();
	}

}
