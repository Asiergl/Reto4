package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.GestorVentanas;

public class VentanaMenuAdmin extends JPanel {
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VentanaMenuAdmin(GestorVentanas f) {
		setSize(460, 385); 
		setBackground(new Color(0, 0, 0));
         
	        setLayout(null);
	        
	        JButton btnAtras = new JButton("Atras");
	      
	        btnAtras.setBounds(33, 32, 89, 23);
	        btnAtras.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnAtras.setBackground(new Color(255, 255, 255));
	        
	        add(btnAtras);
	        
	        btnAtras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					f.cambiarPanel(1);
					f.setVisible(true);
				}
			});
	        
	        JLabel lblNewLabel = new JLabel("MENU");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(199, 36, 46, 14);
	        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
	        add(lblNewLabel);
	        
	        JButton btnGestionarMusica = new JButton("Gestionar música");
	      btnGestionarMusica.setBounds(134, 76, 190, 23);
	      btnGestionarMusica.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnGestionarMusica.setBackground(Color.WHITE);
	        add(btnGestionarMusica);
	        btnGestionarMusica.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					f.cambiarPanel(200);
					f.setVisible(true);
				}
			});
		//
	        
	        JButton btnGestionarPodcast = new JButton("Gestionar Podcast");
	        btnGestionarPodcast.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		f.cambiarPanel(200);
	        	}
	        });
	        btnGestionarPodcast.setBounds(134, 120, 190, 23);
	        btnGestionarPodcast.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnGestionarPodcast.setBackground(Color.WHITE);
	        add(btnGestionarPodcast);
	        
	        JButton btnTopCanciones = new JButton("Top canciones \"favoritas\"");
	        btnTopCanciones.setBounds(33, 230, 190, 23);
	        btnTopCanciones.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnTopCanciones.setBackground(Color.WHITE);
	        add(btnTopCanciones);
	        
	        JLabel lblEstadisticas = new JLabel("ESTADISTICAS");
	        lblEstadisticas.setForeground(Color.WHITE);
	        lblEstadisticas.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblEstadisticas.setBackground(Color.WHITE);
	        lblEstadisticas.setBounds(174, 185, 169, 14);
	        add(lblEstadisticas);
	        
	        JButton btnTopMsEscuchadas = new JButton("Top más escuchadas");
	        btnTopMsEscuchadas.setForeground(Color.BLACK);
	        btnTopMsEscuchadas.setBackground(Color.WHITE);
	        btnTopMsEscuchadas.setBounds(260, 230, 190, 23);
	        add(btnTopMsEscuchadas);
	        
	        JButton btnTopPodcast = new JButton("Top podcast \"favoritas\"");
	        btnTopPodcast.setForeground(Color.BLACK);
	        btnTopPodcast.setBackground(Color.WHITE);
	        btnTopPodcast.setBounds(33, 274, 190, 23);
	        add(btnTopPodcast);
	        
	        JButton btnTopPlaylist = new JButton("Top playlist");
	        btnTopPlaylist.setForeground(Color.BLACK);
	        btnTopPlaylist.setBackground(Color.WHITE);
	        btnTopPlaylist.setBounds(260, 274, 190, 23);
	        add(btnTopPlaylist);
	        
	        JButton btnCerrarSesion = new JButton("Cerrar sesión");
	        btnCerrarSesion.setForeground(Color.BLACK);
	        btnCerrarSesion.setBackground(Color.WHITE);
	        btnCerrarSesion.setBounds(327, 32, 123, 23);
	        add(btnCerrarSesion);
	   
	        btnTopCanciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					f.cambiarPanel(11);
					f.setVisible(true);
				}
			});
	        btnCerrarSesion.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		f.cambiarPanel(0);
	        	}
	        });
	        
		//
	    }
	}
