package application.chunks.chunk;

import javafx.scene.layout.GridPane;

/**
 * Single chunk that contains {@link application.block.BlockType} objects.
 * This will be used by {@link application.chunks.Chunks}.
 */
public interface ChunkType {
    /**
     * Visual representation of chunk.
     *
     * @return JavaFX UI.
     */
    GridPane body();
}
