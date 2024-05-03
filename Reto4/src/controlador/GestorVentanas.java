package controlador;

import java.awt.EventQueue;

import javax.swing.JFrame;

import javax.swing.JLayeredPane;

import SQL.Subir;
import modelo.Cliente;
import vista.VentanaArtista;
import vista.VentanaBienvenida;
import vista.VentanaDescubrirMusica;
import vista.VentanaLogin;
import vista.VentanaMenu;
import vista.VentanaRegistro;

public class GestorVentanas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	public Cliente cliente = new Cliente();
	
	public GestorVentanas() {
		setSize(600, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Spotify Elorrieta");
	}

	public void lanzarVentana() {;
		this.cambiarPanel(0);
		this.setVisible(true);
	}

	public void cambiarPanel(int i) {
		switch (i) {
		case 0: {
			setContentPane(new VentanaBienvenida(this));
			break;

		}
		case 1: {
			setContentPane(new VentanaLogin(this));

			break;
		}
		case 2: {
			setContentPane(new VentanaRegistro(this));
			break;
		}
		case 3: {
			setContentPane(new VentanaMenu(this));
			break;

		}
		case 4: {
			setContentPane(new VentanaDescubrirMusica(this));
			break;
		}
		case 5: {
			setContentPane(new VentanaArtista(this));
			break;
		}

		case 6: {
			// setContentPane(new PanelResumenCompra(this, this.controlador));
			break;
		}

		case 7: {
			// setContentPane(new PanelFin(this));
			break;
		}
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*
		 * Conectorbd gestion = new Conectorbd();
		 */
		GestorVentanas ventanaPrincipal = new GestorVentanas();
		ventanaPrincipal.lanzarVentana();
	}
}