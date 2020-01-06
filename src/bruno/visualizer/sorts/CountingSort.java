package bruno.visualizer.sorts;

import java.util.Arrays;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the counting sort class.
 * 
 * @author Bruno
 */
public class CountingSort extends UpdateGraphThread {
	/**
	 * Starts the counting sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 */
	public static void countingSort(int[] arr, BarChart<String, Number> chart) {
		startThread(chart);
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max - min + 1;
		int count[] = new int[range];
		int output[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i] - min]++;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] += count[i - 1];
		}

		for (int i = arr.length - 1; i >= 0; i--) {
			output[count[arr[i] - min] - 1] = arr[i];
			list.add(new XYValue(count[arr[i] - min] - 1, output[count[arr[i] - min] - 1]));
			count[arr[i] - min]--;
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
			list.add(new XYValue(i, arr[i]));
		}
	}
}
