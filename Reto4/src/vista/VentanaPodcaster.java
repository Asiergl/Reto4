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
import SQLCliente.PodcastSQL;
import controlador.GestorVentanas;
import javax.swing.JList;
import javax.swing.SwingConstants;

public class VentanaPodcaster extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> podcasters  = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaPodcaster(GestorVentanas v) {
		setSize(559, 387);
		setBackground(new Color(0, 0, 0));
		
		PodcastSQL sql = new PodcastSQL();
		sql.podcaster(podcasters);

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

		btnMiPerfil.setBounds(351, 32, 89, 23);
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


		JLabel lblNewLabel = new JLabel("VENTANA PODCASTER");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(132, 33, 199, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);
		
		JList listPodcasters = new JList();
		listPodcasters.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listPodcasters.setModel(new AbstractListModel() {
			public int getSize() {
				return podcasters.size();
			}
			public Object getElementAt(int index) {
				return podcasters.get(index);
			}
		});
		listPodcasters.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.podcaster.setNombreArtistico((String) listPodcasters.getSelectedValuesList().get(0));
				v.cambiarPanel(7);
			}
		});
		listPodcasters.setBounds(79, 94, 281, 152);
		add(listPodcasters);
	}
}
