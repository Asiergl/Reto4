package SQLCliente;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import modelo.Album;
import modelo.Artista;
import modelo.Cancion;
import modelo.Musico;

public class DMusicaSQL {
	public void Musicos(ArrayList<String> musicos) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();

			String sql = "select * from musico";// trigger para que cuando sacas artista saques tambien los oyentes

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				musicos.add(resultSet.getString(2));
			}
		} catch (SQLException sqle) {

		} catch (Exception e) {

		} finally {
		}

	}

	public void Discos(Artista artista, Musico musico, ArrayList<String> discos) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ImageIcon imagen = new ImageIcon();

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			String sql = "select * from musico where nombre_artistico ='" + musico.getNombreArtistico() + "'";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				musico.setIdArtista(resultSet.getInt(1));
				/*
				 * Blob imagenBlob = resultSet.getBlob(3);
				 * byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				 * imagen = new ImageIcon(arrayImagen); 
				 * musico.setImagen(imagen);
				 */
				musico.setDescripcion(resultSet.getString(4));
				musico.setCaracteristica(resultSet.getString(5));
			}
			sql = "select * from album where idMusico ='" + musico.getIdArtista() + "'";

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				discos.add(resultSet.getString(2));
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
		}

	}
	public void Canciones(Album album,Cancion cancion, ArrayList<String> canciones) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ImageIcon imagen = new ImageIcon();

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			String sql = "select * from album where titulo ='" + album.getTitulo() + "'";
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				album.setIdAlbum(resultSet.getString(1));
				album.setFecha(resultSet.getDate(3));
				album.setGenero(resultSet.getString(4));				
				/*
				 * Blob imagenBlob = resultSet.getBlob(5);
				 * byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				 * imagen = new ImageIcon(arrayImagen); 
				 * musico.setImagen(imagen);
				 */
				album.setIdArtista(resultSet.getInt(6));
			}

			sql = "SELECT * FROM cancion can JOIN audio au on au.id_audio = can.id_audio WHERE id_album ='" + album.getIdAlbum() + "'";

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				canciones.add(resultSet.getString(5));
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
		}

	}
}
