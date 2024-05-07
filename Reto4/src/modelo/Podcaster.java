package modelo;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Podcaster extends Artista {

	private String genero;

	public Podcaster(int idArtista, String nombreArtistico, ImageIcon imagen, String descripcion, String genero) {
		super(idArtista, nombreArtistico, imagen, descripcion);
		this.genero=genero;
		
		
		
		
		
	}

	public Podcaster() {
		// TODO Auto-generated constructor stub
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
	

	

	
	
	
}
