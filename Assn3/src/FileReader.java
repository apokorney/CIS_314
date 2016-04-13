import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReader {
	static FileContent loadFile(String fName) throws IOException {
		BufferedReader br = null;
		String sCurrentLine;
		br = new BufferedReader(new java.io.FileReader(fName));

		ArrayList<String> lines = new ArrayList<String>();

		while ((sCurrentLine = br.readLine()) != null)
			lines.add(sCurrentLine);

		br.close();

		return new FileContent(fName, lines);
	}
}
