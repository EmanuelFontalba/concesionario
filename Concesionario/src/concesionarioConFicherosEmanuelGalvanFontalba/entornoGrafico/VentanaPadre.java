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

public class VentanaPadre extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField matricula;

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
		setBounds(100, 100, 195, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel etiquetaMatricula = new JLabel("Matr\u00EDcula: ");
		etiquetaMatricula.setBounds(10, 39, 73, 14);
		contentPanel.add(etiquetaMatricula);
		
		matricula = new JTextField();
		matricula.setBounds(74, 33, 86, 20);
		contentPanel.add(matricula);
		matricula.setColumns(10);
		
		JLabel etiquetaMarca = new JLabel("Marca: ");
		etiquetaMarca.setBounds(10, 81, 61, 14);
		contentPanel.add(etiquetaMarca);
		
		JComboBox comboBoxMarca = new JComboBox();
		comboBoxMarca.setBounds(74, 78, 86, 20);
		contentPanel.add(comboBoxMarca);
		
		JLabel etiquetaModelo = new JLabel("Modelo:");
		etiquetaModelo.setBounds(10, 126, 61, 14);
		contentPanel.add(etiquetaModelo);
		
		JComboBox comboBoxModelo = new JComboBox();
		comboBoxModelo.setBounds(74, 123, 86, 20);
		contentPanel.add(comboBoxModelo);
		
		JLabel etiquetaColor = new JLabel("Color:");
		etiquetaColor.setBounds(10, 173, 61, 14);
		contentPanel.add(etiquetaColor);
		
		JComboBox comboBoxColor = new JComboBox();
		comboBoxColor.setBounds(74, 170, 86, 20);
		contentPanel.add(comboBoxColor);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
