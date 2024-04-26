package ventanas;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.Color;

/**
 * Clase que representa el panel de bienvenida en la interfaz gráfica.
 */
public class VentanaBienvenida extends JPanel {	

	/**
   * Constructor que inicializa y configura el panel de bienvenida.
   * 
   * @param f El objeto FramePrincipal al que pertenece este panel.
   */
	public VentanaBienvenida(FramePrincipal f) {
		// Establece el tamaño, visibilidad, diseño y fondo del panel
		setSize(460, 302);//Configura el tamaño del panel: - Ancho: 934 píxeles y - Altura: 761 píxeles
		setVisible(true);//Establece la visibilidad del panel: - true: visible y - false: no visible
		setLayout(null);//Establece el diseño del panel como nulo (null). - En este caso, se utiliza un diseño nulo para permitir un posicionamiento absoluto de los componentes en el panel, en lugar de utilizar un diseño de diseño automático.
		setBackground(new Color(0, 0, 0));//Establece el fondo del panel con un color oscuro. - Color.DARK_GRAY representa un tono de gris oscuro.
		
		
		// Crea y configura la etiqueta de bienvenida
		JLabel lblNewLabel = new JLabel("Bienvenido");
        lblNewLabel.setBackground(new Color(255, 255, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblNewLabel.setBounds(156, 114, 146, 50);
        lblNewLabel.setForeground(Color.WHITE); // Establecer el color de fuente en blanco
        add(lblNewLabel);
		

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
				long tiempoDeActivacion = System.currentTimeMillis() + 1500; // TENGO QUE CAMBIARLO A 3000 cuando este todo listo
	               while (System.currentTimeMillis() < tiempoDeActivacion) {// Espera activa para pausar la ejecución durante 3 segundos.
	               }
				f.cambiarPanel(1);// Llama al método cambiarPanel(1) del objeto FramePrincipal.

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