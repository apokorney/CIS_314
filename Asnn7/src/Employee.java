import java.io.Serializable;

public class Employee implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 858861701993073323L;
	private final String identifier;
	private final String firstname;
	private final String lastname;
	double hourlyrate;

	public Employee(String identifier, String firstname, String lastname, double hourlyrate) {
		this.identifier = identifier;
		this.firstname = firstname;
		this.lastname = lastname;
		this.hourlyrate = hourlyrate;
	}

	public double getHourlyrate() {
		return hourlyrate;
	}

	public void setHourlyrate(int hourlyrate) {
		this.hourlyrate = hourlyrate;
	}

	public String getIdentifier() {
		return identifier;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		long temp;
		temp = Double.doubleToLongBits(hourlyrate);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((identifier == null) ? 0 : identifier.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (Double.doubleToLongBits(hourlyrate) != Double.doubleToLongBits(other.hourlyrate))
			return false;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee:\n Identifier:       " + identifier + "\n Firstname:        " + firstname
				+ "\n Lastname          " + lastname + "\n Hourlyrate:       " + hourlyrate + "\n";
	}

}
