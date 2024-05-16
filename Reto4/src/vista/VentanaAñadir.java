package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dialog.ModalExclusionType;
import javax.swing.SwingConstants;

import SQLCliente.PlaylistSQL;
import controlador.GestorVentanas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class VentanaAñadir {

	private JFrame frame;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(GestorVentanas v, int DoA) {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setType(Type.POPUP);
		frame.setBounds(100, 100, 166, 99);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		PlaylistSQL sql = new PlaylistSQL();
		sql.Playlists(v.cliente, v.playlists);

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 36, 140, 23);
		for (int i = 0; i < v.playlists.size(); i++) {
			comboBox.addItem(v.playlists.get(i));
		}
		frame.getContentPane().add(comboBox);

		JLabel lblNewLabel = new JLabel("Seleccione playlist");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 140, 14);
		frame.getContentPane().add(lblNewLabel);

		JButton btnCancelar = new JButton("X");
		btnCancelar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(10, 70, 49, 23);
		frame.getContentPane().add(btnCancelar);

		JButton btnNewButton_1 = new JButton("✓");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (DoA == 0) {
					v.playlist.setTitulo((String) comboBox.getSelectedItem());
					sql.CancionPlaylist(v.cliente, v.canciones, v.gestor, v.playlist);
					frame.dispose();
				} else if (DoA == 1) {
					v.playlist.setTitulo((String) comboBox.getSelectedItem());
					frame.dispose();
				}
			}
		});
		btnNewButton_1.setBounds(101, 70, 49, 23);
		frame.getContentPane().add(btnNewButton_1);
		frame.setVisible(true);
	}
}
