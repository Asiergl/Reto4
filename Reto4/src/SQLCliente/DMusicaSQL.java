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

import modelo.Artista;
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
			
			String sql = "select * from musico";//trigger para que cuando sacas artista saques tambien los oyentes
			
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				musicos.add( resultSet.getString(2));		
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

			while (resultSet.next()) {
				Blob imagenBlob = resultSet.getBlob(3);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				musico.setIdArtista(resultSet.getInt(1));
				musico.setImagen(imagen);
				musico.setDescripcion(resultSet.getString(4));
				musico.setCaracteristica(resultSet.getString(5));
			}
			System.out.println(musico.toString());
			sql = "select * from album where idMusico ='" + musico.getIdArtista()+ "'";
			
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {
				discos.add( resultSet.getString(2));		
			}
		} catch (SQLException sqle) {
			System.out.println(sqle);
			
		} catch (Exception e) {
			
		} finally {
		}

	}
}
