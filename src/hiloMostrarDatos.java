import java.util.ArrayList;
import javax.swing.JTextField;

public class hiloMostrarDatos implements Runnable {
	ArrayList listaDatos;
	int cantidadSi = 0, cantidadNo = 0;
	JTextField t1, t2;

	public hiloMostrarDatos(ArrayList listaDatos, JTextField t1, JTextField t2) {
		this.listaDatos = listaDatos;
		this.t1 = t1;
		this.t2 = t2;
	}

	@Override
	public void run() {

		for (Object object : listaDatos) {
			if (object.equals("Si")) {
				cantidadSi++;
			} else if (object.equals("No")) {
				cantidadNo++;
			}
			
			synchronized (t1) {
				t1.setText(String.valueOf(cantidadSi));
			}

			synchronized (t2) {
				t2.setText(String.valueOf(cantidadNo));
			}
		}


	}

}
