package application.turtle.base;

import static org.hamcrest.MatcherAssert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

public final class BtvForwardTest {
	
	@Test
	void moveNorthFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(0, new Point(0, 0));
		turtle.workOn(new BtvForward());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, 1)));
		turtle.workOn(new BtvForward(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, 4)));
	}
	
	@Test
	void moveEastFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(1, new Point(0, 0));
		turtle.workOn(new BtvForward());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(1, 0)));
		turtle.workOn(new BtvForward(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(4, 0)));
	}
	
	@Test
	void moveSouthFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(2, new Point(0, 0));
		turtle.workOn(new BtvForward());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, -1)));
		turtle.workOn(new BtvForward(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, -4)));
	}
	
	@Test
	void moveWestFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(3, new Point(0, 0));
		turtle.workOn(new BtvForward());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(-1, 0)));
		turtle.workOn(new BtvForward(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(-4, 0)));
	}
}
