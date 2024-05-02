package ventanas;

import javax.swing.JPanel;

import controlador.GestorVentanas;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

public class VentanaMenu extends JPanel {
	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VentanaMenu(GestorVentanas f) {
		setSize(460, 302); 
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
	        
	        JButton btnMiPerfil = new JButton("Mi perfil");
	        
	        btnMiPerfil.setBounds(326, 32, 89, 23);
	        btnMiPerfil.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnMiPerfil.setBackground(Color.WHITE);
	        add(btnMiPerfil);
	        
	        JLabel lblNewLabel = new JLabel("MENU");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(199, 36, 46, 14);
	        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
	        add(lblNewLabel);
	        
	        JButton btnDescubrirMusica = new JButton("Descubrir música");
	      btnDescubrirMusica.setBounds(134, 90, 190, 23);
	      btnDescubrirMusica.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnDescubrirMusica.setBackground(Color.WHITE);
	        add(btnDescubrirMusica);
	        btnDescubrirMusica.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					f.cambiarPanel(4);
					f.setVisible(true);
				}
			});
	        
	        JButton btnDescubrirPodcast = new JButton("Descubrir Podcast");
	        btnDescubrirPodcast.setBounds(134, 137, 190, 23);
	        btnDescubrirPodcast.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnDescubrirPodcast.setBackground(Color.WHITE);
	        add(btnDescubrirPodcast);
	        
	        JButton btnPlaylist = new JButton("Mi Playlist");
	        btnPlaylist.setBounds(134, 186, 190, 23);
	        btnPlaylist.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnPlaylist.setBackground(Color.WHITE);
	        add(btnPlaylist);
	    }
	}