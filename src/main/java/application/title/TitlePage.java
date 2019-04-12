package application.title;

import application.overworld.OverworldType;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Title Page.
 *
 * @author Rin
 */
public final class TitlePage {

    /**
     * Primary constructor.
     *
     * @param stage Stage.
     * @param overworld Overworld.
     */
    public TitlePage(final Stage stage, final OverworldType overworld) {
        this.stage = stage;
        this.overworld = overworld;
    }

    /**
     * Cached.
     *
     * @return Scene
     */
    public Scene scene() {
        if (this.sceneBuilt) {
            return this.rawScene;
        }

        final Label lTitle = new Label("Alchemist");
        lTitle.setStyle("-fx-font-size: 50px; -fx-padding: 50 0 0 0;");
        StackPane.setAlignment(lTitle, Pos.TOP_CENTER);

        final StackPane root = new StackPane();
        root.getChildren().addAll(lTitle, this.gridButtons());

        this.rawScene = new Scene(root);
        this.sceneBuilt = true;

        return this.rawScene;
    }

    /**
     * Create new GridPane instance that contains all buttons.
     *
     * @return GridPane that contain buttons.
     */
    private GridPane gridButtons() {
        final double buttonWidth = 100;

        final Button bStart = new Button("Start");
        bStart.setPrefWidth(buttonWidth);
        bStart.setOnAction(e -> this.stage.setScene(this.overworld.scene()));
        bStart.setId("startButton");

        final Button bLoad = new Button("Load");
        bLoad.setPrefWidth(buttonWidth);

        final Button bOption = new Button("Option");
        bOption.setPrefWidth(buttonWidth);

        final Button bExit = new Button("Exit");
        bExit.setId("exitButton");
        bExit.setPrefWidth(buttonWidth);
        bExit.setOnAction(e -> this.stage.close());

        final GridPane gridButtons = new GridPane();
        gridButtons.addColumn(0, bStart, bLoad, bOption, bExit);
        gridButtons.setAlignment(Pos.CENTER);

        return gridButtons;
    }

    /**
     * Stage for displaying this page.
     */
    private final Stage stage;

    /**
     * This page navigates user to over world.
     */
    private final OverworldType overworld;

    /**
     * Flag for caching the rawScene variable.
     * It should only be used in scene() method.
     */
    private boolean sceneBuilt;

    /**
     * It will be instantiated via scene() method and will be cached.
     * It should only be used in scene() method.
     */
    private Scene rawScene;
}
