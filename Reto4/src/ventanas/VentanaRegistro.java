package ventanas;

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
import modelo.modelo_pojos.Cliente;
import javax.swing.JPasswordField;



public class VentanaRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textApellido;
	private GestionBD gestionBD = new GestionBD();
	private JPasswordField textContraseña;
	private JTextField txtUsuario;
	private JTextField txtPremium;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public VentanaRegistro(GestorVentanas f) {
		setSize(560, 385);
		setVisible(true);
		setLayout(null);
		setBackground(new Color(0, 0, 0));
		
		JLabel lblTitulo = new JLabel("DNI");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitulo.setBounds(61, 21, 111, 23);
		add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(61, 91, 111, 23);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido\r\n");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBackground(Color.WHITE);
		lblApellido.setBounds(61, 165, 111, 23);
		add(lblApellido);
		
		JLabel lblContrasea = new JLabel("Contraseña\r\n");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setBounds(61, 236, 111, 23);
		add(lblContrasea);
		
		
		JButton btnInsertar = new JButton("Guardar");
		btnInsertar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Recolecta los valores de los campos de texto y del JComboBox
		        String dni = textDNI.getText();
		        String nombre = textNombre.getText();
		        String apellido = textApellido.getText();
		        String contraseña = textContraseña.getText();
		        String usuario = txtUsuario.getText();
		        String fechaNacimiento = textField.getText();
		        String premium =txtPremium.getText();

		        // Crea un nuevo objeto Cliente
		        Cliente cliente = new Cliente();
		 //       cliente.setDni(dni);
		  //      cliente.setNombre_Cliente(nombre);
		  //      cliente.setApellido(apellido);
		  //      cliente.setSexo(sexo);
		        cliente.setContraseña(contraseña);

		        // Inserta el nuevo cliente en la base de datos
		   //     gestionBD.insertarNuevoCliente(cliente, f);
		    }
		});
		btnInsertar.setBounds(400, 325, 111, 31);
		add(btnInsertar);

		
		textDNI = new JTextField();
		textDNI.setBounds(61, 51, 151, 29);
		add(textDNI);
		textDNI.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(61, 125, 151, 29);
		add(textNombre);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(61, 199, 151, 29);
		add(textApellido);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAtras.setBounds(32, 324, 78, 31);
		add(btnAtras);
		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f.cambiarPanel(1);
				f.setVisible(true);
			}
		});
		
		textContraseña = new JPasswordField();
		textContraseña.setBounds(61, 270, 154, 29);
		add(textContraseña);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(346, 26, 111, 23);
		add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(346, 55, 151, 29);
		add(txtUsuario);
		
		JButton btnComprarPremium = new JButton("Comprar premium");
		btnComprarPremium.setBounds(181, 325, 151, 31);
		add(btnComprarPremium);
		
		txtPremium = new JTextField();
		txtPremium.setColumns(10);
		txtPremium.setBounds(346, 125, 151, 29);
		add(txtPremium);
		
		JLabel lblPremiumActivado = new JLabel("Premium activado");
		lblPremiumActivado.setForeground(Color.WHITE);
		lblPremiumActivado.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPremiumActivado.setBackground(Color.WHITE);
		lblPremiumActivado.setBounds(346, 96, 151, 23);
		add(lblPremiumActivado);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha nacimiento");
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFechaNacimiento.setBackground(Color.WHITE);
		lblFechaNacimiento.setBounds(346, 170, 151, 23);
		add(lblFechaNacimiento);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(346, 199, 151, 29);
		add(textField);
		 setVisible(true);
	}
}
