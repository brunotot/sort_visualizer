package bruno.visualizer.sorts;

import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.sorts.util.XYValue;
import javafx.scene.chart.BarChart;

/**
 * Represents the cycle sort class.
 * 
 * @author Bruno
 *
 */
public class CycleSort extends UpdateGraphThread {
	@SuppressWarnings("unused")
	public static void cycleSort(int arr[], int n, BarChart<String, Number> chart) {
		startThread(chart);
		int writes = 0;

		for (int cycle_start = 0; cycle_start <= n - 2; cycle_start++) {
			int item = arr[cycle_start];

			int pos = cycle_start;
			for (int i = cycle_start + 1; i < n; i++)
				if (arr[i] < item)
					pos++;

			if (pos == cycle_start)
				continue;

			while (item == arr[pos])
				pos += 1;

			if (pos != cycle_start) {
				int temp = item;
				item = arr[pos];
				arr[pos] = temp;
				list.add(new XYValue(pos, arr[pos]));

				writes++;
			}

			while (pos != cycle_start) {
				pos = cycle_start;

				for (int i = cycle_start + 1; i < n; i++)
					if (arr[i] < item)
						pos += 1;

				while (item == arr[pos])
					pos += 1;

				if (item != arr[pos]) {
					int temp = item;
					item = arr[pos];
					arr[pos] = temp;
					list.add(new XYValue(pos, arr[pos]));

					writes++;
				}
			}
		}
	}
}
