package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the heap sort class.
 * 
 * @author Bruno
 *
 */
public class HeapSort extends UpdateGraphThread {
	/**
	 * Starts the heap sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 */
	public static void heapSort(int arr[], BarChart<String, Number> chart) {
		startThread(chart);
		int n = arr.length;

		for (int i = n / 2 - 1; i >= 0; i--)
			heapify(arr, n, i, chart);

		for (int i = n - 1; i >= 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			list.add(new XYValue(0, arr[0]));

			arr[i] = temp;
			list.add(new XYValue(i, arr[i]));

			heapify(arr, i, 0, chart);
		}
	}

	/**
	 * Heapify operation of the given array.
	 *
	 * @param arr   array of integer values of the chart
	 * @param n     size of the array
	 * @param i     index of an array element
	 * @param chart chart that holds an array of integer values
	 */
	private static void heapify(int arr[], int n, int i, BarChart<String, Number> chart) {
		int largest = i;
		int l = 2 * i + 1;
		int r = 2 * i + 2;

		if (l < n && arr[l] > arr[largest])
			largest = l;

		if (r < n && arr[r] > arr[largest])
			largest = r;

		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			list.add(new XYValue(i, arr[i]));

			arr[largest] = swap;
			list.add(new XYValue(largest, arr[largest]));

			heapify(arr, n, largest, chart);
		}
	}
}
