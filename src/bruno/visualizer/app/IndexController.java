package bruno.visualizer.app;

import java.io.IOException;

import bruno.visualizer.util.ActionsUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

// TODO FIX RESIZING WINDOW PROBLEM
// TODO EDIT CSS ON VBOX

public class IndexController {
	@FXML
	public void openStart() {
		try {
			BorderPane centerPane = (BorderPane) FXMLLoader.load(getClass().getResource("Start.fxml"));
			Main.setPane(centerPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML private VBox menuExpanded;
	@FXML private Button menu;
	@FXML private Button comparison;
	@FXML private Button statistics;
	@FXML private Button sortVisualizer;
	
	public void initialize() {
		comparison.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		statistics.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		sortVisualizer.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		
		VBox.setVgrow(menu, Priority.ALWAYS);
		VBox.setVgrow(comparison, Priority.ALWAYS);
		VBox.setVgrow(statistics, Priority.ALWAYS);
		VBox.setVgrow(sortVisualizer, Priority.ALWAYS);
		
        ActionsUtil.setImage(menu, new Image("file:././././img/blue-menu.png"), 26, 26);
        ActionsUtil.setImage(comparison, new Image("file:././././img/blue-x.png"), 26, 26);
        ActionsUtil.setImage(sortVisualizer, new Image("file:././././img/blue-start.png"), 26, 26);
        ActionsUtil.setImage(statistics, new Image("file:././././img/blue-menu.png"), 26, 26);

		menuExpanded.prefHeightProperty().bind(Main.getStage().getScene().heightProperty());
	}
}	
