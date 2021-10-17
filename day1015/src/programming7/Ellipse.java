package programming7;

public class Ellipse extends TwoDimShape {
	public double radius1,radius2;
	
	public void setRadius1(double radius1) {
		this.radius1 = radius1;
	}
	public void setRadius2(double radius2) {
		this.radius2 = radius2;
	}
	public void getArea() {
		area = radius1*radius2;
	}
	public String toString() {
		return super.toString() + "Å¸¿ø:"+area+"¥ð";
	}
}
