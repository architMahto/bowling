package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Player> players = new ArrayList<Player>();
		Scanner scanner = new Scanner(System.in);
		String name;
		int numPlayers;
		
		System.out.println("#################");
		System.out.println("#    Bowling    #");
		System.out.println("#################");
		System.out.println();
		
		// Enter number of players		
		do {
			System.out.print("Enter number of players (Max 5): ");
			numPlayers = scanner.nextInt();
		} while (numPlayers > 5 && !(numPlayers == (int)numPlayers));
		
		// Enter names of each player		
		System.out.println();
		System.out.println("Enter player names: ");
		for (int i = 0; i < numPlayers; i++) {
			name = scanner.next();
			if (name.isEmpty()) break;
			players.add(new Player(name));
		}
		
		System.out.println();
		System.out.println("Let's get started!");
		System.out.println();
		
		// Create new game object		
		Game game = new Game(players);
		// Play game		
		game.play();
		// Print scores of each player	
		game.printScores();
		// Close scanner		
		scanner.close();
	}

}
