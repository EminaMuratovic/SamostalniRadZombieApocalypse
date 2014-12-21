
public class Zombie extends Character{
	
	/**
	 * creates a zombie
	 * @param name String name of the zombie
	 * @param hp double health points ( 0-200 )
	 * @param dex double dexterity // how precise is the zombie ( 0-1 )
	 * @param weapon Weapon what weapon does the zombie have 
	 * @param strength double strength of the zombie ( 0-20 )
	 * @param speed double speed of the zombie ( 0-20 )
	 */
	public Zombie(String name, double hp, double dex, Weapon weapon, double strength, double speed) {
		super(name, hp, dex, weapon, strength, speed);
	}

	/**
	 * gets the name of the zombie
	 */
	public String getName() {
		return this.getName();
	}
}
