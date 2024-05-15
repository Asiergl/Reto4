package SQLCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Podcast;
import modelo.Podcaster;

public class PodcastSQL {
	public void podcaster(ArrayList<String> podcasters) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();

			String sql = "select * from podcaster";// trigger para que cuando sacas artista saques tambien los oyentes

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				podcasters.add(resultSet.getString(2));
			}
		} catch (SQLException sqle) {

		} catch (Exception e) {

		} finally {
		}
		
	}
	public static ResultSet obtenerPodcastsMasEscuchados() throws SQLException {
		 
	    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "root", "");
	    

	    String sql = "SELECT AU.Nombre AS Nombre_Podcast, COUNT(R.id_cliente) AS Reproducciones " +
	                 "FROM Reproducciones R " +
	                 "JOIN Audio AU ON R.id_audio = AU.id_audio " +
	                 "JOIN Podcast P ON AU.id_audio = P.id_audio " +
	                 "GROUP BY AU.Nombre " +
	                 "ORDER BY Reproducciones DESC";
	    

	    java.sql.PreparedStatement statement = connection.prepareStatement(sql);
	    
	  
	    ResultSet resultSet = statement.executeQuery();
	    
	    return resultSet;
	}

}
