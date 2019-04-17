package application.player;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Function;

/**
 * Player.
 */
public final class Player implements PlayerType {

    /**
     * Primary constructor.
     *
     * @param scene Keyboard event on scene will be used.
     * @param groupChunks Info at {@link Player#groupChunks}.
     * @param size Info at {@link Player#size}.
     */
    public Player(final Scene scene, final Group groupChunks, final int size) {
        this.scene = scene;
        this.groupChunks = groupChunks;
        this.size = size;
    }

    /**
     * Cached.
     *
     * @return Root pane of player.
     */
    @Override
    public StackPane body() {
        if (this.rootBuilt) {
            return this.rawRoot;
        }

        this.rawRoot.setMaxSize(this.size, this.size);
        this.rawRoot.setMinSize(this.size, this.size);
        this.rawRoot.setStyle("-fx-background-color: yellow;");
        this.rawRoot.setId("playerBody");

        final AtomicBoolean upPressed = new AtomicBoolean(false);
        final AtomicBoolean downPressed = new AtomicBoolean(false);
        final AtomicBoolean leftPressed = new AtomicBoolean(false);
        final AtomicBoolean rightPressed = new AtomicBoolean(false);

        this.handleKeyPressEvent(upPressed, downPressed, leftPressed, rightPressed);
        this.handleKeyReleaseEvent(upPressed, downPressed, leftPressed, rightPressed);

        final Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(this.movingKeyFrame(upPressed, downPressed, leftPressed, rightPressed));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();

        this.rootBuilt = true;
        return this.rawRoot;
    }

    /**
     * Construct new {@link Point} that represents the coordinates of this player.
     *
     * @return Coordinates of this player.
     */
    @Override
    public Point position() {
        return new Point(this.xPos, this.yPos);
    }

    /**
     * When user presses the arrow button, it will set the corresponding direction value to true.
     * The values will be used to move the player in corresponding direction.
     *
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
     *
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
     *
     * @param upPressed Indicates user pressing up arrow.
     * @param downPressed Indicates user pressing down arrow.
     * @param leftPressed Indicates user pressing left arrow.
     * @param rightPressed Indicates user pressing right arrow.
     * @return KeyFrame.
     */
    private KeyFrame movingKeyFrame(final AtomicBoolean upPressed, final AtomicBoolean downPressed, final AtomicBoolean leftPressed, final AtomicBoolean rightPressed) {
        return new KeyFrame(
            Duration.millis(MOVING_KEYFRAME_DURATION),
            event -> {
                for (final Direction direction : Direction.values()) {
                    if (direction.match(upPressed.get(), downPressed.get(), leftPressed.get(), rightPressed.get())) {
                        final Point newChunksPos = direction.move(this.groupChunks);
                        final int opposite = -1;
                        this.xPos = opposite * newChunksPos.x;
                        this.yPos = opposite * newChunksPos.y;
                    }
                }
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
        TOP_LEFT(
            true,
            false,
            true,
            false,
            chunksPane -> {
                chunksPane.setTranslateX(chunksPane.getTranslateX() + TRANSLATE_AMOUNT);
                chunksPane.setTranslateY(chunksPane.getTranslateY() + TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        ),

        /**
         * Top-Right direction.
         */
        TOP_RIGHT(
            true,
            false,
            false,
            true,
            chunksPane -> {
                chunksPane.setTranslateX(chunksPane.getTranslateX() - TRANSLATE_AMOUNT);
                chunksPane.setTranslateY(chunksPane.getTranslateY() + TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        ),

        /**
         * Top direction.
         */
        TOP(
            true,
            false,
            false,
            false,
            chunksPane -> {
                chunksPane.setTranslateY(chunksPane.getTranslateY() + TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        ),

        /**
         * Bottom-Left direction.
         */
        BOTTOM_LEFT(
            false,
            true,
            true,
            false,
            chunksPane -> {
                chunksPane.setTranslateX(chunksPane.getTranslateX() + TRANSLATE_AMOUNT);
                chunksPane.setTranslateY(chunksPane.getTranslateY() - TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        ),

        /**
         * Bottom-Right direction.
         */
        BOTTOM_RIGHT(
            false,
            true,
            false,
            true,
            chunksPane -> {
                chunksPane.setTranslateX(chunksPane.getTranslateX() - TRANSLATE_AMOUNT);
                chunksPane.setTranslateY(chunksPane.getTranslateY() - TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        ),

        /**
         * Bottom direction.
         */
        BOTTOM(
            false,
            true,
            false,
            false,
            chunksPane -> {
                chunksPane.setTranslateY(chunksPane.getTranslateY() - TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        ),

        /**
         * Left direction.
         */
        LEFT(
            false,
            false,
            true,
            false,
            chunksPane -> {
                chunksPane.setTranslateX(chunksPane.getTranslateX() + TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        ),

        /**
         * Right direction.
         */
        RIGHT(
            false,
            false,
            false,
            true,
            chunksPane -> {
                chunksPane.setTranslateX(chunksPane.getTranslateX() - TRANSLATE_AMOUNT);
                return new Point(
                    (int) chunksPane.getTranslateX(),
                    (int) chunksPane.getTranslateY()
                );
            }
        );

        /**
         * Primary constructor.
         *
         * @param upPressed Indicates user pressing up arrow.
         * @param downPressed Indicates user pressing down arrow.
         * @param leftPressed Indicates user pressing left arrow.
         * @param rightPressed Indicates user pressing right arrow.
         * @param action Info at {@link Direction#action}.
         */
        Direction(final boolean upPressed, final boolean downPressed, final boolean leftPressed, final boolean rightPressed, final Function<Group, Point> action) {
            this.upPressed = upPressed;
            this.downPressed = downPressed;
            this.leftPressed = leftPressed;
            this.rightPressed = rightPressed;
            this.action = action;
        }

        /**
         * Determine whether given direction matches this enum.
         *
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
         * Move the player.
         * Actually, the player itself will not move.
         * Instead, the entire chunks will be moved in opposite way to simulate the player movement.
         *
         * @param groupChunks This will be translated to simulate the player movement.
         * @return New player position. See {@link Direction#action}.
         */
        public Point move(final Group groupChunks) {
            return this.action.apply(groupChunks);
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
         * It will take {@link Player#groupChunks} as parameter and translate its position.
         * Then, it will return new {@link Player#groupChunks} position.
         * Player should update {@link Player#xPos} and {@link Player#yPos}.
         * Note, the player position should be in opposite direction to the {@link Player#groupChunks}.
         */
        private final Function<Group, Point> action;
    }

    /**
     * For keyboard event to control the player.
     */
    private final Scene scene;

    /**
     * We simulate the player movement by translating the chunks in opposite to the player direction.
     * This group contains all chunks and will be translated.
     */
    private final Group groupChunks;

    /**
     * The size of player.
     */
    private final int size;

    /**
     * Position on x-axis.
     * Default value is 0.
     */
    private int xPos;

    /**
     * Position on y-axis.
     * Default value is 0.
     */
    private int yPos;

    /**
     * Flag to cache the body pane.
     * It should only be used in body() method.
     */
    private boolean rootBuilt;

    /**
     * Child nodes will be filled by body() method.
     * It should only be used in body() method.
     */
    private final StackPane rawRoot = new StackPane();

    /**
     * The duration used in {@link Player#movingKeyFrame(AtomicBoolean, AtomicBoolean, AtomicBoolean, AtomicBoolean)} method.
     * In every [this value] milliseconds, the player will move on screen if the user presses move-keys.
     */
    private static final int MOVING_KEYFRAME_DURATION = 10;

    /**
     * JavaFX translate amount.
     * The player can move as frequent as {@link Player#MOVING_KEYFRAME_DURATION}.
     */
    private static final int TRANSLATE_AMOUNT = 3;
}
