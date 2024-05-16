package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlador.GestorVentanas;
import modelo.Cancion;

import javax.swing.JTextField;

import SQLCliente.ClientesSql;
import SQLCliente.DMusicaSQL;

public class AnadirCanciones extends JPanel {

    private static final long serialVersionUID = 1L;
    private JTextField txtNombreCancion;
    private JTextField txtDuracionCancion;

    public AnadirCanciones(GestorVentanas f) {
    	DMusicaSQL sql = new DMusicaSQL();
        setSize(567, 385);
        setBackground(new Color(0, 0, 0));
        setLayout(null);

        JButton btnAtras = new JButton("Atras");
        btnAtras.setBounds(33, 32, 89, 23);
        btnAtras.setForeground(Color.BLACK);
        btnAtras.setBackground(new Color(255, 255, 255));
        add(btnAtras);

        btnAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.cambiarPanel(10);
                f.setVisible(true);
            }
        });

        JLabel lblNewLabel = new JLabel("AÑADIR CANCIONES");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNewLabel.setBounds(145, 33, 185, 22);
        lblNewLabel.setForeground(Color.WHITE);
        add(lblNewLabel);

        JButton btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setForeground(Color.BLACK);
        btnCerrarSesion.setBackground(Color.WHITE);
        btnCerrarSesion.setBounds(327, 32, 123, 23);
        add(btnCerrarSesion);
        
        JLabel lblNombreCancin = new JLabel("Nombre canción:");
        lblNombreCancin.setForeground(Color.WHITE);
        lblNombreCancin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNombreCancin.setBackground(Color.WHITE);
        lblNombreCancin.setBounds(33, 94, 144, 22);
        add(lblNombreCancin);
        
        txtNombreCancion = new JTextField();
        txtNombreCancion.setColumns(10);
        txtNombreCancion.setBounds(33, 127, 151, 29);
        add(txtNombreCancion);
        
        JLabel lblDuracinCancin = new JLabel("Duración canción:");
        lblDuracinCancin.setForeground(Color.WHITE);
        lblDuracinCancin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblDuracinCancin.setBackground(Color.WHITE);
        lblDuracinCancin.setBounds(33, 179, 144, 22);
        add(lblDuracinCancin);
        
        txtDuracionCancion = new JTextField();
        txtDuracionCancion.setColumns(10);
        txtDuracionCancion.setBounds(33, 212, 151, 29);
        add(txtDuracionCancion);
        
        JLabel lblTipoCancin = new JLabel("Tipo canción:");
        lblTipoCancin.setForeground(Color.WHITE);
        lblTipoCancin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblTipoCancin.setBackground(Color.WHITE);
        lblTipoCancin.setBounds(306, 179, 144, 22);
        add(lblTipoCancin);
        
        JLabel lblImagenCancin = new JLabel("Imagen canción:");
        lblImagenCancin.setForeground(Color.WHITE);
        lblImagenCancin.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblImagenCancin.setBackground(Color.WHITE);
        lblImagenCancin.setBounds(306, 101, 144, 22);
        add(lblImagenCancin);
        
        JComboBox comboBoxTipo = new JComboBox();
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"cancion", "podcast"}));
        comboBoxTipo.setBounds(316, 212, 144, 25);
        add(comboBoxTipo);
        
        JButton btnAadirImagen = new JButton("Añadir Imagen");
        btnAadirImagen.setForeground(Color.BLACK);
        btnAadirImagen.setBackground(Color.WHITE);
        btnAadirImagen.setBounds(306, 130, 144, 23);
        add(btnAadirImagen);
        
        JButton btnSiguiente = new JButton("Siguiente");
        btnSiguiente.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		 String nombre = txtNombreCancion.getText();
                 int duracion = Integer.parseInt(txtDuracionCancion.getText());
                 String tipo = (String) comboBoxTipo.getSelectedItem();

                 Cancion cancion = new Cancion(duracion, nombre, duracion, null, tipo, duracion, tipo);
                 sql.insertarCancion(cancion);

                 // Redirigir a otro panel
                 f.cambiarPanel(18);
                 f.setVisible(true);
        	}
        });
        btnSiguiente.setForeground(Color.BLACK);
        btnSiguiente.setBackground(Color.WHITE);
        btnSiguiente.setBounds(175, 309, 144, 23);
        add(btnSiguiente);
        

        btnCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.cambiarPanel(0);
            }
        });
    }
}
