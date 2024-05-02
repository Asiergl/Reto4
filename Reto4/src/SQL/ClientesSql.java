package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import modelo.modelo_pojos.Cliente;



public class ClientesSql {

	public void insertarCliente(Cliente cliente) {

		Connection connection = null;

		Statement statement = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "root", "");

			statement = connection.createStatement();

			String sql = "insert into cliente (id_cliente, nombre, apellido,id_idioma, nombre_usuario, contraseña, edad, fecha_registro, fecha_nacimiento, tipo) VALUES ('"
					+  cliente.getIdCliente() + " ','" + cliente.getNombreCliente() + "','" + cliente.getApellidoCliente() + "','"
					+ cliente.getIdioma() +  " ','" + cliente.getNombreUsuario()+ " ','" + cliente.getContraseña()+" ','" + cliente.getEdad()+" ','" + cliente.getFechaRegistro()+" ','" + cliente.getFechaNacimiento()+  " ','" + cliente.getTipoCliente()+"')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR, Vuelve a intentarlo");
		} finally {
			try {
				if (statement != null)
					statement.close();
				JOptionPane.showMessageDialog(null, "Cliente creado");
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
	}

	public static boolean validarLogin(String nombre_usuario, String Contrasena) {

		boolean ret = false;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "root", "");

			statement = connection.createStatement();

			String sql = "select * from cliente where nombre_usuario = '" + nombre_usuario + "' and Contraseña = '" + Contrasena
					+ "'";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				JOptionPane.showMessageDialog(null, "nombre_usuario y contraseña correctos");
				ret = true;
			} else {
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

}