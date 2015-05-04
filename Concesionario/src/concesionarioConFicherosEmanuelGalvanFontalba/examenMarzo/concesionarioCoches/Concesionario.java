package concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches;

import java.io.Serializable;
import java.util.ArrayList;

/*
 * No pueden existir dos coches con la misma matrícula en el almacén del concesinario
 * no puede añadirse un coche al concecionario con alguno de sus atributos inválidos. Han de conocerse todas sus características 
 * Ninguno de los valores puede ser por defecto
 */
/**
 * El nombre del concesionario es "IES Gran Capitán".
 * 
 * Lógicamente, no podrá añadirse un coche inválido glmacén del concesinario)
 * 
 * Han de conocerse todas sus características Ninguno de los valores puede ser
 * por defecto
 * 
 * @author Emanuel Galván Fontalba
 * 
 */
public class Concesionario implements Serializable {
	/**
	 * colección de coches. No puede tener null
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	private final String nombre = "IES Gran Capitán";

	public void annadir(String matricula, Color color, Modelo modelo) throws Exception{ //throws MatriculaInvalidaException, ColorInvalidoException, ModeloInvalidException, ExisteElCocheException {
		Coche coche = new Coche(matricula, color, modelo);
		if (almacen.contains(coche))
			throw new CocheYaExisteException("El coche ya está en el almacen");
		almacen.add(coche);
	}

	public void eliminar(String matricula) throws MatriculaInvalidaException, CocheNoExisteException{
		if(almacen.remove(new Coche(matricula)))
			return;
		else throw new CocheNoExisteException("El coche no existe");
	}

	
	public int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el Coche del almacén indicado por la matrícula
	 * 
	 * @param matricula
	 *            Matrícula a buscar
	 * @return Coche contenido en el almacén. null si no existe
	 * @throws MatriculaInvalidaException Matricula invalida
	 * @throws CocheNoExisteException 
	 */
	public Coche get(String matricula) throws MatriculaInvalidaException, CocheNoExisteException{
		Coche coche = new Coche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		throw new CocheNoExisteException("El coche no existe");
	}
	
	public Coche get(int position){
		return almacen.get(position);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}
