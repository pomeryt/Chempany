package application.chunks;

import application.player.Player;
import application.player.PlayerType;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import java.util.Set;

/**
 * Tests.
 */
@ExtendWith(ApplicationExtension.class)
final class ChunksTest {

    /**
     * Start JavaFX thread.
     * @param stage This will be provided by TestFX.
     */
    @Start
    public void start(final Stage stage) {
        final int playerSize = 50;
        final StackPane root = new StackPane();
        final Pane panePlayerAndChunksGroup = new Pane();
        panePlayerAndChunksGroup.setMaxSize(playerSize, playerSize);
        panePlayerAndChunksGroup.setMinSize(playerSize, playerSize);
        final Group chunksGroup = new Group();
        final Scene scene = new Scene(root);
        final PlayerType player = new Player(scene, chunksGroup, playerSize);
        final Chunks chunks = new Chunks(player, chunksGroup);

        root.getChildren().add(panePlayerAndChunksGroup);
        panePlayerAndChunksGroup.getChildren().addAll(player.body(), chunksGroup);

        stage.setScene(scene);
        stage.show();
        chunks.start();
    }

    /**
     * Check if the amount of chunks is 121 (11*11).
     * The amount is hard coded as of now, and we may alter the value in the future.
     * @param robot This will be provided by TestFX.
     */
    @Test
    public void chunksShouldBeGenerated(final FxRobot robot) {
        final int expectedChunkAmount = 121;
        final Set<GridPane> chunks = robot.lookup("#chunkGrid").queryAll();
        MatcherAssert.assertThat(chunks.size(), CoreMatchers.equalTo(expectedChunkAmount));
    }

}
