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
	
	// function to add frame to list of frames	
	public void roll(int firstRoll, int secondRoll, int thirdRoll, int currentFrame) {
		if (currentFrame != 9) {
			// not the last frame			
			if (firstRoll == 10) {
				// if strike				
				frames.add(new Frame(firstRoll, 0, 0, currentFrame));
			} else {
				// if not strike	
				frames.add(new Frame(firstRoll, secondRoll, 0, currentFrame));
			}
		} else {
			// last frame			
			if (firstRoll == 10) {
				// if strike				
				frames.add(new Frame(firstRoll, secondRoll, thirdRoll, currentFrame));
			} else {
				// if not strike	
				frames.add(new Frame(firstRoll, secondRoll, 0, currentFrame));
			}
		}
		
		
	}
	
	// function to update scores	
	public int updateScores() {
		
		for (int i = 0; i < frames.size(); i++) {
			score += calculateFrameScore(i);
		}
		
		return this.score;
	}
	
	//	function to get score of each individual frame
	public int calculateFrameScore(int index) {
		Frame currentFrame = frames.get(index);
		
		// get current score of current frame		
		int currentFrameScore = currentFrame.score();
		
		if (currentFrame.isStrike() && index < (frames.size() - 1)) {
			// if current frame is a strike			
			if (frames.get(index+1).isStrike()) {
				// if next frame is a strike
				// update current frame score to add score from next frame			
				currentFrameScore += frames.get(index+1).score();
								
				if ((index + 2) < frames.size()) {
					// update current frame score to add number of pins knocked down
					// from first ball of frame after next frame					
					currentFrameScore += frames.get(index+2).getFirstBall();
				}
			} else {
				currentFrameScore += (frames.get(index+1).getFirstBall() + frames.get(index+1).getSecondBall());
			}
		} else if (currentFrame.isSpare() && index < (frames.size() - 1)) {
			// if current frame is a spare
			// update current frame score to add number of pins knocked down
			// from first throw from next frame		
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
