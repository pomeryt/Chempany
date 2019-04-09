package application.block;

import javafx.scene.layout.StackPane;

/**
 * Block.
 */
public interface BlockType {
    /**
     * Visual representation of block.
     * It's for UI rendering.
     *
     * @return Javafx pane.
     */
    StackPane body();
}
