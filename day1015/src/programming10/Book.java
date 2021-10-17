package programming10;

abstract class Book {
	protected String number;
	protected String title;
	protected String author;
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book() {
	}
	
	public Book(String number, String title, String author) {
		super();
		this.number = number;
		this.title = title;
		this.author = author;
	}
	public abstract void getLateFees();
	@Override
	public String toString() {
		return "Book [number=" + number + ", title=" + title + ", author=" + author + "]";
	}
	
	
	

}
