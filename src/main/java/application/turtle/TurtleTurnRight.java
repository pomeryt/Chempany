package application.turtle;

import plain.contract.entity.VoidTaskOfEntity;

public final class TurtleTurnRight implements VoidTaskOfEntity<Turtle> {

	@Override
	public void handle(final Turtle turtle) {
		if (turtle.direction.value() == 3) {
			turtle.direction.update(0);
			return;
		}
		
		turtle.direction.update(turtle.direction.value() + 1);
	}
	
}
