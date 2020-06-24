package labcodeinspection;

import java.util.Locale;

public class Email {

	private final String firstName;
	private final String lastName;
	private transient String password; // Setter does not make sense here
	private String department;
	private final static int DEFAULT_PWD_LEN = 8;
	private transient String email; // Setter does not make sense

	/**
	 * Create on object of class Email
	 * @param firstName The first name of the employee
	 * @param lastName The last name of the employee
	 */
	public Email(final String firstName, final String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	/**
	 * Prints some information about the object to stdout
	 */
	public void showInfo() {
		System.out.println("\nFIRST NAME= " + getFirstName() + "\nLAST NAME= " + getLastName());
		System.out.println("DEPARMENT= " + getDepartment() + "\nEMAIL= " + getEmail() + "\nPASSWORD= " + getPassword());
	}

	public void setDepartment(final int depChoice) {
		switch (depChoice) {
		case 1:
			this.department = "sales";
			break;
		case 2:
			this.department = "dev";
			break;
		case 3:
			this.department = "acct";
			break;
		default:
			break;
		}
	}

	private String randomPassword(final int length) {
		final String set = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890#$&@*";
		char[] password = new char[length];
		for (int i = 0; i < length; i++) {
			final int rand = (int) (Math.random() * set.length());
			password[i] = set.charAt(rand);
		}
		return new String(password);
	}

	/**
	 * Create an email for the user based on its names. Also set password to a random value
	 */
	public void generateEmail() {
		this.password = this.randomPassword(DEFAULT_PWD_LEN);
		this.email = this.getFirstName().toLowerCase(Locale.forLanguageTag("es")) 
				+ this.getLastName().toLowerCase(Locale.forLanguageTag("es")) 
				+ "@" + this.getDepartment()
				+ ".espol.edu.ec";
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPassword() {
		return password;
	}

	public String getDepartment() {
		return department;
	}

	public String getEmail() {
		return email;
	}
}
