package application.page.component;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.ScrollEvent;
import plain.contract.event.ParamEvent;
import plain.value.CachedValue;

public final class EventScene {
	public EventScene(final Scene scene) {
		this(scene, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
	}
	
	public EventScene(final Scene scene, final List<ParamEvent<ScrollEvent>> scrollEvents, final List<ParamEvent<KeyEvent>> keyPressedEvents, final List<ParamEvent<KeyEvent>> keyReleasedEvents) {
		this(new CachedValue<Scene>( () -> {
			scene.setOnScroll(scrollEvent -> {
				scrollEvents.forEach(event -> {
					event.handle(scrollEvent);
				});
			});
			
			scene.setOnKeyPressed(keyEvent -> {
				keyPressedEvents.forEach(event -> {
					event.handle(keyEvent);
				});
			});
			
			scene.setOnKeyReleased(keyEvent -> {
				keyReleasedEvents.forEach(event -> {
					event.handle(keyEvent);
				});
			});
				
			return scene;
		}), scrollEvents, keyPressedEvents, keyReleasedEvents);
	}
	
	public EventScene(final CachedValue<Scene> cachedScene, final List<ParamEvent<ScrollEvent>> scrollEvents, final List<ParamEvent<KeyEvent>> keyPressedEvents, final List<ParamEvent<KeyEvent>> keyReleasedEvents) {
		this.cachedScene = cachedScene;
		this.scrollEvents = scrollEvents;
		this.keyPressedEvents = keyPressedEvents;
		this.keyReleasedEvents = keyReleasedEvents;
	}
	
	public void workWithScene(final ParamEvent<Scene> task) {
		task.handle(this.cachedScene.value());
	}
	
	public void addScrollEvent(final ParamEvent<ScrollEvent> event) {
		this.scrollEvents.add(event);
	}
	
	public void addKeyPressedEvent(final ParamEvent<KeyEvent> event) {
		this.keyPressedEvents.add(event);
	}
	
	public void addKeyReleasedEvent(final ParamEvent<KeyEvent> event) {
		this.keyReleasedEvents.add(event);
	}
	
	private final CachedValue<Scene> cachedScene;
	private final List<ParamEvent<ScrollEvent>> scrollEvents;
	private final List<ParamEvent<KeyEvent>> keyPressedEvents;
	private final List<ParamEvent<KeyEvent>> keyReleasedEvents;
}
