package chapter1_createdestoryobjects.item2_builderwithmanyconstructorparameters;

import chapter1_createdestoryobjects.item2_builderwithmanyconstructorparameters.HierarchiesPizza.Topping;
import chapter1_createdestoryobjects.item2_builderwithmanyconstructorparameters.NyPizza.Size;

public class test {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE).build();
		Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
	}
}
