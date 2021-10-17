package programming7;

public class Rectangle extends TwoDimShape {
	public double width,length;

	public void setWidth(double width) {
		this.width = width;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void getArea() {
		area = width * length;
	}
	public String toString() {
		return super.toString()+"»ç°¢Çü:"+area;
	}
	
	

}
