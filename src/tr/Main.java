//Nathaniel Eveland 1468524
//Software Design
package tr;


import java.util.Scanner;
public class Main {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		int i = 0;
		double side1 = -1;
		double side2 = -2;
		double side3 = -3;
		String point1 = "";
		String point2 = "";
		String point3 = "";
		int choice = -1;
		System.out.println("Enter 1 to input sides, or 2 to input Cartesian points: ");
		choice = scanner.nextInt();
		if(choice == 1) {

			System.out.println("Please enter 3 real numbers: ");
			if(scanner.hasNextDouble()) {
				side1 = scanner.nextDouble();
				i++;
			}
			if(scanner.hasNextDouble()) {
				side2 = scanner.nextDouble();
				i++;
			}
			if(scanner.hasNextDouble()) {
				side3 = scanner.nextDouble();
				i++;
			}
			scanner.close();
			if(i != 3) {
				System.out.println("Invalid Input!");
				return;
			}
			if(side1 <= 0 || side2 <= 0 || side3 <= 0) {
				System.out.println("Invalid Dimensions!");
				return;
			}
			try {
				Triangle triangle = new Triangle(side1,side2,side3);
				System.out.println(triangle.CheckTriangle());
				System.out.println("The area is: " + triangle.getArea()); 
			}
			catch(InvalidTriangleException e) {
				System.out.println(e.getMessage());
			}

		}
		else if(choice == 2) {
			System.out.println("Please enter 3 Cartesian points in the format (x,y): ");
			if(scanner.hasNext()) {
				point1 = scanner.next();
				i++;
			}
			if(scanner.hasNext()) {
				point2 = scanner.next();
				i++;
			}
			if(scanner.hasNext()) {
				point3 = scanner.next();
				i++;
			}
			scanner.close();
			if(i != 3) {
				System.out.println("Invalid Input!");
				return;
			}
			try {
				Point p1 = new Point(point1);
				Point p2 = new Point(point2);
				Point p3 = new Point(point3);
				Triangle triangle = new Triangle(p1,p2,p3);
				System.out.println(triangle.CheckTriangle());
				System.out.println("The area is: " + triangle.getArea());
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
				return;
			}
		}
		else {
			System.out.print("Invalid choice!");
		}

	}

}
