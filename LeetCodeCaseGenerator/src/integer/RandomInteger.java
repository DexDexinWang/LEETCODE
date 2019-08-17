package integer;

import java.util.concurrent.ThreadLocalRandom;
import keywords.keys;

public class RandomInteger {
	
	/**
	 * To return a random integer with minimum value and maximum value
	 */
	public static int range(int min,int max)
	{
		return ThreadLocalRandom.current().nextInt(min, max + 1);
	}
	
	/**
	 * To return a random integer with final minimum value and final maximum value
	 */
	public static int range()
	{
		return range(keys.MIN, keys.MAX);
	}
	
	
}
