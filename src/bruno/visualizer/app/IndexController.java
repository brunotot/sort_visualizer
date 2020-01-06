/*
 * 
 */
package bruno.visualizer.app;

import java.io.IOException;

import bruno.visualizer.util.ActionsUtil;
import bruno.visualizer.util.Constraints;
import bruno.visualizer.util.TextUtil;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Labeled;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
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
			Main.setPane(centerPane, "center");
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
	 * An initializer for IndexController.java.
	 */
	public void initialize() {
		addNodeToVerticalMenu(new Button("", ActionsUtil.getGraphic(new Image("file:././././img/blue-menu.png"),
				Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT)), "menu");
		addNodeToVerticalMenu(new Button("", ActionsUtil.getGraphic(new Image("file:././././img/blue-menu.png"),
				Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT)), "statistics");
		addNodeToVerticalMenu(new Button("", ActionsUtil.getGraphic(new Image("file:././././img/blue-x.png"),
				Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT)), "comparison");
		addNodeToVerticalMenu(new Button("", ActionsUtil.getGraphic(new Image("file:././././img/blue-start.png"),
				Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT)), "sortVisualizer");
		addNodeToVerticalMenu(new Button("", ActionsUtil.getGraphic(new Image("file:././././img/blue-forward.png"),
				Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT)), "expansionButton");

		verticalMenu.getChildren().forEach(child -> {
			child.getStyleClass().add("menu_button");
			child.setStyle("-fx-background-color: " + Constraints.BACKGROUNDCOLOR);
		});

		verticalMenu.getChildren().get(getIndexById(verticalMenu.getChildren(), "sortVisualizer"))
				.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						openStart();
					};
				});

		verticalMenu.getChildren().get(getIndexById(verticalMenu.getChildren(), "expansionButton"))
				.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
					public void handle(MouseEvent e) {
						if (!((Button) verticalMenu.getChildren().get(0)).getText().equals("")) {
							for (Node child : verticalMenu.getChildren()) {
								if (child.getId().equals("expansionButton")) {
									((Button) child).setGraphic(
											ActionsUtil.getGraphic(new Image("file:././././img/blue-forward.png"),
													Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT));
									break;
								}
								Button button = (Button) child;
								button.setText("");
							}
						} else {
							for (Node child : verticalMenu.getChildren()) {
								if (child.getId().equals("expansionButton")) {
									((Button) child).setGraphic(
											ActionsUtil.getGraphic(new Image("file:././././img/blue-backward.png"),
													Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT));
									break;
								}
								Button button = (Button) child;
								button.setText(TextUtil.toSentenceCase(child.getId()));
							}
						}
					};
				});
	}

	/**
	 * Method for obtaining index of element by their id.
	 * 
	 * @param observableList list to search elements by id in
	 * @param id             id of element to search
	 * @return index of element in list by id
	 */
	private int getIndexById(ObservableList<Node> observableList, String id) {
		if (observableList == null) {
			System.err.println("Given observable list doesn't contain any data!");
			return -1;
		}

		for (int i = 0; i < observableList.size(); i++) {
			if (observableList.get(i).getId().equals(id)) {
				return i;
			}
		}

		// TODO exceptions...
		System.err.println("Given ID doesn't exist!");
		return -2;
	}

	/**
	 * Adds node parameter to the vertical menu with given id.
	 * 
	 * @param node parameter to be added to the vertical menu
	 * @param id   sets id of node
	 */
	private void addNodeToVerticalMenu(Labeled node, String id) {
		node.setTooltip(new Tooltip(TextUtil.toSentenceCase(id)));
		node.setMaxHeight(Double.MAX_VALUE);
		node.setId(id);
		VBox.setVgrow(node, Priority.ALWAYS);
		verticalMenu.getChildren().add(node);
	}
}
