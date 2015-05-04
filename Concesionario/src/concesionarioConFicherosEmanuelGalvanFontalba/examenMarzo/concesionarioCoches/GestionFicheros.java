package concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.regex.Pattern;

public class GestionFicheros {
	public static void guardar(Object object, File archivo)throws IOException {
		File archivoNuevo = archivo;
		try (ObjectOutputStream escrituraObjeto = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(archivoNuevo)));) {
			escrituraObjeto.writeObject(object);
		}
	}

	public static Object abrir(File archivo) throws ClassNotFoundException, IOException {
		File archivoNuevo = archivo;
		try (ObjectInputStream lecturaObjeto = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(archivo)))) {
			return lecturaObjeto.readObject();
		}
	}
	
	private static boolean extensionValida(String archivoName){
		return archivoName.contains(".obj");
	}
}
