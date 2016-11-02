import java.util.Random;

public class LaneHardware {

	/*Lane Hardware is represented by a class that generates a random int.
	 * This int represents the number of pins knocked down after one roll.
	 */
	
    static Random rand = new Random();

	public static int checkPinState(int remainingPins) {
	    int randomNum = rand.nextInt(remainingPins + 1);
	    return randomNum;
	}
	
}
