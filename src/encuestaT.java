import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

class interfaz extends JFrame {
	GridBagLayout gbl = new GridBagLayout();
	GridBagConstraints gbc = new GridBagConstraints();
	llenadoRegistros reg = new llenadoRegistros();
	
	JTextField txtSi, txtNo;
	JButton bttnMostrar;
	JProgressBar histogramaSi,histogramaNo;
	
	public interfaz() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Encuesta");
		setVisible(true);
		
		JPanel resSi = new JPanel();
		resSi.setBorder(new TitledBorder("Resultados encuesta si"));
		agregarComp(resSi, 1, 1, 1, 1);
		txtSi = new JTextField();
		txtSi.setPreferredSize(new Dimension(350,200));
		txtSi.setEditable(false);
		resSi.add(txtSi);
		histogramaSi = new JProgressBar();
		histogramaSi.setMinimum(0);
		histogramaSi.setMaximum(10000000);
		histogramaSi.setStringPainted(true);
		agregarComp(histogramaSi,1,2,1,1);
		
		JPanel resNo = new JPanel();
		resNo.setBorder(new TitledBorder("Resultados encuesta no"));
		agregarComp(resNo, 2, 1, 1, 1);
		txtNo = new JTextField();
		txtNo.setPreferredSize(new Dimension(350,200));
		txtNo.setEditable(false);
		resNo.add(txtNo);
		histogramaNo = new JProgressBar();
		histogramaNo.setMinimum(0);
		histogramaNo.setMaximum(10000000);
		histogramaNo.setStringPainted(true);
		agregarComp(histogramaNo,2,2,1,1);
		
		
		bttnMostrar = new JButton("Mostrar datos encuestas");
		bttnMostrar.setPreferredSize(new Dimension(250,100));
		agregarComp(bttnMostrar, 0, 1, 1, 1);
		bttnMostrar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Thread hiloM = new Thread(new hiloMostrarDatos(reg.llenado(), txtSi, txtNo));
				hiloM.start();
				
				Thread hiloH = new Thread(new hiloHistograma(txtSi,txtNo,histogramaSi,histogramaNo));
				hiloH.start();
			}
		});
		
		
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
	
	public void mostrarDatos(JTextField t1,JTextField t2, Thread m) {
		t1.setText(getName());
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
