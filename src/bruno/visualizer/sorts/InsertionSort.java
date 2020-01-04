package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the insertion sort class.
 * 
 * @author TotB
 */
public class InsertionSort extends UpdateGraphThread {
	/**
	 * Starts the insertion sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 */
	public static void insertionSort(int arr[], BarChart<String, Number> chart) {
		startThread(chart);
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;

			while (j >= 0 && arr[j] > key) {

				arr[j + 1] = arr[j];
				list.add(new XYValue(j + 1, arr[j + 1]));
				j = j - 1;
			}

			arr[j + 1] = key;
			list.add(new XYValue(j + 1, arr[j + 1]));
		}
	}

	/**
	 * Starts the insertion sort sequence recursively.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param n     size of the array
	 */
	public static void insertionSortRecursively(int arr[], BarChart<String, Number> chart, int n) {
		startThread(chart);
		if (n <= 1) {
			return;
		}

		insertionSortRecursively(arr, chart, n - 1);

		int last = arr[n - 1];
		int j = n - 2;

		while (j >= 0 && arr[j] > last) {

			arr[j + 1] = arr[j];
			list.add(new XYValue(j + 1, arr[j + 1]));
			j--;
		}

		arr[j + 1] = last;
		list.add(new XYValue(j + 1, arr[j + 1]));
	}
}
