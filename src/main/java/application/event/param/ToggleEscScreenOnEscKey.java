package application.event.param;

import application.fx.pane.esc.EpToggleScreen;
import application.fx.pane.esc.EscPane;
import javafx.scene.Camera;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import plain.contract.entity.MyEntity;
import plain.contract.event.ParamEvent;

public final class ToggleEscScreenOnEscKey implements ParamEvent<KeyEvent> {

	public ToggleEscScreenOnEscKey(final MyEntity<EscPane> escPane, final Pane root, final Camera camera) {
		this.escPane = escPane;
		this.root = root;
		this.camera = camera;
	}
	
	@Override
	public void handle(final KeyEvent keyEvent) {
		if (keyEvent.getCode().equals(KeyCode.ESCAPE)) {
			this.escPane.workOn(new EpToggleScreen(this.root, this.camera));
		}
	}

	private final MyEntity<EscPane> escPane;
	private final Pane root;
	private final Camera camera;
}
