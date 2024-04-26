package ventanas;

import javax.swing.JFrame;

//import controlador.ControladorEntradaDatos;


public class FramePrincipal extends JFrame {

	//private ControladorEntradaDatos controlador = new ControladorEntradaDatos();
	
	public FramePrincipal() {
		
		setSize(460, 302);
		setVisible(true);
		setResizable(false);
		getContentPane().setLayout(null);
	}
	
	public void cambiarPanel(int i) {
		switch(i) {
		case 0: {
			setContentPane(new VentanaBienvenida(this));
				break;
				
		}
		case 1: {
			setContentPane(new VentanaLogin(this));

				break;
		}
		case 2: {
			setContentPane(new VentanaRegistro(this));
				break;
		}
		case 3: {
			setContentPane(new VentanaMenu(this, this.controlador));
				break;

		}
		case 4: {
			setContentPane(new PanelCinePelicula(this, this.controlador));
				break;
		}
		case 5: {
			setContentPane(new PanelSeleccionDeSesion(this, this.controlador));
				break;
		}

		case 6: {
		setContentPane(new PanelResumenCompra(this, this.controlador));
			break;
		}
		
		case 7: {
			setContentPane(new PanelFin(this));
				break;
		}
}
	}
	public static void main(String[] args) {
		FramePrincipal frame = new  FramePrincipal();
		frame.setContentPane(new VentanaBienvenida(frame));
		frame.cambiarPanel(0);
	}
}
