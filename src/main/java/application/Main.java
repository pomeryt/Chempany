package application;

import application.title.TitlePage;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Starting point of the entire game.
 * @author Rin
 * @version 1.0.0
 */
public final class Main extends Application {

	@Override
	public void start(final Stage stage) throws Exception {
		final TitlePage titlePage = new TitlePage();

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
	 * @since 1.0.0
	 */
	public static void main(final String... args) {
		Application.launch(args);
	}
}