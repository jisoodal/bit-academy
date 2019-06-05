package ch07;

public class Exercise7_22 {

	public static void main(String[] args) {
		
		Shape[] arr = {new Circle(5.0), new Rectangle(3,4), new Circle(1) };
		System.out.println("면적의 합:"+sumArea(arr));

	}
	
	static double sumArea(Shape[] s) {
		
		double sum = 0.0;
		
		for(int i=0;i<s.length;i++) {
			sum += s[i].calcArea();
		}
		
		return sum;
	}

}

class Point {
	int x;
	int y;
	
	Point() {
		this(0,0);
	}
	
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public String toString() {
		return "["+x+","+y+"]";
	}
}

abstract class Shape {
	Point p;
	
	Shape() {
		this(new Point(0,0));
	}
	
	Shape(Point p){
		this.p = p;
	}
	
	abstract double calcArea();
	
	Point getPosition() {
		return p;
	}
	
	void setPosition(Point p) {
		this.p = p;
	}
}

class Circle extends Shape{
	
	double r;
	
	Circle(){
		
	}
	
	Circle(double r){
		this.r = r;
	}
	
	double calcArea() {
		
		return r*r*3.14;
	}
}

class Rectangle extends Shape{
	
	double width;
	double height;
	
	Rectangle() {
		
	}
	
	Rectangle(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	boolean isSquare() {
		
		if(width == height)
			return true;
		
		return false;
	}
	
	double calcArea() {
		
		return width * height;
		
	}
}
