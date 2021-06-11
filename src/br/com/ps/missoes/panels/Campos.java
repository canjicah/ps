package br.com.ps.missoes.panels;

import java.awt.Font;
import java.awt.GridLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.text.MaskFormatter;

import br.com.ps.missoes.dao.MissoesDao;
import br.com.ps.missoes.model.Missoes;

public class Campos extends JPanel  {
	
	private static final long serialVersionUID = 1L;

	private MissoesDao dao = new MissoesDao();
	private JLabel label1= new JLabel();
	private JLabel lId= new JLabel();
	private JLabel lPressAtm= new JLabel();
	private JLabel lDataMarte= new JLabel();
	private JLabel lLongSolar= new JLabel();
	private JLabel lDataTerra= new JLabel();
	private JLabel lTempMax= new JLabel();
	private JLabel lTempMin= new JLabel();
	private JLabel lMesMarte= new JLabel();
	private JTextField id= new JTextField();
	private JTextField diasMarcianos= new JTextField();
	private JTextField mesMarciano= new JTextField();
	private JTextField longSolar= new JTextField();
	private JTextField tempMax= new JTextField();
	private JTextField tempMin= new JTextField();
	private JTextField pressAtm= new JTextField();
	private JTextField dataTerra;
	private JButton cadastrar = new JButton();
	private JButton cancelar = new JButton();
	private Banco banco;
	public Campos() {
		//init();
		initComponents();
	}
	
	private void initComponents() {
		
				//---- label1 ----
		label1.setText("Cadastro de Miss\u00f5es");
		label1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 16));

		//---- lId ----
		lId.setText("ID");

		//---- lPressAtm ----
		lPressAtm.setText("Press\u00e3o atmosf\u00e9rica");

		//---- lDataMarte ----
		lDataMarte.setText("Dias marcianos");

		//---- lLongSolar ----
		lLongSolar.setText("Longitude solar");

		//---- lDataTerra ----
		lDataTerra.setText("Data na terra");

		//---- lTempMax ----
		lTempMax.setText("Temperatura maxima");

		//---- lTempMin ----
		lTempMin.setText("Temperatura m\u00ednima");

		//---- lMesMarte ----
		lMesMarte.setText("M\u00eas marciano");

		//---- cadastrar ----
		cadastrar.setText("Cadastrar");

		//---- cancelar ----
		cancelar.setText("Cancelar");

		MaskFormatter mascaraData = null;
		try {
			 mascaraData = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			 System.err.println("Erro na formatação: " + e.getMessage());
             System.exit(-1);
		}
		dataTerra= new JFormattedTextField(mascaraData);
		id.setEditable(false);
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup()
						.addComponent(lId)
						.addComponent(lDataTerra)
						.addComponent(lDataMarte)
						.addComponent(lMesMarte)
						.addComponent(lTempMin)
						.addComponent(lPressAtm)
						.addComponent(lTempMax))
					.addGap(54, 54, 54)
					.addGroup(layout.createParallelGroup()
						.addGroup(layout.createSequentialGroup()
							.addComponent(cadastrar)
							.addGap(26, 26, 26)
							.addComponent(cancelar))
						.addGroup(layout.createParallelGroup()
							.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
								.addComponent(dataTerra, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
								.addComponent(diasMarcianos, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
							.addComponent(mesMarciano, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addComponent(longSolar, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addComponent(tempMax, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addComponent(tempMin, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addComponent(pressAtm, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
							.addComponent(id, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)))
					.addGap(0, 138, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lLongSolar)
					.addContainerGap(402, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup()
					.addContainerGap(166, Short.MAX_VALUE)
					.addComponent(label1)
					.addContainerGap(194, Short.MAX_VALUE))
		);
		cadastrar.addActionListener(acao -> {
			Missoes missao = new Missoes();
			missao.setDataTerra(getData().getText());
			missao.setDiasMarte(Integer.parseInt(getDiasMarte().getText()));
			missao.setLongSolar(Long.parseLong(getLongSolar().getText()));
			missao.setMesMarte(Integer.parseInt(getMesMarte().getText()));
			missao.setMaxTemp(Long.parseLong(getMaxTemp().getText()));
			missao.setMinTemp(Long.parseLong(getMinTemp().getText()));
			missao.setPressaoAtm(Long.parseLong(getPressaoAtm().getText()));
			
			System.out.println(missao);	
			String id = getId().getText();
			if (id != null && !id.trim().equals("")) {
				missao.setId(Integer.parseInt(id));
				dao.editar(missao);
			} else {
				dao.create(missao);
			}
			});
		cancelar.addActionListener(acao -> {
			getId().setText("");
			getData().setText("");
			getMesMarte().setText("");
			getLongSolar().setText("");
			getDiasMarte().setText("");
			getMaxTemp().setText("");
			getMinTemp().setText("");
			getPressaoAtm().setText("");
			
		});
		layout.setVerticalGroup(
			layout.createParallelGroup()
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(label1)
					.addGap(23, 23, 23)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lId)
						.addComponent(id, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lDataTerra)
						.addComponent(dataTerra, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12, 12, 12)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lDataMarte)
						.addComponent(diasMarcianos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8, 8, 8)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(lMesMarte)
						.addComponent(mesMarciano, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup()
						.addComponent(lLongSolar)
						.addComponent(longSolar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tempMax, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lTempMax))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(tempMin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lTempMin))
					.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(pressAtm, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lPressAtm))
					.addGap(18, 18, 18)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(cadastrar)
						.addComponent(cancelar))
					.addContainerGap(27, Short.MAX_VALUE))
		);}
	public JTextField getId() {
		return id;
	}
	public JTextField getDiasMarte() {
		return diasMarcianos;
	}
	public JTextField getLongSolar() {
		return longSolar;
	}
	public JTextField getMesMarte() {
		return mesMarciano;
	}
	public JTextField getMinTemp() {
		return tempMin;
	}
	public JTextField getMaxTemp() {
		return tempMax;
	}
	public JTextField getPressaoAtm() {
		return pressAtm;
	}
	public JTextField getData() {
		return dataTerra;
	}
//	private void init() {
//		JLabel cID = new JLabel("ID");
//		cID.setBounds(0,0,500,40);
//		add(cID);
//		id.setEditable(false);
//		id.setBounds(0,35,200,30);
//		add(id);
//		
//		
//		
//		MaskFormatter mascaraData = null;
//		try {
//			 mascaraData = new MaskFormatter("##/##/####");
//		} catch (ParseException e) {
//			 System.err.println("Erro na formatação: " + e.getMessage());
//             System.exit(-1);
//		}
//		add(new JLabel("Data na terra"));
//		dateTime = new JFormattedTextField(mascaraData);
//		dateTime.setBounds(150,40,100,20);
//		add(dateTime);
//		
//		add(new JLabel("O número de sóis decorridos (Dias marcianos)"));
//		add(getDiasMarte());
//		
//		add(new JLabel("Longitude solar"));
//		add(getLongSolar());
//		
//		add(new JLabel("Mês marciano"));
//		add(getMesMarte());
//		
//		add(new JLabel("Temperatura mínima"));
//		add(getMinTemp());
//		
//		add(new JLabel("Temperatura maxima"));
//		add(getMaxTemp());
//		
//		add(new JLabel("Pressão atmosférica"));
//		add(getPressaoAtm());
//
//	}
////	
////	public Component curDateTime() {
////		DateTimeFormatter dft = DateTimeFormatter.ofPattern("dd/MM/yyyy");
////		LocalDateTime now = LocalDateTime.now();
////		dateTime.setText(dft.format(now));
////		return dateTime;
////	}
//	public JTextField getId() {
//		return id;
//	}
//	public JTextField getDateTime() {
//		return dateTime;
//	}
//	public JTextField getDiasMarte() {
//		return diasMarte;
//	}
//	public JTextField getLongSolar() {
//		return longSolar;
//	}
//	public JTextField getMesMarte() {
//		return mesMarte;
//	}
//	public JTextField getMinTemp() {
//		return minTemp;
//	}
//	public JTextField getMaxTemp() {
//		return maxTemp;
//	}
//	public JTextField getPressaoAtm() {
//		return pressaoAtm;
//	}
//	public JTextField getData() {
//		return dateTime;
//	}
}

