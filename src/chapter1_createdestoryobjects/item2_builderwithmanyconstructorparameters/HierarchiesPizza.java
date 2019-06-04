package chapter1_createdestoryobjects.item2_builderwithmanyconstructorparameters;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

/**
 * The Builder pattern is well suited to class hierarchies.
 * Use a parallel hierarchy of builders, each nested in the corresponding class.
 * Abstract classes have abstract builders; 
 * Concrete classes have concrete builders
 */
abstract class HierarchiesPizza {
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

class NyPizza extends HierarchiesPizza {
	public enum Size {
		SMALL, MEDIUM, LARGE
	}

	private final Size size;

	public static class Builder extends HierarchiesPizza.Builder<Builder> {
		private final Size size;

		public Builder(Size size) {
			this.size = Objects.requireNonNull(size);
		}

		@Override
		NyPizza build() { // return subclass, not superclass: covariant return typing
			return new NyPizza(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
	}

	NyPizza(Builder builder) {
		super(builder);
		size = builder.size;
	}
}

class Calzone extends HierarchiesPizza {
	private final boolean sauceInside;
	
	public static class Builder extends HierarchiesPizza.Builder<Builder> {
		private boolean sauceInside = false;
		
		public Builder sauceInside() {
			sauceInside = true;
			return this;
		}
		
		@Override
		Calzone build() {// return subclass, not superclass: covariant return typing
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
		
	}
	
	Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}
}
