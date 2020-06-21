import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class CSVData{
	public String id,fileName;
	public Set<String> existfolders;
	public CSVData(String id, String fileName) {
		this.id = id;
		this.fileName = fileName;
		existfolders = new HashSet<>();
	}
}

public class ImageChecker {	
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
	
	private static void mainProcess() {
		//Create file for input
		File csvFile = new File(csvPath);
		//Read data and header from input
		List<CSVData> csvDataList = getCSVData(csvFile);
		//Check file is exist in certain forlder;
		checkFileExist(csvDataList);
		//Output final Result
		outputData(csvDataList);
	}
	
	private static void checkFileExist(List<CSVData> csvDataList) {
		Map<String,Map<String,String>> files = getAllFiles();
		for(CSVData data : csvDataList) {
			for(Map.Entry<String, Map<String,String>> entry: files.entrySet()) {
				if(entry.getValue().containsKey(data.fileName)) {
					data.existfolders.add(entry.getKey());
				}
			}
		}
	}
	
	private static Map<String,Map<String,String>> getAllFiles() {
		Map<String,Map<String,String>> res = new HashMap<>();
		File csvFile = new File(folderPath);
		if(csvFile.isDirectory()) {
			File[] filesList = csvFile.listFiles();
			for(File directory: filesList) {
				if(directory.isDirectory()) {
					String folderName = directory.getName();
					res.put(folderName, traverseDirectoryDFS(directory.listFiles()));
					csvOutputHeaders.add(folderName);
				}
				
			}
			
		} 
		return res;
	}
	
	private static Map<String,String> traverseDirectoryDFS(File[] files) {
		Map<String,String> res = new HashMap<>();
		for (File file:files) {
			if(file.isFile()) {
				String[] fileNameParts = file.getName().split("_");
				String fileName = fileNameParts.length >= 2 ? fileNameParts[0]+"_"+fileNameParts[1]: fileNameParts[0];
				res.put(fileName, file.getPath());
			}
		}
		return res;
	}
	
	private static void outputData(List<CSVData> csvDataList) {
		File outputFile = new File(folderPath+"\\output.csv");
		try { 
			PrintWriter  outputWirter = new PrintWriter(outputFile);
			StringBuilder sb = new StringBuilder();
			sb.append("ID,").append("FielName,");
			for(String header: csvOutputHeaders) {
				sb.append(header).append(',');
			}
			sb.deleteCharAt(sb.length() - 1);
			sb.append('\n');
			outputWirter.write(sb.toString());
			for(CSVData data: csvDataList) {
				sb = new StringBuilder();
				sb.append(data.id).append(',').append(data.fileName).append(',');
				for(String header: csvOutputHeaders) {
					if(data.existfolders.contains(header)) {
						sb.append(1).append(',');
					} else {
						sb.append(0).append(',');
					}
				}
				sb.deleteCharAt(sb.length() - 1);
				sb.append('\n');
				outputWirter.write(sb.toString());
			}
			outputWirter.close();
		} catch(Exception ex) {
			ex.printStackTrace(); 
		}
	}
	
	private static List<CSVData> getCSVData(File csvFile) {
		try {
			if (csvFile.isFile()) {
				BufferedReader csvReader = new BufferedReader(new FileReader(csvFile));
				readHeaders(csvReader);
				List<CSVData> res = readLines(csvReader);
				return res;
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		return null;
	}
	
	private static void readHeaders(BufferedReader csvReader) throws Exception {
		String headerNames = csvReader.readLine();
		String[] headers = headerNames.split(",");
		if (!headers[0].equals("ID") || !headers[1].equals("FileName")) {
			csvReader.close();
			throwExcepction("Incorrect header, it should be 'ID' and 'FileName'");
		}
		csvOutputHeaders = new LinkedList<>();
	}
	
	private static List<CSVData> readLines(BufferedReader csvReader) throws Exception {
		List<CSVData> csvDataList = new LinkedList<>();
		String row;
		int lineNumber = 0;
		while ((row = csvReader.readLine()) != null) {
			lineNumber++;
		    String[] line = row.split(",");
		    if(line == null || line.length <2) {
		    	throwExcepction("The input line " + lineNumber + " is not in correct format!");
		    } else {
		    	CSVData lineData = new CSVData(line[0],line[1]);
		    	csvDataList.add(lineData);
		    }
		}
		csvReader.close();
		return csvDataList;
	}

	
	private static void throwExcepction(String errorMessage) throws Exception {
		throw new Exception(errorMessage);
	}
	
	private static void getDirectory(String filePath) {
		
	}
}
