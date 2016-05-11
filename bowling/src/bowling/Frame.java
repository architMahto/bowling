package bowling;

public class Frame {
	
	private boolean onFirstBall;
	private boolean onSecondBall;
	private int firstBall;
	private int secondBall;

	public Frame(boolean onFirstBall, boolean onSecondBall, int firstBall, int secondBall) {
		// TODO Auto-generated constructor stub
		this.onFirstBall = onFirstBall;
		this.onSecondBall = onSecondBall;
		this.firstBall = firstBall;
		this.secondBall = secondBall;
	}

	public boolean isOnFirstBall() {
		return this.onFirstBall;
	}

	public boolean isOnSecondBall() {
		return this.onSecondBall;
	}

	public int getFirstBall() {
		return this.firstBall;
	}

	public int getSecondBall() {
		return this.secondBall;
	}

}
