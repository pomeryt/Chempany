package application.title;

import application.overworld.FakeOverworld;
import javafx.stage.Stage;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxAssert;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.matcher.control.LabeledMatchers;

/**
 * UI Testings on {@link TitlePage}.
 */
@ExtendWith(ApplicationExtension.class)
final class TitlePageTest {

    /**
     * Start JavaFX thread.
     * @param stage TextFX will inject this.
     */
    @Start
    public void start(final Stage stage) {
        this.stageBag[0] = stage;
        stage.setScene(
            new TitlePage(
                stage,
                new FakeOverworld()
            ).scene()
        );
        stage.show();
    }

    /**
     * Start button should navigate the player to Overworld when it's clicked.
     * @param robot It will click the start button.
     */
    @Test
    public void startButtonShouldNavigatePlayerToOverworldWhenClicked(final FxRobot robot) {
        robot.clickOn("#startButton");
        FxAssert.verifyThat(".label", LabeledMatchers.hasText("Overworld"));
    }

    /**
     * Exit button should close the window.
     * @param robot It will click the exit button.
     */
    @Test
    public void exitButtonShouldCloseWindow(final FxRobot robot) {
        robot.clickOn("#exitButton");
        MatcherAssert.assertThat(
            this.stageBag[0].isShowing(),
            CoreMatchers.equalTo(false)
        );
    }

    /**
     * We will use the {@link Stage#isShowing()} to check whether exit button closes the window or not.
     * This will be used to hold {@link Stage} object injected in {@link TitlePageTest#start(Stage)}.
     */
    private final Stage[] stageBag = new Stage[1];
}
