package application.turtle.base;

import application.turtle.TurtleVoidTask;

public final class BtvTurnLeft implements TurtleVoidTask<BaseTurtle> {

	@Override
	public void handle(final BaseTurtle turtle) {
		if (turtle.direction.value() == 0) {
			turtle.direction.update(3);
			return;
		}
		
		turtle.direction.update(turtle.direction.value() - 1);
	}

}
