import java.util.LinkedList;
import java.util.List;

public class IPCombinations {

	 void dfsHelp(char[] arr, int start, int end, List<String> path, List<String> res) {
		  if(end >=arr.length) {
		    if(path.size() == 4) {
		      StringBuilder sb = new StringBuilder();
		      for(String str: path) {
		        sb.append(str).append(".");
		      }
		      sb.deleteCharAt(sb.length() -1);
		      res.add(sb.toString());
		    }
		    return;
		  }
		  if(path.size() >=4) return;
		  //whether should stop the current one;
		  if(start - end + 1 <= 3) {
		    StringBuilder sb1 = new StringBuilder();
		    for(int i = start; i <= end; i++) {
		      sb1.append(arr[i]);
		    }
		    String temp = sb1.toString();
		    if(Integer.valueOf(temp) <= 255 && !(sb1.charAt(0)=='0' && sb1.length() >= 2)) {
		      path.add(temp);
		      dfsHelp(arr, end+1, end+1, path, res);
		      path.remove(path.size()-1);   
		    }
		  }
		  if(end - start + 1 < 3) {
		    dfsHelp(arr, start, end + 1, path, res);
		  }
		} 
		  
		  public List<String> getIPs(String str) {
		    List<String> res = new LinkedList<>();
		    str = str.replaceAll("[^0-9]","");
		    if(str.length() < 4) return res;
		    char[] arr = str.toCharArray();
		    dfsHelp(arr, 0, 0, new LinkedList<String>(), res);
		    return res;
		  }
		  
		  
		 public static void main(String[] args) {
		   /*
		   Input: s = "25525511135"
		Output: ["255.255.11.135","255.255.111.35"]
		   */
		    System.out.println(new IPCombinations().getIPs("1010sdfsdfsdf23"));
		  }



}
