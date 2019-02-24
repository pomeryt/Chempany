package application.overworld;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;

/**
 * Overworld.
 * @author Rin
 * @version 1.0.0
 */
public final class Overworld {

	/**
	 * Cached.
	 * @return Scene
	 * @since 1.0.0
	 */
	public Scene scene() {
		if (this.sceneBuilt) {
			return this.rawScene;
		}

		final Pane root = new Pane();

		this.rawScene = new Scene(root);
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
