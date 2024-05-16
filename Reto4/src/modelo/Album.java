package modelo;

import java.awt.image.BufferedImage;
import java.sql.Date;

import javax.swing.ImageIcon;

public class Album  {
	private String idAlbum;
	private String titulo;
	private Date fecha; //fecha de publicacion
	private String genero;
	private ImageIcon imagen;
	private int idArtista;
	private int numeroCanciones;
	public Album() {
	}

	public Album(String idAlbum, String titulo, Date fecha, String genero, ImageIcon imagen, int idArtista,
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
	public String getIdAlbum() {
		return idAlbum;
	}
	public void setIdAlbum(String string) {
		this.idAlbum = string;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date date) {
		this.fecha = date;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public ImageIcon getImagen() {
		return imagen;
	}
	public void setImagen(ImageIcon imagen2) {
		this.imagen = imagen2;
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
