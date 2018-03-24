package application.page;

import java.util.ArrayList;
import java.util.List;

import application.page.component.EscScreen;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public final class MainPage {

	public MainPage(final Stage stage) {
		this.stage = stage;
	}
	
	public void display() {
		this.stage.setScene(this.scene());
				
	}
	
	
	private Scene scene() {
		
		if(this.cache.isEmpty() == false) {
			return this.cache.get(0);
		}
		
		final StackPane root = new StackPane();
		final Scene scene = new Scene(root);
		scene.setOnKeyPressed(keyEvent->{
			if(keyEvent.getCode().equals(KeyCode.ESCAPE)) {
				this.escScreen.toggleEsc(root);
			}
		});
		
		this.cache.add(scene);
		return this.cache.get(0);
	}
	
	
	private final Stage stage;
	private final EscScreen escScreen = new EscScreen(); 
	private final List<Scene> cache = new ArrayList<>(); 
}
