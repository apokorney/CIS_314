import java.util.HashMap;

public interface EmployeeFileReader {
	HashMap<String, Employee> loadEmployees(String fileName);

}
