package bruno.visualizer.util;

/**
 * Set of strings that represent CSS color commands.
 * 
 * @author TotB
 */
public class Constraints {
	/**
	 * Default color used to initialize the first color that user sees.
	 */
	public static final String DEFAULT = "rgb(242,97,45)";

	/**
	 * Color that user sees when a certain element of array changes.
	 */
	public static final String CHANGINGELEMENT = "green";
	

	/**
	 * Maximum transition speed for transition speed Slider object.
	 */
	public static final double MAXTRANSITIONSPEED = -2;

	/**
	 * Minimum transition speed for transition speed Slider object.
	 */
	public static final double MINTRANSITIONSPEED = -800;
	
	/**
	 * Holds integer information of how many milliseconds does it take to actually
	 * start the sorting sequence.
	 */
	public static final Integer INITIALDELAYMILLISECONDS = 10;
	
	/**
	 * Holds the value of CSS command for setting up default color configuration.
	 */
	public static final String DEFAULTCSSCOLORCOMMAND = "-fx-background-color: " + DEFAULT + ";";

	public static final Integer STARTWINDOWHEIGHT = 400;
	
	public static final Integer STARTWINDOWWIDTH = 400;
}
