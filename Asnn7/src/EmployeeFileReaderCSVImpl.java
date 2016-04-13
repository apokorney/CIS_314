import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;

public class EmployeeFileReaderCSVImpl implements EmployeeFileReader {
	@Override
	public HashMap<String, Employee> loadEmployees(String fileName) {

		HashMap<String, Employee> loadedEmps = new HashMap<>();
		try {
			Scanner scanner = new Scanner(new File("EmployeeData.csv"));
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String[] values = line.split(",");
				if (values.length != 4) {
					System.err.println("Improperly formatted line: " + line);
					continue;
				}
				String id = values[0];
				String firstName = values[1];
				String lastName = values[2];
				double hourlyRate = Double.parseDouble(values[3]);
				Employee emp = new Employee(id, firstName, lastName, hourlyRate);
				loadedEmps.put(id, emp);
			}
			scanner.close();

		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			return null;
		}
		return loadedEmps;

	}
}
