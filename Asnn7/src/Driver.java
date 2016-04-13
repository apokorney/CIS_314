public class Driver {
	public static void main(String[] args) {
		try {
			System.out.println("Initial Employee Count: " + EmployeeService.getInstance().getEmployeeCount() + "\n");
			EmployeeService.getInstance().loadEmployeesFromFile("EmployeeData.xml");
			System.out.println("Employee Count after loading XML file: "
					+ EmployeeService.getInstance().getEmployeeCount() + "\n");
			EmployeeService.getInstance().loadEmployeesFromFile("EmployeeData.csv");
			System.out.println("Employee Count after loading CSV file: "
					+ EmployeeService.getInstance().getEmployeeCount() + "\n");
			System.out.println("Employee List:\n" + EmployeeService.getInstance());
			EmployeeService.saveToFile("EmployeeService.ser");
			System.out.println(
					"Employee Count after serializing: " + EmployeeService.getInstance().getEmployeeCount() + "\n");
			EmployeeService.resetInstance();
			System.out
					.println("Employee Count after reset: " + EmployeeService.getInstance().getEmployeeCount() + "\n");
			EmployeeService.loadFromFile("EmployeeService.ser");
			System.out.println("Employee Count after loading serialized file: "
					+ EmployeeService.getInstance().getEmployeeCount() + "\n");
			System.out.println("Employee List:\n" + EmployeeService.getInstance());
		} catch (UnknownFormatException ex) {
			ex.printStackTrace();
		}
	}
}
