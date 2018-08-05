package application.utility.point;

import java.awt.Point;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

class FirstPointOfChunkTest {

	@Test
	void testOrigin() {
		MatcherAssert.assertThat(
			new FirstPointOfChunk(new Point(0, 0), 20).value(), 
			CoreMatchers.equalTo(new Point(0, 0))
		);
	}

	@Test
	void testPositiveCoord() {
		MatcherAssert.assertThat(
			new FirstPointOfChunk(new Point(1, 1), 20).value(), 
			CoreMatchers.equalTo(new Point(20, 20))
		);
	}
	
	@Test
	void testNegativeCoord() {
		MatcherAssert.assertThat(
			new FirstPointOfChunk(new Point(-1, -1), 20).value(), 
			CoreMatchers.equalTo(new Point(-20, -20))
		);
	}
	
}
