package Assignment_no_2;

public class SchoolStudent extends Student {
	private String boardName;

	public SchoolStudent(int rollNo, String name, String state, String boardName) {
		super(rollNo, name, state);
		this.boardName = boardName;
	}

	public String getBoardName() {
		return boardName;
	}

	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}

	@Override
	public String toString() {
		return super.toString() + "\nBoard Name: " + boardName+ "\n---------------------------------";
	}
}
