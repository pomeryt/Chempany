package application.esc;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

/**
 * Tests.
 */
@ExtendWith(ApplicationExtension.class)
final class EscScreenTest {

    /**
     * Start JavaFX thread.
     * @param stage This will be provided by TestFx.
     */
    @Start
    public void start(final Stage stage) {
        stage.setScene(new Scene(new EscScreen().root()));
        stage.show();
    }

    /**
     * TODO Actual button action should be tested once it's implemented.
     * As of now, we just check if the save button exists.
     * @param robot This will be provided by TestFx.
     */
    @Test
    public void saveButtonShouldExist(final FxRobot robot) {
        FxAssert.verifyThat("#saveButton", LabeledMatchers.hasText("Save"));
    }

    /**
     * TODO Actual button action should be tested once it's implemented.
     * As of now, we just check if the option button exists.
     * @param robot This will be provided by TestFx.
     */
    @Test
    public void optionButtonShouldExist(final FxRobot robot) {
        FxAssert.verifyThat("#optionButton", LabeledMatchers.hasText("Option"));
    }
}
