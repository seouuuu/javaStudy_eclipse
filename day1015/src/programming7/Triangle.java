package programming7;

public class Triangle extends TwoDimShape {
	public double width,height;

	public void setWidth(double width) {
		this.width = width;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void getArea() {
		area = width *  height * 1/2;
	}
	
	public String toString() {
		return super.toString()+"»ï°¢Çü:"+area;
	}

}
