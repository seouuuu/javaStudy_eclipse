package programming7;

public class ShapeTest {

	public static void main(String[] args) {
		Shape s;
		int type;
		
		type =5;
		
		switch(type) {
		case 1:
			s = new Ellipse();
			((Ellipse)s).setRadius1(2);
			((Ellipse)s).setRadius2(3);
			((Ellipse)s).getArea();
			System.out.println(s);
			break;
		case 2:
			s = new Rectangle();
			((Rectangle)s).setLength(3);
			((Rectangle)s).setWidth(6);
			((Rectangle)s).getArea();
			System.out.println(s);
			break;
		case 3:
			s = new Triangle();
			((Triangle)s).setHeight(6);
			((Triangle)s).setWidth(3);
			((Triangle)s).getArea();
			System.out.println(s);
			break;
		case 4:
			s = new Shpere();
			((Shpere)s).setRadius(2);
			((Shpere)s).getVolume();
			System.out.println(s);
			break;
		case 5:
			s = new Cube();
			((Cube)s).setHeight(5);
			((Cube)s).setLength(8);
			((Cube)s).setWidth(3);
			((Cube)s).getVolume();
			System.out.println(s);
			break;
		case 6:
			s = new Cylinder();
			((Cylinder)s).setHeight(4);
			((Cylinder)s).setRadius(5);
			((Cylinder)s).getVolume();
			System.out.println(s);
			break;
		}
	}
}
