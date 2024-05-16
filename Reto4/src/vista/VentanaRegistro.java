package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;

import SQLCliente.ClientesSql;
import controlador.GestorVentanas;
import java.awt.event.FocusEvent;
import java.awt.event.FocusAdapter;

public class VentanaRegistro extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textNombre;
	private JTextField textApellido;
	private JPasswordField textContraseña;
	private JTextField txtUsuario;
	private JPasswordField textContraseña2;
	private ArrayList<String> idiomas = new ArrayList<String>();
	private JDateChooser dateChooserNormal;
	private Error error = new Error();

	/**
	 * Create the panel.
	 */
	public VentanaRegistro(GestorVentanas v) {
		ClientesSql sql = new ClientesSql();
		sql.Idioma(v.idioma, idiomas);

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
		btnInsertar.setBounds(400, 325, 111, 31);
		add(btnInsertar);

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
		textContraseña.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String a = textContraseña.getText();
				String b = textContraseña2.getText();
				if ((a.length() == 0) && (b.length() == 0)) {
					textContraseña.setBackground(new Color(255, 153, 153));
					textContraseña2.setBackground(new Color(255, 153, 153));
				} else if ((a.length() != 0) && (b.length() != 0)) {
					if (a.equals(b)) {
						textContraseña.setBackground(new Color(153, 255, 102));
						textContraseña2.setBackground(new Color(153, 255, 102));
					} else if (!a.equals(b)) {
						textContraseña.setBackground(new Color(255, 153, 153));
						textContraseña2.setBackground(new Color(255, 153, 153));
					}
				}
				repaint();
			}

		});
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
		textContraseña2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				String a = textContraseña.getText();
				String b = textContraseña2.getText();
				if ((a.length() == 0) && (b.length() == 0)) {
					textContraseña.setBackground(new Color(255, 153, 153));
					textContraseña2.setBackground(new Color(255, 153, 153));
				} else if ((a.length() != 0) && (b.length() != 0)) {
					if (a.equals(b)) {
						textContraseña.setBackground(new Color(153, 255, 102));
						textContraseña2.setBackground(new Color(153, 255, 102));
					} else if (!a.equals(b)) {
						textContraseña.setBackground(new Color(255, 153, 153));
						textContraseña2.setBackground(new Color(255, 153, 153));
					}
				}
				repaint();
			}

		});
		textContraseña2.setColumns(10);
		textContraseña2.setBounds(346, 199, 151, 29);
		add(textContraseña2);

		JComboBox comboBoxIdioma = new JComboBox();
		comboBoxIdioma.setModel(new DefaultComboBoxModel());
		for (int i = 0; i < idiomas.size(); i++) {
			comboBoxIdioma.addItem(idiomas.get(i));
		}
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

		JDateChooser dateChooserNormal;
		dateChooserNormal = new JDateChooser();
		dateChooserNormal.setLocale(new Locale("es"));
		dateChooserNormal.setDateFormatString("yyyy-MM-dd");
		dateChooserNormal.setMaxSelectableDate(new java.util.Date());
		// dateChooser.getJCalendar().setMinSelectableDate(new java.util.Date());
		dateChooserNormal.setBounds(61, 270, 151, 34);
		add(dateChooserNormal);

		JDateChooser dateChooserPremium = new JDateChooser();
		dateChooserPremium.setLocale(new Locale("es"));
		dateChooserPremium.setDateFormatString("yyyy-MM-dd");
		dateChooserPremium.setMinSelectableDate(new java.util.Date());
		// dateChooser.getJCalendar().setMinSelectableDate(new java.util.Date());
		dateChooserPremium.setBounds(61, 199, 151, 34);
		add(dateChooserPremium);

		btnInsertar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String str = sdf.format(dateChooserPremium.getDate());
					Date date = Date.valueOf(str);

					// TODO: handle exception
				} catch (NullPointerException s) {
					try {
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
						String str = sdf.format(dateChooserNormal.getDate());
						Date date = Date.valueOf(str);
						int edad = new java.util.Date().getYear() -  date.getYear();
						// Recolecta los valores de los campos de texto y del JComboBox
						v.cliente.setIdCliente(10);
						v.cliente.setNombreCliente(textNombre.getText());
						v.cliente.setApellidoCliente(textApellido.getText());
						v.cliente.setContraseña(textContraseña.getText());
						v.cliente.setNombreUsuario(txtUsuario.getText());
						v.cliente.setTipoCliente("free");
						v.cliente.setFechaNacimiento(date);
						v.cliente.setIdioma(comboBoxIdioma.getSelectedIndex() + 1);
						v.idioma.setDescripcion((String) comboBoxIdioma.getSelectedItem());
						v.cliente.setEdad(edad);
						sql.insertarCliente(v.cliente);
						v.cambiarPanel(1);
					} catch (NullPointerException s2) {
						error.error("Fecha de nacimiento vacia");

					}
				} catch (Exception e2) {

				} finally {
					error.error("Vacie el campo premium");
				}
			}
		});
		btnComprarPremium.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String str = sdf.format(dateChooserPremium.getDate());
					Date date = Date.valueOf(str);
					try {
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						String str1 = sdf1.format(dateChooserNormal.getDate());
						Date date1 = Date.valueOf(str1);
						int edad = new java.util.Date().getYear() -  date1.getYear();
						// Recolecta los valores de los campos de texto y del JComboBox
						v.cliente.setIdCliente(10);
						v.cliente.setNombreCliente(textNombre.getText());
						v.cliente.setApellidoCliente(textApellido.getText());
						v.cliente.setContraseña(textContraseña.getText());
						v.cliente.setNombreUsuario(txtUsuario.getText());
						v.cliente.setTipoCliente("premium");
						v.cliente.setFechaNacimiento(date1);
						v.cliente.setIdioma(comboBoxIdioma.getSelectedIndex() + 1);
						v.idioma.setDescripcion((String) comboBoxIdioma.getSelectedItem());
						v.cliente.setEdad(edad);
						v.premium.setFechaCaducidad(date);
						sql.insertarCliente(v.cliente);
						sql.Premium(v.premium);
						v.cambiarPanel(1);
					} catch (NullPointerException s2) {
						error.error("Fecha de nacimiento vacia");

					}

					// TODO: handle exception
				} catch (NullPointerException s) {
					error.error("campo premium vacio");
				} catch (Exception e2) {

				} 
			}
		});
	}
}
