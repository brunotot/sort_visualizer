package bruno.visualizer.sorts;

import java.util.ArrayList;
import java.util.List;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the bucket sort class.
 * 
 * @author TotB
 *
 */
public class BucketSort extends UpdateGraphThread {

	/**
	 * Method for combining two integer arrays.
	 *
	 * @param a     integer array
	 * @param b     integer array
	 * @param chart chart that holds an array of integer values
	 * @return arrays a and b combined
	 */
	public static int[] combine(int[] a, int[] b, BarChart<String, Number> chart) {
		int length = a.length + b.length;
		int[] result = new int[length];

		for (int i = 0; i < a.length; i++) {
			result[i] = a[i];
			list.add(new XYValue(i, result[i]));
		}
		for (int i = a.length, j = 0; i < length; i++, j++) {
			result[i] = b[j];
			list.add(new XYValue(i, result[i]));
		}

		return result;
	}

	/**
	 * Starts the bucket sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 * @param n     array size
	 */
	public static void bucketSort(int arr[], BarChart<String, Number> chart, int n) {
		startThread(chart);
		List<List<Integer>> buckets = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			buckets.add(new ArrayList<>());
		}

		for (int i = 0; i < n; i++) {
			int bucketIndex = (int) (arr[i] / n);
			buckets.get(bucketIndex).add(arr[i]);
		}

		int[] bucket[] = new int[n][];
		for (int i = 0; i < n; i++) {
			bucket[i] = new int[buckets.get(i).size()];
			for (int j = 0; j < buckets.get(i).size(); j++) {
				bucket[i][j] = buckets.get(i).get(j);
			}
			insertionSort(bucket[i], chart);
		}

		int[] combined = new int[0];
		for (int i = 0; i < n; i++) {
			combined = combine(combined, bucket[i], chart);
		}
	}

	/**
	 * Insertion sort.
	 *
	 * @param arr   the arr
	 * @param chart the chart
	 */
	public static void insertionSort(int arr[], BarChart<String, Number> chart) {
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
}
