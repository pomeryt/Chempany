package application.turtle;

import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import application.turtle.Turtle;
import application.turtle.TurtleFacing;
import application.turtle.TurtleTurnLeft;

public final class TurtleTurnLeftTest {
	@Test
	void testEastToNorth() {
		final Turtle turtle = new Turtle(1, new Point(0, 0));
		turtle.workOn(new TurtleTurnLeft());
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(0));
	}
	
	@Test
	void testNorthToWest() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		turtle.workOn(new TurtleTurnLeft());
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(3));
	}
}
