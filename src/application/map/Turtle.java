package application.map;

import java.awt.Point;

import plain.value.EventValue;

/**
 * Created to calculate coordinate. <br>
 * Direction (facing): 0 - North, 1 - East, 2 - South, 3 - West. <br>
 * It uses java.awt.Point to express coordinate.
 * @author Rin
 * @version 1.0.0
 */
public final class Turtle {
	
	public Turtle(final int direction, final Point coordinate) {
		this(new EventValue<>(direction), coordinate);
	}
	
	private Turtle(final EventValue<Integer> direction, final Point coordinate) {
		this.direction = direction;
		this.coordinate = coordinate;
	}
	
	public int facing() {
		return this.direction.value();
	}
	
	
	public void turnLeft() {
		if (this.direction.value() == 0) {
			this.direction.update(3);
			return;
		}
		
		this.direction.update(this.direction.value() - 1);
	}
	
	public void turnLeft(final int repeat) {
		for (int x = 0; x < repeat; x++) {
			this.turnLeft();
		}
	}
	
	public void turnRight() {
		if (this.direction.value() == 3) {
			this.direction.update(0);
			return;
		}
		
		this.direction.update(this.direction.value() + 1);
	}
	
	public void turnRight(final int repeat) {
		for (int x = 0; x < repeat; x++) {
			this.turnRight();
		}
	}
	
	public void go() {
		// North.
		if (this.direction.value() == 0) {
			this.coordinate.translate(0, 1);
			return;
		}
		
		// East.
		if (this.direction.value() == 1) {
			this.coordinate.translate(1, 0);
			return;
		}
		
		// South.
		if (this.direction.value() == 2) {
			this.coordinate.translate(0, -1);
			return;
		}
		
		// West.
		if (this.direction.value() == 3) {
			this.coordinate.translate(-1, 0);
			return;
		}
	}
	
	public void go(final int amount) {
		for (int x = 0; x < amount; x++) {
			this.go();
		}
	}
	
	public void back() {
		this.turnLeft(2);
		this.go();
		this.turnLeft(2);
	}
	
	public void back(final int amount) {
		this.turnLeft(2);
		this.go(amount);
		this.turnLeft(2);
	}
	
	public Point coordinate() {
		return new Point(this.coordinate.x, this.coordinate.y);
	}
	
	private final EventValue<Integer> direction;
	private final Point coordinate;
}
