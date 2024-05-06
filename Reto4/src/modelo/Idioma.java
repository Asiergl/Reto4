package modelo;

public class Idioma {
private int idIdioma;
private String letraIdioma; 
private String descripcion;



public Idioma(int idIdioma, String letraIdioma, String descripcion) {
	super();
	this.idIdioma = idIdioma;
	this.letraIdioma = letraIdioma;
	this.descripcion = descripcion;
}
public Idioma() {
	// TODO Auto-generated constructor stub
}
public int getIdIdioma() {
	return idIdioma;
}
public void setIdIdioma(int idIdioma) {
	this.idIdioma = idIdioma;
}
public String getLetraIdioma() {
	return letraIdioma;
}
public void setLetraIdioma(String letraIdioma) {
	this.letraIdioma = letraIdioma;
}
public String getDescripcion() {
	return descripcion;
}
public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
}




}
