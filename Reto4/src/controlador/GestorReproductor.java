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
	public Clip cancionencurso;
	public int reproduciendo;
	public boolean repro = false;
	/*
	 * 
	 * 
	 * falta el menu para añadir a la playlist
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
			repro = true;

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

	public void siguiente(Cancion cancion, ArrayList<Cancion> canciones) {
		if (repro == true) {
			cancionencurso.stop();
			cancionencurso.close();
		}
		// añadir anuncios
		if (reproduciendo < canciones.size()) {
			reproduciendo++;
			cancion.setNombreAudio(canciones.get(reproduciendo).getNombreAudio());
			// cambiar imagen
		} else {
			reproduciendo = 0;
			cancion.setNombreAudio(canciones.get(reproduciendo).getNombreAudio());
		}

	}

	public void atras(ArrayList<Cancion> canciones, Cliente cliente, Cancion cancion) {
		if (repro = true && cliente.getTipoCliente().equals("premium")) {
			cancionencurso.stop();
			cancionencurso.close();
		}
		if (reproduciendo > 0 && cliente.getTipoCliente().equals("premium")) {
			reproduciendo--;
			cancion.setNombreAudio(canciones.get(reproduciendo).getNombreAudio());
			// cambiar imagen
		} else if (cliente.getTipoCliente().equals("premium")) {
			reproduciendo = canciones.size();
			cancion.setNombreAudio(canciones.get(reproduciendo).getNombreAudio());
		}
	}
}
