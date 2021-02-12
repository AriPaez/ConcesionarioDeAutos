package vista;

 
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import controlador.ControlSecretario;

public class Secretario extends JFrame {
	
	private JButton registrarCliente;
	private JButton registrarMecanico ;
	private JButton registrarAutoViejo ;
	private JButton registrarAutoNuevo;
	
	public Secretario() {
		
		getContentPane().setLayout(null);
		
		JPanel laminaPrincipal = new JPanel();
		setSize(500,500);
		setLocationRelativeTo(null);
		setResizable(false);
		laminaPrincipal.setBounds(0, 0, 484, 461);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		menuBar.setBounds(0, 0, 134, 22);
		laminaPrincipal.add(menuBar);
		
		JMenu compraAuto = new JMenu("VENTA");
		menuBar.add(compraAuto);
		
		JMenuItem autoViejo = new JMenuItem("Auto viejo");
		compraAuto.add(autoViejo);
		
		JMenuItem autoNuevo = new JMenuItem("Auto nuevo");
		compraAuto.add(autoNuevo);
		
		JMenu reparacion = new JMenu("REPARACI\u00D3N");
		menuBar.add(reparacion);
		
		JMenuItem registrarReparacion = new JMenuItem("Registrar");
		reparacion.add(registrarReparacion);
		 
		
		
		JLabel labelRegistrarCliente = new JLabel("REGISTRAR CLIENTE");
		labelRegistrarCliente.setForeground(Color.BLACK);
		labelRegistrarCliente.setFont(new Font("Arial", Font.BOLD, 15));
		labelRegistrarCliente.setBackground(Color.GRAY);
		labelRegistrarCliente.setBounds(309, 369, 165, 43);
		laminaPrincipal.add(labelRegistrarCliente);
		
		registrarCliente = new JButton("");
		registrarCliente.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\ventanaSecretario\\registrarCliente.png"));
		registrarCliente.setBounds(323, 254, 120, 120);
		laminaPrincipal.add(registrarCliente);
		
		JLabel labelRegistrarMecanico = new JLabel("REGISTRAR MEC\u00C1NICO");
		labelRegistrarMecanico.setForeground(Color.BLACK);
		labelRegistrarMecanico.setFont(new Font("Arial", Font.BOLD, 15));
		labelRegistrarMecanico.setBackground(Color.GRAY);
		labelRegistrarMecanico.setBounds(10, 369, 191, 43);
		laminaPrincipal.add(labelRegistrarMecanico);
		
		registrarMecanico = new JButton("");
		registrarMecanico.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\ventanaSecretario\\mecanico.png"));
		registrarMecanico.setBounds(50, 254, 120, 120);
		laminaPrincipal.add(registrarMecanico);
		
		JLabel labelRegistrarViejoAuto = new JLabel("REGISTRAR AUTO VIEJO");
		labelRegistrarViejoAuto.setForeground(Color.BLACK);
		labelRegistrarViejoAuto.setFont(new Font("Arial", Font.BOLD, 15));
		labelRegistrarViejoAuto.setBackground(Color.GRAY);
		labelRegistrarViejoAuto.setBounds(283, 171, 191, 43);
		laminaPrincipal.add(labelRegistrarViejoAuto);
		
		registrarAutoViejo = new JButton("");
		registrarAutoViejo.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\ventanaSecretario\\autoViejo.png"));
		registrarAutoViejo.setBounds(323, 56, 120, 120);
		laminaPrincipal.add(registrarAutoViejo);
		
		JLabel labelRegistrarNuevoAuto = new JLabel("REGISTRAR AUTO NUEVO");
		labelRegistrarNuevoAuto.setBackground(Color.GRAY);
		labelRegistrarNuevoAuto.setForeground(Color.BLACK);
		labelRegistrarNuevoAuto.setFont(new Font("Arial", Font.BOLD, 15));
		labelRegistrarNuevoAuto.setBounds(10, 171, 191, 43);
		laminaPrincipal.add(labelRegistrarNuevoAuto);
		
		registrarAutoNuevo = new JButton("");
		registrarAutoNuevo.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\ventanaSecretario\\autoNuevo.png"));
		registrarAutoNuevo.setBounds(50, 56, 120, 120);
		laminaPrincipal.add(registrarAutoNuevo);
		
		JLabel fondoPrincipal = new JLabel();
		fondoPrincipal.setBounds(0, 0, 484, 461);
		fondoPrincipal.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\ventanaSecretario\\fondoSecretario.jpg"));
		laminaPrincipal.add(fondoPrincipal);
		
		
		
	 
		
		ControlSecretario cS=new ControlSecretario(this);
		
		//Eventos de botones.
		this.registrarAutoNuevo.addActionListener(cS);
		this.registrarAutoViejo.addActionListener(cS);
		this.registrarCliente.addActionListener(cS);
		this.registrarMecanico.addActionListener(cS);
	}

	public JButton getRegistrarCliente() {
		return registrarCliente;
	}

	public JButton getRegistrarMecanico() {
		return registrarMecanico;
	}

	public JButton getRegistrarAutoViejo() {
		return registrarAutoViejo;
	}

	public JButton getRegistrarAutoNuevo() {
		return registrarAutoNuevo;
	}
}
