package bowling;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	public String name;
	public List<Frame> frames = new ArrayList<Frame>();
	public int score;

	public Player(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.score = 0;
	}
	
	public void roll(int firstRoll, int secondRoll) {
		if (firstRoll == 10) {
			frames.add(new Frame(firstRoll, 0));
		} else {
			frames.add(new Frame(firstRoll, secondRoll));
		}
	}
	
//	public void updateScores() {
//		if (frames.size() > 2) {
//			
//		}
//	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
}
