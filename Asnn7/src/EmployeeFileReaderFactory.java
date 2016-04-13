
public class EmployeeFileReaderFactory {
	public static EmployeeFileReader makeReader(String filename) throws UnknownFormatException {

		if (filename.endsWith("xml")) {
			EmployeeFileReader xml = new EmployeeFileReaderXMLImpl();
			return xml;
		} else if (filename.endsWith("csv")) {
			EmployeeFileReader csv = new EmployeeFileReaderCSVImpl();
			return csv;
		} else throw new UnknownFormatException("The name of the file passed in has an unknown extension.");
	

	}

}
