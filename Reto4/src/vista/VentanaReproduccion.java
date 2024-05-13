package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import SQLCliente.ReproductorSQL;
import SQLCliente.ReproductorSQL;
import controlador.GestorVentanas;
import java.awt.Dimension;

public class VentanaReproduccion extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> musicos = new ArrayList<String>();
	
	/**
	 * Create the panel.
	 */
	public VentanaReproduccion(GestorVentanas v) {
		setSize(559, 387);
		setBackground(new Color(0, 0, 0));

		ReproductorSQL sql = new ReproductorSQL();
		
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

		JLabel lblNewLabel = new JLabel("REPRODUCCIÓN");//nombre de cancion
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(214, 33, 142, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(177, 68, 179, 173);
		add(panel);
		
		JLabel lblFlechaIzquierda = new JLabel("");
		lblFlechaIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.gestor.atras(v.canciones,v.cliente);
				v.gestor.play(v.cancion, v.canciones);
			}
		});
		lblFlechaIzquierda.setForeground(Color.WHITE);
		lblFlechaIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaIzquierda.setBackground(Color.WHITE);
		lblFlechaIzquierda.setBounds(21, 141, 89, 48);
		lblFlechaIzquierda.setIcon(new ImageIcon("imagenes/flechaIzq.png"));
		add(lblFlechaIzquierda);
		
		JLabel lblFlechaDerecha = new JLabel("");
		lblFlechaDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.gestor.siguiente(v.canciones);
				v.gestor.play(v.cancion, v.canciones);
			}
		});
		lblFlechaDerecha.setForeground(Color.WHITE);
		lblFlechaDerecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaDerecha.setBackground(Color.WHITE);
		lblFlechaDerecha.setBounds(413, 141, 89, 48);
		lblFlechaDerecha.setIcon(new ImageIcon("imagenes/flechaDer.png"));
		add(lblFlechaDerecha);
		
		JLabel lblPause = new JLabel("");
		lblPause.setVisible(false);
		
		lblPause.setForeground(Color.WHITE);
		lblPause.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPause.setBackground(Color.WHITE);
		lblPause.setBounds(214, 252, 89, 48);
		lblPause.setIcon(new ImageIcon("imagenes/pause.png"));
		add(lblPause);
		
		JLabel lblPlay = new JLabel("");
		lblPlay.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.gestor.play(v.cancion, v.canciones);
				lblPlay.setVisible(false);
				lblPause.setVisible(true);
			}
		});
		lblPlay.setForeground(Color.WHITE);
		lblPlay.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPlay.setBackground(Color.WHITE);
		lblPlay.setBounds(216, 252, 89, 48);
		lblPlay.setIcon(new ImageIcon("imagenes/play.png"));
		add(lblPlay);
		
		JButton btnFav = new JButton("Favoritos");
		btnFav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sql.Favoritos(v.cliente, v.cancion);
			}
		});
		btnFav.setBounds(399, 272, 89, 23);
		add(btnFav);
		
		lblPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.gestor.stop();
				lblPause.setVisible(false);
				lblPlay.setVisible(true);
			}
		});
		
	}
}
