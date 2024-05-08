package vista;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controlador.GestionBD;
import controlador.GestorVentanas;
import modelo.Cliente;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;

/**
 * Clase que representa el panel de bienvenida en la interfaz gráfica.
 */
public class VentanaBienvenida extends JPanel {	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
   * Constructor que inicializa y configura el panel de bienvenida.
   * 
   * @param V El objeto FramePrincipal al que pertenece este panel.
   */
	public VentanaBienvenida(GestorVentanas V) {
		// Establece el tamaño, visibilidad, diseño y fondo del panel
		setSize(460, 302);//Configura el tamaño del panel: - Ancho: 934 píxeles y - Altura: 761 píxeles
		setVisible(true);//Establece la visibilidad del panel: - true: visible y - false: no visible
		setLayout(null);//Establece el diseño del panel como nulo (null). - En este caso, se utiliza un diseño nulo para permitir un posicionamiento absoluto de los componentes en el panel, en lugar de utilizar un diseño de diseño automático.
		setBackground(new Color(0, 0, 0));//Establece el fondo del panel con un color oscuro. - Color.DARK_GRAY representa un tono de gris oscuro.
		
		
		// Crea y configura la etiqueta de bienvenida
		JLabel lblNewLabel = new JLabel("Bienvenido");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(156, 79, 146, 50);
        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
        add(lblNewLabel);
        
        JComboBox comboBoxTipo = new JComboBox();
        comboBoxTipo.setModel(new DefaultComboBoxModel(new String[] {"Administrador", "Cliente"}));
        comboBoxTipo.setBounds(159, 185, 143, 22);
        add(comboBoxTipo);
        
        JButton btnNewext = new JButton("Continuar");
        btnNewext.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		if (comboBoxTipo.getSelectedItem().equals("Administrador")) {
        			V.cliente.setContAdmin(1);
        			V.cliente.setContCliente(0);
        		} else if (comboBoxTipo.getSelectedItem().equals("Cliente")) {
        			V.cliente.setContCliente(1);
        			V.cliente.setContAdmin(0);
				}
        		V.cambiarPanel(1);
        	}
        });
        btnNewext.setBounds(186, 241, 89, 23);
        add(btnNewext);
		

		/**
		 * Agrega un MouseListener al panel para detectar eventos del mouse.
		 */
		addMouseListener(new MouseListener() {

			/**
	     * Método invocado cuando se libera un botón del mouse.
	     */
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			/**
	     * Método invocado cuando se presiona un botón del mouse.
	     */
			@Override
			public void mousePressed(MouseEvent e) {
				/**
				 * Este variable es el sustituto de thread sleep
				 * Indica que luego de presionar el click pasen 3 segundos y cambie de panel
				 */
				
				;// Llama al método cambiarPanel(1) del objeto FramePrincipal.

			}
			
			/**
	     * Método invocado cuando el mouse sale del área del componente.
	     */
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			/**
	     * Método invocado cuando el mouse entra en el área del componente.
	     */
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}
			/**
	     * Método invocado cuando se realiza un clic con el mouse.
	     */
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
			
	}
}