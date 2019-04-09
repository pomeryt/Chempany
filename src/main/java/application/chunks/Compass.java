package application.chunks;

import application.player.PlayerType;

import java.awt.*;

/**
 * It's responsible for calculating the chunk coordinates of player.
 */
public final class Compass implements CompassType {

    /**
     * Primary constructor.
     *
     * @param sideLengthOfBlock The length of square block for one side.
     * @param rowAmountInChunk Amount of blocks within one chunk.
     *                         The shape of one chunk should be square.
     *                         In other words, the square root of this value should be an integer.
     * @param player Target player to keep track of their chunk coordinates.
     */
    public Compass(final int sideLengthOfBlock, final int rowAmountInChunk, final PlayerType player) {
        this.sideLengthOfBlock = sideLengthOfBlock;
        this.rowAmountInChunk = rowAmountInChunk;
        this.player = player;
    }

    /**
     * It calculates the chunk coordinates of player.
     *
     * @return Chunk coordinates of the player.
     */
    @Override
    public Point chunkPos() {
        final int playerX = this.player.position().x;
        final int playerY = this.player.position().y;

        final int sideLengthOfChunk = this.sideLengthOfBlock * this.rowAmountInChunk;

        final int chunkX = Math.floorDiv(playerX, sideLengthOfChunk);
        final int chunkY = Math.floorDiv(playerY, sideLengthOfChunk);

        return new Point(chunkX, chunkY);
    }

    /**
     * The length of square block for one side.
     */
    private final int sideLengthOfBlock;

    /**
     * Number of rows in one chunk.
     * The shape of one chunk should be square.
     */
    private final int rowAmountInChunk;

    /**
     * Chunk position will be calculated based on this player.
     */
    private final PlayerType player;
}
