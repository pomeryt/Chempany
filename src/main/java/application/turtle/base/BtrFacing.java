package application.turtle.base;

import application.turtle.TurtleReturnTask;

/**
 * It returns new Integer object that is same as turtle's facing.
 * @author Rin
 * @version 1.0.0
 */
public final class BtrFacing implements TurtleReturnTask<Integer, BaseTurtle> {

	@Override
	public Integer handle(final BaseTurtle turtle) {
		return Integer.valueOf(turtle.direction.value());
	}

}
