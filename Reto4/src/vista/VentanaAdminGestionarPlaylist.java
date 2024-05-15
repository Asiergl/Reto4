package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import controlador.GestorVentanas;

public class VentanaAdminGestionarPlaylist extends JPanel {
	

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VentanaAdminGestionarPlaylist (GestorVentanas f) {
		setSize(567, 385); 
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
					f.cambiarPanel(10);
					f.setVisible(true);
				}
			});
	        
	        JLabel lblNewLabel = new JLabel("GESTIONAR PLAYLISTS");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(132, 29, 196, 22);
	        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
	        add(lblNewLabel);
	        
	        JButton btnCerrarSesion = new JButton("Cerrar sesión");
	        btnCerrarSesion.setForeground(Color.BLACK);
	        btnCerrarSesion.setBackground(Color.WHITE);
	        btnCerrarSesion.setBounds(327, 32, 123, 23);
	        add(btnCerrarSesion);
	 
	        
	        btnCerrarSesion.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		f.cambiarPanel(0);
	        	}
	        });
	        
		//
	    }
	
	}

