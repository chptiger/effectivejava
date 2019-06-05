package chapter1_createdestoryobjects.item5_Preferdependencyinjectiontohardwiringresources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * pass the resource into the constructor when creating a new instance
 * 
 * Static utility classes and singletons are inappropriate for classes whose behavior is parameterized by an underlying resource
 */
public class SpellChecker {
	private final String dictionary;

	public SpellChecker(String dictionary) {
		this.dictionary = Objects.requireNonNull(dictionary);
	}

	public boolean isValid(String word) {
		System.out.println("This is valid" + word);
		return word != null;
	}

	public List<String> suggestions(String type) {
		return new ArrayList<>(Arrays.asList(type));
	}
}
