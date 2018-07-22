package application;
	
import application.chunk.Chunk;
import application.chunk.ChunkOnPlayerCoordUpdate;
import application.chunk.ChunkUpdatePlayerCoord;
import application.event.param.EnablePlayerToMove;
import application.event.plain.CloseStage;
import application.event.plain.SpawnPlayerToField;
import application.event.plain.SwitchToMainPage;
import application.page.main.MainPage;
import application.page.main.MpEventScene;
import application.page.main.MpRoot;
import application.page.title.TitlePage;
import application.page.title.TpOnExit;
import application.page.title.TpOnNew;
import application.page.title.TpShow;
import application.player.Player;
import application.player.PlayerOnEnterField;
import application.player.PlayerOnMove;
import application.turtle.TurtleCoordinate;
import application.utility.pattern.TornadoPattern;
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
			
			// Chunk.
			final Chunk chunk = new Chunk();
			chunk.workOn(new ChunkOnPlayerCoordUpdate(
				point -> {System.out.println("Start to make pattern.");},
				point -> {
					new TornadoPattern(11, point, turtle -> {
						System.out.println(turtle.valueOf(new TurtleCoordinate()));
					}).makePattern();
				}
			));
			
			// MainPage.
			final MainPage mainPage = new MainPage(flagMap);
			
			// Player.
			final Player player = new Player(flagMap);
			player.workOn(
				new PlayerOnEnterField(
					new EnablePlayerToMove(mainPage.valueOf(new MpEventScene()), flagMap)
				)
			);
			player.workOn(
				new PlayerOnMove(p -> {
					new ChunkUpdatePlayerCoord(p).handle(chunk);
				})
			);
			
			// TitlePage.
			final TitlePage titlePage = new TitlePage();
			titlePage.workOn(
				new TpOnNew(
					new SwitchToMainPage(stage, mainPage), 
					new SpawnPlayerToField(player, mainPage.valueOf(new MpRoot()))
				)
			);
			titlePage.workOn(new TpOnExit(new CloseStage(stage)));
			titlePage.workOn(new TpShow(stage));
			
			// Stage.
			stage.setTitle("Alchemy");
			stage.setWidth(825);
			stage.setHeight(550);
			stage.show();
			
		} catch(Exception exception) {
			exception.printStackTrace();
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
