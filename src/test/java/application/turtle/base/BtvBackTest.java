package application.turtle.base;

import static org.hamcrest.MatcherAssert.assertThat;
import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

class BtvBackTest {

	@Test
	void moveBackFacingNorthFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(0, new Point(0, 0));
		turtle.workOn(new BtvBack());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, -1)));
		turtle.workOn(new BtvBack(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, -4)));
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(0));
	}
	
	@Test
	void moveBackFacingEastFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(1, new Point(0, 0));
		turtle.workOn(new BtvBack());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(-1, 0)));
		turtle.workOn(new BtvBack(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(-4, 0)));
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(1));
	}
	
	@Test
	void moveBackFacingSouthFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(2, new Point(0, 0));
		turtle.workOn(new BtvBack());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, 1)));
		turtle.workOn(new BtvBack(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(0, 4)));
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(2));
	}

	@Test
	void moveBackFacingWestFromOrigin() {
		final BaseTurtle turtle = new BaseTurtle(3, new Point(0, 0));
		turtle.workOn(new BtvBack());
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(1, 0)));
		turtle.workOn(new BtvBack(3));
		assertThat(turtle.valueOf(new BtrCoordinate()), new IsEqual<>(new Point(4, 0)));
		assertThat(turtle.valueOf(new BtrFacing()), new IsEqual<>(3));
	}
}
