package application.player;

import javafx.scene.layout.StackPane;

import java.awt.*;

/**
 * Player.
 */
public interface PlayerType {

    /**
     * UI component that represents the whole body of this player.
     *
     * @return JavaFX UI.
     */
    StackPane body();

    /**
     * XY coordinates of this player.
     *
     * @return It represents JavaFX translate value.
     */
    Point position();
}
