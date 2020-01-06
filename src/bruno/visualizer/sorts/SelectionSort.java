package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the selection sort class.
 * 
 * @author TotB
 */
public class SelectionSort extends UpdateGraphThread {
	/**
	 * Starts the selection sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 */
	public static void selectionSort(int arr[], BarChart<String, Number> chart) {
		startThread(chart);
		int n = arr.length;
		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[min_idx]) {
					min_idx = j;
				}
			}

			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			list.add(new XYValue(min_idx, arr[min_idx]));

			arr[i] = temp;
			list.add(new XYValue(i, arr[i]));
		}
	}
}
