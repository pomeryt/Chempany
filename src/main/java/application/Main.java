package application;

import application.overworld.Overworld;
import application.title.TitlePage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starting point of the entire game.
 * @author Rin
 */
public final class Main extends Application {

	@Override
	public void start(final Stage stage) {
		final TitlePage titlePage = new TitlePage(stage, new Overworld());

		final double width = 825;
		final double height = 550;

		stage.setScene(titlePage.scene());
		stage.setTitle("Alchemist");
		stage.setWidth(width);
		stage.setHeight(height);
		stage.show();
	}

	/**
	 * Main method.
	 * @param args JavaFX application launch arguments.
	 */
	public static void main(final String... args) {
		Application.launch(args);
	}
}