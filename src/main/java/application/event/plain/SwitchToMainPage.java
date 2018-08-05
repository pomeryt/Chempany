package application.event.plain;

import application.page.main.MainPage;
import application.page.main.MpShow;
import javafx.stage.Stage;
import plain.contract.event.PlainEvent;

public final class SwitchToMainPage implements PlainEvent {

	public SwitchToMainPage(final Stage stage, final MainPage mainPage) {
		this.stage = stage;
		this.mainPage = mainPage;
	}
	
	@Override
	public void handle() {
		this.mainPage.workOn(new MpShow(this.stage));
	}
	
	private final Stage stage;
	private final MainPage mainPage;
}
