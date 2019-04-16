package application.player;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

/**
 * Tests.
 */
@ExtendWith(ApplicationExtension.class)
final class PlayerTest {

    /**
     * Start JavaFX thread.
     * @param stage TestFX will provide this.
     */
    @Start
    public void start(final Stage stage) {
        final Pane pane = new Pane();
        final Group group = new Group();
        final StackPane root = new StackPane(pane);
        final Scene scene = new Scene(root);
        final int playerSize = 50;
        this.player = new Player(scene, group, playerSize);
        pane.getChildren().addAll(this.player.body(), group);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Player should move up when up key is pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveUpByUpKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.UP);
        robot.release(KeyCode.UP);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, CoreMatchers.equalTo(posMovedX));
        MatcherAssert.assertThat(posOriginY, Matchers.greaterThan(posMovedY));
    }

    /**
     * Player should move down when down key is pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveDownByDownKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.DOWN);
        robot.release(KeyCode.DOWN);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, CoreMatchers.equalTo(posMovedX));
        MatcherAssert.assertThat(posOriginY, Matchers.lessThan(posMovedY));
    }

    /**
     * Player should move left when left key is pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveLeftByLeftKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.LEFT);
        robot.release(KeyCode.LEFT);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, Matchers.greaterThan(posMovedX));
        MatcherAssert.assertThat(posOriginY, CoreMatchers.equalTo(posMovedY));
    }

    /**
     * Player should move right when right key is pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveRightByRightKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.RIGHT);
        robot.release(KeyCode.RIGHT);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, Matchers.lessThan(posMovedX));
        MatcherAssert.assertThat(posOriginY, CoreMatchers.equalTo(posMovedY));
    }

    /**
     * Player should move north-west when up and left keys are pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveNorthWestByUpLeftKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.UP);
        robot.press(KeyCode.LEFT);
        robot.release(KeyCode.UP);
        robot.release(KeyCode.LEFT);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, Matchers.greaterThan(posMovedX));
        MatcherAssert.assertThat(posOriginY, Matchers.greaterThan(posMovedY));
    }

    /**
     * Player should move north-east when up and right keys are pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveNorthEastByUpRightKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.UP);
        robot.press(KeyCode.RIGHT);
        robot.release(KeyCode.UP);
        robot.release(KeyCode.RIGHT);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, Matchers.lessThan(posMovedX));
        MatcherAssert.assertThat(posOriginY, Matchers.greaterThan(posMovedY));
    }

    /**
     * Player should move south-east when down and right keys are pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveSouthEastByDownRightKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.DOWN);
        robot.press(KeyCode.RIGHT);
        robot.release(KeyCode.DOWN);
        robot.release(KeyCode.RIGHT);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, Matchers.lessThan(posMovedX));
        MatcherAssert.assertThat(posOriginY, Matchers.lessThan(posMovedY));
    }

    /**
     * Player should move south-west when down and left keys are pressed.
     * @param robot This will be used to press keyboard.
     */
    @Test
    public void playerShouldMoveSouthWestByDownLeftKey(final FxRobot robot) {
        final int posOriginX = this.player.position().x;
        final int posOriginY = this.player.position().y;
        robot.press(KeyCode.DOWN);
        robot.press(KeyCode.LEFT);
        robot.release(KeyCode.DOWN);
        robot.release(KeyCode.LEFT);
        final int posMovedX = this.player.position().x;
        final int posMovedY = this.player.position().y;
        MatcherAssert.assertThat(posOriginX, Matchers.greaterThan(posMovedX));
        MatcherAssert.assertThat(posOriginY, Matchers.lessThan(posMovedY));
    }

    /**
     * Testing target.
     * We will move this by keyboard and check its position.
     */
    private Player player;
}
