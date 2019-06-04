package chapter1_createdestoryobjects.item2_builderwithmanyconstructorparameters;

/**
 * https://www.geeksforgeeks.org/builder-pattern-in-java/ todo: use one sentence
 * to explain what's builder pattern.
 * 
 * The Builder class is used only when create new NutritionFacts class. --> select inner class
 * Builder class do not need to access in NutritionFacts --> select static class
 * The clients call build method to create the object of NutrtionFacts.
 * there is no setter method in NutritionFacts --> the created object of NutrtionFacts is immutable.
 * immutable means the state of the object could not been updated, but the reference could be updated  -> like immutable class of String
 * final means the reference of the object could not been update, but the state of the object could be updated
 * 
 * Immutable objects are always thread-safe, but their references may not be.
 * To make their references thread-safe, we may need to access them from synchronized blocks/methods.
 */

public class NutritionFacts {
	private final int servingSize;
	private final int servings;
	private final int calories;
	private final int fat;
	private final int sodium;
	private final int carbonhydrate;
	
	public static class Builder{
//		Required parameters
		private final int servingSize;
		private final int servings;
		
//		Optional parameters - initialized to default values
		private int calories = 0;
		private int fat = 0;
		private int sodium = 0;
		private int carbonHydrate = 0;
		
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}
		
		public Builder calories(int val) {
			calories = val;
			return this;
		}
		
		public Builder fat(int val) {
			fat = val;
			return this;
		}
		
		public Builder sodium(int val) {
			sodium = val;
			return this;
		}
		
		public Builder carbonHydrate(int val) {
			carbonHydrate = val;
			return this;
		}
		
		public NutritionFacts build() {
			return new NutritionFacts(this);
		}
	}
	
	private NutritionFacts(Builder builder) {
		servingSize = builder.servingSize;
		servings = builder.servings;
		calories = builder.calories;
		fat = builder.fat;
		sodium = builder.sodium;
		carbonhydrate = builder.carbonHydrate;
	}
	
	
	public static void main(String[] args) {
		NutritionFacts nutritionFacts = new NutritionFacts
											.Builder(17, 8)
											.calories(30)
											.fat(50)
											.carbonHydrate(54)
											.build();
		System.out.println(nutritionFacts.toString());
	}


	@Override
	public String toString() {
		return "NutritionFacts [servingSize=" + servingSize + ", servings=" + servings + ", calories=" + calories
				+ ", fat=" + fat + ", sodium=" + sodium + ", carbonhydrate=" + carbonhydrate + "]";
	}
}
