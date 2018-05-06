package application.map;

import static org.junit.Assert.assertThat;

import java.awt.Point;

import org.hamcrest.core.IsEqual;
import org.junit.jupiter.api.Test;

class MainMapTest {

	@Test
	void testCurrentChunkCoordOfUser() {
		final double blockSize = 50;
		final double multiplier = 20;
		final MainMap mainMap = new MainMap(blockSize, multiplier);
		
		assertThat(mainMap.currentChunkCoordOfUser(0, 0), new IsEqual<>(new Point(0, 0)));
		assertThat(mainMap.currentChunkCoordOfUser(1000, 999.9), new IsEqual<>(new Point(1, 0)));
		assertThat(mainMap.currentChunkCoordOfUser(-0.1, -1000), new IsEqual<>(new Point(-1, -1)));
	}

}
