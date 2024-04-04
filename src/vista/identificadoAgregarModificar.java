package vista;

import dao.ProfesionesDAO;


import dao.LugaresDeDetencionDAO;
import javax.swing.JPanel;

import javax.swing.JRadioButton;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

import modelo.CCDTyE;
import modelo.Fuerzas;
import modelo.Identificado;
import modelo.LugarDeDetencion;
import modelo.Profesion;
import modelo.Testigo;
import dao.CCDTyEDAO;
import dao.FuerzasDAO;
import dao.IdentificadosDAO;
import dao.TestigosDAO;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class identificadoAgregarModificar extends JPanel {
	private JTextField textFieldNombre;
	private JTextField textFieldDNI;
	private JTextField textFieldUltimaVez;
	private JTextField textFieldBiografia;
	private JTextField textFieldAudiovisual;
	private JLabel agregadoModificado;
	//private final ButtonGroup buttonGroup = new ButtonGroup();
	private Identificado identificado = null;
	private int DNIoriginal = 0;
	private JComboBox comboUno;
	private JComboBox comboDos;

	/**
	 * Create the panel.
	 */
	public identificadoAgregarModificar() {
		setBackground(new Color(0, 0, 28));
		setLayout(null);
		setBounds(0,0,600,400);
		JLabel nombre = new JLabel("Nombre completo:");
		nombre.setForeground(new Color(255, 255, 255));
		nombre.setBounds(86, 46, 96, 14);
		add(nombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(178, 43, 86, 20);
		add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel dni = new JLabel("DNI :");
		dni.setForeground(new Color(255, 255, 255));
		dni.setBounds(86, 97, 46, 14);
		add(dni);
		
		textFieldDNI = new JTextField();
		textFieldDNI.setBounds(178, 94, 86, 20);
		add(textFieldDNI);
		textFieldDNI.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("¿Cuando fue visto por ult. vez?");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(24, 184, 158, 14);
		add(lblNewLabel);
		
		textFieldUltimaVez = new JTextField();
		textFieldUltimaVez.setBounds(178, 181, 86, 20);
		add(textFieldUltimaVez);
		textFieldUltimaVez.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Agregar biografía");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(86, 143, 86, 14);
		add(lblNewLabel_1);
		
		textFieldBiografia = new JTextField();
		textFieldBiografia.setBounds(178, 140, 86, 20);
		add(textFieldBiografia);
		textFieldBiografia.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Adjuntar material audiovisual.");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(24, 230, 148, 14);
		add(lblNewLabel_2);
		
		textFieldAudiovisual = new JTextField();
		textFieldAudiovisual.setBounds(178, 227, 86, 20);
		add(textFieldAudiovisual);
		textFieldAudiovisual.setColumns(10);
		
		
		JButton bAtras = new JButton("<--- Atras");
		bAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((Component) e.getSource());
				marco.setContentPane(new desaparecidoTipoAgregarModificar());
				marco.validate();
			}
		});
		JLabel lblNewLabel_3 = new JLabel("¿Cual es su profesion?");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(289, 46, 126, 14);
		add(lblNewLabel_3);
		
		comboUno = new JComboBox();
		comboUno.setBounds(432, 42, 86, 22);
		agregarProfesionesComboBox(comboUno);
		add(comboUno);
		
		JLabel lblNewLabel_4 = new JLabel("Lugar de su secuestro");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(289, 97, 176, 14);
		add(lblNewLabel_4);
		
		comboDos = new JComboBox();
		comboDos.setBounds(432, 93, 88, 22);
		agregarLugaresComboBox(comboDos);
		add(comboDos);
		bAtras.setBounds(32, 270, 104, 38);
		add(bAtras);
		JLabel lblNewLabel_5 = new JLabel("Seleccionar centro");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setBounds(289, 143, 126, 14);
		add(lblNewLabel_5);
		
		JComboBox comboTres = new JComboBox();
		agregarCentrosComboBox(comboTres);
		comboTres.setBounds(432, 143, 86, 22);
		add(comboTres);
		
		
		JButton bSiguiente = new JButton("Siguiente -->");
		bSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IdentificadosDAO identificadodao = new IdentificadosDAO();
				if(esModificacion()) {
					identificado.setNombreDetenido(textFieldNombre.getText());
					identificado.setDniDetenido(Integer.valueOf(textFieldDNI.getText()));
					if(textFieldBiografia.getText()!= " ")
					{
						identificado.setBiografia(textFieldBiografia.getText());
					}
					else 
					{
						identificado.setBiografia(null);
					}
					identificado.setFechaUltimaVezVisto(LocalDate.parse(textFieldUltimaVez.getText().toString()));
					identificado.setMaterialAudiovisual(textFieldAudiovisual.getText());
						Profesion prof = new Profesion();
						String profesionSeleccionada = comboUno.getSelectedItem().toString();
						prof.setNombre(profesionSeleccionada);
					identificado.setProfesionDetenido(prof);
					
						LugarDeDetencion ls = new LugarDeDetencion();
						String lugarSeleccionado = comboDos.getSelectedItem().toString();
						ls.setNombreLugar(lugarSeleccionado);
					identificado.setLugarDetenido(ls);
					
					CCDTyE cen = new CCDTyE();
					String centroSeleccionado = comboTres.getSelectedItem().toString();
					cen.setNombre_centro(centroSeleccionado);
					identificado.añadirCentro(cen);
					identificadodao.modificarIdentificado(identificado, identificado.getDniDetenido());
					
					Testigo tes = new Testigo();
					String testigoSeleccionado = comboDos.getSelectedItem().toString();
					tes.setNombreCompleto(testigoSeleccionado);
				identificado.setTestigoDelDetenido(tes);

					
			}else {
				Identificado nuevoIdentificado = new Identificado();
				//setear valores al nuevo centro
				nuevoIdentificado.setNombreDetenido(textFieldNombre.getText());
				nuevoIdentificado.setDniDetenido(Integer.valueOf(textFieldDNI.getText()));
				if(textFieldBiografia.getText() == "")
				{
					nuevoIdentificado.setBiografia(null);
				}
				else 
				{
					nuevoIdentificado.setBiografia(textFieldBiografia.getText());
				}
				nuevoIdentificado.setFechaUltimaVezVisto(LocalDate.parse(textFieldUltimaVez.getText()));
				nuevoIdentificado.setMaterialAudiovisual(textFieldAudiovisual.getText());
				LugarDeDetencion ls = new LugarDeDetencion();
					String lugarSeleccionado = comboDos.getSelectedItem().toString();
					ls.setNombreLugar(lugarSeleccionado);
				nuevoIdentificado.setLugarDetenido(ls);
				
				Profesion prof = new Profesion();
					String profesionSeleccionada = comboUno.getSelectedItem().toString();
					prof.setNombre(profesionSeleccionada);;
				nuevoIdentificado.setProfesionDetenido(prof);
					
				CCDTyE cen = new CCDTyE();
				String centroSeleccionado = comboTres.getSelectedItem().toString();
				cen.setNombre_centro(centroSeleccionado);
				nuevoIdentificado.añadirCentro(cen);
				
				identificadodao.agregarIdentificado(nuevoIdentificado);
				agregadoModificado = new JLabel("Nuevo desaparecido agregado exitosamente");
				agregadoModificado.setForeground(new Color(255, 255, 255));
				agregadoModificado.setBounds(373, 308, 158, 14);
				add(agregadoModificado);
				
				Testigo tes = new Testigo();
				String testigoSeleccionado = comboDos.getSelectedItem().toString();
				tes.setNombreCompleto(testigoSeleccionado);
				nuevoIdentificado.setTestigoDelDetenido(tes);
			
				JFrame marco = (JFrame) SwingUtilities.getWindowAncestor((JComponent) e.getSource());
				revalidate();
				repaint();
				marco.validate();
		}}
	});
		bSiguiente.setBounds(448, 270, 115, 38);
		add(bSiguiente);
	}
		
	public void agregarProfesionesComboBox(JComboBox comboBox)
	{
		ProfesionesDAO pdao = new ProfesionesDAO();
		ArrayList<Profesion> profesiones = pdao.traerTodos();
		comboBox.addItem("Vacio");
		for(Profesion p  : profesiones) {
			comboBox.addItem(p.getNombre());
		}
	}
	
	public void agregarLugaresComboBox(JComboBox comboBox)
	{
		LugaresDeDetencionDAO ldao = new LugaresDeDetencionDAO();
		ArrayList<LugarDeDetencion> lugares = ldao.traerTodos();
		comboBox.addItem("Vacio");
		for(LugarDeDetencion l : lugares) {
			comboBox.addItem(l.getNombreLugar());
		}
	
	}
	
	public void agregarCentrosComboBox(JComboBox comboBox)
	{
		CCDTyEDAO cdao = new CCDTyEDAO();
		ArrayList<CCDTyE> centros = cdao.traerTodos();
		comboBox.addItem("Vacio");
		for(CCDTyE c : centros) {
			comboBox.addItem(c.getNombre_centro());
		}
	
	}
	
	public boolean esModificacion()
	{
		if(identificado == null)
		{
			return false;
		}
		return true;
	}
	public identificadoAgregarModificar(Identificado i) 
	{
		this();//trae el constructor anterior
		identificado = i;//el entro q recibe es igual al que declaramos null
		//se escrube lo puesto en los textfields
		textFieldDNI.setText(String.valueOf(identificado.getDniDetenido()));
		textFieldNombre.setText(identificado.getNombreDetenido());
		textFieldBiografia.setText(identificado.getBiografia());
		textFieldUltimaVez.setText(identificado.getFechaUltimaVezVisto().toString());
		textFieldAudiovisual.setText(identificado.getMaterialAudiovisual());
		ProfesionesDAO pdao = new ProfesionesDAO();
		ArrayList<Profesion> profesiones = pdao.traerTodos();
		for(Profesion p : profesiones)
		{
			System.out.println(identificado.getProfesionDetenido().getNombre());
			if(p.getNombre().equals(identificado.getProfesionDetenido().getNombre()))
			{
				comboUno.setSelectedItem(p.getNombre());
			}
		}
		LugaresDeDetencionDAO ldao = new LugaresDeDetencionDAO();
		ArrayList<LugarDeDetencion> lugares = ldao.traerTodos();
		for(LugarDeDetencion l : lugares)
		{
			if(l.getNombreLugar().equals(identificado.getLugarDetenido().getNombreLugar()))
			{
				comboDos.setSelectedItem(l.getNombreLugar());
			}
		}
		CCDTyEDAO cdao = new CCDTyEDAO();
		ArrayList<CCDTyE> centros = cdao.traerTodos();
		for(CCDTyE c : centros)
		{
			if(c.getNombre_centro().equals(identificado.getLugarDetenido().getNombreLugar()))
			{
				comboDos.setSelectedItem(c.getNombre_centro());
			}
		}
	}
	}