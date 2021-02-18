package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class RegistroTaller extends JFrame {
	
	private JTextField descripcionTaller;
	private JTextField codigoTaller;
	private JButton registrarTaller ;
	private JButton cancelar;
	
	 public RegistroTaller()
	 {
		 	JPanel laminaPrincipal = new JPanel();
			setSize(315,304);
			setLocationRelativeTo(null);
			laminaPrincipal.setBounds(0, 0, 299, 351);
			getContentPane().add(laminaPrincipal);
			laminaPrincipal.setLayout(null);
			
			JLabel labelRegistroTaller = new JLabel("REGISTRO TALLER");
			labelRegistroTaller.setFont(new Font("Arial", Font.BOLD, 18));
			labelRegistroTaller.setBounds(59, 11, 178, 32);
			laminaPrincipal.add(labelRegistroTaller);
			
			JLabel labelDescripcion = new JLabel("DESCRIPCI\u00D3N");
			labelDescripcion.setFont(new Font("Arial", Font.BOLD, 12));
			labelDescripcion.setBounds(20, 94, 84, 20);
			laminaPrincipal.add(labelDescripcion);
			
			descripcionTaller = new JTextField();
			descripcionTaller.setColumns(10);
			descripcionTaller.setBounds(149, 94, 129, 20);
			laminaPrincipal.add(descripcionTaller);
			
			JLabel labelCodigoTaller = new JLabel("C\u00D3DIGO TALLER");
			labelCodigoTaller.setFont(new Font("Arial", Font.BOLD, 12));
			labelCodigoTaller.setBounds(20, 54, 119, 20);
			laminaPrincipal.add(labelCodigoTaller);
			
			codigoTaller = new JTextField();
			codigoTaller.setColumns(10);
			codigoTaller.setBounds(149, 54, 129, 20);
			laminaPrincipal.add(codigoTaller);
			
			registrarTaller = new JButton("REGISTRAR");
			registrarTaller.setBounds(20, 205, 113, 23);
			laminaPrincipal.add(registrarTaller);
			
			cancelar = new JButton("CANCELAR");
			cancelar.setBounds(164, 205, 108, 23);
			laminaPrincipal.add(cancelar);
			
			//Eventos botones.
			
			
			
	 }

	public String getDescripcionTaller() {
		return descripcionTaller.getText();
	}

	public void setDescripcionTaller(String descripcionTaller) {
		this.descripcionTaller.setText(descripcionTaller);
	}

	public String getCodigoTaller() {
		return codigoTaller.getText();
	}

	public void setCodigoTaller(String codigoTaller) {
		this.codigoTaller.setText(codigoTaller);;
	}

	public JButton getRegistrarTaller() {
		return registrarTaller;
	}

	public JButton getCancelar() {
		return cancelar;
	}

	 
}
