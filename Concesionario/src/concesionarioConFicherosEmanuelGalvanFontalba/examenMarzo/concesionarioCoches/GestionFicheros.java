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
				new BufferedOutputStream(new FileOutputStream(extensionValida(archivoNuevo))));) {
			escrituraObjeto.writeObject(object);
		}
	}

	public static Object abrir(File archivo) throws ClassNotFoundException, IOException {
		File archivoNuevo = archivo;
		try (ObjectInputStream lecturaObjeto = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(extensionValida(archivo))))) {
			return lecturaObjeto.readObject();
		}
	}
	
	private static File extensionValida(File archivo){
		if(archivo.getPath().endsWith(".obj"))
			return archivo;
		else
			return new File(archivo+".obj");
	}
}
