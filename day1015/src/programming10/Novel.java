package programming10;

public class Novel extends Book {
	int day,latefees,fees;
	
	public void getLateFees() {
		latefees = 300;
		fees = day * latefees;
	}
	public Novel() {
	}
	
	public Novel(String number, String title, String author,int day) {
		super(number, title, author);
		this.day = day;
		
	}
	@Override
	public String toString() {
		return "Novel [number=" + number + ", title=" + title + ", author=" + author + ", day=" + day + ", latefees="
				+ latefees + ", fees=" + fees + "]";
	}
	
}
