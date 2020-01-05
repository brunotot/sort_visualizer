package bruno.visualizer.app;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.util.Constraints;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * Main class that starts the primary window of SortVisualizer JavaFX project.
 *
 * @author TotB
 */
public class Main extends Application {
	public static Stage stage;
	
	/**
	 * Static main BorderPane window object.
	 */
	public static HBox root;

	/**
	 * Getter method for main BorderPane object.
	 * 
	 * @return main BorderPane object
	 */
	public static HBox getRoot() {
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
			Scene scene = new Scene(new HBox(), Constraints.STARTWINDOWWIDTH, Constraints.STARTWINDOWHEIGHT);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			stage = primaryStage;
			stage.getIcons().add(new Image("file:img\\logo.png"));
			stage.setScene(scene);
			
			root = (HBox) FXMLLoader.load(getClass().getResource("Index.fxml"));
			scene.setRoot(root);
			stage.getIcons().add(new Image("file:img\\logo.png"));
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
	
	public static void setPane(Node pane) {
		if(root.getChildren() != null && root.getChildren().size() == 2)
			root.getChildren().remove(1);
		root.getChildren().add(pane);
	}

	public static Stage getStage() {
		return stage;
	}
}
