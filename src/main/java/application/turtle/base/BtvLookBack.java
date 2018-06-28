package application.turtle.base;

import application.turtle.TurtleVoidTask;
import plain.loop.PlainLoop;

public final class BtvLookBack implements TurtleVoidTask<BaseTurtle> {

	@Override
	public void handle(final BaseTurtle turtle) {
		new PlainLoop(2, () -> {
			new BtvTurnLeft().handle(turtle);
		}).repeat();
	}
	
}
