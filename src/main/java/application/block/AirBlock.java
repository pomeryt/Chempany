package application.block;

import javafx.scene.layout.StackPane;

/**
 * Air block.
 * It means there is no physical block.
 */
public final class AirBlock implements BlockType {
    @Override
    public StackPane body() {
        final double size = 50;

        final StackPane root = new StackPane();
        root.setId("root");
        root.setMinSize(size, size);
        root.setMaxSize(size, size);
        root.setStyle("-fx-background-color: lightBlue;");

        return root;
    }
}
