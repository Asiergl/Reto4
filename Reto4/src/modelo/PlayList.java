package modelo;

import java.sql.Date;

public class PlayList {
private int idList;
private String titulo;
private Date fechaCreacion;
private int idCliente;
private Audio ArrayListPlaylist;

public PlayList(int idList, String titulo, Date fechaCreacion, int idCliente) {
	super();
	this.idList = idList;
	this.titulo = titulo;
	this.fechaCreacion = fechaCreacion;
	this.idCliente = idCliente;
}
public PlayList() {
	// TODO Auto-generated constructor stub
}
public int getIdList() {
	return idList;
}
public void setIdList(int idList) {
	this.idList = idList;
}
public String getTitulo() {
	return titulo;
}
public void setTitulo(String titulo) {
	this.titulo = titulo;
}
public Date getFechaCreacion() {
	return fechaCreacion;
}
public void setFechaCreacion(Date fechaCreacion) {
	this.fechaCreacion = fechaCreacion;
}
public int getIdCliente() {
	return idCliente;
}
public void setIdCliente(int idCliente) {
	this.idCliente = idCliente;
}
	


	
	
}
