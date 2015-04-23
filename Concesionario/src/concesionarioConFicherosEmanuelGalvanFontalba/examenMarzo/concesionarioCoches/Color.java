package concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches;

/**
 * Colores disponibles.
 *
 * @author Emanuel Galv&aacute;n Fontalba
 * @version 1.0
 */
public enum Color {
	/**
	 * Color plata.
	 */
	PLATA, 
	/**
	 * Color rojo.
	 */
	ROJO, 
	/**
	 * Color azul.
	 */
	AZUL;

	private static final Color[] VALUES = Color.values();
	/**
	 * Genera las opciones para el men&uacute;.
	 * @return Devuelve las opciones del men&uacute;.
	 */
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
	
	/**
	 * @return Devuelve los valores de la enumeraci&oacute;n.
	 */
	public static Color[] getValues() {
		return VALUES;
	}

}
