package application.turtle.base;

import java.awt.Point;

import application.turtle.Turtle;
import application.turtle.TurtleReturnTask;
import application.turtle.TurtleVoidTask;
import plain.value.EventValue;

public final class BaseTurtle implements Turtle<BaseTurtle> {

	public BaseTurtle(final int direction, final Point coordinate) {
		this (
			new EventValue<>(direction),
			new EventValue<>(coordinate)
		);
	}
	
	public BaseTurtle(final EventValue<Integer> direction, final EventValue<Point> coordinate) {
		this.direction = direction;
		this.coordinate = coordinate;
	}
	
	/**
	 * @param task All types of this task have the prefix 'Btv'.
	 */
	@Override
	public void workOn(final TurtleVoidTask<BaseTurtle> task) {
		task.handle(this);
	}

	/**
	 * @param task All types of this task have the prefix 'Btr'.
	 */
	@Override
	public <T> T valueOf(final TurtleReturnTask<T, BaseTurtle> task) {
		return task.handle(this);
	}
	
	final EventValue<Integer> direction;
	final EventValue<Point> coordinate;
}
