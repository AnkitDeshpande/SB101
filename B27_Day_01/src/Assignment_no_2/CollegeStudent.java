package Assignment_no_2;

public class CollegeStudent extends Student {
	private String universityName;

	public CollegeStudent(int rollNo, String name, String state, String universityName) {
		super(rollNo, name, state);
		this.universityName = universityName;
	}

	public String getUniversityName() {
		return universityName;
	}

	public void setUniversityName(String universityName) {
		this.universityName = universityName;
	}

	@Override
	public String toString() {
		return super.toString() + "\nUniversity Name: " + universityName+ "\n---------------------------------";
	}
}
