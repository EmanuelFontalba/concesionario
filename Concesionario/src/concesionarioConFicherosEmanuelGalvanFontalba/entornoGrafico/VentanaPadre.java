package concesionarioConFicherosEmanuelGalvanFontalba.entornoGrafico;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;

import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.Marca;
import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.Modelo;
import concesionarioConFicherosEmanuelGalvanFontalba.examenMarzo.concesionarioCoches.Color;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class VentanaPadre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextField matricula;
	final ButtonGroup buttonGroup = new ButtonGroup();
	JComboBox<Modelo> comboBoxModelo;
	JLabel etiquetaMatricula ;
	JLabel etiquetaMarca ;
	static JComboBox comboBoxMarca;
	JLabel etiquetaModelo;
	JPanel panel ;
	JRadioButton rdbtnPlata ;
	JRadioButton rdbtnAzul ;
	JRadioButton rdbtnRojo;
	JPanel buttonPane;
	JButton okButton;
	JButton cancelButton;
	static JButton buttonNext;
	static JButton buttonPrevious;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPadre dialog = new VentanaPadre();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPadre() {
		setResizable(false);
		setModal(true);
		setBounds(100, 100, 248, 330);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		etiquetaMatricula = new JLabel("Matr\u00EDcula: ");
		etiquetaMatricula.setBounds(10, 39, 73, 14);
		contentPanel.add(etiquetaMatricula);
		
		matricula = new JTextField();
		matricula.setBounds(74, 33, 86, 20);
		contentPanel.add(matricula);
		matricula.setColumns(10);
		
		etiquetaMarca = new JLabel("Marca: ");
		etiquetaMarca.setBounds(10, 81, 61, 14);
		contentPanel.add(etiquetaMarca);
		
		comboBoxMarca = new JComboBox();
		comboBoxMarca.setModel(new DefaultComboBoxModel(Marca.values()));
		comboBoxMarca.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));

			}
		});	
		comboBoxMarca.setBounds(74, 78, 86, 20);
		contentPanel.add(comboBoxMarca);
		
		etiquetaModelo = new JLabel("Modelo:");
		etiquetaModelo.setBounds(10, 126, 61, 14);
		contentPanel.add(etiquetaModelo);
		
		comboBoxModelo = new JComboBox<Modelo>();
		comboBoxModelo.setModel(new DefaultComboBoxModel(getModelo(comboBoxMarca)));
		comboBoxModelo.setBounds(74, 123, 86, 20);
		contentPanel.add(comboBoxModelo);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Colores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 151, 121, 97);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnPlata = new JRadioButton("Plata");
		rdbtnPlata.setBounds(6, 16, 109, 23);
		panel.add(rdbtnPlata);
		buttonGroup.add(rdbtnPlata);
		
		rdbtnAzul = new JRadioButton("Azul");
		rdbtnAzul.setBounds(6, 41, 109, 23);
		panel.add(rdbtnAzul);
		buttonGroup.add(rdbtnAzul);
		
		rdbtnRojo = new JRadioButton("Rojo");
		rdbtnRojo.setBounds(6, 67, 109, 23);
		panel.add(rdbtnRojo);
		buttonGroup.add(rdbtnRojo);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			
			buttonPrevious = new JButton("<");
			buttonPane.add(buttonPrevious);
			
			buttonNext = new JButton(">");
			buttonPane.add(buttonNext);
			{
				okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		
		

	}
	
	private Object[] getModelo(JComboBox comboBoxMarca){
		ArrayList arrayModelos = new ArrayList();

		for(Modelo mod: Modelo.getValues())
			if(mod.getMarca() == ((Marca)comboBoxMarca.getSelectedItem()))
				arrayModelos.add(mod);
				
		return arrayModelos.toArray();
	}

}
