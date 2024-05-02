package ventanas;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controlador.GestionBD;
import controlador.GestorVentanas;
import SQL.ClientesSql;

import javax.swing.JLabel;


import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VentanaLogin extends JPanel {

	private static final long serialVersionUID = 1L;
	private GestionBD gestionBD = new GestionBD();
	
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public VentanaLogin(GestorVentanas gestorVentanas) {
		setBackground(new Color(0, 0, 0));
		setSize(488, 302);
        setLayout(null);
		setVisible(true);
	
		 JLabel lblNewLabel = new JLabel("Usuario:");
	        lblNewLabel.setBackground(new Color(255, 255, 255));
	        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
	        lblNewLabel.setBounds(70, 84, 71, 14);
	        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
	        add(lblNewLabel);
		

			 JLabel lblContraseña = new JLabel("Contraseña:");
			 lblContraseña.setBackground(new Color(255, 255, 255));
			 lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 17));
			 lblContraseña.setBounds(39, 140, 103, 14);
			 lblContraseña.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		        add(lblContraseña);
		        
		JTextField JtextDni = new JTextField();
		JtextDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JtextDni.setBounds(144, 78, 264, 29);
		add(JtextDni);
		JtextDni.setColumns(10);
		
		
		
		JButton btnregistro = new JButton("Registrarse");
		btnregistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnregistro.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnregistro.setBackground(Color.WHITE);
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestorVentanas.cambiarPanel(2);
			}
		});
		btnregistro.setBounds(349, 266, 129, 23);
		add(btnregistro);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(144, 134, 264, 30);
		add(passwordField);
	
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.addMouseListener(new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        String nombre_usuario = JtextDni.getText();
		        String contraseña = passwordField.getText();
		        
		        try {
		        	if (ClientesSql.validarLogin(nombre_usuario, contraseña)) {
		        		gestorVentanas.cambiarPanel(3);
		        		gestorVentanas.setVisible(true);
					}
		            
		        } catch (Exception e1) {
		        	
		        	e1.printStackTrace();
		        }
		    }
		});

		add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
        btnLogin.setBackground(Color.WHITE);
		btnLogin.setBounds(210, 185, 129, 23);
	}
}
//