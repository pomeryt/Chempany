package application.fx.scene.event;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.ParamEvent;
import plain.value.CachedValue;

public final class EventScene implements MyEntity<EventScene> {
	
	public EventScene(final Scene scene) {
		this.scene = scene;
	}
	
	/**
	 * @param task All types of this task have the prefix 'Es'.
	 */
	@Override
	public void workOn(final VoidTaskOfEntity<EventScene> task) {
		task.handle(this);
	}

	/**
	 * @param task All types of this task have the prefix 'Es'.
	 */
	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, EventScene> task) {
		return task.handle(this);
	}
	
	private Scene scene() {
		return this.scene;
	}
	
	private final Scene scene;
	
	final CachedValue<Scene> cachedScene = new CachedValue<>(() -> {
		this.scene().setOnScroll(scrollEvent -> {
			this.scrollEvents.forEach(event -> {
				event.handle(scrollEvent);
			});
		});
		
		this.scene().setOnKeyPressed(keyEvent -> {
			this.keyPressedEvents.forEach(event -> {
				event.handle(keyEvent);
			});
		});
		
		this.scene().setOnKeyReleased(keyEvent -> {
			this.keyReleasedEvents.forEach(event -> {
				event.handle(keyEvent);
			});
		});
			
		return this.scene();
	});
	final List<ParamEvent<ScrollEvent>> scrollEvents = new ArrayList<>();
	final List<ParamEvent<KeyEvent>> keyPressedEvents = new ArrayList<>();
	final List<ParamEvent<KeyEvent>> keyReleasedEvents = new ArrayList<>();
}
