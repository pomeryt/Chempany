package application.title;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Title Page.
 * @author Rin
 * @version 1.0.0
 */
public final class TitlePage {

	/**
	 * Cached.
	 * @return Scene
	 * @since 1.0.0
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
	 * Close the stage when exit button is clicked.
	 * @param stage It will be closed.
	 * @since 1.0.0
	 */
	public void closeOnExit(final Stage stage) {
		this.bExit.setOnAction(e -> {
			stage.close();
		});
	}

	/**
	 * Create new GridPane instance that contains all buttons.
	 * @return GridPane that contain buttons.
	 * @since 1.0.0
	 */
	private GridPane gridButtons() {
		final double buttonWidth = 100;

		final Button bStart = new Button("Start");
		bStart.setPrefWidth(buttonWidth);

		final Button bLoad = new Button("Load");
		bLoad.setPrefWidth(buttonWidth);

		final Button bOption = new Button("Option");
		bOption.setPrefWidth(buttonWidth);

		this.bExit.setPrefWidth(buttonWidth);

		final GridPane gridButtons = new GridPane();
		gridButtons.addColumn(0, bStart, bLoad, bOption, this.bExit);
		gridButtons.setAlignment(Pos.CENTER);

		return gridButtons;
	}

	/**
	 * Flag for caching the scene variable.
	 * It should only be used in scene() method.
	 */
	private boolean sceneBuilt;

	/**
	 * It will be instantiated via scene() method and will be cached.
	 * It should only be used in scene() method.
	 */
	private Scene rawScene;

	/**
	 * Exit button.
	 */
	private final Button bExit = new Button("Exit");
}
