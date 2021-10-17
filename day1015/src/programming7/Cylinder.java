package programming7;

public class Cylinder extends ThreeDimShape {
	public double radius,height;

	public void setRadius(double radius) {
		this.radius = radius;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void getVolume() {
		volume = radius * radius * height;
	}
	
	public String toString() {
		super.toString()+", ¿ø±âµÕ:"+volume +"¥ð";
	}
}
