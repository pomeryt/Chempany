package application.chunks;

import application.chunks.chunk.Chunk;
import application.player.PlayerType;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Group;
import javafx.util.Duration;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * A collection of {@link application.chunks.chunk.Chunk}.
 * It's responsible for generating the chunks.
 */
public final class Chunks {

    /**
     * Primary constructor.
     *
     * @param player Chunks will be generated around this player.
     * @param group Info at {@link Chunks#group}.
     */
    public Chunks(final PlayerType player, final Group group) {
        this.player = player;
        this.group = group;
    }

    /**
     * Play {@link Chunks#timeline} for generating chunks as a background task.
     * This method can be called many times, but there would be no effect if the timeline is playing already.
     */
    public void start() {
        // Prevent duplicated KeyFrames.
        if (this.timeline.getKeyFrames().size() > 0) {
            return;
        }

        final KeyFrame keyFrame = new KeyFrame(
            Duration.ZERO,
            event -> {
                final Radar radar = new Radar(
                    new Compass(
                        SIDE_LENGTH_OF_BLOCK,
                        ROW_AMOUNT_IN_CHUNK,
                        this.player
                    ),
                    HALF_LENGTH_OF_RADAR
                );
                radar.chunkPositionsAroundPlayer().forEach(chunkPos -> {
                    if (!this.chunkMap.containsKey(chunkPos)) {
                        final Chunk chunk = new Chunk(ROW_AMOUNT_IN_CHUNK);
                        chunk.body().setTranslateX(chunkPos.x * SIDE_LENGTH_OF_BLOCK * ROW_AMOUNT_IN_CHUNK);
                        chunk.body().setTranslateY(chunkPos.y * SIDE_LENGTH_OF_BLOCK * ROW_AMOUNT_IN_CHUNK);
                        this.group.getChildren().add(chunk.body());
                        this.chunkMap.put(chunkPos, chunk);
                        this.player.body().toFront();
                    }
                });
            }
        );
        final int duration = 1000;
        this.timeline.getKeyFrames().addAll(keyFrame, new KeyFrame(Duration.millis(duration)));
        this.timeline.setCycleCount(Animation.INDEFINITE);
        this.timeline.play();
    }

    /**
     * Chunks will be generated around this player.
     */
    private final PlayerType player;

    /**
     * This will be used as the root container for all chunks.
     */
    private final Group group;

    /**
     * A {@link Timeline} for generating chunks as a background task.
     */
    private final Timeline timeline = new Timeline();

    /**
     * Store all chunks.
     */
    private final Map<Point, Chunk> chunkMap = new HashMap<>();

    /**
     * We assume all blocks are square.
     * This value will be used to calculate the size of chunks.
     * Ultimately, it's for the chunk generation.
     */
    private static final int SIDE_LENGTH_OF_BLOCK = 50;

    /**
     * Number of rows in one chunk.
     * That means one chunk contains (this value)^2 blocks.
     * We assume all chunks are square.
     * This value will be used to generate chunks.
     */
    private static final int ROW_AMOUNT_IN_CHUNK = 10;

    /**
     * The area of chunk generation is determined by {@link Radar}.
     * In other words, this value will be used to determined the area of chunk generation.
     */
    private static final int HALF_LENGTH_OF_RADAR = 5;
}
