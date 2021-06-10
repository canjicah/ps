package br.com.ps.missoes.panels;

import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

public class Campos extends JPanel  {
	
	private static final long serialVersionUID = 1L;

	private JTextField id = new JTextField();
	private JTextField dateTime;
	private JTextField diasMarte = new JTextField();
	private JTextField longSolar = new JTextField();
	private JTextField mesMarte = new JTextField();
	private JTextField minTemp = new JTextField();
	private JTextField maxTemp = new JTextField();
	private JTextField pressaoAtm = new JTextField();

	public Campos() {
		setLayout(new GridLayout(8, 2));
		init();
	}
	private void init() {
		add(new JLabel("ID"));
		id.setEditable(false);
		add(id);
		MaskFormatter mascaraData = null;
		try {
			 mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			 System.err.println("Erro na formatação: " + e.getMessage());
             System.exit(-1);
		}
		add(new JLabel("Data na terra"));
		dateTime = new JFormattedTextField(mascaraData);
		dateTime.setBounds(150,40,100,20);
		add(dateTime);
		
		add(new JLabel("O número de sóis decorridos (Dias marcianos)"));
		add(getDiasMarte());
		
		add(new JLabel("Longitude solar"));
		add(getLongSolar());
		
		add(new JLabel("Mês marciano"));
		add(getMesMarte());
		
		add(new JLabel("Temperatura mínima "));
		add(getMinTemp());
		
		add(new JLabel("Temperatura maxima "));
		add(getMaxTemp());
		
		add(new JLabel("A pressão atmosférica"));
		add(getPressaoAtm());
		
	}
//	
//	public Component curDateTime() {
//		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		LocalDateTime now = LocalDateTime.now();
//		dateTime.setText(dft.format(now));
//		return dateTime;
//	}
	public JTextField getId() {
		return id;
	}
	public JTextField getDateTime() {
		return dateTime;
	}
	public JTextField getDiasMarte() {
		return diasMarte;
	}
	public JTextField getLongSolar() {
		return longSolar;
	}
	public JTextField getMesMarte() {
		return mesMarte;
	}
	public JTextField getMinTemp() {
		return minTemp;
	}
	public JTextField getMaxTemp() {
		return maxTemp;
	}
	public JTextField getPressaoAtm() {
		return pressaoAtm;
	}
	public JTextField getData() {
		return dateTime;
	}

}
