package application.turtle;

import static org.hamcrest.MatcherAssert.assertThat;
import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

import application.turtle.Turtle;
import application.turtle.TurtleCoordinate;
import application.turtle.TurtleFacing;
import application.turtle.TurtleBack;

class TurtleBackTest {

	@Test
	void moveBackFacingNorthFromOrigin() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		turtle.workOn(new TurtleBack());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, 1)));
		turtle.workOn(new TurtleBack(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, 4)));
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(0));
	}
	
	@Test
	void moveBackFacingEastFromOrigin() {
		final Turtle turtle = new Turtle(1, new Point(0, 0));
		turtle.workOn(new TurtleBack());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(-1, 0)));
		turtle.workOn(new TurtleBack(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(-4, 0)));
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(1));
	}
	
	@Test
	void moveBackFacingSouthFromOrigin() {
		final Turtle turtle = new Turtle(2, new Point(0, 0));
		turtle.workOn(new TurtleBack());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, -1)));
		turtle.workOn(new TurtleBack(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(0, -4)));
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(2));
	}

	@Test
	void moveBackFacingWestFromOrigin() {
		final Turtle turtle = new Turtle(3, new Point(0, 0));
		turtle.workOn(new TurtleBack());
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(1, 0)));
		turtle.workOn(new TurtleBack(3));
		assertThat(turtle.valueOf(new TurtleCoordinate()), new IsEqual<>(new Point(4, 0)));
		assertThat(turtle.valueOf(new TurtleFacing()), new IsEqual<>(3));
	}
}
