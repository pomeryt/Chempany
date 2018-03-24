package application.page;

import java.util.ArrayList;
import java.util.List;

import application.page.contract.Displayable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import plain.contract.event.PlainEvent;

public final class TitlePage implements Displayable {

	public TitlePage(final Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void display() {
		this.stage.setScene(this.scene());
	}
	
	public void addNewEvent(final PlainEvent event) {
		this.newEvents.add(event);
	}
	
	private Scene scene() {
		// Return scene from cache if exists.
		if (this.cache.isEmpty() == false) {
			return this.cache.get(0);
		}
		
		// Build scene:
		final Label lTitle = new Label();
		lTitle.setText("Alchemy");
		lTitle.setStyle("-fx-font-size:100");
		
		final Button bNew = new Button();
		bNew.setText("New");
		bNew.setStyle("-fx-font-size:25");
		bNew.setPrefWidth(150);
		bNew.setOnAction(e->{
			this.newEvents.forEach(event -> {
				event.handle();
			});
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
			this.stage.close();
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
		
		final Scene scene = new Scene(pane);
		
		// Cache the scene:
		this.cache.add(scene);
		return this.cache.get(0);
	}
	
	private final Stage stage;
	
	private final List<Scene> cache = new ArrayList<>();
	private final List<PlainEvent> newEvents = new ArrayList<>();
}
