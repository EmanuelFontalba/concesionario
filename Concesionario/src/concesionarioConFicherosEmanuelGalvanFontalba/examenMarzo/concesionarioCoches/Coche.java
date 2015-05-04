package concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches;

import java.io.Serializable;
import java.util.regex.Pattern;
/**
 * Clase coche el cual tiene matr&iacute;cula, color y modelo.
 *
 * @author Emanuel Galv&aacute;n Fontalba
 * @version 1.0
 */

public class Coche implements Serializable {
	private String matricula;
	private Color color;
	private Modelo modelo;
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");
	
	/**
	 * Constructor de la clase.
	 * @param matricula Matr&iacute;cula del coche.
	 * @param color Color del coche.
	 * @param modelo Modelo del coche.
	 * @throws MatriculaInvalidaException Matricula invalida
	 * @throws ColorInvalidoException Color no escogido
	 * @throws ModeloInvalidException Modelo no escogido
	 */
	
	Coche(String matricula, Color color, Modelo modelo) throws MatriculaInvalidaException, ColorInvalidoException, ModeloInvalidException{
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}
	
	/**
	 * Constructor de la clase solo con el campo matr&iacute;cula.
	 * @param matricula Matr&iacute;cula del coche.
	 * @throws MatriculaInvalidaException Matricula invalida
	 */
	
	Coche(String matricula) throws MatriculaInvalidaException {
		setMatricula(matricula);
	}
	
	/**
	 * Comprueba si la matr&iacute;cula es v&aaccute;lida.
	 * 
	 * @param matricula Matr&iacute;cula a comprobar.
	 * @return Devuelve true si la matr&iacute;cula es v&aaccute;lida. Devuelve false en el caso contrario.
	 */
	
	private static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}
	
	/**
	 * Modifica el campo matr&iacute;cula.
	 * @param matricula Modificacion del campo.
	 * @throws MatriculaInvalidaException Si la matricula es invalida.
	 */
	private void setMatricula(String matricula) throws MatriculaInvalidaException {
		if(esValida(matricula))
			this.matricula = matricula;
		else throw new MatriculaInvalidaException("Matricula no valida");
	}
	
	/**
	 * 
	 * @return Devuelve el campo color.
	 */
	public Color getColor() {
		return color;
	}
	
	/**
	 * Modifica el campo color.
	 * @param color Modificiacion del campo.
	 * @throws ColorInvalidoException Si el color no ha sido escogido
	 */
	private void setColor(Color color) throws ColorInvalidoException {
		if(color!=null)
			this.color = color;
		else throw new ColorInvalidoException("El color no ha sido escogido");
	}
	
	/**
	 * Modifica el campo modelo.
	 * @param modelo Modificacion del campo.
	 * @throws ModeloInvalidException Modelo no escogido
	 */
	private void setModelo(Modelo modelo) throws ModeloInvalidException {
		if(modelo!=null)
			this.modelo = modelo;
		else throw new ModeloInvalidException("El modelo no ha sido escogido");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/**
	 * Comprueba si dos coches son iguales en funci&oacute;n de su matr&iacute;cula.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/**
	 * Devuelve una cadena describiendo la clase.
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

	public Modelo getModelo() {
		return this.modelo;
	}
	
	public String getMatricula(){
		return this.matricula;
	}

}
