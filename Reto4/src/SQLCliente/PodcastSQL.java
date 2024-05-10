package SQLCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import modelo.Artista;
import modelo.Audio;
import modelo.Musico;
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
	public void Capitulos(Audio audio, Podcaster podcaster, ArrayList<String> capitulos) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ImageIcon imagen = new ImageIcon();

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");
			
			statement = connection.createStatement();
			String sql = "select * from podcaster where nombre_artistico ='" + podcaster.getNombreArtistico() + "'";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				podcaster.setIdArtista(resultSet.getInt(1));
				/*
				 * Blob imagenBlob = resultSet.getBlob(3);
				 * byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				 * imagen = new ImageIcon(arrayImagen); 
				 * musico.setImagen(imagen);
				 */
				podcaster.setGenero(resultSet.getString(4));
				podcaster.setDescripcion(resultSet.getString(5));
			}
			sql = "SELECT * FROM podcast pod JOIN audio au on au.id_audio = pod.id_audio WHERE id_podcaster  ='" + podcaster.getIdArtista() + "'";

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				capitulos.add(resultSet.getString(5));
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
		}

	}

}
