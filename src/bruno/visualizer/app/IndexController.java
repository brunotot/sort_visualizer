/*
 * 
 */
package bruno.visualizer.app;

import java.io.IOException;

import bruno.visualizer.util.ActionsUtil;
import bruno.visualizer.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

/**
 * A controller class that controls Index.fxml.
 * 
 * @author Bruno
 *
 */
public class IndexController {
	/**
	 * Opens new window by clicking on certain button.
	 */
	@FXML
	public void openStart() {
		try {
			BorderPane centerPane = (BorderPane) FXMLLoader.load(getClass().getResource("Start.fxml"));
			Main.setPane(centerPane);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Vertical menu on the left side of the starting window.
	 */
	@FXML
	private VBox verticalMenu;
	
	/**
	 * Menu button placed in verticalMenu VBox container.
	 */
	@FXML
	private Button menu;

	/**
	 * Comparison button placed in verticalMenu VBox container.
	 */
	@FXML
	private Button comparison;

	/**
	 * Statistics button placed in verticalMenu VBox container.
	 */
	@FXML
	private Button statistics;

	/**
	 * Sort visualizer button placed in verticalMenu VBox container.
	 */
	@FXML
	private Button sortVisualizer;

	/**
	 * An initializer for IndexController.java.
	 */
	public void initialize() {
		menu.setMaxHeight(Double.MAX_VALUE);
		comparison.setMaxHeight(Double.MAX_VALUE);
		statistics.setMaxHeight(Double.MAX_VALUE);
		sortVisualizer.setMaxHeight(Double.MAX_VALUE);

		VBox.setVgrow(menu, Priority.ALWAYS);
		VBox.setVgrow(comparison, Priority.ALWAYS);
		VBox.setVgrow(statistics, Priority.ALWAYS);
		VBox.setVgrow(sortVisualizer, Priority.ALWAYS);

		ActionsUtil.setImage(menu, new Image("file:././././img/blue-menu.png"), Constraints.MENUBUTTONWIDTH, Constraints.MENUBUTTONHEIGHT);
		ActionsUtil.setImage(comparison, new Image("file:././././img/blue-x.png"), Constraints.MENUBUTTONWIDTH, Constraints.MENUBUTTONHEIGHT);
		ActionsUtil.setImage(sortVisualizer, new Image("file:././././img/blue-start.png"), Constraints.MENUBUTTONWIDTH, Constraints.MENUBUTTONHEIGHT);
		ActionsUtil.setImage(statistics, new Image("file:././././img/blue-menu.png"), Constraints.MENUBUTTONWIDTH, Constraints.MENUBUTTONHEIGHT);
	}
}
