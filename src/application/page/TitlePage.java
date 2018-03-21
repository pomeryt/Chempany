package application.page;

import java.util.ArrayList;
import java.util.List;

import application.page.contract.Displayable;
import javafx.scene.Scene;
import javafx.stage.Stage;

public final class TitlePage implements Displayable {

	public TitlePage(final Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void display() {
		this.stage.setScene(this.scene());
	}
	
	private Scene scene() {
		// Return scene from cache if exists.
		if (this.cache.isEmpty() == false) {
			return this.cache.get(0);
		}
		
		// Build scene:
		
		// Cache the scene:
		
		return this.cache.get(0);
	}
	
	private final Stage stage;
	
	private final List<Scene> cache = new ArrayList<>();
}
