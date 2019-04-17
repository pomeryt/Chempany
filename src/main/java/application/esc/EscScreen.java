package application.esc;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;

/**
 * ESC screen.
 * It will be shown when the player presses the ecs button on the keyboard.
 */
public final class EscScreen {

    /**
     * Cached.
     *
     * @return Root pane of ESC screen.
     */
    public StackPane root() {
        if (this.rootBuilt) {
            return this.rawRoot;
        }

        final double buttonWidth = 100;

        final Button bSave = new Button("Save");
        bSave.setId("saveButton");
        bSave.setPrefWidth(buttonWidth);

        final Button bOption = new Button("Option");
        bOption.setId("optionButton");
        bOption.setPrefWidth(buttonWidth);

        final GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.addColumn(0, bSave, bOption);

        this.rawRoot.getChildren().add(grid);
        this.rawRoot.setId("escRoot");
        this.rootBuilt = true;

        return this.rawRoot;
    }

    /**
     * Flag for caching the rawRoot variable.
     * It should only be used in body() method.
     */
    private boolean rootBuilt;

    /**
     * The content will be filled by body() method.
     * It should only be used in body() method.
     */
    private final StackPane rawRoot = new StackPane();
}
