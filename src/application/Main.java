package application;
	
import application.page.TitlePage;
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(final Stage stage) {
		try {
			// TitlePage
			final TitlePage titlePage = new TitlePage(stage);
			titlePage.display();
			
			// Stage
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
