package application.turtle;

import plain.contract.entity.ReturnTaskOfEntity;

/**
 * It returns new Integer object that is same as turtle's facing.
 * @author Rin
 * @version 1.0.0
 */
public final class TurtleFacing implements ReturnTaskOfEntity<Integer, Turtle> {

	@Override
	public Integer handle(final Turtle turtle) {
		return Integer.valueOf(turtle.direction.value());
	}

}
