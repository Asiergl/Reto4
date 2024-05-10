package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListModel;

import SQLCliente.DMusicaSQL;
import controlador.GestorVentanas;
import modelo.Musico;

import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class VentanaDescubrirMusica extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> musicos = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaDescubrirMusica(GestorVentanas v) {
		setSize(460, 302);
		setBackground(new Color(0, 0, 0));

		DMusicaSQL sql = new DMusicaSQL();
		sql.Musicos(musicos);
		
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

		JButton btnMiPerfil = new JButton("Mi perfil");

		btnMiPerfil.setBounds(326, 32, 89, 23);
		btnMiPerfil.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnMiPerfil.setBackground(Color.WHITE);
		add(btnMiPerfil);
		 btnMiPerfil.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					v.cambiarPanel(7);
					v.setVisible(true);
				}
			});

		JLabel lblNewLabel = new JLabel("DESCUBRIR MUSICA");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(142, 33, 172, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);

		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.musico.setNombreArtistico((String) list.getSelectedValuesList().get(0));
				v.cambiarPanel(5);
			}
		});
		list.setModel(new AbstractListModel() {
			public int getSize() {
				return musicos.size();
			}
			public Object getElementAt(int index) {
				return musicos.get(index);
			}
		});
		list.setBounds(80, 66, 302, 193);
		add(list);
	}
}
