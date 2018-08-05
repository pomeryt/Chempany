package application.event.plain;

import javafx.stage.Stage;
import plain.contract.event.PlainEvent;

public final class CloseStage implements PlainEvent {

	public CloseStage(final Stage stage) {
		this.stage = stage;
	}
	
	@Override
	public void handle() {
		this.stage.close();
	}

	private final Stage stage;
}
