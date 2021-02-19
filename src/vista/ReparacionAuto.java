package vista;

import java.awt.Font;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import controlador.ControlReparacionAuto;

public class ReparacionAuto extends JFrame {
	 private JTextField cantidadHoras;
	 private JTextField matriculaAutoReparado;
	 private JTextField dniMecanico;
	 private JButton registrar ;
	 private JButton cancelar ;
	 private JTextField cantidadMinutos;
	 private JDateChooser fechaReparacion=null ;
	 
	 public ReparacionAuto()
	 {
		    getContentPane().setLayout(null);
			
			JPanel laminaPrincipal = new JPanel();
			setSize(315,343);
			setLocationRelativeTo(null);
			laminaPrincipal.setBounds(0, 0, 299, 311);
			getContentPane().add(laminaPrincipal);
			laminaPrincipal.setLayout(null);
			
			JLabel labelRegistroReparacion = new JLabel("REPARACI\u00D3N AUTO");
			labelRegistroReparacion.setFont(new Font("Arial", Font.BOLD, 18));
			labelRegistroReparacion.setBounds(58, 11, 183, 32);
			laminaPrincipal.add(labelRegistroReparacion);
			
			JLabel labelCantidadHorasArreglo = new JLabel("CANT. HS ARREGLO");
			labelCantidadHorasArreglo.setFont(new Font("Arial", Font.BOLD, 12));
			labelCantidadHorasArreglo.setBounds(10, 77, 126, 20);
			laminaPrincipal.add(labelCantidadHorasArreglo);
			
			cantidadHoras = new JTextField();
			cantidadHoras.setColumns(10);
			cantidadHoras.setText("");
			cantidadHoras.setBounds(153, 77, 40, 20); 
			 
			laminaPrincipal.add(cantidadHoras);
			
			JLabel labelMatricula = new JLabel("MATR\u00CDCULA");
			labelMatricula.setFont(new Font("Arial", Font.BOLD, 12));
			labelMatricula.setBounds(10, 168, 81, 20);
			laminaPrincipal.add(labelMatricula);
			
			matriculaAutoReparado = new JTextField();
			matriculaAutoReparado.setColumns(10);
			matriculaAutoReparado.setBounds(146, 168, 129, 20);
			laminaPrincipal.add(matriculaAutoReparado);
			
			JLabel labelDniMecanico = new JLabel("DNI MEC\u00C1NICO");
			labelDniMecanico.setFont(new Font("Arial", Font.BOLD, 12));
			labelDniMecanico.setBounds(10, 216, 95, 20);
			laminaPrincipal.add(labelDniMecanico);
			
			dniMecanico = new JTextField();
			dniMecanico.setColumns(10);
			dniMecanico.setBounds(146, 216, 129, 20);
			laminaPrincipal.add(dniMecanico);
			
			registrar = new JButton("REGISTRAR");
			registrar.setBounds(24, 267, 113, 23);
			laminaPrincipal.add(registrar);
			
			cancelar = new JButton("CANCELAR");
			cancelar.setBounds(160, 267, 113, 23);
			laminaPrincipal.add(cancelar);
			
			cantidadMinutos = new JTextField(); 
			cantidadMinutos.setColumns(10);
			cantidadMinutos.setText("");
			cantidadMinutos.setBounds(235, 77, 40, 20);
			laminaPrincipal.add(cantidadMinutos);
			
			JLabel labelHs = new JLabel("hs");
			labelHs.setFont(new Font("Arial", Font.BOLD, 12));
			labelHs.setBounds(133, 80, 20, 20);
			laminaPrincipal.add(labelHs);
			
			JLabel labelMin = new JLabel("min.");
			labelMin.setFont(new Font("Arial", Font.BOLD, 12));
			labelMin.setBounds(201, 80, 24, 20);
			laminaPrincipal.add(labelMin);
			
			JLabel labelFecha = new JLabel("FECHA");
			labelFecha.setFont(new Font("Arial", Font.BOLD, 12));
			labelFecha.setBounds(10, 122, 81, 20);
			laminaPrincipal.add(labelFecha);
			
			fechaReparacion = new JDateChooser();
			fechaReparacion.setBounds(146, 122, 129, 20);
			laminaPrincipal.add(fechaReparacion);
			
			ControlReparacionAuto cRA=new ControlReparacionAuto(this);
			
			//Eventos botones
			this.registrar.addActionListener(cRA);
			this.cancelar.addActionListener(cRA);
			
	 }

	 
	
	public Time getCantidadHoras() {
		
		int hs = 0;
		int min = 0;
		
		if(this.cantidadHoras.getText().equals(""))
		{
			return Time.valueOf(LocalTime.of(hs, min));
		}
		
		if(this.cantidadMinutos.getText().equals(""))
		{
			return Time.valueOf(LocalTime.of(hs, min));
		}
		
		hs= Integer.valueOf (cantidadHoras.getText());
		min=Integer.valueOf (cantidadMinutos.getText());
		return Time.valueOf(LocalTime.of(hs, min));
		
	}



	public void setCantidadHoras(String cantidadHoras) {
		this.cantidadHoras.setText(cantidadHoras);
	}


	public void setCantidadMinutos(String cantidadMinutos) {
		this.cantidadMinutos.setText(cantidadMinutos);
	}



	public String getMatriculaAutoReparado() {
		return matriculaAutoReparado.getText();
	}

	public void setMatriculaAutoReparado(String matriculaAutoReparado) {
		this.matriculaAutoReparado.setText(matriculaAutoReparado);
	}

	public String getDniMecanico() {
		return dniMecanico.getText();
	}

	public void setDniMecanico(String dniMecanico) {
		this.dniMecanico.setText(dniMecanico);
	}

	public JButton getRegistrar() {
		return registrar;
	}


	public JButton getCancelar() {
		return cancelar;
	}



	public Date getFechaReparacion() {
		return fechaReparacion.getDate();
	}
 
	
	
}
