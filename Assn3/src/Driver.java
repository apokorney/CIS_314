public class Driver {
	public static void main(String[] args) {
		try {

			FileContent fc = FileReader.loadFile("alice.txt");
			System.out.println(fc.generateReport());
			FileWriter.writeFile("Output.txt", fc, 90);

		} catch (Exception ex) {
			ex.printStackTrace();

		}

	}
}
