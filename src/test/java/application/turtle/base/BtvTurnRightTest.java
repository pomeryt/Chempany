package application.turtle.base;

import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import application.turtle.base.BtvTurnRight;

public final class BtvTurnRightTest {
	@Test
	void testNorthToEast() {
		final BaseTurtle turtle = new BaseTurtle(0, new Point(0, 0));
		turtle.workOn(new BtvTurnRight());
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(1));
	}
	
	@Test
	void testWestToNorth() {
		final BaseTurtle turtle = new BaseTurtle(3, new Point(0, 0));
		turtle.workOn(new BtvTurnRight());
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(0));
	}
}
