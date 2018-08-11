package application.chunk;

import java.awt.Point;
import java.util.Map;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import plain.contract.entity.VoidTaskOfEntity;

public final class ChunkHideChunkBoundaries implements VoidTaskOfEntity<Chunk> {

	public ChunkHideChunkBoundaries(final Pane pane) {
		this.pane = pane;
	}
	
	@Override
	public void handle(final Chunk chunk) {
		final Map<Point, StackPane> boundaries = chunk.chunkBoundaries;
		boundaries.forEach((key, value) -> {
			if (pane.getChildren().contains(value)) {
				pane.getChildren().remove(value);
			}
		});
	}
	
	private final Pane pane;
}
