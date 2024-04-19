import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class hiloHistograma implements Runnable {
	JTextField t1, t2;
	JProgressBar hS, hN;

	public hiloHistograma(JTextField t1, JTextField t2, JProgressBar hS, JProgressBar hN) {
		this.t1 = t1;
		this.t2 = t2;
		this.hS = hS;
		this.hN = hN;
	}

	@Override
	public void run() {
		synchronized (t1) {
			int n = Integer.valueOf(t1.getText()) / 100000;
			hS.setValue(n);
		}

		synchronized (t2) {
			int n = Integer.valueOf(t2.getText()) / 100000;
			hN.setValue(n);
		}

	}

}
