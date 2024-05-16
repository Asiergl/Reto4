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
import modelo.Musico;

import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class VentanaArtista extends JPanel {

	private static final long serialVersionUID = 1L;
	public ArrayList<String> discos = new ArrayList<String>();

	/**
	 * Create the panel.
	 */
	public VentanaArtista(GestorVentanas v) {
		setSize(559, 387);
		setBackground(new Color(0, 0, 0));
		
		DMusicaSQL sql = new DMusicaSQL();
		sql.Discos(v.artista, v.musico, discos);

		setLayout(null);

		JButton btnAtras = new JButton("Atras");

		btnAtras.setBounds(33, 32, 89, 23);
		btnAtras.setForeground(Color.BLACK); // Establecer el color de la fuente en negro
		btnAtras.setBackground(new Color(255, 255, 255));

		add(btnAtras);

		btnAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(4);
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

		JLabel lblNewLabel = new JLabel("VENTANA ARTISTA");
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(142, 33, 172, 14);
		lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
		add(lblNewLabel);

		JLabel lblDiscos = new JLabel("Discos");
		lblDiscos.setForeground(Color.WHITE);
		lblDiscos.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblDiscos.setBackground(Color.WHITE);
		lblDiscos.setBounds(22, 76, 172, 14);
		add(lblDiscos);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(220, 101, 329, 124);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(v.musico.getDescripcion());
		lblNewLabel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_1.setBounds(0, 0, 329, 124);
		panel_1.add(lblNewLabel_1);

		JLabel lblInformacin = new JLabel("Información");
		lblInformacin.setForeground(Color.WHITE);
		lblInformacin.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblInformacin.setBackground(Color.WHITE);
		lblInformacin.setBounds(220, 79, 172, 14);
		add(lblInformacin);

		JLabel lblFoto = new JLabel("");
		lblFoto.setBackground(new Color(255, 255, 255));
		lblFoto.setBounds(220, 236, 329, 140);
		lblFoto.setIcon(v.musico.getImagen());
		add(lblFoto);
		
		JList listDiscos = new JList();
		listDiscos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDiscos.setModel(new AbstractListModel() {
			public int getSize() {
				return discos.size();
			}
			public Object getElementAt(int index) {
				return discos.get(index);
			}
		});
		listDiscos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.album.setTitulo((String) listDiscos.getSelectedValuesList().get(0));
				v.cambiarPanel(6);
			}
		});
		listDiscos.setBounds(22, 101, 172, 275);
		add(listDiscos);
		btnMiPerfil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				v.cambiarPanel(7);
			}
		});
	}
}
