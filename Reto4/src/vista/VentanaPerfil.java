package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import SQLCliente.DMusicaSQL;
import controlador.GestorVentanas;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;

public class VentanaPerfil extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> canciones = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaPerfil(GestorVentanas v) {
		setSize(559, 387);
		setBackground(new Color(0, 0, 0));
		
		DMusicaSQL sql = new DMusicaSQL();
		sql.Canciones(v.album, v.cancion, canciones);

		setLayout(null);

		JButton btnAtras = new JButton("Atras");

		btnAtras.setBounds(33, 32, 89, 23);
		btnAtras.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnAtras.setBackground(new Color(255, 255, 255));

		add(btnAtras);

		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(3);
				v.setVisible(true);
			}
		});

		JLabel lblNewLabel = new JLabel("MI PERFIL");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(184, 33, 172, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);

		JLabel lblFoto = new JLabel("");
		lblFoto.setBackground(new Color(255, 255, 255));
		lblFoto.setBounds(366, 263, 163, 93);
		add(lblFoto);
		
		JButton btnLogOut = new JButton("Cerrar sesión");
		btnLogOut.setBounds(410, 32, 122, 23);
		add(btnLogOut);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblUsuario.setBackground(Color.WHITE);
		lblUsuario.setBounds(33, 132, 172, 14);
		add(lblUsuario);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNombre.setBackground(Color.WHITE);
		lblNombre.setBounds(33, 194, 172, 14);
		add(lblNombre);
		
		JLabel lblApellido = new JLabel("Apellido:");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblApellido.setBackground(Color.WHITE);
		lblApellido.setBounds(33, 231, 172, 23);
		add(lblApellido);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setForeground(Color.WHITE);
		lblFechaDeNacimiento.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblFechaDeNacimiento.setBackground(Color.WHITE);
		lblFechaDeNacimiento.setBounds(33, 287, 172, 14);
		add(lblFechaDeNacimiento);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblTipo.setBackground(Color.WHITE);
		lblTipo.setBounds(33, 327, 172, 29);
		add(lblTipo);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(254, 131, 172, 26);
		add(panel_1);
		
		JLabel labelGetUsuario = new JLabel(v.cliente.getNombreUsuario());
		labelGetUsuario.setBounds(0, 0, 172, 26);
		panel_1.add(labelGetUsuario);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(254, 194, 172, 26);
		add(panel_1_1);
		
		JLabel labelGetnombre_1 = new JLabel(v.cliente.getNombreCliente());
		labelGetnombre_1.setBounds(0, 0, 172, 26);
		panel_1_1.add(labelGetnombre_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBounds(254, 235, 172, 26);
		add(panel_1_1_1);
		
		JLabel labelGetApellido_1_1 = new JLabel(v.cliente.getApellidoCliente());
		labelGetApellido_1_1.setBounds(0, 0, 172, 26);
		panel_1_1_1.add(labelGetApellido_1_1);
		
		JPanel panel_1_1_2 = new JPanel();
		panel_1_1_2.setLayout(null);
		panel_1_1_2.setBounds(254, 287, 172, 26);
		add(panel_1_1_2);
		
		JLabel labelGetNacimiento_1_1 = new JLabel(v.cliente.getFechaNacimiento().toString());
		labelGetNacimiento_1_1.setBounds(0, 0, 172, 26);
		panel_1_1_2.add(labelGetNacimiento_1_1);
		
		JPanel panel_1_1_3 = new JPanel();
		panel_1_1_3.setLayout(null);
		panel_1_1_3.setBounds(254, 327, 172, 26);
		add(panel_1_1_3);
		
		JLabel labelGetTipo_1_1 = new JLabel(v.cliente.getTipoCliente());
		labelGetTipo_1_1.setBounds(0, 0, 172, 26);
		panel_1_1_3.add(labelGetTipo_1_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.shadow"));
		panel.setBounds(213, 111, 250, 265);
		panel.setOpaque(true);
		add(panel);
		
		 btnLogOut.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					v.cambiarPanel(0);
					v.setVisible(true);
				}
			});
		
		
	}
}