package application.utility.pattern;

import java.awt.Point;

import application.turtle.Turtle;
import application.turtle.TurtleForward;
import application.turtle.TurtleTurnLeft;
import plain.contract.task.VoidTask;

/**
 * Tornado pattern in counter clock-wise. <br>
 * The starts from center facing east. <br>
 * It uses BaseTurtle to make pattern. <br>
 * You can execute something with turtle in each movement. <br>
 * The direction of coordinate system is same as computer screen.
 * @author Rin
 * @version 1.0.0
 */
public final class TornadoPattern {
	public TornadoPattern(final int size, final Point initialCoord, final VoidTask<Turtle> taskOfTurtle) {
		this.initialCoord = initialCoord;
		this.size = size;
		this.taskOfTurtle = taskOfTurtle;
	}
	
	public void makePattern() {
		// Summon turtle.
		final Turtle turtle = new Turtle(
			1, new Point(
				this.initialCoord.x,
				this.initialCoord.y
			)
		);
		
		// Start to make pattern.
		this.taskOfTurtle.handle(turtle);
		for (int x = 1; x < this.size; x++) {
			for (int i = 0; i < 2; i++) {
				for (int k = 0; k < x; k++) {
					turtle.workOn(new TurtleForward());
					this.taskOfTurtle.handle(turtle);
				}
				turtle.workOn(new TurtleTurnLeft());
			}
		}
		
		// Last line.
		for (int x = 0; x < this.size - 1; x++) {
			turtle.workOn(new TurtleForward());
			this.taskOfTurtle.handle(turtle);
		}
	}
	
	private final Point initialCoord;
	private final int size;
	private final VoidTask<Turtle> taskOfTurtle;
}
