import java.util.LinkedList;
import java.util.List;

class OrderedStream {
    String[] array;
    int ptr;
    public OrderedStream(int n) {
        array = new String[n + 1];
        ptr = 1;
    }
    
    public List<String> insert(int id, String value) {
        List<String> res = new LinkedList<>();
        array[id]= value;
        while(ptr != array.length && array[ptr]!=null) {
            res.add(array[ptr++]);
        } 
        return res;
    }
}


public class Solution5601 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OrderedStream test = new OrderedStream(5);
		System.out.println(test.insert(3, "c"));
		System.out.println(test.insert(1, "a"));
		System.out.println(test.insert(2, "b"));
		System.out.println(test.insert(5, "E"));
		System.out.println(test.insert(4, "d"));
	}


}
