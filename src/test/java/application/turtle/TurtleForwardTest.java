package application.turtle;

import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import application.turtle.Turtle;
import application.turtle.TurtleCoordinate;
import application.turtle.TurtleForward;

public final class TurtleForwardTest {
	
	@Test
	void moveNorthFromOrigin() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		turtle.workOn(new TurtleForward());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, -1)));
		turtle.workOn(new TurtleForward(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, -4)));
	}
	
	@Test
	void moveEastFromOrigin() {
		final Turtle turtle = new Turtle(1, new Point(0, 0));
		turtle.workOn(new TurtleForward());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(1, 0)));
		turtle.workOn(new TurtleForward(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(4, 0)));
	}
	
	@Test
	void moveSouthFromOrigin() {
		final Turtle turtle = new Turtle(2, new Point(0, 0));
		turtle.workOn(new TurtleForward());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, 1)));
		turtle.workOn(new TurtleForward(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, 4)));
	}
	
	@Test
	void moveWestFromOrigin() {
		final Turtle turtle = new Turtle(3, new Point(0, 0));
		turtle.workOn(new TurtleForward());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(-1, 0)));
		turtle.workOn(new TurtleForward(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(-4, 0)));
	}
}
