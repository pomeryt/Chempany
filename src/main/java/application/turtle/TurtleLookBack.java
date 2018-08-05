package application.turtle;

import plain.contract.entity.VoidTaskOfEntity;
import plain.loop.PlainLoop;

public final class TurtleLookBack implements VoidTaskOfEntity<Turtle> {

	@Override
	public void handle(final Turtle turtle) {
		new PlainLoop(2, () -> {
			new TurtleTurnLeft().handle(turtle);
		}).repeat();
	}
	
}
