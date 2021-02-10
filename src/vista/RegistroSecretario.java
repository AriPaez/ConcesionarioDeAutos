package vista;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
 

public class RegistroSecretario extends JFrame {
	private JTextField dni;
	private JPasswordField contrasenia;

	public RegistroSecretario()
	{
		getContentPane().setLayout(null);
		
		setSize(380,344);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 364, 305);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		contrasenia = new JPasswordField();
		contrasenia.setBounds(181, 159, 173, 20);
		laminaPrincipal.add(contrasenia);
		
		JButton labelCancelar = new JButton("CANCELAR");
		labelCancelar.setBackground(Color.GRAY);
		labelCancelar.setForeground(Color.WHITE);
		labelCancelar.setFont(new Font("Arial", Font.BOLD, 12));
		labelCancelar.setBounds(213, 257, 109, 23);
		laminaPrincipal.add(labelCancelar);
		
		JButton registrarse = new JButton("REGISTRARSE");
		registrarse.setBackground(Color.GRAY);
		registrarse.setForeground(Color.WHITE);
		registrarse.setFont(new Font("Arial", Font.BOLD, 12));
		registrarse.setBounds(47, 257, 135, 23);
		laminaPrincipal.add(registrarse);
		
		JLabel labelContrasenia = new JLabel("CONTRASE\u00D1A");
		labelContrasenia.setForeground(Color.WHITE);
		labelContrasenia.setFont(new Font("Arial", Font.BOLD, 20));
		labelContrasenia.setBounds(18, 156, 153, 20);
		laminaPrincipal.add(labelContrasenia);
		
		JLabel labelDNI = new JLabel("DNI");
		labelDNI.setFont(new Font("Arial", Font.BOLD, 20));
		labelDNI.setForeground(Color.WHITE);
		labelDNI.setBounds(120, 90, 40, 18);
		laminaPrincipal.add(labelDNI);
		
		dni = new JTextField();
		dni.setBounds(181, 92, 173, 20);
		 
		laminaPrincipal.add(dni);
		dni.setColumns(10);
		
		JLabel labelRegistro = new JLabel("REGISTRO");
		labelRegistro.setFont(new Font("Arial", Font.BOLD, 20));
		labelRegistro.setForeground(Color.WHITE);
		labelRegistro.setBounds(125, 11, 109, 32);
		laminaPrincipal.add(labelRegistro);
		
		JLabel fondoRegistro = new JLabel("");
		fondoRegistro.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\login\\fondoLogin.jpg"));
		fondoRegistro.setBounds(0, 0, 364, 305);
		laminaPrincipal.add(fondoRegistro);
		
	}
}
