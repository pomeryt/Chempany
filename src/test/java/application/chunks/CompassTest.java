package application.chunks;

import application.player.FakePlayer;
import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;

import java.awt.*;

/**
 * Tests.
 */
final class CompassTest {

    /**
     * Case of (0, 0).
     */
    @Test
    public void chunkPosShouldBePlayerPosDividedByChunkSizeWherePlayerAtOrigin() {
        final int sideLengthOfBlock = 10;
        final int rowAmountInChunk = 11;

        MatcherAssert.assertThat(
            this.targetCompass(
                sideLengthOfBlock,
                rowAmountInChunk,
                new Point(0, 0)
            ).chunkPos(),
            CoreMatchers.equalTo(new Point(0, 0))
        );
    }

    /**
     * Case of (1, 1).
     */
    @Test
    public void chunkPosShouldBePlayerPosDividedByChunkSizeWherePlayerAt1By1() {
        final int sideLengthOfBlock = 10;
        final int rowAmountInChunk = 11;

        MatcherAssert.assertThat(
            this.targetCompass(
                sideLengthOfBlock,
                rowAmountInChunk,
                new Point(1, 1)
            ).chunkPos(),
            CoreMatchers.equalTo(new Point(0, 0))
        );
    }

    /**
     * Case of (110, 110).
     */
    @Test
    public void chunkPosShouldBePlayerPosDividedByChunkSizeWherePlayerAt110By110() {
        final int sideLengthOfBlock = 10;
        final int rowAmountInChunk = 11;

        final int playerPos = 110;

        MatcherAssert.assertThat(
            this.targetCompass(
                sideLengthOfBlock,
                rowAmountInChunk,
                new Point(playerPos, playerPos)
            ).chunkPos(),
            CoreMatchers.equalTo(new Point(1, 1))
        );
    }

    /**
     * Case of (109, 109).
     */
    @Test
    public void chunkPosShouldBePlayerPosDividedByChunkSizeWherePlayerAt109By109() {
        final int sideLengthOfBlock = 10;
        final int rowAmountInChunk = 11;

        final int playerPos = 109;

        MatcherAssert.assertThat(
            this.targetCompass(
                sideLengthOfBlock,
                rowAmountInChunk,
                new Point(playerPos, playerPos)
            ).chunkPos(),
            CoreMatchers.equalTo(new Point(0, 0))
        );
    }

    /**
     * Case of (-1, -1).
     */
    @Test
    public void chunkPosShouldBeMinus1ByMinus1WhenPlayerPosIsMinus1byMinus1() {
        final int sideLengthOfBlock = 10;
        final int rowAmountInChunk = 11;

        MatcherAssert.assertThat(
            this.targetCompass(
                sideLengthOfBlock,
                rowAmountInChunk,
                new Point(-1, -1)
            ).chunkPos(),
            CoreMatchers.equalTo(new Point(-1, -1))
        );
    }

    /**
     * Case of (-110, -110).
     */
    @Test
    public void chunkPosShouldBePlayerPosDividedByChunkSizeWherePlayerAtMinus110ByMinus110() {
        final int sideLengthOfBlock = 10;
        final int rowAmountInChunk = 11;

        final int playerPos = -110;

        MatcherAssert.assertThat(
            this.targetCompass(
                sideLengthOfBlock,
                rowAmountInChunk,
                new Point(playerPos, playerPos)
            ).chunkPos(),
            CoreMatchers.equalTo(new Point(-1, -1))
        );
    }

    /**
     * Case of (-111, -111).
     */
    @Test
    public void chunkPosShouldBeMinus2ByMinus2WhenPlayerPosIsMinus111byMinus111() {
        final int sideLengthOfBlock = 10;
        final int rowAmountInChunk = 11;

        final int playerPos = -111;
        final int expectedChunkPos = -2;

        MatcherAssert.assertThat(
            this.targetCompass(
                sideLengthOfBlock,
                rowAmountInChunk,
                new Point(playerPos, playerPos)
            ).chunkPos(),
            CoreMatchers.equalTo(new Point(expectedChunkPos, expectedChunkPos))
        );
    }

    /**
     * Generate new {@link Compass} to be tested.
     * @param sideLengthOfBlock It will be used by {@link Compass}.
     * @param rowAmountInChunk It will be used by {@link Compass}.
     * @param playerPos XY coordinate of the player.
     * @return New {@link Compass} object.
     */
    private Compass targetCompass(final int sideLengthOfBlock, final int rowAmountInChunk, final Point playerPos) {
        return new Compass(
            sideLengthOfBlock,
            rowAmountInChunk,
            new FakePlayer(playerPos)
        );
    }
}
