package application;
	
import java.awt.Point;
import java.lang.reflect.Field;

import application.chunk.Chunk;
import application.chunk.ChunkGenerateChunk;
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
import application.player.PlayerXPos;
import application.player.PlayerYPos;
import application.turtle.TurtleCoordinate;
import application.utility.pattern.TornadoPattern;
import application.utility.point.ChunkPointOfPlayer;
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
				new PlayerOnMove(
					p -> {
						new ChunkUpdatePlayerCoord(p).handle(chunk);
					},
					p -> {
						final double playerX = p.valueOf(new PlayerXPos());
						final double playerY = p.valueOf(new PlayerYPos());
						final Point chunkPoint = new ChunkPointOfPlayer(playerX, playerY, 5, 20).value();
						/*System.out.println(
							"Player Coord: ("+playerX+", "+playerY+")"
							+ "\tChunk Coord: ("+chunkPoint.x+", "+chunkPoint.y+")"
						);
						System.out.println();*/
					}
				)
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
			
			chunk.workOn(new ChunkOnPlayerCoordUpdate(
				point -> {
					new TornadoPattern(11, point, turtle -> {
						chunk.workOn(new ChunkGenerateChunk(turtle.valueOf(new TurtleCoordinate())));
					}).makePattern();
				},
				point -> {
					/*try { 
					final Field field = chunk.getClass().getDeclaredField("loadedChunks");
					field.setAccessible(true);
					System.out.println(field.get(chunk));
					System.out.println();
					} catch (Exception e) {
						e.printStackTrace();
					}*/
				}
			));
			
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
