/*
 * 
 */
package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the merge sort class.
 * 
 * @author Bruno
 *
 */
public class MergeSort extends UpdateGraphThread {

	/**
	 * Method used for merging left and right array.
	 *
	 * @param arr   array of integer values of the chart
	 * @param l     left integer parameter
	 * @param m     middle integer parameter
	 * @param r     right integer parameter
	 * @param chart chart that holds an array of integer values
	 */
	private static void merge(int arr[], int l, int m, int r, BarChart<String, Number> chart) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int L[] = new int[n1];
		int R[] = new int[n2];

		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		int i = 0, j = 0;

		int k = l;
		while (i < n1 && j < n2) {

			if (L[i] <= R[j]) {
				arr[k] = L[i];
				list.add(new XYValue(k, arr[k]));
				i++;
			} else {
				arr[k] = R[j];
				list.add(new XYValue(k, arr[k]));
				j++;
			}
			k++;
		}

		while (i < n1) {

			arr[k] = L[i];
			list.add(new XYValue(k, arr[k]));
			i++;
			k++;
		}

		while (j < n2) {

			arr[k] = R[j];
			list.add(new XYValue(k, arr[k]));
			j++;
			k++;
		}
	}

	/**
	 * Starts the merge sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param l     left integer parameter
	 * @param r     right integer parameter
	 */
	public static void mergeSort(int arr[], BarChart<String, Number> chart, int l, int r) {
		startThread(chart);
		if (l < r) {
			int m = (l + r) / 2;

			mergeSort(arr, chart, l, m);
			mergeSort(arr, chart, m + 1, r);

			merge(arr, l, m, r, chart);
		}
	}

	/**
	 * Starts the merge sort sequence iteratively.
	 * 
	 * @param array array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 */
	public static void iterativeMergeSort(int[] array, BarChart<String, Number> chart) {
		startThread(chart);
		if (array == null) {
			return;
		}

		if (array.length > 1) {
			int mid = array.length / 2;

			int[] left = new int[mid];
			for (int i = 0; i < mid; i++) {
				left[i] = array[i];
			}

			int[] right = new int[array.length - mid];
			for (int i = mid; i < array.length; i++) {
				right[i - mid] = array[i];
			}
			iterativeMergeSort(left, chart);
			iterativeMergeSort(right, chart);

			int i = 0;
			int j = 0;
			int k = 0;

			while (i < left.length && j < right.length) {

				if (left[i] < right[j]) {
					array[k] = left[i];
					list.add(new XYValue(k, array[k]));
					i++;
				} else {
					array[k] = right[j];
					list.add(new XYValue(k, array[k]));
					j++;
				}
				k++;
			}
			while (i < left.length) {

				array[k] = left[i];
				list.add(new XYValue(k, array[k]));
				i++;
				k++;
			}
			while (j < right.length) {

				array[k] = right[j];
				list.add(new XYValue(k, array[k]));
				j++;
				k++;
			}
		}
	}
}
