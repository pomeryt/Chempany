package application.turtle.base;

import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

public final class BtvLookBackTest {
	
	@Test
	void testNorthToSouth() {
		final BaseTurtle turtle = new BaseTurtle(0, new Point(0, 0));
		turtle.workOn(new BtvLookBack());
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(2));
	}
	
	@Test
	void testEastToWest() {
		final BaseTurtle turtle = new BaseTurtle(1, new Point(0, 0));
		turtle.workOn(new BtvLookBack());
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(3));
	}
}
