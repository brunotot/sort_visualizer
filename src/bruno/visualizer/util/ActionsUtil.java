/*
 * 
 */
package bruno.visualizer.util;

import javafx.scene.Node;
import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Set of action utility methods.
 * 
 * @author Bruno
 *
 */
public class ActionsUtil {
	/**
	 * Creates an ImageView object with fit dimensions and sets its graphic to node
	 * parameter.
	 * 
	 * @param image  image object to set to ImageView object
	 * @param width  width of image
	 * @param height height of image
	 * @param node   node to set image in
	 */
	public static void setImage(Labeled node, Image image, int width, int height) {
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		node.setGraphic(imageView);
	}

	/**
	 * Creates an ImageView object with fit dimensions.
	 * 
	 * @param image  image object to set to ImageView object
	 * @param width  width of image
	 * @param height height of image
	 * @return graphic node of ImageView object
	 */
	public static Node getGraphic(Image image, int width, int height) {
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		return imageView;
	}
}
