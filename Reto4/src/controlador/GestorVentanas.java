package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import modelo.Album;
import modelo.Artista;
import modelo.Audio;
import modelo.Cancion;
import modelo.Cliente;
import modelo.Estadisticas;
import modelo.Gustos;
import modelo.Idioma;
import modelo.Musico;
import modelo.PlayList;
import modelo.Podcast;
import modelo.Podcaster;
import modelo.Premium;
import modelo.Reproduccion;
import vista.VentanaArtista;
import vista.VentanaBienvenida;
import vista.VentanaCapitulo;
import vista.VentanaDescubrirMusica;
import vista.VentanaDisco;
import vista.VentanaLogin;
import vista.VentanaMenu;
import vista.VentanaMiPlaylist;
import vista.VentanaPerfil;
import vista.VentanaPodcast;
import vista.VentanaRegistro;
import vista.VentanaReproduccion;

public class GestorVentanas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;

	public Album album = new Album();
	public Artista artista = new Artista() {
	};
	public Audio audio = new Audio() {
	};
	public Cancion cancion = new Cancion();
	public Cliente cliente = new Cliente();
	public Estadisticas estadisticas = new Estadisticas();
	public Gustos gustos = new Gustos();
	public Idioma idioma = new Idioma();
	public Musico musico = new Musico();
	public PlayList playlist = new PlayList();
	public Podcast podcast = new Podcast();
	public Podcaster podcaster = new Podcaster();
	public Premium premium = new Premium();
	public Reproduccion reproduccion = new Reproduccion();
	public ArrayList<Cancion> canciones = new ArrayList<Cancion>();
	public ArrayList<Cancion> favoritos = new ArrayList<Cancion>();
	public GestorReproductor gestor = new GestorReproductor();

	public GestorVentanas() {
		setSize(600, 480);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Spotify Elorrieta");
	}

	public void lanzarVentana() {
		;
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
			setContentPane(new VentanaDisco(this));
			break;
		}

		case 7: {
			setContentPane(new VentanaPerfil(this));
			break;
		}

		case 8: {
			setContentPane(new VentanaPodcast(this));
			break;
		}
		
		case 9: {
			setContentPane(new VentanaReproduccion(this));
			break;
		}
		/*
		case 10: {
			setContentPane(new VentanaMenuAdmin(this));
			break;
		}
		case 11: {
			setContentPane(new VentanaEstadisticaTopCanciones(this));
			break;
		}
		*/
		
		case 12: {
			setContentPane(new VentanaMiPlaylist(this));
			break;
		}
		case 13: {
			setContentPane(new VentanaCapitulo(this));
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