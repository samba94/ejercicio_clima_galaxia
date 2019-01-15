package planetas_orbitas;

public class Planeta {

	private String nombre;
	private int velocidad;
	private int angulo_actual;
	private int distancia;

	public Planeta(String nombre, int velocidad, int angulo_actual, int distancia) {
		this.nombre = nombre;
		this.velocidad = velocidad;
		this.angulo_actual = angulo_actual;
		this.distancia = distancia;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getAngulo_actual() {
		return angulo_actual;
	}

	public void setAngulo_actual(int angulo_actual) {
		this.angulo_actual = angulo_actual;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public void unDia(){
		angulo_actual += velocidad;
		if(angulo_actual >= 360 || angulo_actual <= -360){
			angulo_actual = 0;
		}
				
	}
	
}
