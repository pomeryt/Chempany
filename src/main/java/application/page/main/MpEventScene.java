package application.page.main;

import application.fx.scene.event.EventScene;
import plain.contract.entity.ReturnTaskOfEntity;

public final class MpEventScene implements ReturnTaskOfEntity<EventScene, MainPage> {

	@Override
	public EventScene handle(final MainPage page) {
		return page.cachedEventScene.value();
	}

}
