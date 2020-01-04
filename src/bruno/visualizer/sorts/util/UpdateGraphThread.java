package bruno.visualizer.sorts.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import bruno.visualizer.app.Main;
import bruno.visualizer.util.Colors;
import javafx.application.Platform;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Slider;

/**
 * Represents a static class that's used for threading the update of the chart.
 * 
 * @author TotB
 *
 */
public class UpdateGraphThread {
	/**
	 * Holds integer information of how many milliseconds does it take to actually
	 * start the sorting sequence.
	 */
	private static final Integer INITIALDELAYMILLISECONDS = 10;

	/**
	 * A static final Integer that holds the value of time to wait after each array
	 * element change.
	 */
	private static Integer WAITMILLISECONDS = 2;

	/**
	 * A static index counter variable that is used in startThread() to get XYValue
	 * object.
	 */
	protected static Integer indexCounter = 0;

	/**
	 * A static list variable that holds temporary list data of XYValue objects.
	 */
	protected static List<XYValue> list = new ArrayList<>();

	/**
	 * A static ScheduledExecutorService object used to start and stop the update of
	 * the chart.
	 */
	private static ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

	/**
	 * A basic stop-thread method (stops scheduled executor service if in running
	 * state).
	 */
	protected static boolean stopThread() {
		
		if (scheduledExecutorService != null && !scheduledExecutorService.isShutdown()) {
			scheduledExecutorService.shutdown();
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Starts Platform.runLater() which updates the chart every WAITMILLISECONDS
	 * amount of milliseconds.
	 * 
	 * @param chart the chart that needs to be updated
	 */
	protected static void startThread(BarChart<String, Number> chart) {
		if(!scheduledExecutorService.isTerminated())
			return;
		if (chart == null)
			return;
		Slider transitionSpeed = (Slider) Main.getRoot().lookup("#transitionSpeed");
		WAITMILLISECONDS = (int) (transitionSpeed.getValue() * -1);
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleAtFixedRate(() -> {
			Platform.runLater(() -> {
				if (indexCounter == list.size()) {
					chart.getData().get(0).getData().forEach(elem -> {
						elem.getNode().setStyle("-fx-background-color: " + Colors.DEFAULT + ";");
					});
					indexCounter = 0;
					list = new ArrayList<>();
					stopThread();
					
					return;
				}

				if (indexCounter == 0)
					chart.getData().get(0).getData().get(list.get(indexCounter).getIndex()).getNode()
							.setStyle("-fx-background-color: " + Colors.DEFAULT + ";");

				else
					chart.getData().get(0).getData().get(list.get(indexCounter - 1).getIndex()).getNode()
							.setStyle("-fx-background-color: " + Colors.DEFAULT + ";");
				chart.getData().get(0).getData().get(list.get(indexCounter).getIndex()).getNode()
						.setStyle("-fx-background-color: " + Colors.CHANGINGELEMENT + ";");
				chart.getData().get(0).getData().get(list.get(indexCounter).getIndex())
						.setYValue(list.get(indexCounter).getValue());
				indexCounter++;
			});
		}, INITIALDELAYMILLISECONDS, WAITMILLISECONDS, TimeUnit.MILLISECONDS);
	}
	
	/**
	 * Modifies the delay speed.
	 * 
	 * @param milliseconds delay milliseconds
	 * @param chart chart that holds an array of integer values
	 */
	protected static void updateThreadDelay(int milliseconds, BarChart<String, Number> chart) {
		if(milliseconds * -1 == WAITMILLISECONDS) {
			return;
		}
		stopThread();
		WAITMILLISECONDS = milliseconds * -1;
		startThread(chart);
	}
}
