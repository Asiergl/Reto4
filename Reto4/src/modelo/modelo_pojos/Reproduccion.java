package modelo_pojos;

public class Reproduccion {
private int idAudio;
private int idCliente;
private String fechaReproduccion;




public Reproduccion(int idAudio, int idCliente, String fechaReproduccion) {
	super();
	this.idAudio = idAudio;
	this.idCliente = idCliente;
	this.fechaReproduccion = fechaReproduccion;
}
public int getIdAudio() {
	return idAudio;
}
public void setIdAudio(int idAudio) {
	this.idAudio = idAudio;
}
public int getIdCliente() {
	return idCliente;
}
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}
public String getFechaReproduccion() {
	return fechaReproduccion;
}
public void setFechaReproduccion(String fechaReproduccion) {
	this.fechaReproduccion = fechaReproduccion;
}



}
