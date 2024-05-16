package modelo;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public class Podcast extends Audio {
	private String colaboradores;
	private int idPodcaster;
	
	
	

	public Podcast(int idAudio, String nombreAudio, int duracion, ImageIcon imagen, String tipo, int idPodcaster, String colaboradores) {
		super(idAudio, nombreAudio, duracion, imagen, tipo);
		this.colaboradores=colaboradores;
		this.idPodcaster=idPodcaster;
	}



	public Podcast() {
		// TODO Auto-generated constructor stub
	}



	public String getColaboradores() {
		return colaboradores;
	}



	public void setColaboradores(String colaboradores) {
		this.colaboradores = colaboradores;
	}



	public int getIdPodcaster() {
		return idPodcaster;
	}



	public void setIdPodcaster(int idPodcaster) {
		this.idPodcaster = idPodcaster;
	}

	
	
	
	
}
