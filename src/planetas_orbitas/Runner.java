package planetas_orbitas;

public class Runner {

	final static int DIAS_ANIOS = 3650;
	
	public static void main(String[] args) {
		
		Planeta ferengi = new Planeta("Ferengi", 1, 0, 500);
		Planeta vulcano = new Planeta("Vulcano", -5, 0, 1000);
		Planeta betasoide = new Planeta("Betasoide", 3, 0, 2000);
		
		SistemaSolar solar = new SistemaSolar(ferengi, vulcano, betasoide);
		
		int sequias = 0;
		int lluvias = 0;
		int optimas = 0;
		double distancia;
		double distanciaMax = 0;
		int diaDistanciaMax = 0;

		for(int i=1; i<=DIAS_ANIOS; i++){
			solar.sumarUnDia();
			
			if(solar.enSequia()){
				sequias++;
			}
			
			if(solar.esLluvia()){
				lluvias++;
				
				distancia = solar.distanciaEntrePlanetas();
				if(distancia > distanciaMax){
					distanciaMax = distancia;
					diaDistanciaMax = i;
				}
			}
			
			if(solar.alineadosSinSol()){
				optimas++;
			}
			
		}
	
		System.out.println("El sistema solar ha experimentado " + sequias + " sequias.");
		System.out.println("El sistema solar ha experimentado " + lluvias + " lluvias.");
		System.out.println("El pico de intesidad de lluvia fue el dia " + diaDistanciaMax + ", siendo " + distanciaMax + " el perimetro del triangulo formado por los planetas. ");
		System.out.println("El sistema solar ha experimentado " + optimas + " condiciones optimas.");
		
	}

}
