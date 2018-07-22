package application.turtle;

import java.awt.Point;

import plain.contract.entity.ReturnTaskOfEntity;

/**
 * It returns new Point object that is same as turtle's Point.
 * @author Rin
 * @version 1.0.0
 */
public final class TurtleCoordinate implements ReturnTaskOfEntity<Point, Turtle> {

	@Override
	public Point handle(final Turtle turtle) {
		return new Point(turtle.coordinate.value().x, turtle.coordinate.value().y);
	}
	
}
