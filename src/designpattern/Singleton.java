package designpattern;

import java.security.Signature;

import org.junit.jupiter.api.Test;

public class Singleton {
	private static Singleton singleton_instance = null;
	
	public String s = null;
	
	public Singleton() {
		s = "I am a string part of singleton class";
	}
	
	public static Singleton getInstance() {
		if(singleton_instance == null) {
			singleton_instance = new Singleton();
		}
		return singleton_instance;
	}
	
	@Test
	public void test_singleton() {
		Singleton x = Singleton.getInstance();
		Singleton y = Singleton.getInstance();
		x.s = (x.s).toUpperCase();
		System.out.println(x.s);
		System.out.println(y.s);
	}
}
