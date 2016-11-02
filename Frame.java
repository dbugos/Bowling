
public class Frame {
	
	private int firstRoll;
	private int secondRoll;
	private int thirdRoll;
	private boolean isScored;
	
	//Empty Constructor
	public Frame() {
		isScored = false;
	}
	
	//Reset Frame Constructor (User Input Required to Reset)
	public Frame(int firstRollIn, int secondRollIn, int thirdRollIn) {
		firstRoll = firstRollIn;
		secondRoll = secondRollIn;
		thirdRoll = thirdRollIn;
	}

	public int getFirstRoll() {
		return firstRoll;
	}

	public void setFirstRoll(int firstRoll) {
		this.firstRoll = firstRoll;
	}

	public int getSecondRoll() {
		return secondRoll;
	}

	public void setSecondRoll(int secondRoll) {
		this.secondRoll = secondRoll;
	}

	public int getThirdRoll() {
		return thirdRoll;
	}

	public void setThirdRoll(int thirdRoll) {
		this.thirdRoll = thirdRoll;
	}
	
	public boolean isStrike() {
		if (firstRoll == 10) {
			return true;
		}
		return false;
	}
	
	public boolean isSpare() {
		if (firstRoll + secondRoll == 10) {
			return true;
		}
		return false;
	}

	public boolean isScored() {
		return isScored;
	}

	public void setScored(boolean isScored) {
		this.isScored = isScored;
	}
	
}
