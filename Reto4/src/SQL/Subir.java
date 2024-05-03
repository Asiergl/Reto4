package SQL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Subir {

	private Connection conexion;

	public void insercionImagenEnBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "root", "");

			PreparedStatement consulta = conexion.prepareStatement(
					"INSERT INTO MUSICO  (id_musico, nombre_artistico,imagen, descripcion, caracteristica) VALUES (?,?,?,?,?)");
			consulta.setInt(1, 2); // id
			consulta.setString(2, "Vhaldemar"); // nombre
			InputStream imagen = new FileInputStream("imagenes/vhaldemar.png");
			consulta.setBlob(3, imagen);
			consulta.setString(4,
					"Vhäldemar es un grupo de heavy/power metal fundado en Baracaldo, a finales de los años 90. Se formó cuando el guitarrista, Pedro J. Monge, decidió crear una banda junto con Carlos Escudero.");
			consulta.setString(5, "grupo");
			consulta.executeUpdate(); // ejecucion
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ImageIcon lecturaImagenEnBD() {

		ImageIcon imagen = new ImageIcon();

		try {
			PreparedStatement consulta = conexion.prepareStatement("SELECT imagen FROM EMPLEADOS WHERE emp_no = ?");
			consulta.setInt(1, 150);

			ResultSet resultadoConsulta = consulta.executeQuery();
			while (resultadoConsulta.next()) {
				Blob imagenBlob = resultadoConsulta.getBlob(1);
				byte[] arrayImagen = imagenBlob.getBytes(1, (int) imagenBlob.length());
				imagen = new ImageIcon(arrayImagen);
				System.out.println(arrayImagen);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return imagen;

	}

}
