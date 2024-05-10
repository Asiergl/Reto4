package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import SQLCliente.DMusicaSQL;
import controlador.GestorVentanas;

public class VentanaReproduccion extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> musicos = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaReproduccion(GestorVentanas v) {
		setSize(v.getSize());
		setBackground(new Color(0, 0, 0));

		DMusicaSQL sql = new DMusicaSQL();
		sql.Musicos(musicos);
		
		setLayout(null);

		JButton btnAtras = new JButton("Atras");

		btnAtras.setBounds(33, 32, 89, 23);
		btnAtras.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnAtras.setBackground(new Color(255, 255, 255));

		add(btnAtras);

		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(3);
				v.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("REPRODUCCIÓN");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(155, 33, 142, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(140, 69, 179, 173);
		add(panel);
		
		JLabel lblFlechaIzquierda = new JLabel("");
		lblFlechaIzquierda.setForeground(Color.WHITE);
		lblFlechaIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaIzquierda.setBackground(Color.WHITE);
		lblFlechaIzquierda.setBounds(33, 141, 89, 48);
		lblFlechaIzquierda.setIcon(new ImageIcon("imagenes/flechaIzq.png"));
		add(lblFlechaIzquierda);
		
		JLabel lblFlechaIzquierda_1 = new JLabel("");
		lblFlechaIzquierda_1.setForeground(Color.WHITE);
		lblFlechaIzquierda_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaIzquierda_1.setBackground(Color.WHITE);
		lblFlechaIzquierda_1.setBounds(340, 141, 89, 48);

		lblFlechaIzquierda_1.setIcon(new ImageIcon("imagenes/flechaDer.png"));
		add(lblFlechaIzquierda_1);
		
	}
}
