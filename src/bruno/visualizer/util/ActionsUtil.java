package bruno.visualizer.util;

import javafx.scene.control.Labeled;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ActionsUtil {
	public static void setImage(Labeled node, Image image, int width, int height) {
		ImageView imageView = new ImageView(image);
		imageView.setFitWidth(width);
		imageView.setFitHeight(height);
		node.setGraphic(imageView);
	}

}
