package programming10;

public class BookTest {

	public static void main(String[] args) {
		Novel n = new Novel("1000","������ ���","���ο���ƾ",3);
		n.getLateFees();
		Poet p = new Poet("1001","�� ���� ���� ��","������",2);
		p.getLateFees();
		ScienceFiction s = new ScienceFiction("1002","�츮�� ���� �ӵ��� �� �� ���ٸ�","���ʿ�",6);
		s.getLateFees();
		
		System.out.println(n);
		System.out.println(p);
		System.out.println(s);
	}

}
