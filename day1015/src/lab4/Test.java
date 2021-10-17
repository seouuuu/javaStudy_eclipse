package lab4;

public class Test {

	public static void main(String[] args) {
		GameCharacter g1 = new Hobitt();
		GameCharacter g2 = new Titan();
		GameCharacter g3 = new Sorcerer();
		
		g1.getLife();
		g1.getRing();
		((Hobitt)g1).getRing();

	}

}
