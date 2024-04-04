package vista;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import modelo.Testigo;
import dao.TestigosDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Font;

public class testigoAgregarModificar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreCompleto;
	private JTextField textFieldDNI;
	private JTextField textFieldTestimonio;
	private JLabel agregadoModificado;
	private Testigo testigo = null; 
	private int dniOriginal = 0;
	/**
	 * Create the panel.
	 */
	public testigoAgregarModificar() {
		setBackground(new Color(0, 0, 28));
		setLayout(null);
		setBounds(0,0,600,400);
		JLabel lblNewLabel = new JLabel("Nombre Completo:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(114, 67, 156, 14);
		add(lblNewLabel);
		
		textFieldNombreCompleto = new JTextField();
		textFieldNombreCompleto.setBounds(273, 65, 99, 20);
		add(textFieldNombreCompleto);
		textFieldNombreCompleto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("DNI:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(114, 115, 46, 14);
		add(lblNewLabel_1);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(273, 113, 99, 20);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Agregar Testimonio:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(114, 159, 167, 14);
		add(lblNewLabel_2);
		
		textFieldTestimonio = new JTextField();
		textFieldTestimonio.setBounds(273, 157, 99, 20);
		add(textFieldTestimonio);
		textFieldTestimonio.setColumns(10);
		
		
		JButton bListo = new JButton("SIGUIENTE");
		bListo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TestigosDAO tDAO = new TestigosDAO();
					if(esModificacion()) {
						System.out.println(esModificacion());
						testigo.setDniTestigo(Integer.valueOf(textFieldDNI.getText()));
						testigo.setNombreCompleto(textFieldNombreCompleto.getText());
						testigo.setTestimonio(textFieldTestimonio.getText());
						
						tDAO.modificarTestigo(testigo, dniOriginal);
					} else {	
					System.out.println(esModificacion());
					Testigo nuevoTestigo = new Testigo();
					nuevoTestigo.setDniTestigo(Integer.valueOf(textFieldDNI.getText()));
					nuevoTestigo.setNombreCompleto(textFieldNombreCompleto.getText());
					nuevoTestigo.setTestimonio(textFieldTestimonio.getText());
					
					/*int dni = Integer.parseInt(textFieldDNI.getText());
					String nombreCompleto = textFieldNombreCompleto.getText();
					String testigo = textFieldTestimonio.getText();
					
					Testigos t = new Testigos();
					t.setDniTestigo(dni);
					t.setNombreCompleto(nombreCompleto);
					t.setTestimonio(testigo);
					tDAO.agregarTestigo(t);
					*/
					tDAO.agregarTestigo(nuevoTestigo);
					
					agregadoModificado = new JLabel("Testigo agregado exitosamente");
					agregadoModificado.setForeground(new Color(255, 255, 255));
					agregadoModificado.setBounds(152, 186, 127, 14);
							add(agregadoModificado);
							JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent)e.getSource());
							revalidate();
							repaint();
							marco.validate();
						}
					
					int dniTestigo = Integer.parseInt(textFieldDNI.getText());
					String nombreCompleto = textFieldNombreCompleto.getText();
					String testigo = textFieldTestimonio.getText();
					
					Testigo t = new Testigo();
					t.setNombreCompleto(nombreCompleto);
					t.setTestimonio(testigo);
					
					tDAO.modificarTestigo(t, dniTestigo);
					
					
					agregadoModificado = new JLabel("Testigo modificado exitosamente");
					agregadoModificado.setForeground(new Color(255, 255, 255));
					agregadoModificado.setBounds(152, 186, 127, 14);
					add(agregadoModificado);
					JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent)e.getSource());
					revalidate();
					repaint();
					marco.validate();
				}
		});
		bListo.setBounds(382, 260, 133, 47);
		add(bListo);
		JButton bAtras = new JButton("ATRAS");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
					marco.setContentPane(new testigoEliminarConsultar());
					marco.validate();
			}
		});
		bAtras.setBounds(114, 260, 133, 47);
		add(bAtras);
		
		
	}
	
	public testigoAgregarModificar(Testigo t) {
		this();
		testigo = t;
		dniOriginal = testigo.getDniTestigo();
		textFieldNombreCompleto.setText(testigo.getNombreCompleto());
		textFieldTestimonio.setText(testigo.getTestimonio());
		
	}
	
	public boolean esModificacion()
	{
		if(testigo == null)
		{
			return false;
		}
		return true;
	}
}
