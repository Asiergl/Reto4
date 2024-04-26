package paneles;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import controlador.GestionBD;
import modelo.Cliente;


public class VentanaRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textDNI;
	private JTextField textNombre;
	private JTextField textContraseña;
	private JTextField textApellido;
	private GestionBD gestionBD = new GestionBD();

	/**
	 * Create the panel.
	 */
	public VentanaRegistro(FramePrincipal f) {
		setSize(460, 302);
		setVisible(true);
		setLayout(null);
		setBackground(Color.DARK_GRAY);
		
		JLabel lblTitulo = new JLabel("DNI");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitulo.setBounds(61, 42, 111, 23);
		add(lblTitulo);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(61, 126, 111, 23);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido\r\n");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellido.setBackground(Color.WHITE);
		lblApellido.setBounds(351, 126, 111, 23);
		add(lblApellido);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSexo.setBackground(Color.WHITE);
		lblSexo.setBounds(61, 225, 111, 23);
		add(lblSexo);
		
		JLabel lblContrasea = new JLabel("Contraseña\r\n");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBackground(Color.WHITE);
		lblContrasea.setBounds(351, 42, 111, 23);
		add(lblContrasea);
		
		JComboBox<String> comboBox = new JComboBox<String>();	
		comboBox.setBounds(119, 226, 93, 22);
		comboBox.addItem("Seleccionar...");
		comboBox.addItem("M");
        comboBox.addItem("F");
		add(comboBox);
		
		
		JButton btnInsertar = new JButton("Guardar");
		btnInsertar.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // Recolecta los valores de los campos de texto y del JComboBox
		        String dni = textDNI.getText();
		        String nombre = textNombre.getText();
		        String apellido = textApellido.getText();
		        String sexo = (String) comboBox.getSelectedItem();
		        String contraseña = textContraseña.getText();

		        // Crea un nuevo objeto Cliente
		        Cliente cliente = new Cliente();
		        cliente.setDni(dni);
		        cliente.setNombre_Cliente(nombre);
		        cliente.setApellido(apellido);
		        cliente.setSexo(sexo);
		        cliente.setContraseña(contraseña);

		        // Inserta el nuevo cliente en la base de datos
		        gestionBD.insertarNuevoCliente(cliente, f);
		    }
		});
		btnInsertar.setBounds(372, 226, 130, 23);
		add(btnInsertar);

		
		textDNI = new JTextField();
		textDNI.setBounds(61, 76, 151, 29);
		add(textDNI);
		textDNI.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(61, 160, 151, 29);
		add(textNombre);
		
		textContraseña = new JTextField();
		textContraseña.setColumns(10);
		textContraseña.setBounds(351, 76, 151, 29);
		add(textContraseña);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(351, 160, 151, 29);
		add(textApellido);
		
		JButton btnNewButton_1 = new JButton("Atras");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f.cambiarPanel(1);
			}
			
		});
		btnNewButton_1.setBounds(24, 321, 78, 37);
		add(btnNewButton_1);
		 setVisible(true);
	}
}
