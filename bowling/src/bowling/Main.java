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
		
		do {
			System.out.print("Enter number of players (Max 5): ");
			numPlayers = scanner.nextInt();
		} while (numPlayers > 5 && !(numPlayers == (int)numPlayers));
		
		System.out.println();
		System.out.println("Enter player names: ");
		for (int i = 0; i < numPlayers; i++) {
			name = scanner.next();
			if (name.isEmpty()) break;
			players.add(new Player(name));
		}
		
		System.out.println("");
		
		for (Player p : players) {
			System.out.print(p.name + " ");;
		}
		System.out.println();
		
		Game game = new Game(players);
		game.play();
		game.printScores();
		scanner.close();
	}

}
