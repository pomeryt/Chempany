package application.player;

import javafx.scene.layout.StackPane;

import java.awt.*;

/**
 * For testing.
 */
public final class FakePlayer implements PlayerType {

    /**
     * Primary constructor.
     * @param expectedPosition It will be returned when {@link FakePlayer#position()} is called.
     */
    public FakePlayer(final Point expectedPosition) {
        this.expectedPosition = expectedPosition;
    }

    @Override
    public StackPane body() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public Point position() {
        return this.expectedPosition;
    }

    /**
     * Expected position to be returned.
     */
    private final Point expectedPosition;
}
