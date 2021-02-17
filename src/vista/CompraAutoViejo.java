package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controlador.ControlCompraAuto;

public class CompraAutoViejo extends JFrame {
	
	private JTable tabla;
	private JTextField marcaCompra;
	private JTextField modeloCompra;
	private JTextField colorCompra;
	private JTextField dniCliente;
	private JButton comprar;
	private JButton cancelar; 
	private JLabel fotoAuto ;
	private JComboBox modelo ;
	private JComboBox marca;
	
	public CompraAutoViejo() {
	
getContentPane().setLayout(null);
		
		JPanel laminaPrincipal = new JPanel();
		setSize(690,530);
		setLocationRelativeTo(null);
		setResizable(false);
		laminaPrincipal.setBounds(0, 0, 674, 491);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		
		
		Label labelMarca = new Label("MARCA");
		labelMarca.setFont(new Font("Arial", Font.BOLD, 12));
		labelMarca.setBounds(24, 22, 56, 22);
		laminaPrincipal.add(labelMarca);
		
		 
		Label labelModelo = new Label("MODELO");
		labelModelo.setFont(new Font("Arial", Font.BOLD, 12));
		labelModelo.setBounds(24, 58, 56, 22);
		laminaPrincipal.add(labelModelo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 122, 360, 211);
		laminaPrincipal.add(scrollPane);
		
		tabla = new JTable();
		scrollPane.setViewportView(tabla);
		
		Label labelTituloTabla = new Label("VENTA DE AUTOS");
		labelTituloTabla.setFont(new Font("Arial", Font.BOLD, 12));
		labelTituloTabla.setBounds(24, 99, 104, 22);
		laminaPrincipal.add(labelTituloTabla);
		
		Label labelMarcaCompra = new Label("MARCA");
		labelMarcaCompra.setFont(new Font("Arial", Font.BOLD, 12));
		labelMarcaCompra.setBounds(61, 388, 56, 22);
		laminaPrincipal.add(labelMarcaCompra);
		
		Label labelModeloCompra = new Label("MODELO");
		labelModeloCompra.setFont(new Font("Arial", Font.BOLD, 12));
		labelModeloCompra.setBounds(224, 388, 56, 22);
		laminaPrincipal.add(labelModeloCompra);
		
		Label labelColorCompra = new Label("COLOR");
		labelColorCompra.setFont(new Font("Arial", Font.BOLD, 12));
		labelColorCompra.setBounds(380, 388, 56, 22);
		laminaPrincipal.add(labelColorCompra);
		
		marcaCompra = new JTextField();
		marcaCompra.setEditable(false);
		marcaCompra.setColumns(10);
		marcaCompra.setBounds(24, 416, 145, 20);
		laminaPrincipal.add(marcaCompra);
		
		modeloCompra = new JTextField();
		modeloCompra.setEditable(false);
		modeloCompra.setColumns(10);
		modeloCompra.setBounds(197, 416, 119, 20);
		laminaPrincipal.add(modeloCompra);
		
		colorCompra = new JTextField();
		colorCompra.setEditable(false);
		colorCompra.setColumns(10);
		colorCompra.setBounds(367, 416, 80, 20);
		laminaPrincipal.add(colorCompra);
		
		comprar = new JButton("COMPRAR");
		comprar.setFont(new Font("Arial", Font.BOLD, 12));
		comprar.setBounds(159, 457, 119, 23);
		laminaPrincipal.add(comprar);
		
		cancelar = new JButton("CANCELAR");
		cancelar.setFont(new Font("Arial", Font.BOLD, 12));
		cancelar.setBounds(441, 457, 119, 23);
		laminaPrincipal.add(cancelar);
		
		Label labelCompra = new Label("COMPRA AUTO");
		labelCompra.setFont(new Font("Arial", Font.BOLD, 12));
		labelCompra.setBounds(314, 360, 104, 22);
		laminaPrincipal.add(labelCompra);
		
		JSeparator separator = new JSeparator();
		separator.setToolTipText("COMPRA AUTO");
		separator.setBounds(24, 351, 640, 8);
		laminaPrincipal.add(separator);
		
		fotoAuto = new JLabel("");
		fotoAuto.setBounds(409, 122, 255, 213);
		laminaPrincipal.add(fotoAuto);
		
		Label labelFotoAuto = new Label("IMAGEN");
		labelFotoAuto.setFont(new Font("Arial", Font.BOLD, 12));
		labelFotoAuto.setBounds(409, 94, 56, 22);
		laminaPrincipal.add(labelFotoAuto);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(409, 331, 255, 8);
		laminaPrincipal.add(separator_1);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1.setBounds(409, 122, 11, 208);
		laminaPrincipal.add(separator_1_1);
		
		JSeparator separator_1_1_1 = new JSeparator();
		separator_1_1_1.setOrientation(SwingConstants.VERTICAL);
		separator_1_1_1.setBounds(662, 122, 2, 208);
		laminaPrincipal.add(separator_1_1_1);
		
		JSeparator separator_1_2 = new JSeparator();
		separator_1_2.setBounds(409, 119, 255, 2);
		laminaPrincipal.add(separator_1_2);
		
		Label labelDniCliente = new Label("DNI CLIENTE");
		labelDniCliente.setFont(new Font("Arial", Font.BOLD, 12));
		labelDniCliente.setBounds(480, 388, 80, 22);
		laminaPrincipal.add(labelDniCliente);
		
		dniCliente = new JTextField();
		dniCliente.setColumns(10);
		dniCliente.setBounds(480, 416, 80, 20);
		laminaPrincipal.add(dniCliente);
		
		marca = new JComboBox();
		marca.setBounds(84, 25, 145, 22);
		laminaPrincipal.add(marca);
		
		modelo = new JComboBox();
		modelo.setBounds(84, 58, 145, 22);
		laminaPrincipal.add(modelo);
		
		ControlCompraAuto cCA=new ControlCompraAuto(this);
		//Evento botones.
		this.cancelar.addActionListener(cCA);
		this.comprar.addActionListener(cCA);
	
		//Evento ventana.
		this.addWindowListener(cCA);
		
		//Evento JComoboBox
		this.marca.addItemListener(cCA);
		this.modelo.addItemListener(cCA);
		
		//Evento tabla.
		this.tabla.addMouseListener(cCA);
		
	}

	public JComboBox getMarca() {
		return marca;
	}


	public JTable getTabla() {
		return tabla;
	}


	public String getMarcaCompra() {
		return marcaCompra.getText();
	}


	public String getModeloCompra() {
		return modeloCompra.getText();
	}


	public String getColorCompra() {
		return colorCompra.getText();
	}


	public String getDniCliente() {
		return dniCliente.getText();
	}


	public JButton getComprar() {
		return comprar;
	}

	public JButton getCancelar() {
		return cancelar;
	}
	
	
	public JLabel getFotoAuto() {
		return fotoAuto;
	}
 
	public JComboBox getModelo() {
		return modelo;
	}


	public void setMarcaCompra(String marcaCompra) {
		this.marcaCompra.setText(marcaCompra);
	}


	public void setModeloCompra(String modeloCompra) {
		this.modeloCompra.setText(modeloCompra);
	}


	public void setColorCompra(String colorCompra) {
		this.colorCompra.setText(colorCompra);
	}
	
	
	 

}
