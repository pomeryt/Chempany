package application.chunk;

import java.awt.Point;
import java.util.List;

import javafx.scene.layout.Pane;
import plain.contract.entity.VoidTaskOfEntity;

/**
 * Graphically display chunk all loaded boundaries on given {@link Pane}.
 * @author Rin
 * @version 1.0.0
 */
public final class ChunkShowChunkBoundaries implements VoidTaskOfEntity<Chunk> {

	public ChunkShowChunkBoundaries(final Pane pane) {
		this.pane = pane;
	}
	
	@Override
	public void handle(final Chunk chunk) {
		final List<Point> loadedChunks = chunk.loadedChunks;
		loadedChunks.forEach(chunkCoord -> {
			new ChunkShowSingleChunkBoundary(pane, chunkCoord).handle(chunk);
		});
	}
	
	private final Pane pane;
}
