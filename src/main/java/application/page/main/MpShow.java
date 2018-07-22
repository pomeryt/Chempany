package application.page.main;

import application.fx.scene.event.EsShow;
import javafx.stage.Stage;
import plain.contract.entity.VoidTaskOfEntity;

public final class MpShow implements VoidTaskOfEntity<MainPage> {

	public MpShow(final Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle(final MainPage page) {
		page.cachedEventScene.value().workOn(new EsShow(this.stage));
	}

	private final Stage stage;
}
