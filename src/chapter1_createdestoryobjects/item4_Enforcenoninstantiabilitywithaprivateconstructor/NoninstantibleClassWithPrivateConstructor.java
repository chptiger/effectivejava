package chapter1_createdestoryobjects.item4_Enforcenoninstantiabilitywithaprivateconstructor;

public class NoninstantibleClassWithPrivateConstructor {
	private NoninstantibleClassWithPrivateConstructor() {
		System.out.println("Noninstantiable utility class do not need to be instatntiated");
		throw new AssertionError();
	}
}
