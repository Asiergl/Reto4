package modelo;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public abstract class Artista {
private int idArtista;
private String nombreArtistico;
private ImageIcon imagen;
private String descripcion;

public Artista() {
	
}

public Artista(int idArtista, String nombreArtistico, ImageIcon imagen2, String descripcion) {
	this.idArtista=idArtista;
	this.nombreArtistico=nombreArtistico;
	this.imagen = imagen2;
	this.descripcion=descripcion;
	
}


public int getIdArtista() {
	return idArtista;
}


public void setIdArtista(int idArtista) {
	this.idArtista = idArtista;
}


public String getNombreArtistico() {
	return nombreArtistico;
}


public void setNombreArtistico(String nombreArtistico) {
	this.nombreArtistico = nombreArtistico;
}


public ImageIcon getImagen() {
	return imagen;
}


public void setImagen(ImageIcon imagen) {
	this.imagen = imagen;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}





}

