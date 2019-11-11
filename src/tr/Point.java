package tr;

public class Point {
	double x;
	double y;
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public Point(String p) throws InvalidPointException{
		String xs = "";
		String ys = "";
		int j = 1;
		if(p.charAt(0)!= '(') {
			throw new InvalidPointException("Wrong point input format!");
		}
		while(p.charAt(j) != ',') {
			xs+= p.charAt(j);
			j++;
		}
		j++;
		while(p.charAt(j) != ')') {
			ys += p.charAt(j);
			j++;
		}
		this.x = Double.parseDouble(xs);
		this.y = Double.parseDouble(ys);
	}
	public double distanceFrom(Point b) {
		double dist, dx, dy;
		dx = Math.abs(this.x - b.x);
		dy = Math.abs(this.y - b.y);
		dx = Math.pow(dx,2);
		dy = Math.pow(dy,2);
		dist = Math.sqrt(dx+dy);
		return dist;
	}
}
