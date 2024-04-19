import java.awt.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;

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
		bttnMostrar.setPreferredSize(new Dimension(250,100));
		agregarComp(bttnMostrar, 0, 1, 1, 1);
		
		JPanel resSi = new JPanel();
		resSi.setBorder(new TitledBorder("Resultados encuesta si"));
		agregarComp(resSi, 1, 1, 1, 1);
		txtSi = new JTextField();
		txtSi.setPreferredSize(new Dimension(350,200));
		txtSi.setEditable(false);
		resSi.add(txtSi);
		//agregarComp(txtSi, 1, 1, 1, 1);
		
		JPanel resNo = new JPanel();
		resNo.setBorder(new TitledBorder("Resultados encuesta no"));
		agregarComp(resNo, 2, 1, 1, 1);
		txtNo = new JTextField();
		txtNo.setPreferredSize(new Dimension(350,200));
		txtNo.setEditable(false);
		resNo.add(txtNo);
		
		
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
