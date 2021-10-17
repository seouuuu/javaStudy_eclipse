package programming7;

public class Cube extends ThreeDimShape {
	public double width,length,height;

	public void setWidth(double width) {
		this.width = width;
	}
	public void setLength(double length) {
		this.length = length;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	
	public void getVolume() {
		volume = width * length * height;
	}
	public String toString() {
		return super.toString()+"Á÷À°¸éÃ¼:"+volume;
	}
	
}
