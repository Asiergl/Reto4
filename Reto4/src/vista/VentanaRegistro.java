package vista;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import controlador.GestionBD;
import controlador.GestorVentanas;
import modelo.Cliente;

import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import SQLCliente.ClientesSql;

import javax.swing.DefaultComboBoxModel;



public class VentanaRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFecha;
	private JTextField textNombre;
	private JTextField textApellido;
	private JPasswordField textContraseña;
	private JTextField txtUsuario;
	private JTextField txtPremium;
	private JPasswordField textContraseña2;

	/**
	 * Create the panel.
	 */
	public VentanaRegistro(GestorVentanas v) {
		ClientesSql sql = new ClientesSql();
		
		setSize(560, 385);
		setVisible(true);
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		JLabel lblContrasea2 = new JLabel("Repita Contraseña");
		lblContrasea2.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea2.setForeground(new Color(255, 255, 255));
		lblContrasea2.setBackground(new Color(255, 255, 255));
		lblContrasea2.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea2.setBounds(346, 165, 151, 23);
		add(lblContrasea2);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(61, 26, 151, 23);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido\r\n");
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBackground(Color.WHITE);
		lblApellido.setBounds(346, 26, 151, 23);
		add(lblApellido);
		
		JLabel lblContrasea = new JLabel("Contraseña\r\n");
		lblContrasea.setHorizontalAlignment(SwingConstants.CENTER);
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setBounds(346, 91, 151, 23);
		add(lblContrasea);
		
		
		JButton btnInsertar = new JButton("Guardar");
		btnInsertar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Recolecta los valores de los campos de texto y del JComboBox
		    	v.cliente.setNombreCliente(textNombre.getText());
		        v.cliente.setApellidoCliente(textApellido.getText());
		        v.cliente.setContraseña(textContraseña.getText());
		        v.cliente.setNombreUsuario(txtUsuario.getText());
		        v.cliente.setTipoCliente("free");
		        
		        String fechaNacimiento = textContraseña2.getText();
		        String premium =txtPremium.getText();
		        sql.insertarCliente(v.cliente);
		    }
		});
		btnInsertar.setBounds(400, 325, 111, 31);
		add(btnInsertar);

		
		textFecha = new JTextField();
		textFecha.setBounds(61, 270, 151, 29);
		add(textFecha);
		textFecha.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(61, 55, 151, 29);
		add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(346, 60, 151, 29);
		add(textApellido);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtras.setBounds(32, 324, 78, 31);
		add(btnAtras);
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(1);
				v.setVisible(true);
			}
		});
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(343, 125, 154, 29);
		add(textContraseña);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(61, 91, 151, 23);
		add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(61, 125, 151, 29);
		add(txtUsuario);
		
		JButton btnComprarPremium = new JButton("Comprar premium");
		btnComprarPremium.setBounds(181, 325, 151, 31);
		add(btnComprarPremium);
		
		txtPremium = new JTextField();
		txtPremium.setColumns(10);
		txtPremium.setBounds(61, 199, 151, 29);
		add(txtPremium);
		
		JLabel lblPremiumActivado = new JLabel("Premium activado");
		lblPremiumActivado.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremiumActivado.setForeground(Color.WHITE);
		lblPremiumActivado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPremiumActivado.setBackground(Color.WHITE);
		lblPremiumActivado.setBounds(61, 165, 151, 23);
		add(lblPremiumActivado);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setHorizontalAlignment(SwingConstants.CENTER);
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaNacimiento.setBackground(Color.WHITE);
		lblFechaNacimiento.setBounds(61, 236, 151, 23);
		add(lblFechaNacimiento);
		
		textContraseña2 = new JPasswordField();
		textContraseña2.setColumns(10);
		textContraseña2.setBounds(346, 199, 151, 29);
		add(textContraseña2);
		
		JComboBox comboBoxIdioma = new JComboBox();
		comboBoxIdioma.setModel(new DefaultComboBoxModel(new String[] {"Euskera", "Español", "Ingles", "Frances", "Aleman", "Catalan", "Gallego", "Aragones"}));
		comboBoxIdioma.setSelectedIndex(0);
		comboBoxIdioma.setBounds(346, 273, 151, 22);
		add(comboBoxIdioma);
		
		JLabel lblIdioma = new JLabel("Idioma");
		lblIdioma.setHorizontalAlignment(SwingConstants.CENTER);
		lblIdioma.setForeground(Color.WHITE);
		lblIdioma.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblIdioma.setBackground(Color.WHITE);
		lblIdioma.setBounds(346, 241, 151, 23);
		add(lblIdioma);
		 setVisible(true);
	}
}
