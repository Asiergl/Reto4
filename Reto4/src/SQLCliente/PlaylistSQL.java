package SQLCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import modelo.Cliente;

public class PlaylistSQL {
	public void Playlists(Cliente cliente, ArrayList<String> playlists) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();

			String sql = "select titulo from playlist where id_cliente ='" + cliente.getIdCliente() + "'" ;// trigger para que cuando sacas artista saques tambien los oyentes

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				playlists.add(resultSet.getString(1));
			}
		} catch (SQLException sqle) {
			String seleccion = JOptionPane.showInputDialog(
					   "Input dialog",
					   JOptionPane.QUESTION_MESSAGE);  // el icono sera un iterrogante
					        
					// Si seleccion es null es que el usuario ha pulsado Cancelar.
					System.out.println("El usuario ha escrito "+seleccion);

		} catch (Exception e) {

		} finally {
		}

	}
	public void NuevaList(Cliente cliente) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			String seleccion = JOptionPane.showInputDialog(
					   "Nombre de la playlist",
					   JOptionPane.QUESTION_MESSAGE);	
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			/*
			 * crear triger para actualizar en estadisticas
			 */
			String sql = "insert into playlist (titulo, id_cliente) VALUES ('"
					+ seleccion + " ','" + cliente.getIdCliente() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println(sqle);
				      
		} catch (Exception e) {

		} finally {
		}

	}
	public void DropList(Cliente cliente) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			String seleccion = JOptionPane.showInputDialog(
					   "Nombre de la playlist",
					   JOptionPane.QUESTION_MESSAGE);	
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			/*
			 * crear triger para actualizar en estadisticas
			 */
			String sql = "insert into playlist (titulo, id_cliente) VALUES ('"
					+ seleccion + " ','" + cliente.getIdCliente() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println(sqle);
			Object seleccion = JOptionPane.showInputDialog(
					   null, "Seleccione opcion",
					   "Selector de opciones",
					   JOptionPane.QUESTION_MESSAGE,
					   null,  // null para icono defecto
					   new Object[] { "opcion 1", "opcion 2", "opcion 3" }, 
					   "opcion 1");
		} catch (Exception e) {

		} finally {
		}

	}

}
