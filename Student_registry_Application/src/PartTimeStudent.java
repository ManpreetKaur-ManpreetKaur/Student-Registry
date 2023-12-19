public class PartTimeStudent extends Student {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PartTimeStudent(String id, String firstName, String lastName, String program) {
		super(id, firstName, lastName, program, "Part Time");
	}

	@Override
	public String toString() {
		return super.toString() + "\nEnrollment Type: " + getEnrollmentType();
	}

}
