package application;
	
import application.page.MainPage;
import application.page.TitlePage;
import application.player.Player;
import javafx.application.Application;
import javafx.stage.Stage;
import plain.map.FlagMap;
import plain.map.FormalMap;

public class Main extends Application {
	@Override
	public void start(final Stage stage) {
		try {
			// FlagMap.
			final FlagMap<String, FormalMap<String, Boolean>> flagMap = this.newFlagMap();
			
			// Player.
			final Player player = new Player(flagMap);
			
			// MainPage.
			final MainPage mainPage = new MainPage(stage, player, flagMap);
			
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
	
	private FlagMap<String, FormalMap<String, Boolean>> newFlagMap() {
		final FlagMap<String, FormalMap<String, Boolean>> flagMap = new FlagMap<>(new FormalMap<>());
		flagMap.register("esc", false);
		return flagMap;
	}
}
