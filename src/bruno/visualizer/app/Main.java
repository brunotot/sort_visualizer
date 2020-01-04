package bruno.visualizer.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Main class that starts the primary window of SortVisualizer JavaFX project
 * 
 * @author TotB
 *
 */
public class Main extends Application {
	/**
	 * Static main BorderPane window object.
	 */
	public static BorderPane root;
	
	/**
	 * Getter method for main BorderPane object.
	 * 
	 * @return main BorderPane object
	 */
	public static BorderPane getRoot() {
		return root;
	}

	/**
	 * Setter method for main BorderPane object.
	 * 
	 * @param root main BorderPane object
	 */
	public static void setRoot(BorderPane root) {
		Main.root = root;
	}

	/**
	 * Method gets called upon launch() to start the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			root = (BorderPane) FXMLLoader.load(getClass().getResource("Start.fxml"));
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.getIcons().add(new Image("file:img\\logo.png"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Starting method for SortVisualizer JavaFX project
	 * 
	 * @param args input string (usually null)
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
