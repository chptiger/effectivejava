package designpattern;

import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

/**
 * https://www.geeksforgeeks.org/flyweight-design-pattern/
 * 
 * To avoid java.lang.OutOfMemoryError
 * 
 * Intrinsic V.S Extrinsic States: 
 * Intrinsic State : Here ‘task’ is an intrinsic
 * state for both types of players, since this is always same for T’s/CT’s. We
 * can have some other states like their color or any other properties which are
 * similar for all the Terrorists/Counter Terrorists in their respective
 * Terrorists/Counter Terrorists class.
 * 
 * Extrinsic State : Weapon is an extrinsic state since each player can carry
 * any weapon of his/her choice. Weapon need to be passed as a parameter by the
 * client itself.
 * 
 * 
 * There are two person, terrorist and counter terrorist
 * 
 * each time they got different weapons.
 * 
 */
public class Flyweight {
	public static final String TERRORIST = "Terrorist";
	public static final String COUNTER_TERRORIST = "Counter_Terrorist";

	private static String[] playerType = {COUNTER_TERRORIST, TERRORIST};
	private static String[] weapons = {"AK-47", "Maverick", "Gut Knife", "Desert Eagle"};
	
	@Test
	public void test_flyweight() {
		for(int i = 0; i < 30; i++) {
			Player p = PlayerFactory.getPlayer(getRandPlayerType());
			p.assignWeapon(getRandWeapon());
			p.mission();
		}
	}

	private String getRandWeapon() {
		Random r = new Random();
		int randInt = r.nextInt(weapons.length);
		return weapons[randInt];
	}

	private String getRandPlayerType() {
		Random r = new Random();
		int randInt = r.nextInt(playerType.length);
		return playerType[randInt];
	}
}

interface Player {
	void assignWeapon(String weapon);
	void mission();
}

class PlayerFactory {
	private static HashMap<String, Player> hm = new HashMap<String, Player>();
	
	public static Player getPlayer(String type) {
		Player player = null;
		if(hm.containsKey(type)) {
			return hm.get(type);
		} else {
			switch(type) {
			case Flyweight.TERRORIST:
				System.out.println("Terrorist Created");
				player = new Terrorist();
				break;
			case Flyweight.COUNTER_TERRORIST :
				System.out.println();
				player = new Terrorist();
				break;
			default:
				System.out.println("Unreachable code!");
			}
			hm.put(type, player);
		}
		return player;
	}
}

class Terrorist implements Player {
//	Intrinsic Attribute
	private final String TASK;
	
//	Extrinsic Attribute
	private String weapon;
	
	public Terrorist() {
		TASK = "PLANT A BOMB";
	}
	
	public void assignWeapon(String weapon) {
		this.weapon = weapon;
	}

	public void mission() {
		System.out.println("Terrorist with weapon " + weapon + " | " + " Task is " + TASK);
	}
}

class CountTerrorist implements Player {
//	Intrinsic Attribute
	private final String TASK;
	
//	Extrinsic Attribute
	private String weapon;
	
	public CountTerrorist() {
		TASK = "DIFFUSE BOMB";
	}
	
	public void assignWeapon(String weapon) {
		this.weapon = weapon;
	}

	public void mission() {
		System.out.println("CountTerrorist with weapon " + weapon + " | " + " Task is " + TASK);
	}
}