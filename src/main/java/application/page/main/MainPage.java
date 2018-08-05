package application.page.main;

import application.event.param.ToggleEscScreenOnEscKey;
import application.fx.pane.esc.EscPane;
import application.fx.scene.event.EsOnKeyPressed;
import application.fx.scene.event.EventScene;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.map.FlagMap;
import plain.map.FormalMap;
import plain.value.CachedValue;

public final class MainPage implements MyEntity<MainPage> {

	public MainPage(final FlagMap<String, FormalMap<String, Boolean>> flagMap) {
		this(new EscPane(flagMap));
	}
	
	public MainPage(final EscPane escPane) {
		this.escPane = escPane;
	}
	
	/**
	 * @param task All types of this task have the prefix 'Mp'.
	 */
	@Override
	public void workOn(final VoidTaskOfEntity<MainPage> task) {
		task.handle(this);
	}

	/**
	 * @param task All types of this task have the prefix 'Mp'.
	 */
	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, MainPage> task) {
		return task.handle(this);
	}
	
	private EscPane escPane() {
		return this.escPane;
	}
	
	final EscPane escPane;
	
	final CachedValue<StackPane> cachedRoot = new CachedValue<>(() -> {
		// Test.
		final StackPane block = new StackPane();
		block.setMaxSize(150, 150);
		block.setStyle("-fx-border-color: blue");

		final StackPane root = new StackPane();
		root.getChildren().add(block);
		
		return root;
	});
	
	final CachedValue<EventScene> cachedEventScene = new CachedValue<>(() -> {
		final Scene scene = new Scene(this.cachedRoot.value());
		scene.setCamera(new PerspectiveCamera());

		final EventScene eventScene = new EventScene(scene);
		eventScene.workOn(
			new EsOnKeyPressed(
				new ToggleEscScreenOnEscKey(
					this.escPane(), this.cachedRoot.value(), scene.getCamera()
				)
			)
		);
		
		return eventScene;
	});
}
