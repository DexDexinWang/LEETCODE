import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution353 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SnakeGame test = new SnakeGame(3,2, new int[][]{{1,2},{0,1}});
		System.out.println(test.move("R"));
		System.out.println(test.move("D"));
		System.out.println(test.move("R"));
		System.out.println(test.move("U"));
		System.out.println(test.move("L"));
		System.out.println(test.move("U"));
	}
}
