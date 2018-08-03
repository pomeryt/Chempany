package application.chunk;

import java.awt.Point;

import plain.contract.entity.VoidTaskOfEntity;

/**
 * Generate blocks in the specified chunk.
 * @author Rin
 * @version 1.0.0
 */
public final class ChunkGenerateChunk implements VoidTaskOfEntity<Chunk> {

	public ChunkGenerateChunk(final Point chunkCoordinate) {
		this.chunkCoordinate = chunkCoordinate;
	}
	
	@Override
	public void handle(final Chunk chunk) {
		
	}
	
	private final Point chunkCoordinate;
}
