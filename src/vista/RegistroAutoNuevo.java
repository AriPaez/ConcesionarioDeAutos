package vista;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlador.ControlRegistroAuto;
import modelo.BBDDAutos;

public class RegistroAutoNuevo extends JFrame {
	
	private JTextField marca;
	private JTextField modelo;
	private JTextField color;
	private JButton registrarAutoNuevo;
	private JButton cancelar;
	private JTextField cantidad;
	private JButton buscarImagenAuto ;
	private String rutaDeImagen;
	
	public RegistroAutoNuevo() {
		
		getContentPane().setLayout(null);
		
		JPanel laminaPrincipal = new JPanel();
		setSize(315,390);
		setLocationRelativeTo(null);
		laminaPrincipal.setBounds(0, 0, 299, 351);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JLabel labelRegistroAutoNuevo = new JLabel("REGISTRO AUTO NUEVO");
		labelRegistroAutoNuevo.setFont(new Font("Arial", Font.BOLD, 18));
		labelRegistroAutoNuevo.setBounds(38, 11, 231, 32);
		laminaPrincipal.add(labelRegistroAutoNuevo);
		
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
		
		registrarAutoNuevo = new JButton("REGISTRAR");
		registrarAutoNuevo.setBounds(20, 306, 121, 23);
		laminaPrincipal.add(registrarAutoNuevo);
		
		cancelar = new JButton("CANCELAR");
		cancelar.setBounds(168, 306, 121, 23);
		laminaPrincipal.add(cancelar);
		
		JLabel labelCantidad = new JLabel("CANTIDAD");
		labelCantidad.setFont(new Font("Arial", Font.BOLD, 12));
		labelCantidad.setBounds(31, 207, 84, 20);
		laminaPrincipal.add(labelCantidad);
		
		cantidad = new JTextField();
		cantidad.setColumns(10);
		cantidad.setBounds(160, 207, 129, 20);
		laminaPrincipal.add(cantidad);
		
		JLabel labelImagenAuto = new JLabel("IMAGEN AUTO");
		labelImagenAuto.setFont(new Font("Arial", Font.BOLD, 12));
		labelImagenAuto.setBounds(31, 256, 84, 20);
		laminaPrincipal.add(labelImagenAuto);
		
		buscarImagenAuto = new JButton("");
		buscarImagenAuto.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\registroAuto\\buscar.jpg"));
		buscarImagenAuto.setBounds(160, 253, 20, 20);
		laminaPrincipal.add(buscarImagenAuto);
		
		ControlRegistroAuto cAN=new ControlRegistroAuto(this);
		
		 
		//Eventos botones.
		this.registrarAutoNuevo.addActionListener(cAN);
		this.cancelar.addActionListener(cAN);
		this.buscarImagenAuto.addActionListener(cAN);
		
	}

	public JButton getRegistrarAutoNuevo() {
		return registrarAutoNuevo;
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
	
	public String getCantidad() {
		return cantidad.getText();
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
	
	public void setCantidad(String cantidad) {
		this.cantidad.setText(cantidad);
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
