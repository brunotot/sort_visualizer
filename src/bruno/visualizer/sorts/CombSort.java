package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the bubble sort class.
 * 
 * @author Bruno
 *
 */
public class CombSort extends UpdateGraphThread {

	/**
	 * Gets the next gap.
	 *
	 * @param gap the gap
	 * @return the next gap
	 */
	private static int getNextGap(int gap) {
		gap = (gap * 10) / 13;
		if (gap < 1)
			return 1;
		return gap;
	}

	/**
	 * Comb sort.
	 *
	 * @param arr   the arr
	 * @param chart the chart
	 */
	public static void combSort(int arr[], BarChart<String, Number> chart) {
		startThread(chart);
		int n = arr.length;

		int gap = n;
		boolean swapped = true;
		while (gap != 1 || swapped == true) {
			gap = getNextGap(gap);

			swapped = false;

			for (int i = 0; i < n - gap; i++) {
				if (arr[i] > arr[i + gap]) {
					int temp = arr[i];
					arr[i] = arr[i + gap];
					list.add(new XYValue(i, arr[i]));

					arr[i + gap] = temp;
					list.add(new XYValue(i + gap, arr[i + gap]));

					swapped = true;
				}
			}
		}
	}
}
