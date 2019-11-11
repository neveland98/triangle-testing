package tr;

public class Triangle {
	double side1;
	double side2;
	double side3;
	public Triangle(double a, double b, double c) throws InvalidTriangleException{
		if(c >= a+b || a >= b+c || b >= a+c) {
			throw new InvalidTriangleException("Invalid Dimensions!");
		}
		else {
			side1 = a;
			side2 = b;
			side3 = c;
		}
	}
	public Triangle(Point a, Point b, Point c) throws InvalidTriangleException{
		double side1 = a.distanceFrom(b);
		double side2 = b.distanceFrom(c);
		double side3 = c.distanceFrom(a);
		if(side1 >= side2 + side3 || side2 >= side1 + side3 || side3 >= side1 + side2) {
			throw new InvalidTriangleException("Invalid Dimensions!");
		}
		else {
			this.side1 = side1;
			this.side2 = side2;
			this.side3 = side3;
		}
	}
	public String CheckTriangle() {
		if(side1 == side2 && side2 == side3) {
			return "This is an equilateral triangle.";
		}
		else if(side1 == side2 || side2 == side3 || side1 == side3) {		
			if(side1*side1 + side2*side2 == side3*side3 || side2*side2 + side3*side3 == side1*side1 || side1*side1 + side3*side3 == side2*side2) {
				return("This is an isosceles right triangle");
			}
			return("This is an isosceles triangle.");
		}
		else {
			if(side1*side1 + side2*side2 == side3*side3 || side2*side2 + side3*side3 == side1*side1 || side1*side1 + side3*side3 == side2*side2) {
				return("This is a scalene right triangle");
			}
			return("This is a scalene triangle.");
		}
	}
	public double getArea() {
		double area, semip;
		//System.out.println("Sides are: " + side1 + " " + side2 + " " + side3);
		semip = (side1 + side2 + side3)/2;
		//System.out.println("Semiperimeter is: " + semip);
		area = semip*(semip-side1)*(semip-side2)*(semip-side3);
		//System.out.println("Area^2 is: " + area);
		area = Math.sqrt(area);
		//System.out.println("Area is: " + area);
		return area;
	}
}
