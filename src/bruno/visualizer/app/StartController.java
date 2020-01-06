/*
 * 
 */
package bruno.visualizer.app;

import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import bruno.visualizer.sorts.BubbleSort;
import bruno.visualizer.sorts.BucketSort;
import bruno.visualizer.sorts.CombSort;
import bruno.visualizer.sorts.CountingSort;
import bruno.visualizer.sorts.CycleSort;
import bruno.visualizer.sorts.HeapSort;
import bruno.visualizer.sorts.InsertionSort;
import bruno.visualizer.sorts.MergeSort;
import bruno.visualizer.sorts.PigeonholeSort;
import bruno.visualizer.sorts.QuickSort;
import bruno.visualizer.sorts.RadixSort;
import bruno.visualizer.sorts.SelectionSort;
import bruno.visualizer.sorts.ShellSort;
import bruno.visualizer.sorts.TimSort;
import bruno.visualizer.sorts.util.UpdateGraphThread;
import bruno.visualizer.util.ActionsUtil;
import bruno.visualizer.util.Constraints;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Slider;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;

/**
 * A controller class that controls Start.fxml.
 *
 * @author Bruno
 *
 */
public class StartController extends UpdateGraphThread {
	/**
	 * Check box for starting/not starting the thread for slowing the sorting
	 * sequence for user to see.
	 */
	@FXML
	private CheckBox noDelay;

	/**
	 * Slider object for transition speed.
	 */
	@FXML
	private Slider transitionSpeed;

	/**
	 * Button for starting sort sequence.
	 */
	@FXML
	private Button sortButton;

	/**
	 * Button for stopping sort sequence if in progress.
	 */
	@FXML
	private Button stopSortButton;

	/**
	 * NumberAxis variable from the BarChart (Y-axis).
	 */
	@FXML
	private NumberAxis yAxis;

	/**
	 * A chart that holds an array of integers.
	 */
	@FXML
	private BarChart<String, Number> chart;

	/**
	 * ComboBox selector for the array size.
	 */
	@FXML
	private ComboBox<Integer> selectedSize;

	/**
	 * ComboBox selector for the sorting algorithm to be used.
	 */
	@FXML
	private ComboBox<String> selectedSort;

	/**
	 * Generates a random 0-100 number array with the size of
	 * selectedSize.getValue().
	 */
	@FXML
	public void generateArray() {
		if (stopThread()) {
			indexCounter = 0;
			list = new ArrayList<>();
		}
		if (chart.getData() != null && chart.getData().size() == 1)
			chart.getData().remove(0);
		if (selectedSize.getValue() == null)
			return;

		array = new int[selectedSize.getValue()];
		chart.getData().add(new Series<String, Number>());
		for (int i = 0; i < selectedSize.getValue(); i++) {
			array[i] = new Random().nextInt(100);
			chart.getData().get(0).getData().add(new XYChart.Data<String, Number>(String.valueOf(i), array[i]));
			chart.getData().get(0).getData().get(i).getNode().setStyle("-fx-background-color: " + Constraints.DEFAULT);
		}
	}

	/**
	 * Starts the sorting sequence.
	 */
	@FXML
	public void sort() {
		if (chart.getData() != null && chart.getData().size() == 0)
			return;
		
		String sort = selectedSort.getValue();
		int size = selectedSize.getValue();

		if (sort.equals("Bubble"))
			BubbleSort.bubbleSort(array, chart);
		else if (sort.equals("Selection"))
			SelectionSort.selectionSort(array, chart);
		else if (sort.equals("Recursive Bubble"))
			BubbleSort.bubbleSortRecursively(array, chart, size);
		else if (sort.equals("Insertion"))
			InsertionSort.insertionSort(array, chart);
		else if (sort.equals("Recursive Insertion"))
			InsertionSort.insertionSortRecursively(array, chart, size);
		else if (sort.equals("Merge"))
			MergeSort.mergeSort(array, chart, 0, size - 1);
		else if (sort.equals("Iterative Merge"))
			MergeSort.iterativeMergeSort(array, chart);
		else if (sort.equals("Quick"))
			QuickSort.quickSort(array, chart, 0, size - 1);
		else if (sort.equals("Iterative Quick"))
			QuickSort.iterativeQuickSort(array, chart, 0, size - 1);
		else if (sort.equals("Heap"))
			HeapSort.heapSort(array, chart);
		else if (sort.equals("Counting"))
			CountingSort.countingSort(array, chart);
		else if (sort.equals("Radix"))
			RadixSort.radixSort(array, chart, size);
		else if (sort.equals("Bucket"))
			BucketSort.bucketSort(array, chart, size);
		else if (sort.equals("ShellSort"))
			ShellSort.shellSort(array, chart);
		else if (sort.equals("TimSort"))
			TimSort.timSort(array, chart, size);
		else if (sort.equals("Comb"))
			CombSort.combSort(array, chart);
		else if (sort.equals("Pigeonhole"))
			PigeonholeSort.pigeonholeSort(array, chart, size);
		else if (sort.equals("Cycle"))
			CycleSort.cycleSort(array, chart, size);

		if (!useThread) {
			list = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				chart.getData().get(0).getData().get(i).setYValue(array[i]);
			}
		}
	}

	/**
	 * Stops the sorting sequence if in progress.
	 */
	@FXML
	public void stopSort() {
		if (stopThread()) {
			list = new ArrayList<>();
			for (int i = 0; i < selectedSize.getValue(); i++) {
				array[i] = (int) chart.getData().get(0).getData().get(i).getYValue();
				chart.getData().get(0).getData().get(i).getNode().setStyle("-fx-background-color: " + Constraints.DEFAULT);
			}
			indexCounter = 0;
		}
	}

	/**
	 * The actual array used in the chart.
	 */
	private int[] array;

	/**
	 * Static boolean variable that holds true or false whether the user wants to
	 * slow the sorting sequence down.
	 */
	private static boolean useThread = true;

	/**
	 * Getter method for useThread boolean variable.
	 * 
	 * @return true or false whether the user wants to slow the sorting sequence
	 *         down.
	 */
	public static boolean getUseThread() {
		return useThread;
	}

	/**
	 * An initializer for StartController.java.
	 */
	public void initialize() {
		yAxis.setUpperBound(100);
		
		chart.setAnimated(false);
		chart.setHorizontalZeroLineVisible(false);
		chart.setHorizontalGridLinesVisible(false);
		chart.setVerticalZeroLineVisible(false);
		chart.setVerticalGridLinesVisible(false);
		chart.setCategoryGap(0);
		chart.setBarGap(0);
		chart.setLegendVisible(false);
		chart.getYAxis().setAutoRanging(false);
		chart.getYAxis().setTickLabelsVisible(false);
		chart.getYAxis().setOpacity(0);
		chart.getXAxis().setTickLabelsVisible(false);
		chart.getXAxis().setOpacity(0);

		stopSortButton.setTooltip(new Tooltip("Stop sort"));
        ActionsUtil.setImage(stopSortButton, new Image("file:././././img/blue-x.png"), Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT);

		sortButton.setTooltip(new Tooltip("Start sort"));
        ActionsUtil.setImage(sortButton, new Image("file:././././img/blue-start.png"), Constraints.BOXBUTTONWIDTH, Constraints.BOXBUTTONHEIGHT);
		
		transitionSpeed.setMin(Constraints.MINTRANSITIONSPEED);
		transitionSpeed.setMax(Constraints.MAXTRANSITIONSPEED);
		transitionSpeed.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				updateThreadDelay((int) transitionSpeed.getValue(), chart);
			}
		});

		useThread = true;
		noDelay.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (noDelay.isSelected()) {
					transitionSpeed.setDisable(true);
					useThread = false;
				} else {
					transitionSpeed.setDisable(false);
					useThread = true;
				}
			}
		});
		
		selectedSize.setItems(FXCollections.observableArrayList(10, 100, 1000));
		selectedSize.setValue(10);

		Set<String> set = new TreeSet<>();
		set.add("Selection");
		set.add("Bubble");
		set.add("Selection");
		set.add("Bubble");
		set.add("Recursive Bubble");
		set.add("Insertion");
		set.add("Recursive Insertion");
		set.add("Merge");
		set.add("Iterative Merge");
		set.add("Quick");
		set.add("Iterative Quick");
		set.add("Heap");
		set.add("Counting");
		set.add("Radix");
		set.add("Bucket");
		set.add("ShellSort");
		set.add("TimSort");
		set.add("Comb");
		set.add("Pigeonhole");
		set.add("Cycle");
//		set.add("Cocktail");
//		set.add("Strand");
//		set.add("Bitonic");
//		set.add("Pancakeing");
//		set.add("Binary Insertion");
//		set.add("BogoSort or Permutation");
//		set.add("Gnome");
//		set.add("Sleep");
//		set.add("Structuring (C++)");
//		set.add("Stooge");
//		set.add("Tag (sorted + original)");
//		set.add("Tree");
//		set.add("Cartesian Treeing");
//		set.add("Odd-Even / Brick");
//		set.add("QuickSort on Singly Linked List");
//		set.add("QuickSort on Doubly Linked List");
//		set.add("Three-way QuickSort");
//		set.add("Merge for Linked Lists");
//		set.add("Merge for Doubly Linked List");
//		set.add("Three-way Merge))");
		
		selectedSort.setItems(FXCollections.observableArrayList(set));
		selectedSort.setValue(set.iterator().next());
		generateArray();
	}
}
