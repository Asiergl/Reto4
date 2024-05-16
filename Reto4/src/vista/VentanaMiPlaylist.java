package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;

import SQLCliente.DMusicaSQL;
import SQLCliente.PlaylistSQL;
import SQLCliente.PodcastSQL;
import controlador.GestorVentanas;
import modelo.Cliente;

import javax.swing.JList;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaMiPlaylist extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> playlists = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaMiPlaylist(GestorVentanas v) {
		setSize(559, 387);
		setBackground(new Color(0, 0, 0));

		PlaylistSQL sql = new PlaylistSQL();
		sql.Playlists(v.cliente, playlists);

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

		btnMiPerfil.setBounds(440, 32, 89, 23);
		btnMiPerfil.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnMiPerfil.setBackground(Color.WHITE);
		add(btnMiPerfil);

		JLabel lblNewLabel = new JLabel("MIS  PLAYLIST");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(142, 33, 288, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);

		JList listCanciones = new JList();
		listCanciones.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listCanciones.setModel(new AbstractListModel() {
			public int getSize() {
				return playlists.size();
			}

			public Object getElementAt(int index) {
				return playlists.get(index);
			}
		});
		listCanciones.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cancion.setNombreAudio((String) listCanciones.getSelectedValuesList().get(0));
				v.cambiarPanel(7);
			}
		});
		listCanciones.setBounds(22, 80, 165, 279);
		add(listCanciones);

		JButton btnNueva = new JButton("Nueva Playlist");
		btnNueva.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				sql.NuevaList(v.cliente);
				repaint();
			}
		});
		btnNueva.setBounds(374, 77, 124, 23);
		add(btnNueva);

		JButton btnBorrar = new JButton("Borrar Playlist");
		btnBorrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				sql.DropList(v.cliente, playlists);
			}
		});
		btnBorrar.setBounds(374, 125, 124, 23);
		add(btnBorrar);

		JButton btnImport = new JButton("");
		btnImport.setBounds(374, 290, 124, 69);
		btnImport.setIcon(new ImageIcon("imagenes/importar.png"));
		add(btnImport);

		JButton btnExport = new JButton("Exportar");
		btnExport.setBounds(374, 220, 124, 23);
		add(btnExport);
		btnMiPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(7);
			}
		});
	}
}