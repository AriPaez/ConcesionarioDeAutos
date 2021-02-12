package vista;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.RegistroClienteYMecanico;

public class RegistroCliente extends JFrame {
	
	private JTextField dni;
	private JTextField primerNombre;
	private JTextField segundoNombre;
	private JTextField apellido;
	private JTextField direccion;
	private JTextField telefono;
	private JButton registrar;
	private JButton cancelar ;
	
	public RegistroCliente()
	{
		getContentPane().setLayout(null);
		
		JPanel laminaPrincipal = new JPanel();
		setSize(315,423);
		setLocationRelativeTo(null);
		laminaPrincipal.setBounds(0, 0, 299, 411);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		JLabel labelRegistroCliente = new JLabel("REGISTRO CLIENTE");
		labelRegistroCliente.setFont(new Font("Arial", Font.BOLD, 18));
		labelRegistroCliente.setBounds(59, 11, 182, 32);
		laminaPrincipal.add(labelRegistroCliente);
		
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
		labelPrimerNombre.setBounds(31, 104, 108, 20);
		laminaPrincipal.add(labelPrimerNombre);
		
		primerNombre = new JTextField();
		primerNombre.setColumns(10);
		primerNombre.setBounds(160, 104, 129, 20);
		laminaPrincipal.add(primerNombre);
		
		JLabel labelSegundoNombre = new JLabel("SEGUNDO NOMBRE");
		labelSegundoNombre.setFont(new Font("Arial", Font.BOLD, 12));
		labelSegundoNombre.setBounds(31, 151, 119, 20);
		laminaPrincipal.add(labelSegundoNombre);
		
		segundoNombre = new JTextField();
		segundoNombre.setColumns(10);
		segundoNombre.setBounds(160, 151, 129, 20);
		laminaPrincipal.add(segundoNombre);
		
		JLabel labelApellido = new JLabel("APELLIDO");
		labelApellido.setFont(new Font("Arial", Font.BOLD, 12));
		labelApellido.setBounds(31, 203, 84, 20);
		laminaPrincipal.add(labelApellido);
		
		apellido = new JTextField();
		apellido.setColumns(10);
		apellido.setBounds(160, 203, 129, 20);
		laminaPrincipal.add(apellido);
		
		JLabel labelDireccion = new JLabel("DIRECCI\u00D3N");
		labelDireccion.setFont(new Font("Arial", Font.BOLD, 12));
		labelDireccion.setBounds(31, 251, 84, 20);
		laminaPrincipal.add(labelDireccion);
		
		direccion = new JTextField();
		direccion.setColumns(10);
		direccion.setBounds(160, 251, 129, 20);
		laminaPrincipal.add(direccion);
		
		JLabel labelTelefono = new JLabel("TEL\u00C9FONO");
		labelTelefono.setFont(new Font("Arial", Font.BOLD, 12));
		labelTelefono.setBounds(31, 301, 84, 20);
		laminaPrincipal.add(labelTelefono);
		
		telefono = new JTextField();
		telefono.setColumns(10);
		telefono.setBounds(160, 301, 129, 20);
		laminaPrincipal.add(telefono);
		
		registrar = new JButton("REGISTRAR");
		registrar.setBounds(23, 352, 113, 23);
		laminaPrincipal.add(registrar);
		
		cancelar = new JButton("CANCELAR");
		cancelar.setBounds(168, 352, 108, 23);
		laminaPrincipal.add(cancelar);
		
		RegistroClienteYMecanico cRP=new RegistroClienteYMecanico(this);
		
		//Eventos botones.
		this.registrar.addActionListener(cRP);
		this.cancelar.addActionListener(cRP);
		
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

	public String getDireccion() {
		return direccion.getText();
	}

	public void setDireccion(String direccion) {
		this.direccion.setText(direccion);
	}

	public String getTelefono() {
		return telefono.getText();
	}

	public void setTelefono(String telefono) {
		this.telefono.setText(telefono);
	}

	public JButton getRegistrar() {
		return registrar;
	}

	public JButton getCancelar() {
		return cancelar;
	}
	
	
}
