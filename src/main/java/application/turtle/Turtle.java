package application.turtle;

import java.awt.Point;

import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.value.EventValue;

public final class Turtle implements MyEntity<Turtle> {

	public Turtle(final int direction, final Point coordinate) {
		this (
			new EventValue<>(direction),
			new EventValue<>(coordinate)
		);
	}
	
	public Turtle(final EventValue<Integer> direction, final EventValue<Point> coordinate) {
		this.direction = direction;
		this.coordinate = coordinate;
	}
	
	/**
	 * @param task All types of this task have the prefix 'Turtle'.
	 */
	@Override
	public void workOn(final VoidTaskOfEntity<Turtle> task) {
		task.handle(this);
	}

	/**
	 * @param task All types of this task have the prefix 'Turtle'.
	 */
	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, Turtle> task) {
		return task.handle(this);
	}
	
	final EventValue<Integer> direction;
	final EventValue<Point> coordinate;
}
