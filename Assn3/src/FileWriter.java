import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class FileWriter {
	static void writeFile(String newFileName, FileContent fc, int lineWidth)
			throws FileNotFoundException, UnsupportedEncodingException {
		PrintWriter writer = new PrintWriter(newFileName);

		ArrayList<String> lines = fc.getContent();

		for (int i = 0; i < lines.size(); i++) {
			if (lines.get(i).length() > lineWidth) {

				if (i == lines.size() - 1)
					lines.add("");

				String correctLine = lines.get(i);
				String restOfLine = "";
				char cChar;

				do {
					int length = correctLine.length();
					cChar = correctLine.charAt(length - 1);
					
					if (correctLine.length() == 1) {
						writer.close();
						throw new IllegalArgumentException(
								"There is too large word in the text or too many spaces.");
					}
					
					if(correctLine.length() < lineWidth
						&& (cChar == ' ' && Character.isLetter(correctLine
								.charAt(length - 2))))
						break;
					
					correctLine = correctLine.substring(0,
							correctLine.length() - 1);
					restOfLine = cChar + restOfLine;

				} while (true);

				lines.set(i, correctLine);
				lines.set(i + 1, restOfLine + lines.get(i + 1));
			}

			writer.println(lines.get(i));
		}

		writer.close();
	}
}
