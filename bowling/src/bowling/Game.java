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
	
	// function to input number of pins up to limit	
	private int enterNumberOfPins(Player currentPlayer, int limit, Scanner scanner) {
		int numPins;
		
		do {
			System.out.println(currentPlayer.name + "'s turn.");
			System.out.print("Enter number of pins (0-10): ");
			numPins = scanner.nextInt();
		} while(numPins < 0 || numPins > limit);
		
		return numPins;
	}

	// function to play game	
	public void play() {
		Scanner scanner = new Scanner(System.in);
		int firstRoll, secondRoll, thirdRoll; 
		
		// Go through each frame		
		for (int i = 0; i < 10; i++) {
			System.out.println();
			System.out.println("===========================================================");
			System.out.println("Frame " + (i+1));
			System.out.println();
			
			// Go through turn of each player			
			for (int j = 0; j < players.size(); j++) {
				
				System.out.println();
				System.out.println("-----------------------------------------------------------");
								
				Player currentPlayer = players.get(j);
				
				// Get the number of pins on first roll				
				firstRoll = enterNumberOfPins(currentPlayer, 10, scanner);
					
				if (i != 9) {
					// Not the last frame			
					if (firstRoll == 10) {
						// if player gets a strike						
						currentPlayer.roll(firstRoll, 0, 0, i);
					} else {
						// if player doesn't get a strike						
						secondRoll = enterNumberOfPins(currentPlayer, 10-firstRoll, scanner);
						currentPlayer.roll(firstRoll, secondRoll, 0, i);
					}
						
				} else {
					// Last frame	
					if (firstRoll == 10) {
						// if player gets a strike						
						secondRoll = enterNumberOfPins(currentPlayer, 10, scanner);
						if (secondRoll == 10) {
							thirdRoll = enterNumberOfPins(currentPlayer, 10, scanner);
						} else {
							thirdRoll = enterNumberOfPins(currentPlayer, 10-secondRoll, scanner);
						}
						currentPlayer.roll(firstRoll, secondRoll, thirdRoll, i);
					} else {
						// if player doesn't get a strike		
						secondRoll = enterNumberOfPins(currentPlayer, 10-firstRoll, scanner);
						currentPlayer.roll(firstRoll, secondRoll, 0, i);
					}
				}
				
				System.out.println("-----------------------------------------------------------");
				System.out.println();
			}
			
			System.out.println("===========================================================");
			System.out.println();
		}
		scanner.close();
	}
	
	// function to print scores of each player	
	public void printScores() {
		System.out.println();
		System.out.println("Players \t" + "Score");
		System.out.println("---------------------");
		for (Player p : players) {
			System.out.println(p.name + " \t\t" + p.updateScores());
		}
	}
}
