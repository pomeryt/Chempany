package application.turtle;

import plain.contract.entity.VoidTaskOfEntity;

public final class TurtleTurnLeft implements VoidTaskOfEntity<Turtle> {

	@Override
	public void handle(final Turtle turtle) {
		if (turtle.direction.value() == 0) {
			turtle.direction.update(3);
			return;
		}
		
		turtle.direction.update(turtle.direction.value() - 1);
	}

}
