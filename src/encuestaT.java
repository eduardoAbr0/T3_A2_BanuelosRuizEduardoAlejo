import java.awt.*;
import javax.swing.*;

class interfaz extends JFrame {
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();

	JTextField txtSi, txtNo;

	JButton bttnMostrar;

	public interfaz() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Encuesta");
		setVisible(true);

		bttnMostrar = new JButton("Mostrar datos encuestas");
		agregarComp(bttnMostrar, 0, 1, 1, 1);

		txtSi = new JTextField();

		pack();
		setLocationRelativeTo(null);
	}

	public void agregarComp(JComponent c, int x, int y, int altura, int ancho) {
		gbc.gridx = x;
		gbc.gridy = y;
		gbc.gridheight = altura;
		gbc.gridwidth = ancho;

		gbl.setConstraints(c, gbc);
		add(c);
	}
}

public class encuestaT {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				new interfaz();
			}
		});

	}

}
