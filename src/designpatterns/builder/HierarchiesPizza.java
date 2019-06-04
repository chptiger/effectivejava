package designpatterns.builder;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

public abstract class HierarchiesPizza {
	public enum Topping {
		HAM, ONION, PEPPER, SAUSAGE
	}

	final Set<Topping> toppings;

	abstract static class Builder<T extends Builder<T>> {
		EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

		public T addTopping(Topping topping) {
			toppings.add(Objects.requireNonNull(topping));
			return self();
		}

		abstract HierarchiesPizza build();

		// Subclasses must override this method to return "this"
		protected abstract T self();
	}

	HierarchiesPizza(Builder<?> builder) {
		toppings = builder.toppings.clone();// see item 50
	}
}
