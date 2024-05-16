package SQLCliente;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import controlador.GestorReproductor;
import controlador.GestorVentanas;
import modelo.Cancion;
import modelo.Cliente;
import modelo.PlayList;
import vista.VentanaAñadir;

public class PlaylistSQL {
	public void Playlists(Cliente cliente, ArrayList<String> playlists) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		playlists.clear();

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();

			String sql = "select titulo from playlist where id_cliente ='" + cliente.getIdCliente() + "'";
			// trigger para que cuando sacas artista saques tambien los oyentes

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				playlists.add(resultSet.getString(1));
			}
		} catch (SQLException sqle) {
			String seleccion = JOptionPane.showInputDialog("Input dialog", JOptionPane.QUESTION_MESSAGE); // el icono
																											// sera un
																											// iterrogante

			// Si seleccion es null es que el usuario ha pulsado Cancelar.
			System.out.println("El usuario ha escrito " + seleccion);

		} catch (Exception e) {

		} finally {
		}

	}

	public void NuevaList(Cliente cliente) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			String seleccion = JOptionPane.showInputDialog("Nombre de la playlist", JOptionPane.QUESTION_MESSAGE);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			/*
			 * crear triger para actualizar en estadisticas
			 */
			String sql = "insert into playlist (titulo, id_cliente) VALUES ('" + seleccion + " ','"
					+ cliente.getIdCliente() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println(sqle);

		} catch (Exception e) {
			System.out.println(e);

		} finally {
		}

	}

	public void DropList(PlayList playlist, GestorVentanas v) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			VentanaAñadir ven = new VentanaAñadir();
			ven.initialize(v, 1);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			/*
			 * crear triger para actualizar en estadisticas
			 */

			String sql = "DELETE FROM playlist WHERE `playlist`.`titulo` ='" + playlist.getTitulo() + "'";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}

	}

	public void CancionPlaylist(Cliente cliente, ArrayList<Cancion> canciones, GestorReproductor gestor,
			PlayList playlist) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			/*
			 * crear triger para actualizar en estadisticas
			 */
			String sql = "select idList from playlist where titulo	 ='" + playlist.getTitulo() + "'";
			// trigger para que cuando sacas artista saques tambien los oyentes

			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				playlist.setIdList(resultSet.getInt(1));
			}

			sql = "insert into playlist_canciones (id_audio, idList) VALUES ('"
					+ canciones.get(gestor.reproduciendo).getIdAudio() + " ','" + playlist.getIdList() + "')";

			statement.executeUpdate(sql);

		} catch (SQLException sqle) {

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
		}

	}

	public void CancionesPlaylist(Cliente cliente, ArrayList<Cancion> canciones, GestorReproductor gestor,
			PlayList playlist) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ImageIcon imagen = new ImageIcon();

		try {
			canciones.clear();
			canciones.clear();// se resetea el arraylist para que se añada solo el album selccionado
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			String sql = "SELECT * FROM playlist_canciones pycan JOIN playlist play on play.idList = pycan.idList JOIN audio au on au.id_audio = pycan.id_audio where play.titulo = '"
					+ playlist.getTitulo() + "'ORDER BY au.id_audio + 0";

			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				Blob imagenBlob = resultSet.getBlob(7);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				canciones.add(new Cancion(resultSet.getInt(1), resultSet.getString(5), resultSet.getInt(6), imagen,
						resultSet.getString(8), resultSet.getInt(2), resultSet.getString(3)));
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
		}

	}

}
