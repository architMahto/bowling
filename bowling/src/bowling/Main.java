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
		
		do {
			System.out.println("Enter number of players (Max 5): ");
			numPlayers = scanner.nextInt();
		} while (numPlayers > 5);
		
		System.out.println();
		System.out.println("Enter player names: ");
		for (int i = 0; i < numPlayers; i++) {
			name = scanner.next();
			if (name.isEmpty()) break;
			players.add(new Player(name));
		}
		
		scanner.close();
		System.out.println("");
		
		for (Player p : players) {
			System.out.print(p.name + " ");;
		}
	}

}
