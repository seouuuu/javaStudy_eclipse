package programming10;

public class Poet extends Book {
	int day,latefees,fees;

	public void getLateFees() {
		latefees = 200;
		fees = day * latefees;
	}
	
	public Poet() {
	}
	
	
	public Poet(String number, String title, String author,int day) {
		super(number, title, author);
		this.day = day;
	}

	@Override
	public String toString() {
		return "Poet [number=" + number + ", title=" + title + ", author=" + author + ", day=" + day + ", latefees="
				+ latefees + ", fees=" + fees + "]";
	}
	
}
