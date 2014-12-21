/**
 * The game is played by the user. The user is a player and he has his characteristics(name,  health, dexterity, weapon, strength, speed i intelligence)
 * He is walking through zombies who also have their own characteristics ( name, health, dexterity, weapon, strength i speed).
 * When the player is eye-to-eye with zombie, he has two options: to run or to attack.
 * Run will succeed if the player is enough wiser and faster than zombie, if not he must defend himself.
 * The player and the zombie will be in the battle as long as one of the characters loses all of their HP.
 * Attack is depended by the characteristics of the attacker(dexterity, weapon,strength i intelligence).
 * There are many weapons for the player and the zombie, as well as different kinds of zombies.
 * After every battle(if the player survives) we should know how many health is left for the player.
 * The player has won the game if he survives all of the zombies.
 * @author eminamuratovic
 *
 */
public class Fajt {
	public static void main(String[] args) {
		
		
		//weapons:
		
		Weapon bone = new Bone();
		Weapon bite = new Bite();
		Weapon claw = new Claw();
		Weapon uzi = new Uzi();
		Weapon katana = new Katana();
		Weapon saw = new Saw();
		
		//player:
		
		Player p = new Player("Vedad", 100, 0.4, uzi, 4, 16, 1.7);
		 
		//zombies:
		
		Zombie Benjo = new Benjo(katana);
		Zombie Smoker = new Smoker(bite);
		Zombie Spitter = new Spitter(bone);
		Zombie Jockey = new Jockey(claw);
		Zombie Charger = new Charger(saw);
		
		System.out.println("Opis. You have: " + p.toString());
		System.out.println("Opis. Charger. Do you attack (attack) or do you escape(escape)?");
		String answer = TextIO.getlnString();
		if(attackZombie(p, Charger, answer) == true)
			return;
		System.out.println("Opis. Jockey. Do you attack (attack) or do you escape(escape)?");
		answer = TextIO.getlnString();
		if(attackZombie(p, Jockey, answer) == true)
			return;
		System.out.println("Opis. Spitter. Do you attack (attack) or do you escape(escape)?");
		answer = TextIO.getlnString();
		if(attackZombie(p, Spitter, answer) == true)
			return;
		System.out.println("Opis. Smoker. Do you attack (attack) or do you escape(escape)?");
		answer = TextIO.getlnString();
		if(attackZombie(p, Smoker, answer) == true)
			return;
		System.out.println("Opis. Benjo. Do you attack (attack) or do you escape(escape)?");
		answer = TextIO.getlnString();
		if(attackZombie(p, Benjo, answer) == true)
			return;
		System.out.println("You won the game! Congrats!");
		
			
	 
		
	}

	/**
	 * This method is called when we want to see what has the player decided: to run or to attack
	 * @param p Player attacker
	 * @param z Zombie opponent
	 * @param answer String players answer
	 * @return true or false
	 */

	private static boolean attackZombie(Player p, Zombie z, String answer) {
		if(answer.equals("attack"))
		{
			if(attack(p, z) == 0)
				return false;
			else 
				return true;
		}
		else
		{	
			if(escape(p, z) == 0)
				return false;
			else
				if(attack(p, z) == 0)
					return false;
				else 
					return true;
		}
	}


	
	/**
	 * If the player has decided to attack than we call this method
	 * @param p Player attacker
	 * @param z Zombie opponent
	 * @return 0 - player has killed the zombie; 1 - zombie has killed the player
	 */
	private static int attack(Player p, Zombie z) {
		p.attack(z);
		if(p.compare(z) == true)
			{
			p.setSkill(p.getSkill());
			System.out.println("You killed him! You now have: " + p.getHPafterAttack() + " health points and " + p.getSkill() + " skill.");
			return 0;
			}
		else
			{
			System.out.println("You have been killed by " + z.getName() + ". We are sorry. ");
			return 1;
			}
		
	}
	
	/**
	 * if the player has decided to escape than we call this method
	 * @param p Player attacker
	 * @param z Zombie opponent
	 * @return 0 - player has escped; 1 - player did not escape, he has to fight with the opponent
	 */
	private static int escape(Player p, Zombie z) {
		p.escChance(z);
		if (p.escChance(z) == true)
			{
			System.out.println("You had more speed and intelligence than Charger. You escaped.");
			return 0;
			}
		else 
			{
			System.out.println("You did not have more speed and intelligence than " + z.getName() + ". You did not escape. You have to battle " + z.getName() + "!");
			return 1;
			}
		
	}

}
