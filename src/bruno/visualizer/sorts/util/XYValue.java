/*
 * 
 */
package bruno.visualizer.sorts.util;

/**
 * Represents a class that holds X-axis and Y-axis values.
 * 
 * @author Bruno
 */
public class XYValue {
	/**
	 * Represents a chart element index (X-axis) variable that holds an Integer.
	 */
	private Integer index;

	/**
	 * Represents a chart element value (Y-axis) variable that holds an Integer.
	 */
	private Integer value;

	/**
	 * A getter method for fetching index from the XYValue object.
	 * 
	 * @return index(X-axis) of a certain element in the chart graph
	 */
	public Integer getIndex() {
		return index;
	}

	/**
	 * A getter method for fetching value from the XYValue object.
	 * 
	 * @return value (Y-axis) of a certain element in the chart graph
	 */
	public Integer getValue() {
		return value;
	}

	/**
	 * A setter method for setting index(X-axis) of the XYValue object.
	 * 
	 * @param index index(X-axis) of a certain element in the chart graph
	 */
	public void setIndex(Integer index) {
		this.index = index;
	}

	/**
	 * A setter method for setting value(Y-axis) of the XYValue object.
	 * 
	 * @param value index(X-axis) of a certain element in the chart graph
	 */
	public void setValue(Integer value) {
		this.value = value;
	}

	/**
	 * Public constructor for XYValue class that sets this.index and this.value to
	 * given parameters.
	 * 
	 * @param index index(X-axis) of a certain element in the chart graph
	 * @param value value(Y-axis) of a certain element in the chart graph
	 */
	public XYValue(Integer index, Integer value) {
		super();
		this.index = index;
		this.value = value;
	}
}
