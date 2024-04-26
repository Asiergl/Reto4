package modelo_pojos;

import java.awt.image.BufferedImage;

public class Podcast extends Audio {
	private String colaboradores;
	
	
	

	public Podcast(int idAudio, String nombreAudio, int duracion, BufferedImage imagen, String tipo, int idPodcaster, String colaboradores) {
		super(idAudio, nombreAudio, duracion, imagen, tipo);
		this.colaboradores=colaboradores;
		this.idPodcaster=idPodcaster;
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
