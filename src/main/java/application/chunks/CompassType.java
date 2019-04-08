package application.chunks;

import java.awt.*;

/**
 * It's responsible for calculating the chunk coordinates of player.
 */
public interface CompassType {

    /**
     * It calculates the chunk coordinates of player.
     * @return Chunk coordinates of the player.
     */
    Point chunkPos();
}
