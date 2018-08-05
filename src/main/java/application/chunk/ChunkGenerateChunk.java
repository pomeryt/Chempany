package application.chunk;

import java.awt.Point;
import java.util.List;

import plain.contract.entity.VoidTaskOfEntity;
import plain.value.EventValue;

/**
 * Record specified chunk coordinates to the loaded chunk list.
 * @author Rin
 * @version 1.0.0
 */
public final class ChunkGenerateChunk implements VoidTaskOfEntity<Chunk> {

	public ChunkGenerateChunk(final Point chunkCoordinate) {
		this(new EventValue<List<Point>>(), chunkCoordinate);
	}
	
	public ChunkGenerateChunk(final List<Point> loadedChunks, final Point chunkCoordinate) {
		this(new EventValue<List<Point>>(loadedChunks), chunkCoordinate);
	}
	
	public ChunkGenerateChunk(final EventValue<List<Point>> loadedChunks, final Point chunkCoordinate) {
		this.loadedChunks = loadedChunks;
		this.chunkCoordinate = chunkCoordinate;
	}
	
	@Override
	public void handle(final Chunk chunk) {
		final List<Point> loadedChunks = this.loadedChunks.value(memory -> {
			if (memory.isEmpty()) {
				return chunk.loadedChunks;
			}
			return memory.get(0);
		});
		
		if (!loadedChunks.contains(chunkCoordinate)) {
			loadedChunks.add(chunkCoordinate);
		}
	}
	
	private final EventValue<List<Point>> loadedChunks;
	private final Point chunkCoordinate;
}
