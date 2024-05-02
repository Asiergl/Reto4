package ventanas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.GestorVentanas;

public class VentanaArtista extends JPanel {	

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public VentanaArtista(GestorVentanas f) {
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
					f.cambiarPanel(4);
					f.setVisible(true);
				}
			});
	        
	        JButton btnMiPerfil = new JButton("Mi perfil");
	        
	        btnMiPerfil.setBounds(326, 32, 89, 23);
	        btnMiPerfil.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
	        btnMiPerfil.setBackground(Color.WHITE);
	        add(btnMiPerfil);
	        
	        JLabel lblNewLabel = new JLabel("VENTANA ARTISTA");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(142, 33, 172, 14);
	        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
	        add(lblNewLabel);
	        
	        JPanel panel = new JPanel();
	        panel.setBounds(20, 101, 138, 178);
	        add(panel);
	        
	        JLabel lblDiscos = new JLabel("Discos");
	        lblDiscos.setForeground(Color.WHITE);
	        lblDiscos.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblDiscos.setBackground(Color.WHITE);
	        lblDiscos.setBounds(22, 76, 172, 14);
	        add(lblDiscos);
	        
	        JPanel panel_1 = new JPanel();
	        panel_1.setBounds(220, 101, 230, 74);
	        add(panel_1);
	        
	        JLabel lblInformacin = new JLabel("Información");
	        lblInformacin.setForeground(Color.WHITE);
	        lblInformacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblInformacin.setBackground(Color.WHITE);
	        lblInformacin.setBounds(220, 79, 172, 14);
	        add(lblInformacin);
	        
	        JPanel panel_1_1 = new JPanel();
	        panel_1_1.setBounds(273, 198, 153, 93);
	        add(panel_1_1);
	    }
	}