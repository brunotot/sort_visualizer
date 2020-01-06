package bruno.visualizer.sorts;

import java.util.Arrays;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the bubble sort class.
 * 
 * @author Bruno
 *
 */
public class PigeonholeSort extends UpdateGraphThread {

	/**
	 * Pigeonhole sort.
	 *
	 * @param arr   the arr
	 * @param chart the chart
	 * @param n     the n
	 */
	public static void pigeonholeSort(int arr[], BarChart<String, Number> chart, int n) {
		startThread(chart);
		int min = arr[0];
		int max = arr[0];
		int range, i, j, index;

		for (int a = 0; a < n; a++) {
			if (arr[a] > max) {
				max = arr[a];
			}
			if (arr[a] < min) {
				min = arr[a];
			}
		}

		range = max - min + 1;
		int[] phole = new int[range];
		Arrays.fill(phole, 0);

		for (i = 0; i < n; i++) {
			phole[arr[i] - min]++;
		}

		index = 0;

		for (j = 0; j < range; j++)
			while (phole[j]-- > 0) {
				arr[index] = j + min;
				list.add(new XYValue(index, arr[index]));

				index++;
			}

	}
}
