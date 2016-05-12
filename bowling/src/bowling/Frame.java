package bowling;

public class Frame {
	
	private int firstBall;
	private int secondBall;
	private int thirdBall;
	private int currentFrame;
	private int score;

	public Frame(int firstBall, int secondBall, int thirdBall, int currentFrame) {
		// TODO Auto-generated constructor stub
		this.firstBall = firstBall;
		this.secondBall = secondBall;
		this.thirdBall = thirdBall;
		this.currentFrame = currentFrame;
		this.score = 0;
	}

	public int getFirstBall() {
		return this.firstBall;
	}

	public int getSecondBall() {
		return this.secondBall;
	}

	public int getThirdBall() {
		return this.thirdBall;
	}
	
	public boolean isLastFrame() {
		return this.currentFrame == 9;
	}
	
	// check if frame is a strike	
	public boolean isStrike() {
		return this.firstBall == 10 && this.secondBall == 0;
	}

	// check if frame is a spare	
	public boolean isSpare() {
		return (this.firstBall + this.secondBall == 10) && this.firstBall != 10; 
	}
	
	// return score for single frame
	public int score() {
		if (isStrike() || isSpare()) {
			// score is 10 if frame is strike or spare	
			this.score = 10;
		} else if (isLastFrame()) {
			// if frame is last frame of the game			
			// score is the sum of all three throws			
			this.score = this.firstBall + this.secondBall + this.thirdBall;
		} else {
			// score is the sum of first two throws				
			this.score = this.firstBall + this.secondBall;
		}
		return this.score;
	}
}
