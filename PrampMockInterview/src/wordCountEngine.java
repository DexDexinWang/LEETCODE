import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class wordCountEngine {
	
	 static String[][] wordCountEngine1(String doc) {
	      
	      //doc.toLowerCase().replaceAll("^a-z","");
	      String[] words = doc.toLowerCase().replaceAll("'","").replaceAll("[^a-z]"," ").split("\\s+");//this bugged
	      Map<String,Integer> positions = new HashMap<>();
	      Map<String,Integer> count = new HashMap<>();
	      int index = 0 ;
	      for(String word : words) {
	        count.put(word,count.getOrDefault(word, 0)+1);
	        if(!positions.containsValue(word)) {
	          positions.put(word, index++);//this is bugged
	        }
	      }
	      
	        PriorityQueue<String> maxHeap = new PriorityQueue<>((a,b) -> (count.get(a) == count.get(b) ? positions.get(a) -positions.get(b) : count.get(b) -count.get(a)));//this is bugged
	      
	      for(Map.Entry<String,Integer> entry: count.entrySet()) {
	        maxHeap.offer(entry.getKey());
	      }
	      
	      int len = maxHeap.size();
	      String[][] res = new String[len][2];
	      for(int i = 0 ; i< len; i++) {
	        String temp = maxHeap.poll();
	        String[] tempRes = new String[]{temp,count.get(temp)+""};
	        res[i] = tempRes;
	      }
	      return res;
	    }
	  
	  //Time: O(nlogn) O(n)
	  
	 
	  
	  
	  
	  
	  static String[][] wordCountEngine(String doc) {
	        if(doc == null)
	        {
	            return new String[][]{};
	        }

	        String[] allWords = doc.replaceAll("[^a-zA-Z\\s]+", "")
	                .trim()
	                .toLowerCase()
	                .split("\\s");

	        LinkedHashMap<String, Integer> wordFreqMap = new LinkedHashMap<>();
	        mapByFrequency(allWords, wordFreqMap);

	        //System.out.println(wordFreqMap);

	        //Sorting can be O(n) by using extra memory, or O(n log n) if doing in place.
	        List[] wordsSortedByFreq = new ArrayList[allWords.length + 1];
	        sortByFrequency(wordFreqMap, wordsSortedByFreq);

	       //System.out.println(Arrays.toString(wordsSortedByFreq));

	        String[][] result = new String[wordFreqMap.size()][2];
	        reduceResult(wordsSortedByFreq, result);

	        return result;
	    }

	    private static void mapByFrequency(String[] allWords, LinkedHashMap<String, Integer> wordFreq)
	    {
	        Arrays.stream(allWords).forEach(w -> {
	            wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
	        });
	    }

	    private static void sortByFrequency(LinkedHashMap<String, Integer> wordFreq, List<String>[] sortedMap)
	    {
	        for (Map.Entry<String, Integer> entry : wordFreq.entrySet())
	        {
	            List<String> list = sortedMap[entry.getValue()] == null ?
	                    new ArrayList<>() : sortedMap[entry.getValue()];

	            list.add(entry.getKey());
	            sortedMap[entry.getValue()] = list;
	        }
	    }

	    private static void reduceResult(List<String>[] sortedMap, String[][] result)
	    {
	        int i = 0;
	        for(int index = sortedMap.length - 1; index > 0; index--)
	        {
	            List<String> words = sortedMap[index];
	            if(words != null)
	            {
	                for(String word : words)
	                {
	                    result[i] = new String[]{word, "" + index};
	                    i++;
	                }
	            }
	        }
	    }
	        
	  
	  
	  
    
    
    public static void main(String[] args) {
        String[][] res = wordCountEngine("Practice makes perfect. you'll only get Perfect by practice. just practice!");
        System.out.println(Arrays.deepToString(res));
      }
}
