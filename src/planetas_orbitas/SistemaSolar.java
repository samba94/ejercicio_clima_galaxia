package planetas_orbitas;

public class SistemaSolar {
	
	private Planeta planeta1;
	private Planeta planeta2;
	private Planeta planeta3;

	public SistemaSolar(Planeta planeta1, Planeta planeta2, Planeta planeta3) {
		this.planeta1 = planeta1;
		this.planeta2 = planeta2;
		this.planeta3 = planeta3;
	}

	public Planeta getPlaneta1() {
		return planeta1;
	}

	public void setPlaneta1(Planeta planeta1) {
		this.planeta1 = planeta1;
	}

	public Planeta getPlaneta2() {
		return planeta2;
	}

	public void setPlaneta2(Planeta planeta2) {
		this.planeta2 = planeta2;
	}

	public Planeta getPlaneta3() {
		return planeta3;
	}

	public void setPlaneta3(Planeta planeta3) {
		this.planeta3 = planeta3;
	}
	
	public void sumarUnDia(){
		planeta1.unDia();
		planeta2.unDia();
		planeta3.unDia();
	}
	
	public double sumarAngulos(double a1, double a2){
		double sum = a1+a2;		
		if(sum>360){
			sum -= 360;
		}		
		return sum;
	}
	
	public boolean enLinea(double ang1, double ang2){ //Usando el puntosAlineados de la clase Geometria con coordenadas, funciona tambien4
		boolean ret = false;		
		
		if(ang1<0){
			ang1 += 360;
		}
		if(ang2<0){
			ang2 += 360;
		}
		
		if(ang1 == ang2){
			ret = true;
		} else{
			if(ang1 < ang2){
				if(sumarAngulos(ang1, 180) == ang2){
					ret = true;
				}
			} else{
				if(sumarAngulos(ang2, 180) == ang1){
					ret = true;
				}
			}
		}
		
		return ret;
	}
	
	public boolean enSequia(){
		boolean ret = false;
		double a1 = planeta1.getAngulo_actual();
		double a2 = planeta2.getAngulo_actual();
		double a3 = planeta3.getAngulo_actual();
		
		if(enLinea(a1,a2) && enLinea(a2,a3)){
			ret = true;
		}
		
		return ret;
	}
	
	public boolean enSequiaV2(){
		Geometria geom = new Geometria();
		Punto origen = new Punto(0,0);
		Punto a = geom.generarCoordenadas(planeta1.getDistancia(), planeta1.getAngulo_actual());
		Punto b = geom.generarCoordenadas(planeta2.getDistancia(), planeta2.getAngulo_actual());
		Punto c = geom.generarCoordenadas(planeta3.getDistancia(), planeta3.getAngulo_actual());
		
		return geom.puntosAlineados(a, b, c) && geom.puntosAlineados(origen, a, b);
	}
	
	public boolean esLluvia(){
		boolean ret = false;
		int a1 = planeta1.getAngulo_actual();
		int a2 = 360 + planeta2.getAngulo_actual();
		int a3 = planeta3.getAngulo_actual();
		
		int t1 = a2 - a1;
		int t2 = a3 - a2;
		int t3 = 360 - a3 + a1;
		
		if(t1 < 180 && t2 < 180 && t3 < 180){
			ret = true;
		}	
		
		return ret;
	}

	public double distanciaEntrePlanetas(){
		Geometria geom = new Geometria();
		Punto a = geom.generarCoordenadas(planeta1.getDistancia(), planeta1.getAngulo_actual());
		Punto b = geom.generarCoordenadas(planeta2.getDistancia(), planeta2.getAngulo_actual());
		Punto c = geom.generarCoordenadas(planeta3.getDistancia(), planeta3.getAngulo_actual());
		
		return geom.perimetroTriangulo(a, b, c);
	}
	
	public boolean esOptimo(){
		Geometria geom = new Geometria();
		Punto origen = new Punto(0,0);
		Punto a = geom.generarCoordenadas(planeta1.getDistancia(), planeta1.getAngulo_actual());
		Punto b = geom.generarCoordenadas(planeta2.getDistancia(), planeta2.getAngulo_actual());
		Punto c = geom.generarCoordenadas(planeta3.getDistancia(), planeta3.getAngulo_actual());
		
		return geom.puntosAlineados(a, b, c) && !geom.puntosAlineados(origen, a, b);		
	}
	
}
