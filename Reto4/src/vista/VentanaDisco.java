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

public class VentanaDisco extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> canciones = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaDisco(GestorVentanas v) {
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

		JButton btnMiPerfil = new JButton("Mi perfil");

		btnMiPerfil.setBounds(326, 32, 89, 23);
		btnMiPerfil.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnMiPerfil.setBackground(Color.WHITE);
		add(btnMiPerfil);

		JLabel lblNewLabel = new JLabel("VENTANA ARTISTA");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(142, 33, 172, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);

		JLabel lblCanciones = new JLabel("Canciones");
		lblCanciones.setHorizontalAlignment(SwingConstants.CENTER);
		lblCanciones.setForeground(Color.WHITE);
		lblCanciones.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblCanciones.setBackground(Color.WHITE);
		lblCanciones.setBounds(22, 76, 172, 14);
		add(lblCanciones);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(245, 101, 284, 141);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha de publicación:" + v.album.getFecha() +" \r\nGenero:<dynamic>");
		lblNewLabel_1.setBounds(0, 0, 287, 141);
		panel_1.add(lblNewLabel_1);

		JLabel lblInformacin = new JLabel("Información");
		lblInformacin.setForeground(Color.WHITE);
		lblInformacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInformacin.setBackground(Color.WHITE);
		lblInformacin.setBounds(307, 76, 172, 14);
		add(lblInformacin);

		JLabel lblFoto = new JLabel("");
		lblFoto.setBackground(new Color(255, 255, 255));
		lblFoto.setBounds(366, 263, 163, 93);
		add(lblFoto);
		
		JList listCanciones = new JList();
		listCanciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCanciones.setModel(new AbstractListModel() {
			public int getSize() {
				return canciones.size();
			}
			public Object getElementAt(int index) {
				return canciones.get(index);
			}
		});
		listCanciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cancion.setNombreAudio((String) listCanciones.getSelectedValuesList().get(0));
				v.cambiarPanel(7);
			}
		});
		listCanciones.setBounds(22, 101, 172, 239);
		add(listCanciones);
	}
}