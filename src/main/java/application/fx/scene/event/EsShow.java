package application.fx.scene.event;

import javafx.stage.Stage;
import plain.contract.entity.VoidTaskOfEntity;

public final class EsShow implements VoidTaskOfEntity<EventScene> {

	public EsShow(final Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle(final EventScene eventScene) {
		this.stage.setScene(eventScene.cachedScene.value());
	}

	private final Stage stage;
}
