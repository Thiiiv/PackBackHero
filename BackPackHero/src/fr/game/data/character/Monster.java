package fr.game.data.character;

public class Monster implements Character{

	private final String name = "monstre";
	private int attackPoint;
	private int defensePoint;
	private int health = 20;
	
	public String getName() {
		return name;
	}

	public int attackPoint() {
		return attackPoint;
	}
	
	public int defensePoint() {
		return defensePoint;
	}
	
	public int health() {
		return health;
	}
	
	public void attack(Hero hero) { // add Character argument
		hero.getDamage(attackPoint);
	}
	
	public int preventAttack(){
		return attackPoint;
	}

	public boolean beAttacked(Hero hero) {
		return true;
	}

	@Override
	public void getDamage(int damage) {
		this.health -= damage;
		 System.out.println("Le " + name + " a encaissé " + damage + " points de dégât.");
	}
}
