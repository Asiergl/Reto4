package vista;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import controlador.GestorVentanas;

public class VentanaAdminGestionarMusica extends JPanel {

    private static final long serialVersionUID = 1L;

    public VentanaAdminGestionarMusica(GestorVentanas f) {
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

        JLabel lblNewLabel = new JLabel("GESTIONAR MUSICA");
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

        JButton btnAadirCanciones = new JButton("Añadir canciones");
        btnAadirCanciones.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser seleccion = new JFileChooser();
                seleccion.setDialogTitle("Seleccionar Imagen");
                seleccion.setDialogType(JFileChooser.OPEN_DIALOG);
                seleccion.setFont(new java.awt.Font("Lucida Handwriting", 0, 18));

                int respuesta = seleccion.showOpenDialog(VentanaAdminGestionarMusica.this);
                if (respuesta == JFileChooser.APPROVE_OPTION) {
                    File archivoSeleccionado = seleccion.getSelectedFile();
                    File destino = new File("C:\\DATOS\\PROG\\eclipse\\Reto4\\imagenes", archivoSeleccionado.getName());
                    System.out.println("Guardar en: " + destino.getAbsolutePath());

                    // Copiar el archivo seleccionado a la ubicación deseada
                    try (FileInputStream fis = new FileInputStream(archivoSeleccionado);
                         FileOutputStream fos = new FileOutputStream(destino)) {

                        byte[] buffer = new byte[1024];
                        int bytesRead;
                        while ((bytesRead = fis.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                        System.out.println("Archivo guardado exitosamente en " + destino.getAbsolutePath());
                    } catch (IOException es1) {
                        System.out.println("Error al guardar el archivo: " + es1.getMessage());
                    }
                } else if (respuesta == JFileChooser.CANCEL_OPTION) {
                    System.out.println("Cancelado");
                } else {
                    System.out.println("Error");
                }
            }
        });
        btnAadirCanciones.setForeground(Color.BLACK);
        btnAadirCanciones.setBackground(Color.WHITE);
        btnAadirCanciones.setBounds(113, 119, 235, 23);
        add(btnAadirCanciones);

        btnCerrarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                f.cambiarPanel(0);
            }
        });
    }
}
