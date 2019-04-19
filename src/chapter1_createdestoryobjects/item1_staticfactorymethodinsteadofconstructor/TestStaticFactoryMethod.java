package chapter1_createdestoryobjects.item1_staticfactorymethodinsteadofconstructor;

import org.junit.Test;

public class TestStaticFactoryMethod {
	@Test
	public void test_staticFactoryMethod() {
		int a = 8;
		double b = 9.0;
		System.out.println(valueOf(a));
		System.out.println(valueOf(b));
		
//		createWithDefaultCountry is a static method
		User user = User.createWithDefaultCountry("Tom", "tom@gmail.com");
		System.out.println(user.getCountry());
	}
	
	/**
	 * valueOf is a static factory method
	 */
	public static <T> String valueOf(T i) {
		return String.valueOf(i);
	}
	
}

