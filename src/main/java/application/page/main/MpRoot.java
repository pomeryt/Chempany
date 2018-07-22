package application.page.main;

import javafx.scene.layout.Pane;
import plain.contract.entity.ReturnTaskOfEntity;

public final class MpRoot implements ReturnTaskOfEntity<Pane, MainPage> {

	@Override
	public Pane handle(final MainPage page) {
		return page.cachedRoot.value();
	}

}
