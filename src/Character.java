
public class Character {
	
	private String name;
	private double hp;
	private double dex;
	private Weapon weapon;
	private double strength;
	private double speed;
	private double evasion; // evading the attack
	private double luck; // (0 - 5)
	private double damage;
	private double attack;
	private double attack_speed;
	private double chance_to_hit;
	
	
	/**
	 * creates a character with their characteristics
	 * @param name String name of the character
	 * @param hp double health points ( 0-200 )
	 * @param dex double dexterity // how precise is the character ( 0-1 )
	 * @param weapon Weapon what weapon does the character have 
	 * @param strength double strength of the character ( 0-20 )
	 * @param speed double speed of the character ( 0-20 )
	 */
	public Character(String name, double hp, double dex, Weapon weapon, double strength, double speed) {
		this.name = name;
		this.hp = hp;
		this.weapon = weapon;
		this.dex = dex;
		this.strength = strength;
		this.speed = speed;
		
	}
	
	/**
	 * attack multiplied by 3
	 */
	public void specialAttack(Character z) {
		
		attack = (this.strength + this.weapon.getMight()) * 3;
		attack_speed = (this.speed - this.weapon.getWeight()) * 3;
		double a = z.getEvasion() / 4;
		chance_to_hit = (this.dex / (this.dex + (Math.pow(a, 0.8)))) * 3;
	}
	
	/**
	 * attacks the opponent
	 * @param z Character the opponent
	 */
	public void attack(Character z) {
		
		attack = this.strength + this.weapon.getMight();
		attack_speed = this.speed - this.weapon.getWeight();
		double a = z.getEvasion() / 4;
		chance_to_hit = this.dex / (this.dex + (Math.pow(a, 0.8)));
	}
	
	/**
	 * gets the percent of the evasion of the character when he is being attacked
	 * @return evasion
	 */
	public double getEvasion() {
		this.luck = 1 + Math.random() * 5;
		this.evasion = this.speed + this.luck;
		return this.evasion;
	}
	
	/**
	 * gets the dexterity of the player
	 * @return dexterity
	 */
	public double getDex() {
		return dex;
	}
	
	/**
	 * gets health points of the character
	 * @return hp
	 */
	public double getHp(){
		return hp;
	}
	
	/**
	 * gets the speed of the character
	 * @return
	 */
    public double getSpeed(){
    	return speed;
    }

    /**
     * gets the strength of the character
     * @return strength
     */
    public double getStrength(){
	    return strength;
    }
    
    /**
     * gets the name of the character
     * @return the name
     */
    public String getName() {
    	return name;
    }
    
    /**
     * gets the damage of the character after attack
     * @param z Character opponent
     * @return damage in percent
     */
    public double getDamage(Character z) {
    	this.damage =  this.weapon.getAttackPower(this) - this.strength;
    	return this.damage;
    }
    
    /**
     * gets the health points after the attack
     * @param z Character 
     * @return
     */
    public double getHPafterAttack() {
    	this.hp = getDamage(this) * getHp() / 100;
    	return this.hp;
    }
    
    
    /**
     * comperes the two characters
     * @param z Character opponent
     * @return true or false
     */
    public boolean compare(Character z) {
    	int counterAttacker = 0;
    	int counterOpponent = 0;
    	if(this.attack < z.attack)
    		counterOpponent++;
    	else
    		counterAttacker++;
    	if(this.attack_speed < z.attack_speed)
    		counterOpponent++;
    	else
    		counterAttacker++;
    	if(this.chance_to_hit < z.chance_to_hit)
    		counterOpponent++;
    	else
    		counterAttacker++;
    	if(this.getHPafterAttack() <= 0)
    		return false;
    	if(counterAttacker > counterOpponent)
    		return true;
    	else
    		return false;
    }
   
    
    
}
