package application.chunk;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

class ChunkGenerateChunkTest {

	@Test
	void testGenerateNewChunk() {
		final List<Point> loadedChunks = new ArrayList<>();
		this.generateChunk(loadedChunks, new Point(0, 0)).handle(this.dummyChunk());
		final List<Point> expectedChunks = new ArrayList<>();
		expectedChunks.add(new Point(0, 0));
		MatcherAssert.assertThat(loadedChunks, CoreMatchers.equalTo(expectedChunks));
	}
	
	@Test
	void testGenerateDuplicatedChunk() {
		final List<Point> loadedChunks = new ArrayList<>();
		loadedChunks.add(new Point(0, 0));
		this.generateChunk(loadedChunks, new Point(0, 0));
		final List<Point> expectedChunks = new ArrayList<>();
		expectedChunks.add(new Point(0, 0));
		MatcherAssert.assertThat(loadedChunks, CoreMatchers.equalTo(expectedChunks));
	}
	
	private ChunkGenerateChunk generateChunk(final List<Point> loadedChunks, final Point newChunk) {
		return new ChunkGenerateChunk(loadedChunks, newChunk);
	}
	
	private Chunk dummyChunk() {
		return new Chunk();
	}
	
}
