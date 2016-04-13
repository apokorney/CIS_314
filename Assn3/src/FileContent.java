import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FileContent {
	private String fileName;
	private int lineCount, wordCount, characterCount;
	private ArrayList<String> lines;
	private HashMap<Character, Integer> characters;
	private HashMap<String, Integer> words;
	private final int NUMBER_OF_COLUMNS = 5;

	public FileContent(String fileName, ArrayList<String> lines) {
		this.fileName = fileName;
		this.lines = lines;

		lineCount = 0;
		wordCount = 0;
		characterCount = 0;
		characters = new HashMap<Character, Integer>();
		words = new HashMap<String, Integer>();

		for (String line : lines) {
			++lineCount;

			for (int i = 0; i < line.length(); i++) {
				++characterCount;
				char ch = line.charAt(i);
				if (characters.containsKey(ch)) {
					int value = characters.get(ch) + 1;
					characters.put(ch, value);

				} else
					characters.put(ch, 1);
			}

			line = line.toLowerCase();
			line = line.replaceAll("[()':;\",!.?]", "");
			String[] lineWords = line.split("[- ]");

			for (String word : lineWords) {
				++wordCount;

				if (words.containsKey(word)) {
					int value = words.get(word) + 1;
					words.put(word, value);

				} else
					words.put(word, 1);
			}

		}
	}

	public ArrayList<String> getContent() {
		return new ArrayList<String>(lines);
	}

	public String generateReport() {
		String report = "File Name: " + fileName + ".\n" + "Line Count: "
				+ lineCount + ".\n" + "Word Count: " + wordCount + ".\n"
				+ "Char Count: " + characterCount + ".\n"
				+ "Characters Report: \n";

		String cReport = "";

		int count = 1;
		for (Entry<Character, Integer> entry : characters.entrySet()) {

			String temp = String.format("%-5s%s", "\'"+entry.getKey()+"\'",
					": " + entry.getValue() + "\t");
			cReport += temp;
			if (count % NUMBER_OF_COLUMNS == 0)
				cReport += "\n";
			++count;
		}

		count = 1;
		cReport += "\nWord Report: \n";
		for (Entry<String, Integer> entry : (new TreeMap<String,Integer>(words)).entrySet()) {

			String temp = String.format("%-15s%s", entry.getKey(),
					": " + entry.getValue() + "\t");
			cReport += temp;
			if (count % NUMBER_OF_COLUMNS == 0)
				cReport += "\n";
			++count;
		}

		return report + cReport;
	}
}
