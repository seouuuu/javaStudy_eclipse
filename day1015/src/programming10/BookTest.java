package programming10;

public class BookTest {

	public static void main(String[] args) {
		Novel n = new Novel("1000","오만과 편견","제인오스틴",3);
		n.getLateFees();
		Poet p = new Poet("1001","입 속의 검은 잎","기형도",2);
		p.getLateFees();
		ScienceFiction s = new ScienceFiction("1002","우리가 빛의 속도로 갈 수 없다면","김초엽",6);
		s.getLateFees();
		
		System.out.println(n);
		System.out.println(p);
		System.out.println(s);
	}

}
