package modelo;

import java.awt.image.BufferedImage;

public class Album  {
	private int idAlbum;
	private String titulo;
	private String fecha; //fecha de publicacion
	private String genero;
	private BufferedImage imagen;
	private int idArtista;
	private int numeroCanciones;
	public Album() {
	}

	public Album(int idAlbum, String titulo, String fecha, String genero, BufferedImage imagen, int idArtista,
			int numeroCanciones) {
		super();
		this.idAlbum = idAlbum;
		this.titulo = titulo;
		this.fecha = fecha;
		this.genero = genero;
		this.imagen = imagen;
		this.idArtista = idArtista;
		this.numeroCanciones = numeroCanciones;
	}
	public int getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public BufferedImage getImagen() {
		return imagen;
	}
	public void setImagen(BufferedImage imagen) {
		this.imagen = imagen;
	}
	public int getIdArtista() {
		return idArtista;
	}
	public void setIdArtista(int idArtista) {
		this.idArtista = idArtista;
	}
	public int getNumeroCanciones() {
		return numeroCanciones;
	}
	public void setNumeroCanciones(int numeroCanciones) {
		numeroCanciones = numeroCanciones;
	}



}
