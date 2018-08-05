package application.page.title;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import plain.contract.entity.MyEntity;
import plain.contract.entity.ReturnTaskOfEntity;
import plain.contract.entity.VoidTaskOfEntity;
import plain.contract.event.PlainEvent;
import plain.value.CachedValue;

public final class TitlePage implements MyEntity<TitlePage> {
	
	/**
	 * @param task All types of this task have the prefix 'Tp'.
	 */
	@Override
	public void workOn(final VoidTaskOfEntity<TitlePage> task) {
		task.handle(this);
	}

	/**
	 * @param task All types of this task have the prefix 'Tp'.
	 */
	@Override
	public <T> T valueOf(final ReturnTaskOfEntity<T, TitlePage> task) {
		return task.handle(this);
	}
	
	final CachedValue<Scene> cachedScene = new CachedValue<>(() -> {
		final Label lTitle = new Label();
		lTitle.setText("Alchemy");
		lTitle.setStyle("-fx-font-size:100");
		
		final Button bNew = new Button();
		bNew.setText("New");
		bNew.setStyle("-fx-font-size:25");
		bNew.setPrefWidth(150);
		bNew.setOnAction(e->{
			this.newEvents.forEach(event -> event.handle());
		});
		
		final Button bLoad = new Button();
		bLoad.setText("Load");
		bLoad.setStyle("-fx-font-size:25");
		bLoad.setPrefWidth(150);
		
		final Button bOption = new Button();
		bOption.setText("Option");
		bOption.setStyle("-fx-font-size:25");
		bOption.setPrefWidth(150);
		
		final Button bExit = new Button();
		bExit.setText("Exit");
		bExit.setStyle("-fx-font-size:25");
		bExit.setPrefWidth(150);
		bExit.setOnAction(e->{
			this.exitEvents.forEach(event -> event.handle());
		});
		
		final GridPane gridButtons = new GridPane();
		gridButtons.addColumn(0, bNew, bLoad, bOption, bExit);
		gridButtons.setAlignment(Pos.CENTER);
		gridButtons.setVgap(8);
		gridButtons.setPadding(new Insets(100, 0, 0, 0));
		
		final StackPane pane = new StackPane();
		pane.getChildren().add(lTitle);
		pane.getChildren().add(gridButtons);
		StackPane.setAlignment(lTitle, Pos.TOP_CENTER);
		
		return new Scene(pane);
	});
	final List<PlainEvent> newEvents = new ArrayList<>();
	final List<PlainEvent> exitEvents = new ArrayList<>();
}
