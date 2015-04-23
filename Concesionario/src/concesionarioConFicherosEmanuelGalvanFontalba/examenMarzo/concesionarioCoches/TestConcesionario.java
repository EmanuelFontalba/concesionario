package concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches;

import java.io.IOException;

import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.Color;
import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.Modelo;
import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.utiles.Menu;
import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.utiles.Teclado;

/**
 * Queremos modelar un concesionario de coches en Java. Nos limitaremos a las
 * siguientes opciones: Añadir un coche (se pedirá matricula, color y modelo),
 * Eliminar un coche (por matrícula), mostrar un coche (por matrícula), mostrar
 * coches (todo el concesionario)
 * 
 * @author Emanuel Galvan Fontalba
 * @deprecated
 */
public class TestConcesionario{
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color","Ficheros", "Salir" });
	private static Menu menuColores = new Menu("Colores de los coches",
			Color.generarOpcionesMenu());
	private static Menu menuModelos = new Menu("Modelos de los coches",
			Modelo.generarOpcionesMenu());
	static Concesionario concesionario = new Concesionario();//otro conc vacio
	static String ultimoNombre="";//
	static boolean guardado=false;//false

	public static void main(String[] args) {
		do {
			switch (menu.gestionar()) {
			case 1:// "Añadir Coche
				annadirCoche();
				break;
			case 2:// Eliminar Coche
				eliminarCoche();
				break;
			case 3:// Obtener Coche
				getCoche();
				break;
			case 4:// Mostrar lista
				System.out.println(concesionario);
				break;
			case 5:// Contar coches
				System.out.println("Número de coches en el concesionario: "
						+ concesionario.size());
				break;
			case 6:// Mostrar coches de un color
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;
			case 7:
				manejoFicheros();
				break;
			default:// Salir
				System.out.println("Aaaaaaaaaaaaaaaaaaaaadios");
				return;
			}
		} while (true);
	}

	private static void manejoFicheros() {
		Menu menuFicheros = new Menu("Archivo", new String[] {
			"Nuevo", "Abrir", "Guardar", "Guardar como", "Salir" });
		String nombreActual="";
		switch (menuFicheros.gestionar()) {
		case 1:
			if(modificarCambios()){
				concesionario=new Concesionario();
				guardado=false;
				ultimoNombre="";
				break;
			}
			if(quieresGuardar()){
				if(guardado)
					try {
						if(modificarCambios()){
							GestionFicheros.guardar(concesionario,ultimoNombre);
						}
					} catch (IOException e1) {
						System.out.println(e1);
					}
				else
					try {
						ultimoNombre=Teclado.leerCadena("Introduce el nombre del archivo");
						GestionFicheros.guardar(concesionario, ultimoNombre);
						guardado=true;
					} catch (IOException e1) {
						System.out.println(e1);
					}
				if(quieresCrear()){
					concesionario=new Concesionario();
					guardado=false;
					ultimoNombre="";
					break;
				}
				break;
			}
			break;
		case 2:
			try {
				ultimoNombre=Teclado.leerCadena("Introduce el nombre del archivo");
				concesionario=(Concesionario)GestionFicheros.abrir(ultimoNombre);
				System.out.println("El concesionario se ha abierto con exito");
				guardado=true;
			} catch (ClassNotFoundException | IOException e1) {
				System.out.println(e1);
				System.err.println("El concesionario no se ha podido abrir");
			}
			break;
		case 3:
			if(guardado)
				try {
					if(modificarCambios()){
						GestionFicheros.guardar(concesionario,ultimoNombre);
					}
				} catch (IOException e1) {
					System.out.println(e1);
				}
			else
				try {
					ultimoNombre=Teclado.leerCadena("Introduce el nombre del archivo");
					GestionFicheros.guardar(concesionario, ultimoNombre);
					guardado=true;
				} catch (IOException e1) {
					System.out.println(e1);
				}
			break;
		case 4:
			try {
				nombreActual=Teclado.leerCadena("Introduce el nombre del archivo");
				if(ultimoNombre.equals(nombreActual))
					if(modificarCambios()){
						GestionFicheros.guardar(concesionario,ultimoNombre);
						guardado=true;
					}else break;
				else{
					ultimoNombre=nombreActual;
					GestionFicheros.guardar(concesionario, nombreActual);
					guardado=true;
				}
			} catch (IOException e) {
				System.out.println(e);
			}
			break;
		default:
			break;
		}
	}
	private static boolean quieresCrear() {
		char decision;

		do{
		System.out.println("¿Quieres crear ahora un archivo nuevo? s= continuar, n= salir");
		decision=Teclado.leerCaracter();
		if((decision=='s')||(decision=='S'))
			return (true);
		else
			if((decision=='n')||(decision=='N'))
				return (false);
			else
				System.out.println("ERROR, no existe esa opciÃ³n");
		}while(true);
	}
	
	private static boolean quieresGuardar() {
		char decision;

		do{
		System.out.println("¿Quieres guardar los el concesionario anterior? s= continuar, n= salir");
		decision=Teclado.leerCaracter();
		if((decision=='s')||(decision=='S'))
			return (true);
		else
			if((decision=='n')||(decision=='N'))
				return (false);
			else
				System.out.println("ERROR, no existe esa opciÃ³n");
		}while(true);
	}
	
	private static boolean modificarCambios() {
		char decision;

		do{
		System.out.println("Se va a perder información. ¿Quieres continuar? s= continuar, n= salir");
		decision=Teclado.leerCaracter();
		if((decision=='s')||(decision=='S'))
			return (true);
		else
			if((decision=='n')||(decision=='N'))
				return (false);
			else
				System.out.println("ERROR, no existe esa opciÃ³n");
		}while(true);
	}

	private static void getCoche() {
		Coche coche;
		try {
			coche = concesionario.get(Teclado
					.leerCadena("Introduce la matrícula"));
			System.out.println(coche);
		} catch (CocheNoExisteException |MatriculaInvalidaException e) {
			System.out.println(e);
		}
	}

	private static void eliminarCoche() {
		try {
			concesionario.eliminar(Teclado.leerCadena("Introduce la matrícula"));
			System.out.println("Coche eliminado");
		} catch (MatriculaInvalidaException|CocheNoExisteException e) {
			System.out.println(e);
		}

	}

	private static void annadirCoche() {
		try {
			concesionario.annadir(Teclado.leerCadena("Introduce la matrícula"),
					pedirColor(), pedirModelo());
			System.out.println("Coche añadido con éxito");
		} catch (Exception e) {
			System.out.println(e);
		}	
	}

	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionar();
		Modelo[] arrModelos = Modelo.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}

	private static Color pedirColor() {
		int opcion = menuColores.gestionar();
		Color[] arrColores = Color.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}
}
