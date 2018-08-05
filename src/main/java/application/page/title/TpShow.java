package application.page.title;

import javafx.stage.Stage;
import plain.contract.entity.VoidTaskOfEntity;

public final class TpShow implements VoidTaskOfEntity<TitlePage> {

	public TpShow(final Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle(final TitlePage page) {
		this.stage.setScene(page.cachedScene.value());
	}
	
	private final Stage stage;
}
