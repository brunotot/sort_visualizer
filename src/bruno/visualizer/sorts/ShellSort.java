package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the shell sort class.
 * 
 * @author Bruno
 *
 */
public class ShellSort extends UpdateGraphThread {
	/**
	 * Starts the shell sort sequence.
	 * 
	 * @param arr   array of integer values of the chart
	 * @param chart chart that holds an array of integer values
	 */
	public static void shellSort(int arr[], BarChart<String, Number> chart) {
		startThread(chart);
		int n = arr.length;

		for (int gap = n / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < n; i += 1) {
				int temp = arr[i];

				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
					arr[j] = arr[j - gap];
					list.add(new XYValue(j, arr[j]));
				}

				arr[j] = temp;
				list.add(new XYValue(j, arr[j]));
			}
		}
	}
}
