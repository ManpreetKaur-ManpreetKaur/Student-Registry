import java.io.Serializable;

/**
 * @author Hp
 *
 */
public abstract class Student implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;
	private String firstName;
	private String lastName;
	private String program;
	private String enrollmentType;

	public Student(String id, String firstName, String lastName, String program, String enrollmentType) {
		this.setId(id);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setProgram(program);
		this.setEnrollmentType(enrollmentType);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

	public String getEnrollmentType() {
		return enrollmentType;
	}

	public void setEnrollmentType(String enrollmentType) {
		this.enrollmentType = enrollmentType;
	}

	@Override
	public String toString() {
		return "ID:" + id + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nProgram: " + program;
	}

}

