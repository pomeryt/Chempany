package application.chunk;

import java.awt.Point;
import java.util.List;
import java.util.Map;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import plain.contract.entity.VoidTaskOfEntity;

/**
 * Graphically display specified chunk boundary on given {@link Pane}. <br>
 * If will throw {@link IllegalArgumentException} if specified chunk coordinate is not loaded yet. <br>
 * Please check {@link Chunk} class that contains {@link List} of loaded chunks.
 * @author Rin
 * @version 1.0.0
 */
public final class ChunkShowSingleChunkBoundary implements VoidTaskOfEntity<Chunk> {

	/**
	 * @param pane Boundary will be inserted into this pane.
	 * @param chunkCoord Display chunk boundary of this chunkCoord.
	 * @since 1.0.0
	 */
	public ChunkShowSingleChunkBoundary(final Pane pane, final Point chunkCoord) {
		this.pane = pane;
		this.chunkCoord = chunkCoord;
	}
	
	@Override
	public void handle(final Chunk chunk) {
		final double blockSize = chunk.blockSize;
		final double multiplier = chunk.multiplier;
		final List<Point> loadedChunks = chunk.loadedChunks;
		final Map<Point, StackPane> chunkBoundaries = chunk.chunkBoundaries;
		
		// Make sure the specified chunk has been loaded.
		if (loadedChunks.contains(this.chunkCoord) == false) {
			throw new IllegalArgumentException("Specified chunk coordinate "+this.chunkCoord+" has not been loaded.");
		}
		
		// Put boundary in the map if it has not been mapped yet.
		chunkBoundaries.computeIfAbsent(this.chunkCoord, key -> {
			final double boundarySize = blockSize * multiplier;
			final StackPane boundary = new StackPane();
			boundary.setMinSize(boundarySize, boundarySize);
			boundary.setMaxSize(boundarySize, boundarySize);
			boundary.setStyle("-fx-border-color: red");
			boundary.setTranslateX(this.chunkCoord.getX() * boundarySize);
			boundary.setTranslateY(this.chunkCoord.getY() * boundarySize);
			return boundary;
		});
		
		// Display boundary on the given pane.
		if (pane.getChildren().contains(chunkBoundaries.get(this.chunkCoord)) == false) {
			pane.getChildren().add(chunkBoundaries.get(this.chunkCoord));
		}
	}

	private final Pane pane;
	private final Point chunkCoord;
}
