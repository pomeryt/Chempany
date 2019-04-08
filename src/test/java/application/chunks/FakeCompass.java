package application.chunks;

import java.awt.*;

/**
 * For testing.
 */
public final class FakeCompass implements CompassType {

    /**
     * Primary constructor.
     * @param chunkPosX Info at {@link FakeCompass#chunkPosX}.
     * @param chunkPosY Info at {@link FakeCompass#chunkPosY}.
     */
    public FakeCompass(final int chunkPosX, final int chunkPosY) {
        this.chunkPosX = chunkPosX;
        this.chunkPosY = chunkPosY;
    }

    @Override
    public Point chunkPos() {
        return new Point(this.chunkPosX, this.chunkPosY);
    }

    /**
     * It will be used to create {@link Point} object.
     * Then, the Point will be returned by {@link FakeCompass#chunkPos()}.
     */
    private final int chunkPosX;

    /**
     * It will be used to create {@link Point} object.
     * Then, the Point will be returned by {@link FakeCompass#chunkPos()}.
     */
    private final int chunkPosY;
}
