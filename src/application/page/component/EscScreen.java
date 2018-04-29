package application.page.component;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import plain.map.FlagMap;
import plain.map.FormalMap;

public final class EscScreen {
	public EscScreen(final FlagMap<String, FormalMap<String, Boolean>> flagMap) {
		this.flagMap = flagMap;
	}
	
	public void toggleEsc(final Pane root) {
		// Hide ESC option.
		if(root.getChildren().contains(this.pane())) {
			root.getChildren().remove(this.pane());
			this.flagMap.update("esc", false);
			return;
		}
		
		// show ESC option.
		root.getChildren().add(this.pane());
		this.flagMap.update("esc", true);
	}
	
	public void workWithPane(final Consumer<StackPane> task) {
		task.accept(this.pane());
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
		pane.setCache(true);
		pane.setCacheHint(CacheHint.SCALE_AND_ROTATE);
		
		this.cache.add(pane);
		return this.cache.get(0);
	}
	
	private final List<StackPane> cache = new ArrayList<>();
	private final FlagMap<String, FormalMap<String, Boolean>> flagMap;
}
