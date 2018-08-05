package application.turtle;

import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import application.turtle.Turtle;
import application.turtle.TurtleFacing;
import application.turtle.TurtleTurnRight;

public final class TurtleTurnRightTest {
	@Test
	void testNorthToEast() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		turtle.workOn(new TurtleTurnRight());
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(1));
	}
	
	@Test
	void testWestToNorth() {
		final Turtle turtle = new Turtle(3, new Point(0, 0));
		turtle.workOn(new TurtleTurnRight());
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(0));
	}
}
