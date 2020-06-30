import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> equations = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		temp.add("a");
		temp.add("b");
		equations.add(temp);
		
		List<String> temp1 = new ArrayList<>();
		temp1.add("b");
		temp1.add("c");
		equations.add(temp1);
		
		double[] values = new double[]{2.0, 3.0};
		
		List<List<String>> queries = new ArrayList<>();
		List<String> temp3 = new ArrayList<>();
		temp3.add("a");
		temp3.add("c");
		queries.add(temp3);
		
		temp3 = new ArrayList<>();
		temp3.add("b");
		temp3.add("a");
		queries.add(temp3);
		
		temp3 = new ArrayList<>();
		temp3.add("a");
		temp3.add("e");
		queries.add(temp3);
		
		temp3 = new ArrayList<>();
		temp3.add("a");
		temp3.add("a");
		queries.add(temp3);
		
		temp3 = new ArrayList<>();
		temp3.add("x");
		temp3.add("x");
		queries.add(temp3);
		
		
		System.out.println(Arrays.toString(new Solution399().calcEquation(equations, values, queries)));
		
	}
    class Edge{
        public String target;
        public double value;
        public Edge(String target, double value) {
            this.target = target;
            this.value =  value;
        }
    }
    //Directed graph with edge value. 
    //Check whether queries size is bigger than edges? 
    //It means whether record all nodes to others cost will be less than check each query
    //DFS check each equery.
    //How many levels in stack? N
    //How many status in each level?
    //1. if visited return -1;
    //2. if target return res;
    //3. otherwise, check nei; if anyh nei res is not -1 return that, otherwiese return -1
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = new HashMap<>();
        for(int i = 0; i < equations.size(); i++) {
            List<String> equ = equations.get(i);
            String a = equ.get(0);
            String b = equ.get(1);
            double value = values[i];
            graph.putIfAbsent(a, new LinkedList<Edge>());
            graph.putIfAbsent(b, new LinkedList<Edge>());
            graph.get(a).add(new Edge(b, value));
            graph.get(b).add(new Edge(a, 1/value));
        }
        
        double[] res = new double[queries.size()];
        int index = 0;
        for(List<String> query: queries) {
            String start = query.get(0);
            String end = query.get(1);
            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                res[index++] = -1;
                continue;
            }
            res[index++] = dfsCalculate(graph,  start,  end,  1, new HashSet<>());
        }
        return res;
    }
    
    private double dfsCalculate(Map<String, List<Edge>> graph, String start, String end, double pathRes, Set<String> seen){
        if(seen.contains(start)) return -1.0;
        if(start.equals(end)) return pathRes;
        seen.add(start);
        if(graph.containsKey(start)){
            for(Edge nei: graph.get(start)) {
                double res = dfsCalculate(graph, nei.target, end, pathRes * nei.value, seen);
                if(res != -1.0) {
                    return res;
                }
            }
        }
        seen.remove(start);
        return -1.0;
    }
}
