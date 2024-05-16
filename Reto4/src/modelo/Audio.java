package modelo;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public abstract class Audio {

	private int idAudio;
	private String nombreAudio;
	private int duracion;
	private ImageIcon imagen;
	
	private String tipo;

	public Audio(int idAudio, String nombreAudio, int duracion, ImageIcon imagen2, String tipo) {
		super();
		this.idAudio = idAudio;
		this.nombreAudio = nombreAudio;
		this.duracion = duracion;
		this.imagen = imagen2;
		this.tipo = tipo;
	}

	public Audio() {
		// TODO Auto-generated constructor stub
	}
	
	public int getIdAudio() {
		return idAudio;
	}

	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}

	public String getNombreAudio() {
		return nombreAudio;
	}

	public void setNombreAudio(String nombreAudio) {
		this.nombreAudio = nombreAudio;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public ImageIcon getImagen() {
		return imagen;
	}

	public void setImagen(ImageIcon imagen) {
		this.imagen = imagen;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	
	
}
