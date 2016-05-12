package bowling;

import java.util.ArrayList;
import java.util.List;

public class Game {
	
	public List<Player> players = new ArrayList<Player>();

	public Game(List<Player> players) {
		// TODO Auto-generated constructor stub
		for (Player p : players) {
			this.players.add(p);
		}
	}

}
