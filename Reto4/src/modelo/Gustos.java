package modelo;

public class Gustos {
	private int idCliente;
	private int idAudio;
	public Gustos(int idCliente, int idAudio) {
		super();
		this.idCliente = idCliente;
		this.idAudio = idAudio;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdAudio() {
		return idAudio;
	}
	public void setIdAudio(int idAudio) {
		this.idAudio = idAudio;
	}
	
	

}
