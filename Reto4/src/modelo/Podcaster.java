package modelo;

import java.awt.image.BufferedImage;

public class Podcaster extends Artista {

	private String genero;

	public Podcaster(int idArtista, String nombreArtistico, BufferedImage imagen, String descripcion, String genero) {
		super(idArtista, nombreArtistico, imagen, descripcion);
		this.genero=genero;
		
		
		
		
		
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

	

	
	
	
}
