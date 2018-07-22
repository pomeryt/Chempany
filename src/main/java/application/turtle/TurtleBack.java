package application.turtle;

import plain.contract.entity.VoidTaskOfEntity;

/**
 * Move backward in the facing direction. <br>
 * You can specify how many times turtle will go backward via constructor. <br>
 * The default amount of moving backward is one. <br>
 * Moving towards north increases y value of coordinate.
 * @author Rin
 * @version 1.0.0
 */
public final class TurtleBack implements VoidTaskOfEntity<Turtle> {

	public TurtleBack() {
		this(1);
	}
	
	public TurtleBack(final int amount) {
		this.amount = amount;
	}
	
	@Override
	public void handle(final Turtle turtle) {
		turtle.workOn(new TurtleLookBack());
		turtle.workOn(new TurtleForward(this.amount));
		turtle.workOn(new TurtleLookBack());
	}

	private final int amount;
}
