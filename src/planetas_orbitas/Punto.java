package planetas_orbitas;

public class Punto {

	private double x;
	private double y;

	public Punto() {
		x = 0;
		y = 0;
	}

	public Punto(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

}
