package programming7;

public class Shpere extends ThreeDimShape {
	double radius;

	public void setRadius(double radius) {
		this.radius = radius;
	}
	
	public void getVolume() {
		volume = radius * radius * radius *4/3;
	}
	
	public String toString() {
		return super.toString()+"±¸:"+volume+"¥ð";
	}

}
