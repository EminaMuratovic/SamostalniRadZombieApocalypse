
public class Player extends Character{
	private double intelligence;
	private int skill;
	
	/**
	 * creates a player with his characteristics
	 * @param name String name of the player
	 * @param hp double health points ( 0-200 )
	 * @param dex double dexterity, how precise is the player ( 0-1 )
	 * @param weapon Weapon what weapon does the character have 
	 * @param strength double strength of the player ( 0-20 )
	 * @param speed double speed of the player ( 0-20 )
	 * @param inteligence double inteligence of the player ( 0-2 )
	 */
	public Player(String name, double hp, double dex, Weapon weapon, double strength, double speed, double intelligence) {
		super(name, hp, dex, weapon, strength, speed);
		setIntelligence(intelligence);
		this.skill = 0;
	}
	
	/**
	 * escape chance of the player
	 * @param z Character zombie
	 * @return true or false
	 */
	public boolean escChance(Character z) {
		int a = (int)((intelligence * getSpeed()) / z.getSpeed());
		if(a == 0)
			return false;
		else
			return true;
	}
	
	/**
	 * gets the skill of the player
	 * @return skill
	 */
	public int getSkill() {
		return skill;
	}
	
	/**
	 * sets the skill of the player	
	 * @param skill
	 */
	public void setSkill(int skill) {
		this.skill = skill + 1;
	}
	
	/**
	 * sets the inteligence of the player
	 * @param inteligence double inteligence of the player
	 * @throws IllegalArgumentException("!!")
	 */
	public void setIntelligence(double intelligence) {
		if(intelligence >= 0.5 && intelligence <=2)
			this.intelligence = intelligence;
		else throw new IllegalArgumentException("!!");
	}
	
	/**
	 * returns string representation of the object
	 */
	public String toString() {
		String str = "";
		str += "HP: " + this.getHPafterAttack() + "; Dexterity: " + this.getDex() + "; Strength: " + this.getStrength();
		str += "; Speed: " + this.getSpeed() + "; Intelligence: " + intelligence + "; Skill: " + this.skill;
		return str;
	}

}
