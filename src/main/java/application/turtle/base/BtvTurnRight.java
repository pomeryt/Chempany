package application.turtle.base;

import application.turtle.TurtleVoidTask;

public final class BtvTurnRight implements TurtleVoidTask<BaseTurtle> {

	@Override
	public void handle(final BaseTurtle turtle) {
		if (turtle.direction.value() == 3) {
			turtle.direction.update(0);
			return;
		}
		
		turtle.direction.update(turtle.direction.value() + 1);
	}
	
}
