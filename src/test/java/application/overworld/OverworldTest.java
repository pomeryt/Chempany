package application.overworld;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Tests.
 */
@ExtendWith(ApplicationExtension.class)
final class OverworldTest {

    /**
     * Start JavaFX thread.
     * @param stage This will be provided by the TestFX.
     */
    @Start
    public void start(final Stage stage) {
        stage.setScene(new Overworld().scene());
        stage.show();
    }

    /**
     * Check if the player exists in the world.
     * We assume the root pane of player has id equals to 'playerBody'.
     * @param robot This will be provided by the TestFX.
     */
    @Test
    public void playerShouldExist(final FxRobot robot) {
        MatcherAssert.assertThat(
            robot.lookup("#playerBody").queryAll().size(),
            CoreMatchers.equalTo(1)
        );
    }

    /**
     * Check if the {@link KeyCode#ESCAPE} toggles the {@link application.esc.EscScreen}.
     * @param robot This will be provided by the TestFX.
     */
    @Test
    public void escButtonShouldToggleEscScreen(final FxRobot robot) {
        robot.press(KeyCode.ESCAPE);
        robot.release(KeyCode.ESCAPE);
        FxAssert.verifyThat(
            robot.lookup("#escRoot").queryAll().size(),
            CoreMatchers.equalTo(1)
        );

        robot.press(KeyCode.ESCAPE);
        robot.release(KeyCode.ESCAPE);
        FxAssert.verifyThat(
            robot.lookup("#escRoot").queryAll().size(),
            CoreMatchers.equalTo(0)
        );
    }
}
