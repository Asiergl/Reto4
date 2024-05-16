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
import javax.swing.BorderFactory;

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

		v.gestor.play(v.cancion, v.canciones);
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


		JLabel lblNewLabel = new JLabel(v.cancion.getNombreAudio());// nombre de cancion
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(142, 33, 301, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);

		JLabel lblFlechaIzquierda = new JLabel("");

		lblFlechaIzquierda.setForeground(Color.WHITE);
		lblFlechaIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaIzquierda.setBackground(Color.WHITE);
		lblFlechaIzquierda.setBounds(20, 193, 89, 48);
		lblFlechaIzquierda.setIcon(new ImageIcon("imagenes/flechaIzq.png"));
		add(lblFlechaIzquierda);

		JLabel lblFlechaDerecha = new JLabel("");

		lblFlechaDerecha.setForeground(Color.WHITE);
		lblFlechaDerecha.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFlechaDerecha.setBackground(Color.WHITE);
		lblFlechaDerecha.setBounds(445, 193, 89, 48);
		lblFlechaDerecha.setIcon(new ImageIcon("imagenes/flechaDer.png"));
		add(lblFlechaDerecha);

		JLabel lblPause = new JLabel("");


		lblPause.setForeground(Color.WHITE);
		lblPause.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblPause.setBackground(Color.WHITE);
		lblPause.setBounds(216, 328, 89, 48);
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
		lblPlay.setBounds(216, 328, 89, 48);
		lblPlay.setVisible(false);
		lblPlay.setIcon(new ImageIcon("imagenes/play.png"));
		add(lblPlay);

		JButton btnFav = new JButton("Favoritos");
		btnFav.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sql.Favoritos(v.cliente, v.canciones, v.gestor);
			}
		});
		btnFav.setBounds(413, 337, 89, 23);
		add(btnFav);

		JLabel lblFoto = new JLabel("");
		lblFoto.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		lblFoto.setBounds(119, 66, 316, 260);
		lblFoto.setIcon(v.canciones.get(v.gestor.reproduciendo).getImagen());
		add(lblFoto);
		
		JButton btnNewButton = new JButton("playlist");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				VentanaAñadir ven = new VentanaAñadir();
				ven.initialize(v, 0);
			}
		});
		btnNewButton.setBounds(33, 328, 89, 23);
		add(btnNewButton);

		lblPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.gestor.stop();
				lblPause.setVisible(false);
				lblPlay.setVisible(true);
			}
		});
		lblFlechaDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.gestor.siguiente(v.cancion, v.canciones);
				v.gestor.play(v.cancion, v.canciones);
				lblPlay.setVisible(false);
				lblPause.setVisible(true);
				lblNewLabel.setText(v.cancion.getNombreAudio());

			}
		});
		lblFlechaIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.gestor.atras(v.canciones, v.cliente, v.cancion);
				v.gestor.play(v.cancion, v.canciones);
				lblPlay.setVisible(false);
				lblPause.setVisible(true);
				lblNewLabel.setText(v.cancion.getNombreAudio());
			}
		});
		v.gestor.cancionencurso.addLineListener(null);
		if (!(v.gestor.cancionencurso.isRunning()) && v.gestor.repro == true) {
			v.gestor.siguiente(v.cancion, v.canciones);
			v.gestor.play(v.cancion, v.canciones);

		}
	}
}
