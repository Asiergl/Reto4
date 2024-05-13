package SQLCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Cancion;
import modelo.Cliente;

public class ReproductorSQL {
	public void Favoritos(Cliente cliente, Cancion cancion) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();

			String sql = "insert into gustos (id_cliente, id_audio) VALUES ('"
					+ cliente.getIdCliente() + "','" + cancion.getIdAudio() + "')";

			statement.executeUpdate(sql);
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();

		} catch (Exception e) {

		} finally {
		}

	}

}
