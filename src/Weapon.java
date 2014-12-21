
public class Weapon {
	
	private double damage;
	private double critDamage;
	private int ammo;
	private double weight;
	private double might; 
	private double attack_power;
	
	
	/**
	 * creates a weapon with all of its characteristics
	 * @param damage double damage that the weapon can make ( 0 - 10 )
	 * @param critDamage double critical demage that the weapon can make ( 0% - 10% )
	 * @param ammo int how much ammo has the weapon have
	 * @param speed double speed of the weapon 
	 * @param weight double weight of the weapon
	 * @param might double might of the weapon ( 0 - 50)
	 */
	public Weapon(double damage, double critDamage, int ammo, double weight, double might) {
		this.damage = damage;
		this.critDamage = critDamage;
		this.ammo = ammo;
		this.weight = weight;
		this.might = might;
	}
	
	/**
	 * gets the weight of the weapon
	 * @return weight
	 */
	public double getWeight() {
		return weight;
	}
	
	/**
	 * gets the might of the weapon
	 * @return might
	 */
	public double getMight() {
		return might;
	}
	
	/**
	 * gets the damage of the weapon to the opponent
	 * @return damage
	 */
	public double getDamage() {
		return damage;
	}

	/**
	 * gets the critical damage that weapon can make
	 * @return critical damage
	 */
	public double getCritDamage() {
		return critDamage;
	}

	/**
	 * gets the ammo of the weapon
	 * @return ammo
	 */
	public double getAmmo() {
		return ammo;
	}
	
	/**
	 * gets the attack power of the weapon
	 * @param z Character character who is using the weapon
	 * @return attack power
	 */
	public double getAttackPower(Character z) {
		attack_power = z.getStrength() + this.might;
		return attack_power;
	}

	/**
	 * returns the string representation od the object
	 */
	public String toString() {
		String str = "";
		str = "Damage: " + damage + "; Crit. damage: " + critDamage + "; Ammo: " + ammo + "; Weight: " + weight + "; Might: " + might;
		return str;
	}
	
	
}
