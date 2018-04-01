package application.page;

import java.util.ArrayList;
import java.util.List;

import application.page.component.EscScreen;
import application.player.Player;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public final class MainPage {

	public MainPage(final Stage stage, Player player) {
		this.stage = stage;
		this.player = player;
	}
	
	public void display() {
		this.stage.setScene(this.scene());
		this.player.spawn(this.scene(), this.root());
	}
	
	private Pane root() {
		if (this.cachedRoot.isEmpty() == false) {
			return this.cachedRoot.get(0);
		}
		
		// Test.
		final StackPane block = new StackPane();
		block.setMaxSize(150, 150);
		block.setStyle("-fx-border-color: blue");
		
		final StackPane root = new StackPane();
		root.getChildren().add(block);
		
		this.cachedRoot.add(root);
		return cachedRoot.get(0);
	}
	
	private Scene scene() {
		if(this.cachedScene.isEmpty() == false) {
			return this.cachedScene.get(0);
		}
		
		final Scene scene = new Scene(this.root());
		scene.setOnKeyPressed(keyEvent->{
			if(keyEvent.getCode().equals(KeyCode.ESCAPE)) {
				this.escScreen.toggleEsc(this.root());
			}
		});
		
		this.cachedScene.add(scene);
		
		return this.cachedScene.get(0);
	}
	
	
	private final Stage stage;
	private final Player player;
	private final EscScreen escScreen = new EscScreen(); 
	private final List<Pane> cachedRoot = new ArrayList<>();
	private final List<Scene> cachedScene = new ArrayList<>(); 
}
