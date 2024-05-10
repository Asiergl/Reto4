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
import java.awt.Dimension;

public class VentanaReproduccion extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> musicos = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaReproduccion(GestorVentanas v) {
		setSize(new Dimension(481, 379));
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
		lblNewLabel.setBounds(177, 33, 142, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(151, 68, 179, 173);
		add(panel);
		
		JLabel lblFlechaIzquierda = new JLabel("");
		lblFlechaIzquierda.setForeground(Color.WHITE);
		lblFlechaIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaIzquierda.setBackground(Color.WHITE);
		lblFlechaIzquierda.setBounds(52, 141, 89, 48);
		lblFlechaIzquierda.setIcon(new ImageIcon("imagenes/flechaIzq.png"));
		add(lblFlechaIzquierda);
		
		JLabel lblFlechaDerecha = new JLabel("");
		lblFlechaDerecha.setForeground(Color.WHITE);
		lblFlechaDerecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaDerecha.setBackground(Color.WHITE);
		lblFlechaDerecha.setBounds(340, 141, 89, 48);
		lblFlechaDerecha.setIcon(new ImageIcon("imagenes/flechaDer.png"));
		add(lblFlechaDerecha);
		
		JLabel lblPause = new JLabel("");
		lblPause.setForeground(Color.WHITE);
		lblPause.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPause.setBackground(Color.WHITE);
		lblPause.setBounds(151, 252, 89, 48);
		lblPause.setIcon(new ImageIcon("imagenes/pause.png"));
		add(lblPause);
		
		JLabel lblPlay = new JLabel("");
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlay.setBackground(Color.WHITE);
		lblPlay.setBounds(250, 252, 89, 48);
		lblPlay.setIcon(new ImageIcon("imagenes/play.png"));
		add(lblPlay);
		
	}
}
