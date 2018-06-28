package application.turtle.base;

import application.turtle.TurtleVoidTask;

/**
 * Move backward in the facing direction. <br>
 * You can specify how many times turtle will go backward via constructor. <br>
 * The default amount of moving backward is one. <br>
 * Moving towards north increases y value of coordinate.
 * @author Rin
 * @version 1.0.0
 */
public final class BtvBack implements TurtleVoidTask<BaseTurtle> {

	public BtvBack() {
		this(1);
	}
	
	public BtvBack(final int amount) {
		this.amount = amount;
	}
	
	@Override
	public void handle(final BaseTurtle turtle) {
		turtle.workOn(new BtvLookBack());
		turtle.workOn(new BtvForward(this.amount));
		turtle.workOn(new BtvLookBack());
	}

	private final int amount;
}
