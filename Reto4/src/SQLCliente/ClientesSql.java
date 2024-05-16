package SQLCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Cliente;
import modelo.Idioma;
import modelo.Premium;
import vista.Error;

public class ClientesSql {

	public void insertarCliente(Cliente cliente) {

		Connection connection = null;

		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			/*
			 * crear triger BEGIN DECLARE lastId int; DECLARE IdiomId int; DECLARE edad int;
			 * DECLARE f_actual date SELECT id_idioma INTO IdiomId FROM idioma WHERE
			 * idioma.descripcion = idiomaD; set edad = YEAR_MONTH END
			 * 
			 */
			String sql = "insert into cliente (id_cliente, nombre, apellido,id_idioma, nombre_usuario, contraseña, edad, fecha_nacimiento, tipo) VALUES ('"
					+ cliente.getIdCliente() + " ','" + cliente.getNombreCliente() + "','"
					+ cliente.getApellidoCliente() + "','" + cliente.getIdioma() + " ','" + cliente.getNombreUsuario()
					+ " ','" + cliente.getContraseña() + " ','" + cliente.getEdad() + " ','"
					+ cliente.getFechaNacimiento() + " ','"
					+ cliente.getTipoCliente() + "')";

			statement.executeUpdate(sql);
			JOptionPane.showMessageDialog(null, "Cliente creado");
		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, sqle);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} 
	}

	public boolean validarLogin(String nombre_usuario, String Contrasena, Cliente cliente, Idioma idioma) {
		Error error = new Error();
		boolean ret = false;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();

			String sql = "select * from cliente cli JOIN idioma idi on idi.id_idioma = cli.id_idioma where nombre_usuario = '"
					+ nombre_usuario + "' and Contraseña = '" + Contrasena + "'";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				JOptionPane.showMessageDialog(null, "nombre_usuario y contraseña correctos");
				cliente.setIdCliente(resultSet.getInt(1));
				cliente.setNombreCliente(resultSet.getString(2));
				cliente.setApellidoCliente(resultSet.getString(3));
				cliente.setIdioma(resultSet.getInt(4));
				cliente.setNombreUsuario(resultSet.getString(5));
				cliente.setContraseña(resultSet.getString(6));
				cliente.setFechaNacimiento(resultSet.getDate(7));
				cliente.setEdad(resultSet.getInt(8));
				cliente.setFechaRegistro(resultSet.getDate(9));
				cliente.setTipoCliente(resultSet.getString(10));
				idioma.setIdIdioma(resultSet.getInt(11));
				idioma.setLetraIdioma(resultSet.getString(12));;
				idioma.setDescripcion(resultSet.getString(13));
				ret = true;
			} else {
				error.error("Nombre de usuario o contraseña incorrectos");
			}

		} catch (SQLException sqle) {
			System.out.println("Error con la BBDD - " + sqle.getMessage());
		} catch (Exception e) {
			System.out.println("Error generico - " + e.getMessage());
		} finally {
//
			try {
				if (resultSet != null)
					resultSet.close();
			} catch (Exception e) {
			}
			;
			try {
				if (statement != null)
					statement.close();
			} catch (Exception e) {
			}
			;
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			;
		}
		return ret;
	}
	public void Idioma(Idioma idioma, ArrayList<String> idiomas) {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();

			String sql = "select descripcion from idioma";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				idiomas.add(resultSet.getString(1));
			}

		} catch (SQLException sqle) {

		} catch (Exception e) {

		} 
	}
	public void Premium(Premium premium){
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {

			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			
			String sql = "insert into premium (id_cliente, fecha_caducidad) VALUES ('"
					+ premium.getIdCliente() + " ','" + premium.getFechaCaducidad() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {

		} catch (Exception e) {

		} 
		
	}

}
