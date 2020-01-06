/*
 * 
 */
package bruno.visualizer.sorts;

import java.util.Arrays;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the radix sort class.
 * 
 * @author Bruno
 *
 */
public class RadixSort extends UpdateGraphThread {

	/**
	 * Method that searches for the maximum number and returns it.
	 *
	 * @param arr   array of integer values of the chart
	 * @param n     array length
	 * @param chart chart that holds an array of integer values
	 * @return maximum number from the given array
	 */
	private static int getMax(int arr[], int n, BarChart<String, Number> chart) {
		int mx = arr[0];
		for (int i = 1; i < n; i++)
			if (arr[i] > mx)
				mx = arr[i];
		return mx;
	}

	/**
	 * Starts the radix-counting sort sequence.
	 *
	 * @param arr   array of integer values of the chart
	 * @param n     array length
	 * @param exp   digit representation
	 * @param chart chart that holds an array of integer values
	 */
	private static void countingSort(int arr[], int n, int exp, BarChart<String, Number> chart) {
		int output[] = new int[n];
		int i;

		int count[] = new int[n];
		Arrays.fill(count, 0);

		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % n]++;

		for (i = 1; i < n; i++)
			count[i] += count[i - 1];

		for (i = n - 1; i >= 0; i--) {

			output[count[(arr[i] / exp) % n] - 1] = arr[i];
			list.add(new XYValue(count[(arr[i] / exp) % n] - 1, output[count[(arr[i] / exp) % n] - 1]));
			count[(arr[i] / exp) % n]--;
		}

		for (i = 0; i < n; i++) {

			arr[i] = output[i];
			list.add(new XYValue(i, arr[i]));
		}
	}

	/**
	 * Starts the radix sort sequence.
	 *
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param n     array length
	 */
	public static void radixSort(int arr[], BarChart<String, Number> chart, int n) {
		startThread(chart);
		int m = getMax(arr, n, chart);

		for (int exp = 1; m / exp > 0; exp *= n)
			countingSort(arr, n, exp, chart);
	}
}
