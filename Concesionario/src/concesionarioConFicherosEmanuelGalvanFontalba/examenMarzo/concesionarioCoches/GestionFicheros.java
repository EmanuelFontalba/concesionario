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
	
	private Pattern patronExtension = Pattern.compile(".obj$");

	static void guardar(Object object, String archivoName)throws IOException {
		File archivo ;
		if(extensionValida(archivoName)){
			archivo = new File(archivoName);
		}
		else{
			archivo = new File(archivoName + ".obj");
		}
		try (ObjectOutputStream escrituraObjeto = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(archivo)));) {
			escrituraObjeto.writeObject(object);
		}
	}

	static Object abrir(String archivoName) throws ClassNotFoundException, IOException {
		File archivo ;
		if(extensionValida(archivoName))
			archivo = new File(archivoName);
		else
			archivo = new File(archivoName + ".obj");
		try (ObjectInputStream lecturaObjeto = new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(archivo)))) {
			return lecturaObjeto.readObject();
		}
	}
	
	private static boolean extensionValida(String archivoName){
		return archivoName.contains(".obj");
	}
}
