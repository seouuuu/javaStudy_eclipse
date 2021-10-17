package programming7;

abstract class ThreeDimShape extends Shape {
	public double volume;
	
	
	public abstract void getVolume();
	
	public String toString() {
		return super.toString() +" 3차원도형체적/ ";
	}
}
