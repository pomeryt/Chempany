package application.fx.scene.event;

import javafx.scene.Camera;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.validation.list.IsListNullSafe;
import plain.value.CachedValue;
import plain.value.give.ThrowableGive;

public final class EsCamera implements ReturnTaskOfEntity<Camera, EventScene> {

	@Override
	public Camera handle(final EventScene eventScene) {
		return new CachedValue<Camera>(
			() -> eventScene.cachedScene.value().getCamera()
		).value(
			new ThrowableGive<>(
				"Camera does not exist in the EventScene.", 
				new IsListNullSafe<>()
			)
		);
	}

}
