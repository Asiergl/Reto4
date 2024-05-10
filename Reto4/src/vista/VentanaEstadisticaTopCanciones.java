package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.GestorVentanas;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VentanaEstadisticaTopCanciones extends JPanel {
	

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VentanaEstadisticaTopCanciones(GestorVentanas f) {
		setSize(467, 385); 
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
	        
	        JLabel lblNewLabel = new JLabel("TOP CANCIONES FAV");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(145, 33, 185, 22);
	        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
	        add(lblNewLabel);
	        
	        JButton btnCerrarSesion = new JButton("Cerrar sesión");
	        btnCerrarSesion.setForeground(Color.BLACK);
	        btnCerrarSesion.setBackground(Color.WHITE);
	        btnCerrarSesion.setBounds(327, 32, 123, 23);
	        add(btnCerrarSesion);
	        
	        table = new JTable();
	        table.setModel(new DefaultTableModel(
	        	new Object[][] {
	        		{null, null, null, null},
	        		{null, null, null, null},
	        		{null, null, null, null},
	        		{null, null, null, null},
	        	},
	        	new String[] {
	        		"Puesto", "Musico", "Canci\u00F3n", "Escuchas"
	        	}
	        ));
	        table.getColumnModel().getColumn(3).setResizable(false);
	        table.setBounds(33, 74, 417, 160);
	        add(table);
	        btnCerrarSesion.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		f.cambiarPanel(0);
	        	}
	        });
	        
		//
	    }
	}
