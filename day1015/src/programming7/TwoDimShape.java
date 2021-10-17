package programming7;

abstract class TwoDimShape extends Shape {
	protected double area;
	
	public abstract void getArea();
	
	@Override
	public String toString() {
		return super.toString() + " 2차원도형면적/ ";
	}
	

}
