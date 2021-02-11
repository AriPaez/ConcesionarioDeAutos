package vista;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controlador.ControlRegistroSecretario;
 

public class RegistroSecretario extends JFrame {
	
	private JTextField dni;
	private JPasswordField password;
	private JButton cancelar;
	private JButton registrarse;
	
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
		
		password = new JPasswordField();
		password.setBounds(181, 159, 173, 20);
		laminaPrincipal.add(password);
		
		cancelar = new JButton("CANCELAR");
		cancelar .setBackground(Color.GRAY);
		cancelar .setForeground(Color.WHITE);
		cancelar .setFont(new Font("Arial", Font.BOLD, 12));
		cancelar .setBounds(213, 257, 109, 23);
		laminaPrincipal.add(cancelar );
		
		registrarse = new JButton("REGISTRARSE");
		registrarse.setBackground(Color.GRAY);
		registrarse.setForeground(Color.WHITE);
		registrarse.setFont(new Font("Arial", Font.BOLD, 12));
		registrarse.setBounds(47, 257, 135, 23);
		laminaPrincipal.add(registrarse);
		
		JLabel labelPassword = new JLabel("CONTRASE\u00D1A");
		labelPassword.setForeground(Color.WHITE);
		labelPassword.setFont(new Font("Arial", Font.BOLD, 20));
		labelPassword.setBounds(18, 156, 153, 20);
		laminaPrincipal.add(labelPassword);
		
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
		
		ControlRegistroSecretario cS=new ControlRegistroSecretario(this);
		
		//Eventos botones.
		this.cancelar.addActionListener(cS);
		this.registrarse.addActionListener(cS);
		
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
		this.password.setText(password);;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	public void setCancelar(JButton cancelar) {
		this.cancelar = cancelar;
	}

	public JButton getRegistrarse() {
		return registrarse;
	}

	public void setRegistrarse(JButton registrarse) {
		this.registrarse = registrarse;
	}
 
}
