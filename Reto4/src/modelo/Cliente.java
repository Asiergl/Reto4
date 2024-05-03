package modelo;

import java.util.Date;

public class Cliente {
	private int idCliente;
	private String nombreCliente;
	private String apellidoCliente;
	private String idioma;
	private String nombreUsuario;
	private String contraseña;
	private Date fechaNacimiento;
	private int edad;
	private Date fechaRegistro;
	private String tipoCliente;
	//contadores para saber si el usuario es administrador o cliente
	private int contAdmin = 0;
	private int contCliente = 0;
	
	
	public int getContAdmin() {
		return contAdmin;
	}

	public void setContAdmin(int contAdmin) {
		this.contAdmin = contAdmin;
	}

	public int getContCliente() {
		return contCliente;
	}

	public void setContCliente(int contCliente) {
		this.contCliente = contCliente;
	}

	public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String idioma, String nombreUsuario,
			String contraseña, Date fechaNacimiento, int edad, Date fechaRegistro, String tipoCliente) {
		this.idCliente = idCliente;
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.idioma = idioma;
		this.nombreUsuario = nombreUsuario;
		this.contraseña = contraseña;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.fechaRegistro = fechaRegistro;
		this.tipoCliente = tipoCliente;
	}
	
	public Cliente() {}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	
	
	
	

}
