package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.ControlRegistroAuto;
import javax.swing.ImageIcon;

public class RegistroAutoViejo extends JFrame {
	 
	private JTextField marca;
	private JTextField modelo;
	private JTextField color;
	private JButton registrarAutoViejo;
	private JButton cancelar;
	private JTextField cantidadKm;
	private JTextField matricula;
	private JTextField dniDuenioAnterior;
	private JButton buscarImagenAuto ;
	private String rutaDeImagen;
	
	public RegistroAutoViejo() {
		
		getContentPane().setLayout(null);
		
		JPanel laminaPrincipal = new JPanel();
		setSize(315,460);
		setLocationRelativeTo(null);
		laminaPrincipal.setBounds(0, 0, 299, 421);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel labelRegistroAutoViejo = new JLabel("REGISTRO AUTO VIEJO");
		labelRegistroAutoViejo.setFont(new Font("Arial", Font.BOLD, 18));
		labelRegistroAutoViejo.setBounds(38, 11, 231, 32);
		laminaPrincipal.add(labelRegistroAutoViejo);
		
		JLabel labelMarca = new JLabel("MARCA");
		labelMarca.setFont(new Font("Arial", Font.BOLD, 12));
		labelMarca.setBounds(31, 54, 84, 20);
		laminaPrincipal.add(labelMarca);
		
		JLabel labelModelo = new JLabel("MODELO");
		labelModelo.setFont(new Font("Arial", Font.BOLD, 12));
		labelModelo.setBounds(31, 104, 84, 20);
		laminaPrincipal.add(labelModelo);
		
		JLabel labelColor = new JLabel("COLOR");
		labelColor.setFont(new Font("Arial", Font.BOLD, 12));
		labelColor.setBounds(31, 151, 84, 20);
		laminaPrincipal.add(labelColor);
		
		marca = new JTextField();
		marca.setColumns(10);
		marca.setBounds(160, 54, 129, 20);
		laminaPrincipal.add(marca);
		
		modelo = new JTextField();
		modelo.setColumns(10);
		modelo.setBounds(160, 104, 129, 20);
		laminaPrincipal.add(modelo);
		
		color = new JTextField();
		color.setColumns(10);
		color.setBounds(160, 151, 129, 20);
		laminaPrincipal.add(color);
		
		registrarAutoViejo = new JButton("REGISTRAR");
		registrarAutoViejo.setBounds(10, 387, 121, 23);
		laminaPrincipal.add(registrarAutoViejo);
		
		cancelar = new JButton("CANCELAR");
		cancelar.setBounds(158, 387, 121, 23);
		laminaPrincipal.add(cancelar);
		
		JLabel labelKM = new JLabel("KM");
		labelKM.setFont(new Font("Arial", Font.BOLD, 12));
		labelKM.setBounds(31, 250, 84, 20);
		laminaPrincipal.add(labelKM);
		
		cantidadKm = new JTextField();
		cantidadKm.setColumns(10);
		cantidadKm.setBounds(160, 250, 129, 20);
		laminaPrincipal.add(cantidadKm);
		
		JLabel labelMatricula = new JLabel("MATRICULA");
		labelMatricula.setFont(new Font("Arial", Font.BOLD, 12));
		labelMatricula.setBounds(31, 200, 84, 20);
		laminaPrincipal.add(labelMatricula);
		
		matricula = new JTextField();
		matricula.setColumns(10);
		matricula.setBounds(160, 200, 129, 20);
		laminaPrincipal.add(matricula);
		
		JLabel labelDniDuenioAnterior = new JLabel("DNI DUE\u00D1O ANTERIOR");
		labelDniDuenioAnterior.setFont(new Font("Arial", Font.BOLD, 12));
		labelDniDuenioAnterior.setBounds(31, 299, 129, 20);
		laminaPrincipal.add(labelDniDuenioAnterior);
		
		dniDuenioAnterior = new JTextField();
		dniDuenioAnterior.setColumns(10);
		dniDuenioAnterior.setBounds(160, 299, 129, 20);
		laminaPrincipal.add(dniDuenioAnterior);
		
		JLabel labelImagenAuto = new JLabel("IMAGEN AUTO");
		labelImagenAuto.setFont(new Font("Arial", Font.BOLD, 12));
		labelImagenAuto.setBounds(31, 345, 84, 20);
		laminaPrincipal.add(labelImagenAuto);
		
		buscarImagenAuto = new JButton("");
		buscarImagenAuto.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\registroAuto\\buscar.jpg"));
		buscarImagenAuto.setBounds(160, 342, 20, 20);
		laminaPrincipal.add(buscarImagenAuto);
		
		ControlRegistroAuto cAN=new ControlRegistroAuto(this);
		
		
		//Eventos botones.
		this.registrarAutoViejo.addActionListener(cAN);
		this.cancelar.addActionListener(cAN);
		this.buscarImagenAuto.addActionListener(cAN);
		
	}

	public JButton getRegistrarAutoViejo() {
		return registrarAutoViejo;
	}

	public JButton getCancelar() {
		return cancelar;
	}
 
	public String getMarca() {
		return marca.getText();
	}

	public String getModelo() {
		return modelo.getText();
	}

	public String getColor() {
		return color.getText();
	}

	public Float getCantidadKm() {
		
		if(this.cantidadKm.getText()!="")
		{
			return Float.parseFloat(cantidadKm.getText());
			
		}
		
		return (float) 0.0;
	}

	public String getMatricula() {
		return matricula.getText();
	}

	public String getDniDuenioAnterior() {
		return dniDuenioAnterior.getText();
	}
	
	
	public void setMarca(String marca) {
		this.marca.setText(marca);;
	}

	public void setModelo(String modelo) {
		this.modelo.setText(modelo);
	}
	
	public void setColor(String color) {
		this.color.setText(color);
	}
 
	public void setCantidadKm(String cantidadKm) {
		this.cantidadKm.setText(cantidadKm);
	}

	public void setMatricula(String matricula) {
		this.matricula.setText(matricula);
	}

	public void setDniDuenioAnterior(String dniDuenioAnterior) {
		this.dniDuenioAnterior.setText(dniDuenioAnterior);
	}
	 
	public JButton getBuscarImagenAuto() {
		return buscarImagenAuto;
	}
	
	public String getRutaDeImagen() {
		return rutaDeImagen;
	}

	public void setRutaDeImagen(String rutaDeImagen) {
		this.rutaDeImagen = rutaDeImagen;
	}

}
