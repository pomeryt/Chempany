package application.utility.point;

import java.awt.Point;

import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

class ChunkPointOfPlayerTest {

	@Test
	void test() {
		final double blockSize = 50;
		final double multiplier = 20;
		
		MatcherAssert.assertThat(
			new ChunkPointOfPlayer(0, 0, blockSize, multiplier).value(), 
			new IsEqual<Point>(new Point(0, 0))
		);
		
		MatcherAssert.assertThat(
			new ChunkPointOfPlayer(1000, 999.9, blockSize, multiplier).value(), 
			new IsEqual<Point>(new Point(1, 0))
		);
		
		MatcherAssert.assertThat(
			new ChunkPointOfPlayer(-0.1, -1000, blockSize, multiplier).value(), 
			new IsEqual<Point>(new Point(-1, -1))
		);
	}

}
