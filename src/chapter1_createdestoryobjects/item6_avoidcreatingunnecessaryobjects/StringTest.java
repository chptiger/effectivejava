package chapter1_createdestoryobjects.item6_avoidcreatingunnecessaryobjects;

import org.junit.Test;

/**
 * https://www.edureka.co/blog/java-string/ 
 * Java String Pool: 
 * Java String pool refers to collection of Strings which are stored in heap memory.
 * In this, whenever a new object is created, String first checks whether the object is already present in the pool or not.
 * If it is present, then same reference is returned to the variable else new object will be created in the String pool and respective reference will be returned.
 * 
 * String are immutable. By immutable, we mean that Strings are constant, their values can not be changed after they are created.
 * Because String objects are immutable, they can be shared.
 * For example:
 * String str = "abc";  is equivalent to : 
 * char data[] = {'a', 'b', 'c'};
 * String str = new String(data);
 */
public class StringTest {

	@Test
	public void test_String() {
		String s = new String("bikini"); // do not do this
		String ss = "bikini"; // correct 
	}
}
