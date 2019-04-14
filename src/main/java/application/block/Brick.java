package application.block;

import javafx.scene.layout.StackPane;

/**
 * A generic physical block for prototyping.
 */
public final class Brick implements BlockType {
    @Override
    public StackPane body() {
        final double size = 50;

        final StackPane root = new StackPane();
        root.setMinSize(size, size);
        root.setMaxSize(size, size);
        root.setStyle("-fx-background-color: #450a06");

        return root;
    }
}
