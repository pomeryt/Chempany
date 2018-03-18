package application;
	
import javafx.application.Application;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(final Stage stage) {
		try {
			
			stage.setTitle("Chempany");
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
