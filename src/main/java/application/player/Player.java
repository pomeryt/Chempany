package application.player;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Player.
 */
public final class Player {

    /**
     * Primary constructor.
     * @param scene Keyboard event on scene will be used.
     */
    public Player(final Scene scene) {
        this.scene = scene;
    }

    /**
     * Cached.
     * @return Root pane of player.
     */
    public StackPane root() {
        if (this.rootBuilt) {
            return this.rawRoot;
        }

        final Label lDirection = new Label();

        final double size = 50;

        this.rawRoot.setMaxSize(size, size);
        this.rawRoot.setStyle("-fx-background-color: yellow;");
        this.rawRoot.getChildren().add(lDirection);

        final AtomicBoolean upPressed = new AtomicBoolean(false);
        final AtomicBoolean downPressed = new AtomicBoolean(false);
        final AtomicBoolean leftPressed = new AtomicBoolean(false);
        final AtomicBoolean rightPressed = new AtomicBoolean(false);

        this.handleKeyPressEvent(upPressed, downPressed, leftPressed, rightPressed);
        this.handleKeyReleaseEvent(upPressed, downPressed, leftPressed, rightPressed);

        final Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(this.movingKeyFrame(upPressed, downPressed, leftPressed, rightPressed, lDirection));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        this.rootBuilt = true;
        return this.rawRoot;
    }

    /**
     * When user presses the arrow button, it will set the corresponding direction value to true.
     * The values will be used to move the player in corresponding direction.
     * @param upPressed Indicates user pressing up arrow.
     * @param downPressed Indicates user pressing down arrow.
     * @param leftPressed Indicates user pressing left arrow.
     * @param rightPressed Indicates user pressing right arrow.
     */
    private void handleKeyPressEvent(final AtomicBoolean upPressed, final AtomicBoolean downPressed, final AtomicBoolean leftPressed, final AtomicBoolean rightPressed) {
        this.scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.UP)) {
                upPressed.set(true);
            }
            if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                downPressed.set(true);
            }
            if (keyEvent.getCode().equals(KeyCode.LEFT)) {
                leftPressed.set(true);
            }
            if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
                rightPressed.set(true);
            }
        });
    }

    /**
     * When user presses the arrow button, it will set the corresponding direction value to false.
     * The values will be used to stop the player from moving in corresponding direction.
     * @param upPressed Indicates user pressing up arrow.
     * @param downPressed Indicates user pressing down arrow.
     * @param leftPressed Indicates user pressing left arrow.
     * @param rightPressed Indicates user pressing right arrow.
     */
    private void handleKeyReleaseEvent(final AtomicBoolean upPressed, final AtomicBoolean downPressed, final AtomicBoolean leftPressed, final AtomicBoolean rightPressed) {
        this.scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEvent -> {
            if (keyEvent.getCode().equals(KeyCode.UP)) {
                upPressed.set(false);
            }
            if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                downPressed.set(false);
            }
            if (keyEvent.getCode().equals(KeyCode.LEFT)) {
                leftPressed.set(false);
            }
            if (keyEvent.getCode().equals(KeyCode.RIGHT)) {
                rightPressed.set(false);
            }
        });
    }

    /**
     * KeyFrame that moves player.
     * @param upPressed Indicates user pressing up arrow.
     * @param downPressed Indicates user pressing down arrow.
     * @param leftPressed Indicates user pressing left arrow.
     * @param rightPressed Indicates user pressing right arrow.
     * @param lDirection Label for indicating the direction.
     * @return KeyFrame.
     */
    private KeyFrame movingKeyFrame(final AtomicBoolean upPressed, final AtomicBoolean downPressed, final AtomicBoolean leftPressed, final AtomicBoolean rightPressed, final Label lDirection) {
        final int keyFrameDuration = 10;
        return new KeyFrame(
            Duration.millis(keyFrameDuration),
            event -> {
                for (final Direction direction : Direction.values()) {
                    if (direction.match(upPressed.get(), downPressed.get(), leftPressed.get(), rightPressed.get())) {
                        lDirection.setText(direction.text());
                        return;
                    }
                }
                lDirection.setText("");
            }
        );
    }

    /**
     * Direction of moving player.
     * Although enum objects seems to be unused, they will be used in iteration.
     */
    private enum Direction {
        /**
         * Top-Left direction.
         */
        TOP_LEFT(true, false, true, false, "↖︎"),

        /**
         * Top-Right direction.
         */
        TOP_RIGHT(true, false, false, true, "↗︎"),

        /**
         * Top direction.
         */
        TOP(true, false, false, false, "↑"),

        /**
         * Bottom-Left direction.
         */
        BOTTOM_LEFT(false, true, true, false, "↙︎"),

        /**
         * Bottom-Right direction.
         */
        BOTTOM_RIGHT(false, true, false, true, "↘︎"),

        /**
         * Bottom direction.
         */
        BOTTOM(false, true, false, false, "↓"),

        /**
         * Left direction.
         */
        LEFT(false, false, true, false, "←"),

        /**
         * Right direction.
         */
        RIGHT(false, false, false, true, "→");

        /**
         * Primary constructor.
         * @param upPressed Indicates user pressing up arrow.
         * @param downPressed Indicates user pressing down arrow.
         * @param leftPressed Indicates user pressing left arrow.
         * @param rightPressed Indicates user pressing right arrow.
         * @param text Direction in text.
         */
        Direction(final boolean upPressed, final boolean downPressed, final boolean leftPressed, final boolean rightPressed, final String text) {
            this.upPressed = upPressed;
            this.downPressed = downPressed;
            this.leftPressed = leftPressed;
            this.rightPressed = rightPressed;
            this.text = text;
        }

        /**
         * Determine whether given direction matches this enum.
         * @param upPressed Indicates user pressing up arrow.
         * @param downPressed Indicates user pressing down arrow.
         * @param leftPressed Indicates user pressing left arrow.
         * @param rightPressed Indicates user pressing right arrow.
         * @return Whether given direction matches this enum.
         */
        public boolean match(final boolean upPressed, final boolean downPressed, final boolean leftPressed, final boolean rightPressed) {
            return this.upPressed == upPressed && this.downPressed == downPressed && this.leftPressed == leftPressed && this.rightPressed == rightPressed;
        }

        /**
         * Text representation of direction.
         * @return Direction.
         */
        public String text() {
            return this.text;
        }

        /**
         * Indicates user pressing up arrow.
         */
        private final boolean upPressed;

        /**
         * Indicates user pressing down arrow.
         */
        private final boolean downPressed;

        /**
         * Indicates user pressing left arrow.
         */
        private final boolean leftPressed;

        /**
         * Indicates user pressing right arrow.
         */
        private final boolean rightPressed;

        /**
         * String representation of direction.
         */
        private final String text;
    }

    /**
     * For keyboard event to control the player.
     */
    private final Scene scene;

    /**
     * Flag to cache the root pane.
     * It should only be used in root() method.
     */
    private boolean rootBuilt;

    /**
     * Child nodes will be filled by root() method.
     * It should only be used in root() method.
     */
    private final StackPane rawRoot = new StackPane();
}
