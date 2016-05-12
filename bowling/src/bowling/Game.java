package bowling;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
	
	public List<Player> players = new ArrayList<Player>();

	public Game(List<Player> players) {
		// TODO Auto-generated constructor stub
		for (Player p : players) {
			this.players.add(p);
		}
	}
	
	private int enterNumberOfPins(Player currentPlayer, int limit, Scanner scanner) {
		int numPins;
		
		do {
			System.out.println(currentPlayer.name + "'s turn.");
			System.out.println("Enter number of pins (0-10): ");
			numPins = scanner.nextInt();
		} while(numPins < 0 || numPins > limit);
		
		return numPins;
	}

	public void play() {
		Scanner scanner = new Scanner(System.in);
		int firstRoll, secondRoll, thirdRoll; 
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < players.size(); j++) {
				
				Player currentPlayer = players.get(j);
				
				firstRoll = enterNumberOfPins(currentPlayer, 10, scanner);
				
				if (i != 9) {
					if (firstRoll == 10) {
						currentPlayer.roll(firstRoll, 0, 0, i);
					} else {
						secondRoll = enterNumberOfPins(currentPlayer, 10-firstRoll, scanner);
						currentPlayer.roll(firstRoll, secondRoll, 0, i);
					}
				} else {
					if (firstRoll == 10) {
						secondRoll = enterNumberOfPins(currentPlayer, 10, scanner);
						if (secondRoll == 10) {
							thirdRoll = enterNumberOfPins(currentPlayer, 10, scanner);
						} else {
							thirdRoll = enterNumberOfPins(currentPlayer, 10-secondRoll, scanner);
						}
						currentPlayer.roll(firstRoll, secondRoll, thirdRoll, i);
					} else {
						secondRoll = enterNumberOfPins(currentPlayer, 10-firstRoll, scanner);
						currentPlayer.roll(firstRoll, secondRoll, 0, i);
					}
				}
			}
		}
		scanner.close();
	}
	
	public void printScores() {
		System.out.println();
		System.out.println("Players \t" + "Score");
		System.out.println("---------------------");
		for (Player p : players) {
			System.out.println(p.name + " \t\t" + p.updateScores());
		}
	}
}