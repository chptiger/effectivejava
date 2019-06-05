package chapter1_createdestoryobjects.item7_Eliminateobsoleteobjectreferences;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * this example is not good
 * pop(): Remvoes the object at the top of this tack and returns that objects as the value of this function
 * following pop() method only returns that object as the value of the pop() function, but not remove it from the top of the stack. 
 *
 * 1. not release obsolete reference
 * 2. caches
 * 3. listeners and other callbacks
 */
public class MemoryLeakStack {
	private Object[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;
	
	public MemoryLeakStack() {
		elements = new Object[DEFAULT_INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}

//	memory leak pop
	public Object pop() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		return elements[--size];
	}
	
	/**
	 * The stack maintains obsolete references to these objects.
	 * An obsolete reference is simply a reference that will never be dereferenced again.
	 * In this case, any references outside of the "active portion" of the element array are obsolete.
	 * The action portion consists of the elements whose index is less than size.
	 */
//	fixed
	public Object pop_memorySafe() {
		if(size == 0) {
			throw new EmptyStackException();
		}
		Object result = elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}
	
	private void ensureCapacity() {
		if(elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
