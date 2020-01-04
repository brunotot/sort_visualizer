package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the tim sort class.
 * 
 * @author Bruno
 *
 */
public class TimSort extends UpdateGraphThread {
	/**
	 * Dividing array into RUN blocks (represents the number of blocks to divide an
	 * array in).
	 */
	private static int RUN = 32;

	/**
	 * Starts the insertion sort that is used by Tim sort's diving of array by blocks.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param left  left integer parameter
	 * @param right right integer parameter
	 */
	public static void insertionSort(int[] arr, int left, int right, BarChart<String, Number> chart) {
		for (int i = left + 1; i <= right; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j >= left && arr[j] > temp) {
				arr[j + 1] = arr[j];
				list.add(new XYValue(j + 1, arr[j + 1]));
				j--;
			}
			arr[j + 1] = temp;
			list.add(new XYValue(j + 1, arr[j + 1]));
		}
	}

	/**
	 * Method used for merging left and right array
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param l     left integer parameter
	 * @param r     right integer parameter
	 * @param m     middle integer parameter
	 */
	public static void merge(int[] arr, int l, int m, int r, BarChart<String, Number> chart) {
		int len1 = m - l + 1, len2 = r - m;
		int[] left = new int[len1];
		int[] right = new int[len2];
		for (int x = 0; x < len1; x++) {
			left[x] = arr[l + x];
		}
		for (int x = 0; x < len2; x++) {
			right[x] = arr[m + 1 + x];
		}

		int i = 0;
		int j = 0;
		int k = l;

		while (i < len1 && j < len2) {
			if (left[i] <= right[j]) {
				arr[k] = left[i];
				list.add(new XYValue(k, arr[k]));
				i++;
			} else {
				arr[k] = right[j];
				list.add(new XYValue(k, arr[k]));
				j++;
			}
			k++;
		}

		while (i < len1) {
			arr[k] = left[i];
			list.add(new XYValue(k, arr[k]));
			k++;
			i++;
		}

		while (j < len2) {
			arr[k] = right[j];
			list.add(new XYValue(k, arr[k]));
			k++;
			j++;
		}
	}

	/**
	 * Starts the tim sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param n     array length
	 */
	public static void timSort(int[] arr, int n, BarChart<String, Number> chart) {
		startThread(chart);
		for (int i = 0; i < n; i += RUN) {
			insertionSort(arr, i, Math.min((i + 31), (n - 1)), chart);
		}

		for (int size = RUN; size < n; size = 2 * size) {
			for (int left = 0; left < n; left += 2 * size) {
				int mid = left + size - 1;
				int right = Math.min((left + 2 * size - 1), (n - 1));

				merge(arr, left, mid, right, chart);
			}
		}
	}
}
