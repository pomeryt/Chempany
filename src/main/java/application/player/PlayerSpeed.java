package application.player;

import plain.contract.entity.ReturnTaskOfEntity;
import plain.value.EventValue;

public final class PlayerSpeed implements ReturnTaskOfEntity<Double, Player> {

	public PlayerSpeed() {
		this(new EventValue<>());
	}
	
	public PlayerSpeed(final Double speed) {
		this(new EventValue<>(speed));
	}
	
	public PlayerSpeed(final EventValue<Double> speed) {
		this.speed = speed;
	}
	
	@Override
	public Double handle(final Player player) {
		return this.speed.value(memory -> {
			if (memory.isEmpty()) {
				return player.speed.value();
			}
			return this.speed.value();
		});
	}
	
	private final EventValue<Double> speed;
}
