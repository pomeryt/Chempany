package application.turtle;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import application.turtle.Turtle;
import application.turtle.TurtleFacing;
import application.turtle.TurtleLook;

public final class TurtleLookTest {
	@Test
	void test() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		turtle.workOn(new TurtleLook(3));
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(3));
	}
	
	@Test
	void testNegativeDirection() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		final Exception exception = assertThrows(RuntimeException.class, () -> {
			turtle.workOn(new TurtleLook(-1));
		});
		assertThat(
			exception.getMessage(), 
			new IsEqual<>("-1 is invalid direction. You must choose from the following: 0 - north, 1 - east, 2 - south, 3 - west")
		);
	}
	
	@Test
	void testInvalidPositiveDirection() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		final Exception exception = assertThrows(RuntimeException.class, () -> {
			turtle.workOn(new TurtleLook(4));
		});
		assertThat(
			exception.getMessage(), 
			new IsEqual<>("4 is invalid direction. You must choose from the following: 0 - north, 1 - east, 2 - south, 3 - west")
		);
	}
}
