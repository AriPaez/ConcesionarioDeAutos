package vista;

import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controlador.RegistroClienteYMecanico;

public class RegistroMecanico extends JFrame {

	private JTextField dni;
	 
	private JTextField primerNombre;
	private JTextField segundoNombre;
	private JTextField apellido;
	 
	private JButton registrar;
	private JButton cancelar ;
	private JDateChooser fechaContrato=null;
	private JTextField idTaller;
	private JTextField salario;
	
	public RegistroMecanico() 
	{

		getContentPane().setLayout(null);
		
		JPanel laminaPrincipal = new JPanel();
		setSize(315,460);
		setLocationRelativeTo(null);
		laminaPrincipal.setBounds(0, 0, 299, 421);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		JLabel labelRegistroMecanico = new JLabel("REGISTRO M\u00C9CANICO");
		labelRegistroMecanico.setFont(new Font("Arial", Font.BOLD, 18));
		labelRegistroMecanico.setBounds(59, 11, 217, 32);
		laminaPrincipal.add(labelRegistroMecanico);
		
		JLabel labelDni = new JLabel("DNI");
		labelDni.setFont(new Font("Arial", Font.BOLD, 12));
		labelDni.setBounds(31, 54, 84, 20);
		laminaPrincipal.add(labelDni);
		
		dni = new JTextField();
		dni.setColumns(10);
		dni.setBounds(160, 54, 129, 20);
		laminaPrincipal.add(dni);
		
		JLabel labelPrimerNombre = new JLabel("PRIMER NOMBRE");
		labelPrimerNombre.setFont(new Font("Arial", Font.BOLD, 12));
		labelPrimerNombre.setBounds(31, 144, 108, 20);
		laminaPrincipal.add(labelPrimerNombre);
		
		primerNombre = new JTextField();
		primerNombre.setColumns(10);
		primerNombre.setBounds(160, 144, 129, 20);
		laminaPrincipal.add(primerNombre);
		
		JLabel labelSegundoNombre = new JLabel("SEGUNDO NOMBRE");
		labelSegundoNombre.setFont(new Font("Arial", Font.BOLD, 12));
		labelSegundoNombre.setBounds(31, 191, 119, 20);
		laminaPrincipal.add(labelSegundoNombre);
		
		segundoNombre = new JTextField();
		segundoNombre.setColumns(10);
		segundoNombre.setBounds(160, 191, 129, 20);
		laminaPrincipal.add(segundoNombre);
		
		JLabel labelApellido = new JLabel("APELLIDO");
		labelApellido.setFont(new Font("Arial", Font.BOLD, 12));
		labelApellido.setBounds(31, 241, 84, 20);
		laminaPrincipal.add(labelApellido);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(160, 241, 129, 20);
		laminaPrincipal.add(apellido);
	
		
		registrar = new JButton("REGISTRAR");
		registrar.setBounds(23, 376, 113, 23);
		laminaPrincipal.add(registrar);
		
		cancelar = new JButton("CANCELAR");
		cancelar.setBounds(168, 376, 108, 23);
		laminaPrincipal.add(cancelar);
		
		JLabel labelCodigoTaller = new JLabel("C\u00D3DIGO TALLER");
		labelCodigoTaller.setFont(new Font("Arial", Font.BOLD, 12));
		labelCodigoTaller.setBounds(31, 96, 119, 20);
		laminaPrincipal.add(labelCodigoTaller);
		
	 
		
		JLabel labelFechaContratacion = new JLabel("FECHA CONTRATO");
		labelFechaContratacion.setFont(new Font("Arial", Font.BOLD, 12));
		labelFechaContratacion.setBounds(31, 284, 129, 20);
		laminaPrincipal.add(labelFechaContratacion);
		
		fechaContrato = new JDateChooser();
		fechaContrato.setBounds(160, 284, 129, 20);
		laminaPrincipal.add(fechaContrato);
		
		idTaller = new JTextField();
		idTaller.setBounds(160, 96, 129, 20);
		laminaPrincipal.add(idTaller);
		idTaller.setColumns(10);
		
		JLabel labelSalario = new JLabel("SALARIO");
		labelSalario.setFont(new Font("Arial", Font.BOLD, 12));
		labelSalario.setBounds(31, 323, 84, 20);
		laminaPrincipal.add(labelSalario);
		
		salario = new JTextField();
		salario.setColumns(10);
		salario.setBounds(160, 323, 129, 20);
		laminaPrincipal.add(salario);
		
		RegistroClienteYMecanico rCM=new RegistroClienteYMecanico(this);
		//Eventos botones.
		this.registrar.addActionListener(rCM);
		this.cancelar.addActionListener(rCM);
	}
	
	
	public String getDni() {
		return dni.getText();
	}

	public void setDni(String dni) {
		this.dni.setText(dni);
	}

	public String getPrimerNombre() {
		return primerNombre.getText();
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre.setText(primerNombre);
	}

	public String getSegundoNombre() {
		return segundoNombre.getText();
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre.setText(segundoNombre);
	}

	public String getApellido() {
		return apellido.getText();
	}

	public void setApellido(String apellido) {
		this.apellido.setText(apellido);
	}

	public JButton getRegistrar() {
		return registrar;
	}

	public JButton getCancelar() {
		return cancelar;
	}


	public String getIdTaller() {
		return idTaller.getText();
	}


	public void setIdTaller(String idTaller) {
		this.idTaller.setText(idTaller);;
	}


	public Float getSalario() {
		
		if(salario!=null)
		{
			 
			return Float.parseFloat(this.salario.getText());
		}
		
		return (float) 0;
	}
	
	public void setSalario(String salario)
	{
		if(salario==null)
		{
			this.salario.setText(salario);
		}
	}
 
	public Date getFechaContrato() {
		
		 return this.fechaContrato.getDate();
	}
}
