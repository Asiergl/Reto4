package modelo_pojos;

import java.awt.image.BufferedImage;

public abstract class Artista {
private int idArtista;
private String nombreArtistico;
private BufferedImage imagen;
private String descripcion;


public Artista(int idArtista, String nombreArtistico, BufferedImage imagen, String descripcion) {
	this.idArtista=idArtista;
	this.nombreArtistico=nombreArtistico;
	this.imagen = imagen;
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


public BufferedImage getImagen() {
	return imagen;
}


public void setImagen(BufferedImage imagen) {
	this.imagen = imagen;
}


public String getDescripcion() {
	return descripcion;
}


public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}





}

