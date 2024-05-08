package vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import SQLCliente.ClientesSql;
import controlador.GestionBD;
import controlador.GestorVentanas;

import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class VentanaLogin extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public VentanaLogin(GestorVentanas V) {
		ClientesSql sql = new ClientesSql();
		
		setBackground(new Color(0, 0, 0));
		setSize(488, 302);
		setLayout(null);
		setVisible(true);

		JLabel lblNewLabel = new JLabel("Usuario:");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(89, 96, 71, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);

		JLabel lblContraseña = new JLabel("Contraseña:");
		lblContraseña.setBackground(new Color(255, 255, 255));
		lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblContraseña.setBounds(58, 152, 103, 14);
		lblContraseña.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblContraseña);

		JTextField JtextDni = new JTextField();
		JtextDni.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JtextDni.setBounds(163, 90, 264, 29);
		add(JtextDni);
		JtextDni.setColumns(10);

		JButton btnregistro = new JButton("Registrarse");
		int contAdmin = V.cliente.getContAdmin();
		int contCli = V.cliente.getContCliente();
		if (contAdmin == 1) {
			btnregistro.setVisible(false);
		} else if (contCli == 1) {
			btnregistro.setVisible(true);
		}
		btnregistro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnregistro.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnregistro.setBackground(Color.WHITE);
		btnregistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				V.cambiarPanel(2);
			}
		});
		btnregistro.setBounds(349, 266, 129, 23);
		add(btnregistro);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setBounds(163, 146, 264, 30);
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
					if (contAdmin == 1) {
						if (nombre_usuario.equalsIgnoreCase("admin") && contraseña.equalsIgnoreCase("admin")) {
							V.cambiarPanel(3);//cambiar al panel de menu de admin
							V.setVisible(true);
						}
					} else {

						if (sql.validarLogin(nombre_usuario, contraseña, V.cliente, V.idioma)) {
							V.cambiarPanel(3);
							V.setVisible(true);
						}
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
		btnLogin.setBounds(200, 228, 129, 23);

		JButton btnAtras = new JButton("Atras");
		btnAtras.setForeground(Color.BLACK);
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(39, 267, 129, 23);
		add(btnAtras);
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				V.cambiarPanel(0);
				V.setVisible(true);
			}
		});
	}
}
//