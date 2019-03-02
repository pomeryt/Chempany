package application.overworld;

import application.esc.EscScreen;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;

/**
 * Overworld.
 * @author Rin
 */
public final class Overworld {

	/**
	 * Cached.
	 * @return Scene
	 */
	public Scene scene() {
		if (this.sceneBuilt) {
			return this.rawScene;
		}

		final EscScreen escScreen = new EscScreen();

		final StackPane root = new StackPane();

		this.rawScene = new Scene(root);
		this.rawScene.setOnKeyPressed(keyEvent -> {
			if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
				if (root.getChildren().contains(escScreen.root())) {
					root.getChildren().remove(escScreen.root());
				} else {
					root.getChildren().add(escScreen.root());
				}
			}
		});
		this.sceneBuilt = true;

		return this.rawScene;
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
}
