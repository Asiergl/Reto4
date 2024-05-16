package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import SQLCliente.DMusicaSQL;
import SQLCliente.PodcastSQL;
import controlador.GestorVentanas;

public class VentanaTopPodcastFav extends JPanel {
	

	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public VentanaTopPodcastFav(GestorVentanas f) {
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
	        
	        JLabel lblNewLabel = new JLabel("TOP PODCAST FAV");
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
	                "Puesto", "Músico", "Canción", "Escuchas"
	            }
	        ));
	        table.getColumnModel().getColumn(3).setResizable(false);
	        
	        JScrollPane scrollPane = new JScrollPane(table);
	        scrollPane.setBounds(66, 130, 400, 200);
	        add(scrollPane);
	        
	        try {
	            ResultSet resultSet = PodcastSQL.obtenerPodcastsMasEscuchados();
	            
	            DefaultTableModel model = (DefaultTableModel) table.getModel();
	            model.setRowCount(0);
	            
	            int puesto = 1;
	            while (resultSet.next()) {
	                String nombrePodcast = resultSet.getString("Nombre_Podcast");
	                int reproducciones = resultSet.getInt("Reproducciones");
	                model.addRow(new Object[]{puesto, nombrePodcast, reproducciones});
	                puesto++;
	            }
	            
	            resultSet.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        
	        
	        btnCerrarSesion.addMouseListener(new MouseAdapter() {
	        	@Override
	        	public void mouseClicked(MouseEvent e) {
	        		f.cambiarPanel(0);
	        	}
	        });
	        
		//
	    }
	
	}

