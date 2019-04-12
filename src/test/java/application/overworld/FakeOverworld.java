package application.overworld;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

/**
 * For testing.
 */
public final class FakeOverworld implements OverworldType {

    @Override
    public Scene scene() {
        return new Scene(
            new StackPane(
                new Label("Overworld")
            )
        );
    }
}
