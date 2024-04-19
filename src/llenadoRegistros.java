import java.util.ArrayList;
import java.util.Random;

public class llenadoRegistros {
	ArrayList<String> resultados = new ArrayList<String>();
	
	public ArrayList llenado() {
		Random r = new Random();
		int random;
		
		for (int i = 1; i <= 10000000; i++) {
			random = r.nextInt(0,2);
			
			if (random==1) {
				resultados.add("Si");
			} else if(random==0){
				resultados.add("No");
			}
		}
		
		return resultados;
	}
}
