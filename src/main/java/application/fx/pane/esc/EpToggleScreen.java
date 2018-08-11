package application.fx.pane.esc;

import javafx.scene.Camera;
import javafx.scene.layout.Pane;
import plain.contract.entity.VoidTaskOfEntity;

/**
 * Display or hide ESC screen.
 * @author Rin
 * @version 1.0.0
 */
public final class EpToggleScreen implements VoidTaskOfEntity<EscPane> {

	/**
	 * @param root The ESC pane will get into this root.
	 * @param camera The ESC pane will move to its appropriate position based on camera.
	 * @since 1.0.0
	 */
	public EpToggleScreen(final Pane root, final Camera camera) {
		this.root = root;
		this.camera = camera;
	}
	
	@Override
	public void handle(final EscPane esc) {
		final Pane escPane = esc.cachedRoot.value();
		
		// Hide ESC screen.
		if(this.root.getChildren().contains(escPane)) {
			this.root.getChildren().remove(escPane);
			// Update flag as ESC option is not on the screen.
			esc.flagMap.value("esc").update(false);
			return;
		}

		// show ESC screen.
		// Fit location of ESC option to camera.
		escPane.setTranslateX(this.camera.getTranslateX());
		escPane.setTranslateY(this.camera.getTranslateY());
		escPane.setTranslateZ(this.camera.getTranslateZ());
		this.root.getChildren().add(escPane);
		// Update flag as ESC option is on the screen.
		esc.flagMap.value("esc").update(true);
	}

	private final Pane root;
	private final Camera camera;
}
