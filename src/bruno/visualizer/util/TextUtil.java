package bruno.visualizer.util;

public class TextUtil {
	public static String toSentenceCase(String text) {
		String sentenceCase = "" + Character.toUpperCase(text.charAt(0));
		for(int i = 1; i < text.length(); i++) {
			if(Character.isUpperCase(text.charAt(i))) {
				sentenceCase += " " + Character.toLowerCase(text.charAt(i));
			} else {
				sentenceCase += text.charAt(i);
			}
		}
		return sentenceCase;
	}
}
