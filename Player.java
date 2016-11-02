import java.util.ArrayList;

/* Class that represents a bowling player. Each player has an
 * ArrayList of frames that can be analyzed to calculate a
 * player's score.
*/
public class Player {

	private String name;
	private int score;
	private ArrayList<Frame> frames;
	private int frameNum = 0;
	private static final int MAX_PINS = 10;

	public Player(String nameIn) {
		this.name = nameIn;
		this.score = 0;
		this.frames = new ArrayList<Frame>();
	}

	// Getters and Setters//
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return this.score;
	}

	public ArrayList<Frame> getFrames() {
		return frames;
	}

	public void setFrames(ArrayList<Frame> frames) {
		this.frames = frames;
	}

	/////Player Actions/////
	
	//Returns the number of pins downed on one roll
	public int roll(int remainingPins) {
		return LaneHardware.checkPinState(remainingPins);
	}

	// Executes one turn with random rolls
	public void playFrameRandom() {
		if (this.frameNum < 9) {
			this.getFrames().add(new Frame());
			this.frameNum++;

			int roll1 = roll(MAX_PINS);
			getCurrFrame().setFirstRoll(roll1);

			if (roll1 < MAX_PINS) {
				int roll2 = roll(MAX_PINS - roll1);
				getCurrFrame().setSecondRoll(roll2);
			}
		} else if (this.frameNum == 9) {
			this.getFrames().add(new Frame());
			this.frameNum++;
			int roll1 = roll(MAX_PINS);
			getCurrFrame().setFirstRoll(roll1);

			if (roll1 < MAX_PINS) {
				int roll2 = roll(MAX_PINS - roll1);
				getCurrFrame().setSecondRoll(roll2);
				if (roll1 + roll2 == MAX_PINS) {
					int roll3 = roll(MAX_PINS);
					getCurrFrame().setThirdRoll(roll3);
				}
			} else if (roll1 == MAX_PINS) {
				int roll2 = roll(MAX_PINS);
				getCurrFrame().setSecondRoll(roll2);
				if (roll2 < MAX_PINS) {
					int roll3 = roll(MAX_PINS - roll2);
					getCurrFrame().setThirdRoll(roll3);
				} else if (roll2 == MAX_PINS) {
					int roll3 = roll(MAX_PINS);
					getCurrFrame().setThirdRoll(roll3);
				}
			}
		}
		updateScore();
	}

	// For when we want to designate how many pins the player knocked down per
	// roll
	public void playFrameSpecific(int roll1In, int roll2In) {
		if (this.frameNum < 9) {
			this.getFrames().add(new Frame());
			this.frameNum++;
			this.getCurrFrame().setFirstRoll(roll1In);
			this.getCurrFrame().setSecondRoll(roll2In);
		} else if (this.frameNum == 9) {
			this.getFrames().add(new Frame());
			this.frameNum++;
			this.getCurrFrame().setFirstRoll(roll1In);
			this.getCurrFrame().setSecondRoll(roll1In);
			this.getCurrFrame().setThirdRoll(roll1In);
		}
		updateScore();
	}

	// Scoreboard Helper Methods
	public Frame getCurrFrame() {
		return this.getFrames().get(frameNum - 1);
	}

	public Frame getPrevFrame() {
		return this.getFrames().get(frameNum - 2);
	}

	public Frame getPrevPrevFrame() {
		return this.getFrames().get(frameNum - 3);
	}

	public int getFrameNum() {
		return frameNum;
	}

	public int updateScore() {
		if (frameNum == 10) {
			if (getCurrFrame().getFirstRoll() == 10) {
				if (getCurrFrame().getSecondRoll() == 10) {
					if (getCurrFrame().getThirdRoll() == 10) {
						score += 60;
					} else {
						score += (50 + getCurrFrame().getThirdRoll());
					}
				}
			}
		} else if (frameNum == 1) {
			this.score += getCurrFrame().getFirstRoll()
					+ (getCurrFrame().isStrike() ? 0 : getCurrFrame().getSecondRoll());
			if (!getCurrFrame().isSpare() && !getCurrFrame().isStrike()) {
				getCurrFrame().setScored(true);
			}
		} else if (frameNum == 2) {
			if (!getCurrFrame().isSpare() && !getCurrFrame().isStrike()) {
				getCurrFrame().setScored(true);
			}
			if (getPrevFrame().isStrike()) {
				if (getCurrFrame().isStrike()) {
					this.score += 20;
				} else {
					this.score += 2 * (getCurrFrame().getFirstRoll() + getCurrFrame().getSecondRoll());
					getPrevFrame().setScored(true);
				}
			} else if (getPrevFrame().isSpare()) {
				if (getCurrFrame().isStrike()) {
					this.score += 20;
				} else {
					this.score += 2 * (getCurrFrame().getFirstRoll()) + getCurrFrame().getSecondRoll();
				}
				getPrevFrame().setScored(true);
			} else {
				this.score += getCurrFrame().getFirstRoll() + getCurrFrame().getSecondRoll();
				if (!getCurrFrame().isSpare() && !getCurrFrame().isStrike()) {
					getCurrFrame().setScored(true);
				}
				getPrevFrame().setScored(true);
			}
		}

		else if (frameNum > 2) {

			if (!getCurrFrame().isSpare() && !getCurrFrame().isStrike()) {
				getCurrFrame().setScored(true);
			}
			if (getPrevPrevFrame().isScored() == false) {
				if (getCurrFrame().isStrike()) {
					this.score += 30;
					getPrevPrevFrame().setScored(true);
				}
			} else {
				if (getPrevFrame().isStrike()) {
					if (getCurrFrame().isStrike()) {
						this.score += 20;
					} else {
						this.score += 2 * (getCurrFrame().getFirstRoll() + getCurrFrame().getSecondRoll());
						getPrevFrame().setScored(true);
					}
				} else if (getPrevFrame().isSpare()) {
					this.score += (2 * getCurrFrame().getFirstRoll()) + getCurrFrame().getSecondRoll();
					getPrevFrame().setScored(true);
				} else {
					this.score += getCurrFrame().getFirstRoll() + getCurrFrame().getSecondRoll();
					getCurrFrame().setScored(true);
				}
			}
		}
		return this.score;
	}

}
