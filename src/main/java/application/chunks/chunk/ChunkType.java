package application.chunks.chunk;

import javafx.scene.layout.GridPane;

/**
 * Interface for variable Chunk.
 */
public interface ChunkType {
    /**
     * Visual representation of chunk.
     * The body is persistent, which means the same pane will be returned if this method has already been called.
     *
     * @return JavaFX UI.
     */
    GridPane body();
}
