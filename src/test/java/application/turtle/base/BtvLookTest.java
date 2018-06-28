package application.turtle.base;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

public final class BtvLookTest {
	@Test
	void test() {
		final BaseTurtle turtle = new BaseTurtle(0, new Point(0, 0));
		turtle.workOn(new BtvLook(3));
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(3));
	}
	
	@Test
	void testNegativeDirection() {
		final BaseTurtle turtle = new BaseTurtle(0, new Point(0, 0));
		final Exception exception = assertThrows(RuntimeException.class, () -> {
			turtle.workOn(new BtvLook(-1));
		});
		assertThat(
			exception.getMessage(), 
			new IsEqual<>("-1 is invalid direction. You must choose from the following: 0 - north, 1 - east, 2 - south, 3 - west")
		);
	}
	
	@Test
	void testInvalidPositiveDirection() {
		final BaseTurtle turtle = new BaseTurtle(0, new Point(0, 0));
		final Exception exception = assertThrows(RuntimeException.class, () -> {
			turtle.workOn(new BtvLook(4));
		});
		assertThat(
			exception.getMessage(), 
			new IsEqual<>("4 is invalid direction. You must choose from the following: 0 - north, 1 - east, 2 - south, 3 - west")
		);
	}
}
