import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EmployeeService implements Serializable {

	private static final long serialVersionUID = -2212892153913865887L;
	private static EmployeeService instance = new EmployeeService();
	private transient EmployeeFileReader reader;
	HashMap<String, Employee> employees = new HashMap<>();

	private EmployeeService() {
	}

	public static EmployeeService getInstance() {
		return instance;
	}

	public int getEmployeeCount() {
		return employees.size();
	}

	public void loadEmployeesFromFile(String filename) throws UnknownFormatException {

		reader = EmployeeFileReaderFactory.makeReader(filename);
		HashMap<String, Employee> temp = reader.loadEmployees(filename);
		employees.putAll(temp);
	}

	public static void resetInstance() {
		instance = null;
		instance = new EmployeeService();
	}

	public static void saveToFile(String fileName) {
		File f = new File(fileName);
		if (f.exists()) {
			f.delete();
		}

		try (OutputStream file = new FileOutputStream(fileName);
				OutputStream buffer = new BufferedOutputStream(file);
				ObjectOutput output = new ObjectOutputStream(buffer);) {
			output.writeObject(instance);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static void loadFromFile(String fileName) {
		try (InputStream file = new FileInputStream(fileName);
				InputStream buffer = new BufferedInputStream(file);
				ObjectInput input = new ObjectInputStream(buffer);) {

			instance = (EmployeeService) input.readObject();
			
		} catch (IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		File f = new File(fileName);
		f.delete();
	}

	@Override
	public String toString() {
		Set set = employees.entrySet();
		Iterator i = set.iterator();
		String allEmp = "";
		while (i.hasNext()) {
			Map.Entry mentry = (Map.Entry) i.next();
			allEmp += mentry.getValue();
		}
		String readername = "None";
		if(reader != null){
			readername = reader.getClass().getName();
		}
		return "EmployeeService: (" + getEmployeeCount() + " Employees)\nCurrent Reader: " + readername
				+ "\n" + allEmp;
	}
}
