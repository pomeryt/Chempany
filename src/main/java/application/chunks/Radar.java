package application.chunks;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * It's responsible for detect chunks around a player.
 * It assumes the player is at the center chunk.
 */
public final class Radar {

    /**
     * Primary constructor.
     * @param compass This will provide the chunk coordinates of the player.
     * @param halfLength Half length of this radar.
     */
    public Radar(final CompassType compass, final int halfLength) {
        this.compass = compass;
        this.halfLength = halfLength;
    }

    /**
     * It will be used for chunk generation.
     * @return Chunk positions around the player.
     */
    public List<Point> chunkPositionsAroundPlayer() {
        final int xBegin = this.compass.chunkPos().x - this.halfLength;
        final int xEnd = this.compass.chunkPos().x + this.halfLength;

        final int yBegin = this.compass.chunkPos().y - this.halfLength;
        final int yEnd = this.compass.chunkPos().y + this.halfLength;

        final List<Point> positions = new ArrayList<>();

        for (int y = yBegin; y < yEnd + 1; y++) {
            for (int x = xBegin; x < xEnd + 1; x++) {
                positions.add(new Point(x, y));
            }
        }

        return positions;
    }

    /**
     * This will provide the chunk coordinates of the player.
     */
    private final CompassType compass;

    /**
     * Half length of this radar.
     * It can be regarded as radius, but the shape of radar is actually square :P
     */
    private final int halfLength;
}
