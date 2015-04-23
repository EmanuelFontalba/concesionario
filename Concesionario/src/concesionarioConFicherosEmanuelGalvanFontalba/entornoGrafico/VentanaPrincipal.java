package concesionarioConFicherosEmanuelGalvanFontalba.entornoGrafico;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal {

	private JFrame frmConcesionarioDeCoches;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal();
					window.frmConcesionarioDeCoches.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConcesionarioDeCoches = new JFrame();
		frmConcesionarioDeCoches.setTitle("Concesionario de coches");
		frmConcesionarioDeCoches.setBounds(100, 100, 450, 300);
		frmConcesionarioDeCoches.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmConcesionarioDeCoches.setJMenuBar(menuBar);
		
		JMenu archivo = new JMenu("Archivo");
		menuBar.add(archivo);
		
		JMenuItem archivoNuevo = new JMenuItem("Nuevo");
		archivo.add(archivoNuevo);
		
		JMenuItem archivoAbrir = new JMenuItem("Abrir");
		archivo.add(archivoAbrir);
		
		JMenuItem archivoGuardar = new JMenuItem("Guardar");
		archivo.add(archivoGuardar);
		
		JMenuItem archivoGuardarComo = new JMenuItem("Guardar como ...");
		archivo.add(archivoGuardarComo);
		frmConcesionarioDeCoches.getContentPane().setLayout(null);
		
		JButton altaCoche = new JButton("Alta coche");
		altaCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		altaCoche.setBounds(10, 11, 112, 23);
		frmConcesionarioDeCoches.getContentPane().add(altaCoche);
		
		JButton bajaCoche = new JButton("Baja coche");
		bajaCoche.setBounds(132, 11, 112, 23);
		frmConcesionarioDeCoches.getContentPane().add(bajaCoche);
		
		JButton mostrarCoche = new JButton("Mostrar coche");
		mostrarCoche.setBounds(254, 11, 170, 23);
		frmConcesionarioDeCoches.getContentPane().add(mostrarCoche);
		
		JButton contarCoches = new JButton("Contar coches");
		contarCoches.setBounds(10, 80, 189, 23);
		frmConcesionarioDeCoches.getContentPane().add(contarCoches);
		
		JButton cochesDeUnColor = new JButton("Mostrar coches de un color");
		cochesDeUnColor.setBounds(209, 80, 215, 23);
		frmConcesionarioDeCoches.getContentPane().add(cochesDeUnColor);
		
		JButton mostrarConcesionario = new JButton("Mostrar concesionario");
		mostrarConcesionario.setBounds(10, 152, 414, 78);
		frmConcesionarioDeCoches.getContentPane().add(mostrarConcesionario);
	}
}
