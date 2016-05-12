package bowling;

import java.util.ArrayList;
import java.util.List;

public class Player {
	
	public String name;
	public List<Frame> frames = new ArrayList<Frame>();
	public List<Integer> scores = new ArrayList<Integer>();
	public int score;

	public Player(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.score = 0;
	}
	
	public void roll(int firstRoll, int secondRoll, int thirdRoll, int currentFrame) {
		if (currentFrame != 9) {
			if (firstRoll == 10) {
				frames.add(new Frame(firstRoll, 0, 0, currentFrame));
			} else {
				frames.add(new Frame(firstRoll, secondRoll, 0, currentFrame));
			}
		} else {
			if (firstRoll == 10) {
				frames.add(new Frame(firstRoll, secondRoll, thirdRoll, currentFrame));
			} else {
				frames.add(new Frame(firstRoll, secondRoll, 0, currentFrame));
			}
		}
		
		
	}
	
	public int updateScores() {
		
		for (int i = 0; i < frames.size(); i++) {
			score += calculateFrameScore(i);
		}
		
		return this.score;
	}
	
	public int calculateFrameScore(int index) {
		Frame currentFrame = frames.get(index);
		
		int currentFrameScore = currentFrame.score();
		
		if (currentFrame.isStrike() && index < (frames.size() - 1)) {

			if (frames.get(index+1).isStrike()) {
				currentFrameScore += frames.get(index+1).score();
				
				if ((index + 2) < frames.size()) {
					currentFrameScore += frames.get(index+2).getFirstBall();
				}
			} else {
				currentFrameScore += (frames.get(index+1).getFirstBall() + frames.get(index+1).getSecondBall());
			}
		} else if (currentFrame.isSpare() && index < (frames.size() - 1)) {
			currentFrameScore += frames.get(index+1).getFirstBall();
		}
		
		return currentFrameScore;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getScore() {
		return this.score;
	}
}
