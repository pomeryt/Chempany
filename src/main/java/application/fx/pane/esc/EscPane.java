package application.fx.pane.esc;

import javafx.geometry.Pos;
import javafx.scene.CacheHint;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.map.FlagMap;
import plain.map.FormalMap;
import plain.value.CachedValue;

public final class EscPane implements MyEntity<EscPane> {

	public EscPane(final FlagMap<String, FormalMap<String, Boolean>> flagMap) {
		this.flagMap = flagMap;
	}
	
	/**
	 * @param task All types of this task have the prefix 'Ep'.
	 */
	@Override
	public void workOn(final VoidTaskOfEntity<EscPane> task) {
		task.handle(this);
	}

	/**
	 * @param task All types of this task have the prefix 'Ep'.
	 */
	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, EscPane> task) {
		return task.handle(this);
	}
	
	final FlagMap<String, FormalMap<String, Boolean>> flagMap;
	
	final CachedValue<StackPane> cachedRoot = new CachedValue<>(() -> {
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
		
		return pane;
	});
}
