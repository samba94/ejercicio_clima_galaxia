package planetas_orbitas;

public class Geometria {

	public Geometria() {
	}

	public Punto generarCoordenadas(int distancia, int angulo) {
		Punto punto = new Punto();

		double radianes = Math.toRadians(angulo);
		
		punto.setX(Math.round(Math.sin(radianes) * distancia));
		punto.setY(Math.round(Math.cos(radianes) * distancia));
		
		return punto;
	}

	public double distanciaEntre2Puntos(Punto a, Punto b) {
		double ax = a.getX();
		double ay = a.getY();
		double bx = b.getX();
		double by = b.getY();
		
		return Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
	}

	public double perimetroTriangulo(Punto a, Punto b, Punto c) {
		double d1 = distanciaEntre2Puntos(a, b);
		double d2 = distanciaEntre2Puntos(b, c);
		double d3 = distanciaEntre2Puntos(c, a);
		
		return d1 + d2 + d3;
	}

	public boolean puntosAlineados(Punto a, Punto b, Punto c) {
		boolean ret = false;

		double ax = a.getX();
		double ay = a.getY();
		double bx = b.getX();
		double by = b.getY();
		double cx = c.getX();
		double cy = c.getY();
		
		if((by-ay)*(cx-bx)==((cy-by)*(bx-ax))){
			ret = true;
		}
		
		return ret;
	}

}
