package com.masai;

class Player {
	String name;

	public Player(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + "]";
	}

}

interface createObject {
	Player createPlayerObject(String name);
}

interface createObject2 {
	void createPlayerObject(String name);
}

public class methodRefEx {
	public static void main(String[] args) {
		createObject c1 = Player::new;
		Player p1 = c1.createPlayerObject("Ankit");
		System.out.println(p1);

//		createObject2 c2 = Player::new;
//		Player p2 = c2.createPlayerObject("Sanket");
		System.out.println();
	}
}
