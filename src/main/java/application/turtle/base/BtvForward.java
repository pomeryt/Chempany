package application.turtle.base;

import java.awt.Point;

import application.turtle.TurtleVoidTask;
import plain.loop.PlainLoop;
import plain.value.EventValue;

/**
 * Move forward in the facing direction. <br>
 * You can specify how many times turtle will go forward via constructor. <br>
 * The default amount of moving forward is one. <br>
 * Moving towards north increases y value of coordinate.
 * @author Rin
 * @version 1.0.0
 */
public final class BtvForward implements TurtleVoidTask<BaseTurtle> {

	public BtvForward() {
		this(1);
	}
	
	public BtvForward(final int amount) {
		this.amount = amount;
	}
	
	@Override
	public void handle(final BaseTurtle turtle) {
		new PlainLoop(this.amount, () -> {
			this.move(turtle.direction, turtle.coordinate);
		}).repeat();
	}
	
	private void move(final EventValue<Integer> direction, final EventValue<Point> coordinate) {
		// North.
		if (direction.value() == 0) {
			coordinate.value().translate(0, 1);
			return;
		}

		// East.
		if (direction.value() == 1) {
			coordinate.value().translate(1, 0);
			return;
		}

		// South.
		if (direction.value() == 2) {
			coordinate.value().translate(0, -1);
			return;
		}

		// West.
		if (direction.value() == 3) {
			coordinate.value().translate(-1, 0);
			return;
		}
	}

	private final int amount;
}
