
public class Point {
	Double y;
	int x;
	public Point(double y, Date xdate) {
		this.y = y;
		this.x =  xdate.getDaysSince2000();
	}
	
	public Point(double y, int x) {
		this.y = y;
		this.x =  x;
	}
	
	@Override
	public String toString() {
		return "Point [y=" + y + ", x=" + x + "]";
	}

	public Double getY() {
		return y;
	}
	public int getX() {
		return x;
	}
}
