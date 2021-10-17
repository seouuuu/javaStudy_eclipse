package programming10;

public class ScienceFiction extends Book {
	int day,latefees,fees;
	
	public void getLateFees() {
		latefees = 600;
		fees = day * latefees;
	}
	
	public ScienceFiction() {
	}
	
	public ScienceFiction(String number, String title, String author,int day) {
		super(number, title, author);
		this.day = day;
	}

	@Override
	public String toString() {
		return "ScienceFiction [number=" + number + ", title=" + title + ", author=" + author + ", day=" + day
				+ ", latefees=" + latefees + ", fees=" + fees + "]";
	}
	
}
