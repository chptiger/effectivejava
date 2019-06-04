package designpatterns.builder.hierarchies;

import designpatterns.builder.hierarchies.HierarchiesPizza.Topping;
import designpatterns.builder.hierarchies.NyPizza.Size;

public class test {
	public static void main(String[] args) {
		NyPizza pizza = new NyPizza.Builder(Size.SMALL).addTopping(Topping.SAUSAGE).build();
		Calzone calzone = new Calzone.Builder().addTopping(Topping.HAM).sauceInside().build();
	}
}
