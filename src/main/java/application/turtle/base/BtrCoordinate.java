package application.turtle.base;

import java.awt.Point;

import application.turtle.TurtleReturnTask;

/**
 * It returns new Point object that is same as turtle's Point.
 * @author Rin
 * @version 1.0.0
 */
public final class BtrCoordinate implements TurtleReturnTask<Point, BaseTurtle> {

	@Override
	public Point handle(final BaseTurtle turtle) {
		return new Point(turtle.coordinate.value().x, turtle.coordinate.value().y);
	}
	
}
