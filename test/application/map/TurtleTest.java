package application.map;

import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

class TurtleTest {

	@Test
	void testFacing() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		assertThat(turtle.facing(), new IsEqual<>(0));
	}

	@Test
	void testTurnLeft() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		
		// From north to west.
		turtle.turnLeft();
		assertThat(turtle.facing(), new IsEqual<>(3));
		
		// From west to rest.
		for (int x = 2; x > -1; x--) {
			turtle.turnLeft();
			assertThat(turtle.facing(), new IsEqual<>(x));
		}
	}

	@Test
	void testTurnLeftInt() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		
		turtle.turnLeft(2);
		assertThat(turtle.facing(), new IsEqual<>(2));
	}

	@Test
	void testTurnRight() {
		final Turtle turtle = new Turtle(3, new Point(0, 0));
		
		// From west to north.
		turtle.turnRight();
		assertThat(turtle.facing(), new IsEqual<>(0));
		
		// From north to rest.
		for (int x = 1; x < 4; x++) {
			turtle.turnRight();
			assertThat(turtle.facing(), new IsEqual<>(x));
		}
	}

	@Test
	void testTurnRightInt() {
		final Turtle turtle = new Turtle(3, new Point(0, 0));
		
		turtle.turnRight(2);
		assertThat(turtle.facing(), new IsEqual<>(1));
	}

	@Test
	void testGo() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		
		// Go north.
		turtle.go();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(0, 1)));
		
		// Go west.
		turtle.turnLeft();
		turtle.go();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(-1, 1)));
		
		// Go south.
		turtle.turnLeft();
		turtle.go();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(-1, 0)));
		
		// Go east.
		turtle.turnLeft();
		turtle.go();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(0, 0)));
	}

	@Test
	void testGoInt() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		
		turtle.go(3);
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(0, 3)));
	}

	@Test
	void testBack() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));

		// Back while facing north.
		turtle.back();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(0, -1)));
		
		// Back while facing west.
		turtle.turnLeft();
		turtle.back();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(1, -1)));
		
		// Back while facing south.
		turtle.turnLeft();
		turtle.back();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(1, 0)));
		
		// Back while facing east.
		turtle.turnLeft();
		turtle.back();
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(0, 0)));
	}

	@Test
	void testBackInt() {
		final Turtle turtle = new Turtle(0, new Point(0, 0));
		
		turtle.back(3);
		assertThat(turtle.coordinate(), new IsEqual<>(new Point(0, -3)));
	}

}
