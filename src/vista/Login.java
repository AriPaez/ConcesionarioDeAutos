package vista;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {
	private JTextField dni;
	private JPasswordField password;
	private JButton registrarse;
	private JButton login;
	
	public Login() 
	{
		getContentPane().setLayout(null); 
		setSize(380,344);
		setResizable(false);
		setLocationRelativeTo(null);
		JPanel laminaPrincipal = new JPanel();
		laminaPrincipal.setBounds(0, 0, 380, 400);
		getContentPane().add(laminaPrincipal);
		laminaPrincipal.setLayout(null);
		
		registrarse = new JButton("REGISTRARSE");
		registrarse.setBackground(Color.GRAY);
		registrarse.setForeground(Color.WHITE);
		registrarse.setBounds(134, 278, 117, 23);
		laminaPrincipal.add(registrarse);
		
		JLabel labelRegistro = new JLabel("\u00BFNo tiene cuenta?");
		labelRegistro.setForeground(Color.WHITE);
		labelRegistro.setBounds(144, 253, 128, 14);
		laminaPrincipal.add(labelRegistro);
		
		login = new JButton("LOGIN");
		login.setBackground(Color.GRAY);
		login.setForeground(Color.WHITE);
		login.setBounds(144, 225, 89, 23);
		laminaPrincipal.add(login);
		
		password = new JPasswordField();
		password.setBounds(182, 180, 154, 20);
		laminaPrincipal.add(password);
		
		dni = new JTextField();
		dni.setBounds(182, 133, 155, 20);
		laminaPrincipal.add(dni);
		dni.setColumns(10);
		
		JLabel labelPass = new JLabel("PASSWORD");
		labelPass.setForeground(Color.WHITE);
		labelPass.setFont(new Font("Arial", Font.BOLD, 15));
		labelPass.setBackground(Color.BLACK);
		labelPass.setBounds(52, 186, 110, 14);
		laminaPrincipal.add(labelPass);
		
		JLabel labeldniUsuario = new JLabel("DNI USUARIO");
		labeldniUsuario.setForeground(Color.WHITE);
		labeldniUsuario.setBackground(Color.BLACK);
		labeldniUsuario.setFont(new Font("Arial", Font.BOLD, 15));
		labeldniUsuario.setBounds(52, 139, 110, 14);
		laminaPrincipal.add(labeldniUsuario);
		
		JLabel loginUsuario = new JLabel("");
		loginUsuario.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\login\\loginUsuario.png"));
		loginUsuario.setBounds(151, 22, 100, 100);
		laminaPrincipal.add(loginUsuario);
		
		JLabel fondoPrincipal = new JLabel();
		fondoPrincipal.setBounds(0, 0, 370, 304);
		fondoPrincipal.setIcon(new ImageIcon("C:\\Users\\ArielPaez\\Desktop\\proyectosJava\\concesionarioDeAuto\\ConcesionarioDeAutos\\src\\icon\\login\\fondoLogin.jpg"));
		laminaPrincipal.add(fondoPrincipal);
		
		JLabel label = new JLabel("DNI USUARIO");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.BOLD, 15));
		label.setBackground(Color.BLACK);
		label.setBounds(39, 228, 110, 14);
		laminaPrincipal.add(label);
	
	}

	public String getDni() {
		return dni.getText();
	}

	public void setDni(String dni) {
		this.dni.setText(dni);;
	}

	public String getPassword() {
		
		char[] arrayC = this.password.getPassword();
		return  new String(arrayC);
		
	}

	public void setPassword(String password) {
		this.password.setText(password);
	}

	public JButton getRegistrarse() {
		return registrarse;
	}

	public JButton getLogin() {
		return login;
	}
	
	
	
}
