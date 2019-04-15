package application.block;

import javafx.scene.Scene;
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
final class BrickTest {

    /**
     * Start JavaFX thread.
     * @param stage This will be provided by TestFX.
     */
    @Start
    public void start(final Stage stage) {
        stage.setScene(new Scene(new Brick().body()));
        stage.show();
    }

    /**
     * TODO Actual behavior of {@link Brick} should be tested once it's implemented.
     * As of now, we just check the size of it.
     * @param robot This will be used to find the root pane of {@link Brick}.
     */
    @Test
    public void blockSizeShouldBe50(final FxRobot robot) {
        final double expectedSize = 50.0;
        final StackPane root = robot.lookup("#root").query();
        MatcherAssert.assertThat(root.getWidth(), CoreMatchers.equalTo(expectedSize));
        MatcherAssert.assertThat(root.getHeight(), CoreMatchers.equalTo(expectedSize));
    }
}
