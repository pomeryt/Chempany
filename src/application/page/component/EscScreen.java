package application.page.component;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public final class EscScreen {
	public void toggleEsc(final Pane root) {
		if(root.getChildren().contains(this.pane())) {
			root.getChildren().remove(this.pane());
			return;
		}
		root.getChildren().add(this.pane());
	}
	
	

	private StackPane pane() {
		
		if(this.cache.isEmpty() == false) {
			return this.cache.get(0);			
		}
		
		final Button bSave = new Button();
		bSave.setText("Save");
		bSave.setPrefWidth(80);
		bSave.setStyle("-fx-background-color:gold; -fx-border-color:black");
		
		final Button bOption = new Button();
		bOption.setText("Option");
		bOption.setPrefWidth(80);
		bOption.setStyle("-fx-background-color:gold; -fx-border-color:black");
		
		final GridPane grid = new GridPane();
		grid.addColumn(0, bSave, bOption);
		grid.setAlignment(Pos.CENTER);
		grid.setVgap(5);
		
		final Label lMenuTitle = new Label(); 
		lMenuTitle.setText("Game Menu");
		lMenuTitle.setStyle("-fx-border-color:black; -fx-background-color:lime;");
		lMenuTitle.setPrefWidth(Integer.MAX_VALUE);
		lMenuTitle.setAlignment(Pos.CENTER);
		
		final StackPane pane = new StackPane();
		pane.getChildren().add(grid);
		pane.getChildren().add(lMenuTitle);
		pane.setStyle("-fx-border-color:black; -fx-background-color:pink");
		
		pane.setMaxSize(200, 200);
		StackPane.setAlignment(lMenuTitle, Pos.TOP_CENTER);
		
		this.cache.add(pane);
		return this.cache.get(0);
	}
	
	private final List<StackPane> cache = new ArrayList<>();
}
