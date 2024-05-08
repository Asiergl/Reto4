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
				v.cambiarPanel(5);
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
	}
}