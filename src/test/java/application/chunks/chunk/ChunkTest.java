package application.chunks.chunk;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Tests.
 */
@ExtendWith(ApplicationExtension.class)
final class ChunkTest {

    /**
     * Start JavaFX thread.
     * @param stage TestFX will provide this.
     */
    @Start
    public void start(final Stage stage) {
        final StackPane root = new StackPane(new Chunk(ROW_AMOUNT).body());
        final Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * The total number of blocks in one chunk should be ({@link ChunkTest#ROW_AMOUNT})^2.
     * @param robot This will be used to find the {@link GridPane} of {@link Chunk}.
     */
    @Test
    public void blockAmountShouldBeRowAmountSquareInChunk(final FxRobot robot) {
        final GridPane grid = robot.lookup("#chunkGrid").query();
        MatcherAssert.assertThat(
            grid.getChildren().size(),
            CoreMatchers.equalTo(ROW_AMOUNT * ROW_AMOUNT)
        );
    }

    /**
     * Number of rows in single chunk.
     */
    private static final int ROW_AMOUNT = 5;
}
