public class FullTimeStudent extends Student {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FullTimeStudent(String id, String firstName, String lastName, String program) {
		super(id, firstName, lastName, program, "Full Time");
	}

	@Override
	public String toString() {
		return super.toString() + "\nEnrollment Type: " + getEnrollmentType();
	}

}
