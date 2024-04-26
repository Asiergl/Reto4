package modelo_pojos;

import java.awt.image.BufferedImage;

public class Cancion extends Audio{
	
	private int idAlbum;
	private String invitados;

	public Cancion(int idAudio, String nombreAudio, int duracion, BufferedImage imagen, String tipo, int idAlbum, String invitados) {
		super(idAudio, nombreAudio, duracion, imagen, tipo);
		this.idAlbum=idAlbum;
		this.invitados=invitados;
		
	}

	public int getIdAlbum() {
		return idAlbum;
	}

	public void setIdAlbum(int idAlbum) {
		this.idAlbum = idAlbum;
	}

	public String getInvitados() {
		return invitados;
	}

	public void setInvitados(String invitados) {
		this.invitados = invitados;
	}

	
	
	
}
