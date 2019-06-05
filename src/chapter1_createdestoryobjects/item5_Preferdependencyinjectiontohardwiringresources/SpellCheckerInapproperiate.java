package chapter1_createdestoryobjects.item5_Preferdependencyinjectiontohardwiringresources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// inappropriate use of static utility -- inflexible && untestable
public class SpellCheckerInapproperiate {
	private static final String dictionary = "Lexicon";
	private SpellCheckerInapproperiate() {}
	
	public static boolean isValid(String word) {
		return word != null;
	}
	
	public static List<String> suggestion(String type) {
		return new ArrayList<>(Arrays.asList(type));
	}
}
