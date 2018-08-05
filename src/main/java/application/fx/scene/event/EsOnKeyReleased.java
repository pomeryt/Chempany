package application.fx.scene.event;

import javafx.scene.input.KeyEvent;
import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.ParamEvent;

public final class EsOnKeyReleased implements VoidTaskOfEntity<EventScene> {

	@SafeVarargs
	public EsOnKeyReleased(final ParamEvent<KeyEvent>... events) {
		this.events = events;
	}
	
	@Override
	public void handle(final EventScene eventScene) {
		for (ParamEvent<KeyEvent> event: events) {
			eventScene.keyReleasedEvents.add(event);
		}
	}

	private final ParamEvent<KeyEvent>[] events;
}
