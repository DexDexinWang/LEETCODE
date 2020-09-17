import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindMostFrequentWordFromExcel {
	
	private static String folderPath;
	private static String csvPath;
	private static List<String> csvOutputHeaders;
	public static void main(String[] args) {
		csvPath = (args == null || args.length == 0 ? System.getProperty("user.dir") + "\\test.csv" : args[0]);
		folderPath = (args == null || args.length <= 1 ? System.getProperty("user.dir") : args[1]);
		System.out.println(csvPath);
		System.out.println(folderPath);
		mainProcess();
	}
	private static List<String> getCSVData(File csvFile) {
		try {
			if (csvFile.isFile()) {
				BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
				List<String> res = readLines(csvReader);
				return res;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		return null;
	}
	
	private static void mainProcess() {
		//Create file for input
		File csvFile = new File(csvPath);
		//Read all sentencexs
		List<String> sentences = getCSVData(csvFile);
		//Output final Result
		outputData(sentences);
	}
	
	private static List<String> readLines(BufferedReader csvReader) throws Exception {
		List<String> sentences = new LinkedList<>();
		String row;
		while ((row = csvReader.readLine()) != null) {
			sentences.add(row);
		}
		csvReader.close();
		return sentences;
	}
	
	private static void outputData(List<String> sentences) {
		PriorityQueue<String[]> maxHeap = getMaxHeap(countWord(sentences));
		File outputFile = new File(folderPath+"\\output.csv");
		try { 
			PrintWriter  outputWirter = new PrintWriter(outputFile);
			StringBuilder sb = new StringBuilder();
			sb.append("Word,").append("Frequency");
			sb.append('\n');
			while(!maxHeap.isEmpty()) {
				String[] temp = maxHeap.poll();
				sb.append(temp[0]).append(",").append(temp[1]).append(",").append('\n');
			}
			outputWirter.write(sb.toString());
			outputWirter.close();
		} catch(Exception ex) {
			ex.printStackTrace(); 
		} 
	}
	
	private static PriorityQueue<String[]> getMaxHeap(Map<String, Integer> count){
		PriorityQueue<String[]> maxHeap = new PriorityQueue<String[]>((a,b)->(count.get(b[0]) - count.get(a[0])));
		for(Map.Entry<String,Integer> entry: count.entrySet()) {
			maxHeap.offer(new String[] {entry.getKey(),String.valueOf(entry.getValue())});
		}
		return maxHeap;
	}
	
	private static Map<String, Integer> countWord(List<String> sentences) {
		Map<String, Integer> count = new HashMap<>();
		for(String sentence: sentences) {
			sentence = sentence.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();
			String[] words = sentence.split(" ");
			for(String word: words) {
				count.putIfAbsent(word, 0);
				count.put(word, count.get(word) + 1);
			}
		}
		return count;
	}
	
}
