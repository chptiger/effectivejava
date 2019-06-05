package chapter1_createdestoryobjects.item5_Preferdependencyinjectiontohardwiringresources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Neither of these approaches is satisfactory, because they assume that there is only one dictionary woth using.
 * In practice, each language has its own dictionary, and special dictionaries are used for special vocabularies.
 * Also it may be desirable to use a special dictionary for testing. 
 * It's wishful thinking to assume that a singleton dictionary will suffice for all time.
 * 
 * Static utility classes and singletons are inappropriate for classes whose behavior is parameterized by an underlying resource.
 * 
 * pass the resource into the constructor when creating a new instance
 */
// inappropriate use of singleton -- inflexible && untestable
public class SpellCheckerInapproperiateSingleton {
	private static final String dictionary = "Lexicon";

	private SpellCheckerInapproperiateSingleton() {
	}

	public static SpellCheckerInapproperiateSingleton INSTANCE = new SpellCheckerInapproperiateSingleton();

	public static SpellCheckerInapproperiateSingleton getInstance() {
		return INSTANCE;
	}

	public static boolean isValid(String word) {
		return word != null;
	}

	public static List<String> suggestion(String type) {
		return new ArrayList<>(Arrays.asList(type));
	}
}
