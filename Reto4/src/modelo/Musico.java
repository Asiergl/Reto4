package modelo;

import java.awt.image.BufferedImage;

public class Musico extends Artista {
private String caracteristica;

public Musico(int idArtista, String nombreArtistico, BufferedImage imagen, String descripcion, String caracteristica) {
	super(idArtista, nombreArtistico, imagen, descripcion);
	this.caracteristica=caracteristica;
	
}

public Musico() {
	// TODO Auto-generated constructor stub
}

public String getCaracteristica() {
	return caracteristica;
}

public void setCaracteristica(String caracteristica) {
	this.caracteristica = caracteristica;
}





}
