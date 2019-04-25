package chapter1_createdestoryobjects.item1_staticfactorymethodinsteadofconstructor;

import java.util.Collections;

//https://www.baeldung.com/java-constructors-vs-static-factory-methods 

class User {
	private final String name;
	private final String email;
	private final String country;
	
	public User(String name, String email, String country) {
		this.name = name;
		this.email = email;
		this.country = country;
	}
	
	/**
	 * createWithDefaultCountry is a static factory method
	 * 
	 * Advantages of static factory methods: 
	 * 	1. unlike constructors, they have names. --> easy to understand.
	 * 	2. unlike constructors, they are not required to create a new object each time they’re invoked. --> fly-weight pattern
	 * 	3. unlike constructors, they can return an object of any sub-type of their return type.  -> return subType
	 * 		e.x. Collections 
	 *  4. the class of the returned object can vary from call to call as a function of the input parameters.
	 *  5. the class of the returned object need not exist when the class containing the method is written.
	 */
	public static User createWithDefaultCountry(String name, String email) {
		return new User(name, email, "United States");
	}

	public String getCountry() {
		return country;
	}
}