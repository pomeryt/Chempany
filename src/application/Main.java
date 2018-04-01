package application;
	
import application.page.MainPage;
import application.page.TitlePage;
import application.player.Player;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(final Stage stage) {
		try {
			// Player.
			final Player player = new Player();
			
			// MainPage.
			final MainPage mainPage = new MainPage(stage, player);
			
			// TitlePage.
			final TitlePage titlePage = new TitlePage(stage);
			titlePage.addNewEvent(()->{
				mainPage.display();
			});
			titlePage.display();
			
			// Stage.
			stage.setTitle("Alchemy");
			stage.setWidth(825);
			stage.setHeight(550);
			stage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
