package bowling;

public class Frame {
	
	private int firstBall;
	private int secondBall;
	private int score;

	public Frame(int firstBall, int secondBall) {
		// TODO Auto-generated constructor stub
		this.firstBall = firstBall;
		this.secondBall = secondBall;
		this.score = 0;
	}

	public int getFirstBall() {
		return this.firstBall;
	}

	public int getSecondBall() {
		return this.secondBall;
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
			this.score = 10;
		} else {
			this.score = this.firstBall + this.secondBall;
		}
		return this.score;
	}
}
