package SQLCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JDialog;
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

			String sql = "select titulo from playlist where id_cliente ='" + cliente.getIdCliente() + "'" ;
			// trigger para que cuando sacas artista saques tambien los oyentes

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
			System.out.println(e);

		} finally {
		}

	}
	
	public void DropList(Cliente cliente, ArrayList<String> playlists) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			String[] date= {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
	        String[] month= {"1","2","3","4","5","6","7","8","9","10","11","12"};
	        String[] year={"2016","2017","2018","2019","2020"};
	        JComboBox jcd = new JComboBox(date);
	        JComboBox jcm = new JComboBox(month);
	        JComboBox jcy = new JComboBox(year);

	        jcd.setEditable(true);
	        jcm.setEditable(true);
	        jcy.setEditable(true);

	        //create a JOptionPane
	        Object[] options = new Object[] {};
	        JOptionPane jop = new JOptionPane("Please Select",
	                                        JOptionPane.QUESTION_MESSAGE,
	                                        JOptionPane.DEFAULT_OPTION,
	                                        null,options, null);

	        //add combos to JOptionPane
	        jop.add(jcd);
	        jop.add(jcm);
	        jop.add(jcy);

	        //create a JDialog and add JOptionPane to it 
	        JDialog diag = new JDialog();
	        diag.getContentPane().add(jop);
	        diag.pack();
	        diag.setVisible(true);
			connection = DriverManager.getConnection("jdbc:mysql://localhost/reto4_grupo3_tarde", "cliente",
					"Elorrieta00");

			statement = connection.createStatement();
			/*
			 * crear triger para actualizar en estadisticas
			 */
			/*
			String sql = "insert into playlist (titulo, id_cliente) VALUES ('"
					+ seleccion + " ','" + cliente.getIdCliente() + "')";

			statement.executeUpdate(sql);
			*/
		} catch (SQLException sqle) {
			System.out.println(sqle);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
		}

	}

}
