package controlador;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import modelo.Cancion;
import modelo.Cliente;

public class GestorReproductor {
	private Clip cancionencurso;
	public int reproduciendo;
	/*
	 * 
	 * 
	 * falta
	 * el
	 * menu
	 * para
	 * añadir
	 * a
	 * la 
	 * playlist
	 * 
	 * 
	 * 
	 */

	public void play(Cancion cancion, ArrayList<Cancion> canciones) {
		try {
			cancionencurso = AudioSystem.getClip();
			cancionencurso.open(AudioSystem
					.getAudioInputStream(new File("audios/" + canciones.get(reproduciendo).getIdAudio() + ".wav")));
			cancionencurso.start();

		} catch (UnsupportedAudioFileException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (LineUnavailableException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void stop() {
		cancionencurso.stop();
		cancionencurso.close();
	}

	public void siguiente(ArrayList<Cancion> canciones) {
		// añadir anuncios
		if (reproduciendo < canciones.size()) {
			reproduciendo++;
			//cambiar imagen
		} else {
			reproduciendo = 0;
		}

	}

	public void atras(ArrayList<Cancion> canciones, Cliente cliente) {
		if (reproduciendo > 0) {
			reproduciendo--;
			//cambiar imagen
		} else if (cliente.getTipoCliente().equals("premium"))
			reproduciendo = canciones.size();
	}

}
