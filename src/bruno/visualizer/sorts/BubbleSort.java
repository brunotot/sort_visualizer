/*
 * 
 */
package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the bubble sort class.
 * 
 * @author Bruno
 *
 */
public class BubbleSort extends UpdateGraphThread {
	/**
	 * Starts the bubble sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 */
	public static void bubbleSort(int arr[], BarChart<String, Number> chart) {
		startThread(chart);
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					list.add(new XYValue(j, arr[j]));

					arr[j + 1] = temp;
					list.add(new XYValue(j + 1, arr[j + 1]));
				}
			}
		}
	}

	/**
	 * Starts the bubble sort sequence recursively.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param n     size of the array
	 */
	public static void bubbleSortRecursively(int arr[], BarChart<String, Number> chart, int n) {
		if (n == 1) {
			return;
		}

		startThread(chart);

		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				list.add(new XYValue(i, arr[i]));
				arr[i + 1] = temp;
				list.add(new XYValue(i + 1, arr[i + 1]));
			}
		}

		bubbleSortRecursively(arr, chart, n - 1);
	}
}
