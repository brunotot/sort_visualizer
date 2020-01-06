package bruno.visualizer.app;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.util.Constraints;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Main class that starts the primary window of SortVisualizer JavaFX project.
 *
 * @author Bruno
 */
public class Main extends Application {
	/**
	 * Static main Stage object.
	 */
	public static Stage stage;

	/**
	 * Getter method for main Stage object.
	 * 
	 * @return stage object
	 */
	public static Stage getStage() {
		return stage;
	}
	
	/**
	 * Static main BorderPane window object.
	 */
	public static GridPane root;

	/**
	 * Getter method for main BorderPane object.
	 * 
	 * @return main BorderPane object
	 */
	public static GridPane getRoot() {
		return root;
	}
	
	/**
	 * Method gets called upon launch() to start the primary stage.
	 *
	 * @param primaryStage the primary stage
	 */
	@Override
	public void start(Stage primaryStage) {
		try {
			stage = primaryStage;
			stage.getIcons().add(new Image("file:img\\logo.png"));
			root = (GridPane) FXMLLoader.load(getClass().getResource("Index.fxml"));
			Scene scene = new Scene(root, Constraints.STARTWINDOWWIDTH, Constraints.STARTWINDOWHEIGHT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage.setScene(scene);
			stage.setOnHiding(event -> UpdateGraphThread.stopThread());
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Starting method for SortVisualizer JavaFX project.
	 *
	 * @param args input string (usually null)
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Replaces second child (right side of window) with another child parameter.
	 * 
	 * @param pane node object to be replaced with the old node on root.getChildren().get(1)
	 */
	public static void setPane(Node pane) {
		if(root.getChildren() != null && root.getChildren().size() == 2)
			root.getChildren().remove(1);
		root.getChildren().add(pane);
	}

}
