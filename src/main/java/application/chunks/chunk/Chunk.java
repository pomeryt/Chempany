package application.chunks.chunk;

import application.block.AirBlock;
import application.block.BlockType;
import application.block.Brick;
import javafx.scene.layout.GridPane;

import java.util.Random;

/**
 * Single chunk that contains ({@link Chunk#rowAmount})^2 blocks.
 */
public final class Chunk implements ChunkType {

    /**
     * Primary constructor.
     *
     * @param rowAmount Info at {@link Chunk#rowAmount}.
     */
    public Chunk(final int rowAmount) {
        this.rowAmount = rowAmount;
    }

    /**
     * Visual representation of chunk.
     * The body is persistent, which means the same pane will be returned if this method has already been called.
     *
     * @return JavaFX UI.
     */
    @Override
    public GridPane body() {
        if (this.grid.getChildren().size() > 0) {
            return this.grid;
        }

        this.grid.setMaxSize(0, 0);
        this.grid.setStyle("-fx-border-color: blue;");
        this.grid.setId("chunkGrid");

        for (int y = 0; y < this.rowAmount; y++) {
            for (int x = 0; x < this.rowAmount; x++) {
                this.grid.add(this.blockByRandom().body(), x, y);
            }
        }

        return this.grid;
    }

    /**
     * Generate a block at random.
     * It generates 10% {@link Brick} and 90% {@link AirBlock} for prototyping.
     *
     * @return New random block.
     */
    private BlockType blockByRandom() {
        final int randomBound = 11;
        final int airProbability = 9;
        if (new Random().nextInt(randomBound) > airProbability) {
            return new Brick();
        }

        return new AirBlock();
    }

    /**
     * Number of rows.
     * That means this contains (this value)^2 blocks.
     * We assume all chunks are square.
     * This value will be used to generate chunks.
     */
    private final int rowAmount;

    /**
     * Root pane containing all blocks.
     */
    private final GridPane grid = new GridPane();
}
