package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.GestorVentanas;

public class VentanaDescubrirMusica extends JPanel {	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VentanaDescubrirMusica(GestorVentanas f) {
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
					f.cambiarPanel(3);
					f.setVisible(true);
				}
			});
	        
	        JButton btnMiPerfil = new JButton("Mi perfil");
	        
	        btnMiPerfil.setBounds(326, 32, 89, 23);
	        btnMiPerfil.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnMiPerfil.setBackground(Color.WHITE);
	        add(btnMiPerfil);
	        
	        JLabel lblNewLabel = new JLabel("DESCUBRIR MUSICA");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(142, 33, 172, 14);
	        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
	        add(lblNewLabel);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(81, 66, 303, 207);
	        add(panel);
	    }
	}