package modelo;

import java.util.Date;

public class Premium extends Cliente{

	private Date fechaCaducidad;
	protected float playlistMax = Float.POSITIVE_INFINITY;

	public Premium(int idCliente, String nombreCliente, String apellidoCliente, int idioma, String nombreUsuario,
			String contraseña, Date fechaNacimiento, int edad, Date fechaRegistro, String tipoCliente, Date fechaCaducidad) {
		super(idCliente, nombreCliente, apellidoCliente, idioma, nombreUsuario, contraseña, fechaNacimiento, edad,
				fechaRegistro, tipoCliente);
		this.fechaCaducidad=fechaCaducidad;
		
	}
	
	public Premium() {}

	public Date getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	
	
	
	
}
