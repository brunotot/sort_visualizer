/*
 * 
 */
package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the quick sort class.
 * 
 * @author Bruno
 */
public class QuickSort extends UpdateGraphThread {

	/**
	 * Method for obtaining the pi integer used in quick sort method.
	 *
	 * @param arr             array of integer values of the chart
	 * @param low             low integer parameter
	 * @param high            high integer parameter
	 * @param chart           chart that holds an array of integer values
	 * @param normalQuickSort can be normal quick sort or iterative quick sort
	 * @return pi partition integer
	 */
	private static int partition(int arr[], int low, int high, BarChart<String, Number> chart,
			boolean normalQuickSort) {
		int pivot = arr[high];
		int i = (low - 1);
		for (int j = low; j < high; j++) {
			if (arr[j] < pivot + (normalQuickSort ? 0 : 1)) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				list.add(new XYValue(i, arr[i]));

				arr[j] = temp;
				list.add(new XYValue(j, arr[j]));
			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[high];
		list.add(new XYValue(i + 1, arr[i + 1]));

		arr[high] = temp;
		list.add(new XYValue(high, arr[high]));

		return i + 1;
	}

	/**
	 * Starts the quick sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param low   low integer parameter
	 * @param high  high integer parameter
	 */
	public static void quickSort(int arr[], BarChart<String, Number> chart, int low, int high) {
		startThread(chart);
		if (low < high) {
			int pi = partition(arr, low, high, chart, true);

			quickSort(arr, chart, low, pi - 1);
			quickSort(arr, chart, pi + 1, high);
		}
	}

	/**
	 * Starts the quick sort sequence iteratively.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param low   low integer parameter
	 * @param high  high integer parameter
	 */
	public static void iterativeQuickSort(int arr[], BarChart<String, Number> chart, int low, int high) {
		startThread(chart);
		if (low < high) {
			int pi = partition(arr, low, high, chart, false);

			iterativeQuickSort(arr, chart, low, pi - 1);
			iterativeQuickSort(arr, chart, pi + 1, high);
		}
	}
}
