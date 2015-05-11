package concesionarioConFicherosEmanuelGalvanFontalba.entornoGrafico;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.Coche;
import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.Concesionario;
import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.GestionFicheros;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class VentanaPrincipal {
	
	static Concesionario concesionario = new Concesionario();
	static File archivoElegido;
	static boolean guardado=false;
	static boolean modificado = false;
	private JFrame frmConcesionarioDeCoches;
	private Component contentPane;
	
	static ArrayList<Coche> concesionarioDeUnColor = new ArrayList<Coche>();
	private static Component parentComponent;

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
		if(archivoElegido!=null)
			frmConcesionarioDeCoches.setTitle("Concesionario de coches. - "+ archivoElegido.getName());
		else
			frmConcesionarioDeCoches.setTitle("Concesionario de coches. - Sin título");
		frmConcesionarioDeCoches.setBounds(100, 100, 450, 300);
		frmConcesionarioDeCoches.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frmConcesionarioDeCoches.setJMenuBar(menuBar);
		
		JMenu archivo = new JMenu("Ficheros");
		archivo.setMnemonic('F');
		menuBar.add(archivo);
		
		JMenuItem archivoNuevo = new JMenuItem("Nuevo");
		archivoNuevo.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				if(modificado){
					Nuevo nuevo = new Nuevo();
					nuevo.setVisible(true);
					archivoElegido=null;
				}
				else{
					concesionario=new Concesionario();
					guardado=false;
					modificado=false;
					archivoElegido=null;
					JOptionPane.showMessageDialog(parentComponent, "Concesionario creado con éxito");
				}
				if(archivoElegido!=null)
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - "+ archivoElegido.getName());
				else
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - Sin título");

			}
		});
		archivoNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, InputEvent.CTRL_MASK));
		archivo.add(archivoNuevo);
		
		JMenuItem archivoAbrir = new JMenuItem("Abrir");
		archivoAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		archivoAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Abrir menuAbrir= new Abrir();
					if(archivoElegido==null)
						return;
					concesionario=(Concesionario)GestionFicheros.abrir(archivoElegido);
					guardado=true;
					modificado = false;
				} catch (ClassNotFoundException | IOException e1) {
					JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
				}
				if(archivoElegido!=null)
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - "+ archivoElegido.getName());
				else
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - Sin título");
			}
		});
		archivo.add(archivoAbrir);
		
		JMenuItem archivoGuardar = new JMenuItem("Guardar");
		archivoGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(guardado)
					if(modificado)
						try {
							if(modificarCambios() == JOptionPane.YES_OPTION){
								GestionFicheros.guardar(concesionario,archivoElegido);
								modificado = false;
							}
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
					else
						try {
							GestionFicheros.guardar(concesionario,archivoElegido);
							modificado=false;
						} catch (IOException e1) {
							JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
						}
				else
					try {
						GuardarComo menuGuardarComo = new GuardarComo();
						if(archivoElegido==null)
							return;
						GestionFicheros.guardar(concesionario,archivoElegido);
						guardado=true;
						modificado = false;
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(contentPane, e1.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				if(archivoElegido!=null)
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - "+ archivoElegido.getName());
				else
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - Sin título");
			}
		});
		archivoGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		archivo.add(archivoGuardar);
		
		JMenuItem archivoGuardarComo = new JMenuItem("Guardar como ...");
		archivoGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		archivoGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					GuardarComo menuGuardarComo = new GuardarComo();
					if(archivoElegido==null)
						return;
					GestionFicheros.guardar(concesionario,archivoElegido);
					guardado=true;
					modificado = false;
				} catch (IOException e) {
					System.out.println(e);
				}
				if(archivoElegido!=null)
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - "+ archivoElegido.getName());
				else
					frmConcesionarioDeCoches.setTitle("Concesionario de coches. - Sin título");
			}
		});
		archivo.add(archivoGuardarComo);
		
		JMenu concesionarioMenu = new JMenu("Coches");
		concesionarioMenu.setMnemonic('C');
		menuBar.add(concesionarioMenu);
		
		JMenuItem annadirCoche = new JMenuItem("A\u00F1adir");
		annadirCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Annadir annadir = new Annadir();
				annadir.setVisible(true);
				modificado = true;
			}
		});
		annadirCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		concesionarioMenu.add(annadirCoche);
		
		JMenuItem eliminarCoche = new JMenuItem("Eliminar");
		eliminarCoche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eliminar eliminar = new Eliminar();
				eliminar.setVisible(true);
				modificado = true;
			}
		});
		eliminarCoche.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		concesionarioMenu.add(eliminarCoche);
		
		JMenu mnBuscar = new JMenu("Buscar");
		mnBuscar.setMnemonic('S');
		concesionarioMenu.add(mnBuscar);
		
		JMenuItem mntmPorMatrcula = new JMenuItem("Por matr\u00EDcula");
		mntmPorMatrcula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPorMatricula buscarPorMatricula= new BuscarPorMatricula();
				buscarPorMatricula.setVisible(true);
			}
		});
		mntmPorMatrcula.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mnBuscar.add(mntmPorMatrcula);
		
		JMenuItem mntmPorColor = new JMenuItem("Por color");
		mntmPorColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarPorColor buscarPorColor = new BuscarPorColor();
				buscarPorColor.setVisible(true);
			}
		});
		mntmPorColor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnBuscar.add(mntmPorColor);
		
		JMenuItem mntmMostrar = new JMenuItem("Mostrar todos");
		mntmMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(concesionario.size()<=0){
					JOptionPane.showMessageDialog(contentPane, "El concesionario está vacio", "ERROR", JOptionPane.ERROR_MESSAGE);
				}else{
				MostrarConcesionario mostrar = new MostrarConcesionario();
				mostrar.setVisible(true);
				}
			}
		});
		mntmMostrar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		concesionarioMenu.add(mntmMostrar);
		
		JMenuItem mntmContar = new JMenuItem("Contar");
		mntmContar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Contar contar = new Contar();
				contar.setVisible(true);
			}
		});
		mntmContar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		concesionarioMenu.add(mntmContar);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('A');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVerAyuda = new JMenuItem("Ver ayuda");
		mntmVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(parentComponent, "¿En serio necesitas ayuda para usar esto?!!!!", "Ayuda", JOptionPane.OK_OPTION);
			}
		});
		mnAyuda.add(mntmVerAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Acerca acerca = new Acerca();
				acerca.setVisible(true);
			}
		});
		mnAyuda.add(mntmAcercaDe);
		frmConcesionarioDeCoches.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Azahara\\git\\concesionario\\Concesionario\\650_1200.jpg"));
		lblNewLabel.setBounds(-80, -127, 562, 368);
		frmConcesionarioDeCoches.getContentPane().add(lblNewLabel);
	}

	protected int quieresCrear() {
		return JOptionPane.showConfirmDialog(parentComponent, "¿Quieres crear un nuevo concesionario ahora?", "Nuevo concesionario" , JOptionPane.YES_NO_OPTION);
	
	}

	public static Concesionario getConcesionario() {
		return concesionario;
	}
	
	private static int modificarCambios() {
		return JOptionPane.showConfirmDialog(parentComponent, "Se va a perder información. ¿Quieres continuar?", "Sobreescritura" , JOptionPane.YES_NO_OPTION);
	}
	
	private int quieresGuardar() {
		return JOptionPane.showConfirmDialog(parentComponent, "¿Quieres guardar el concesionario?", "Guardar" , JOptionPane.YES_NO_OPTION);
	
	}
}
