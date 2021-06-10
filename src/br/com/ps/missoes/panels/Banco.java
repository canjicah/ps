package br.com.ps.missoes.panels;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.com.ps.missoes.App;
import br.com.ps.missoes.dao.MissoesDao;
import br.com.ps.missoes.model.Missoes;
public class Banco extends JPanel  implements ActionListener {

	private static final long serialVersionUID = -5716238796167890251L;
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton editar = new JButton("editar");
	private JButton apagar = new JButton("apagar");
	private JTable tabela = new JTable(modelo);
	public Banco() {
		setLayout(new BorderLayout());
		carregaDados();
		init();
	}
	public void init(){
		JPanel tLayout = new JPanel(new GridLayout(1, 1));
		
		modelo.addColumn("ID");
		modelo.addColumn("Data Terra");
		modelo.addColumn("Dias em Marte");
		modelo.addColumn("Longitude Solar");
		modelo.addColumn("Mes Marciano");
		modelo.addColumn("temperatura Minima");
		modelo.addColumn("Temperatura Maxima");
		modelo.addColumn("Pressao Atmosférica");
		modelo.setNumRows(0);
		MissoesDao dao = new MissoesDao();
		List<Missoes> lista = dao.buscarTodos();
		for (Missoes missoes : lista) {
			Object[] linha = { 
					missoes.getId(),
					missoes.getDataTerra(),
					missoes.getDiasMarte(),
					missoes.getLongSolar(),
					missoes.getMesMarte(),
					missoes.getMinTemp(),
					missoes.getMaxTemp(),
					missoes.getPressaoAtm()
					
			};
			modelo.addRow(linha);
		}
		JScrollPane scroll = new JScrollPane(tabela);
		tLayout.add(scroll);
		add(tLayout,BorderLayout.CENTER);
		JPanel painel = new JPanel(new FlowLayout());
		
		editar.addActionListener(this);
		apagar.addActionListener(this);
		painel.add(apagar);
		painel.add(editar);
		add(painel,BorderLayout.SOUTH);
		}

	private void carregaDados() {
		modelo.setNumRows(0);
		MissoesDao dao = new MissoesDao();
		List<Missoes> lista = dao.buscarTodos();
		for (Missoes missoes : lista) {
			Object[] linha = { 
					missoes.getId(),
					missoes.getDataTerra(),
					missoes.getDiasMarte(),
					missoes.getLongSolar(),
					missoes.getMesMarte(),
					missoes.getMinTemp(),
					missoes.getMaxTemp(),
					missoes.getPressaoAtm()
					
			};
			modelo.addRow(linha);
		}
	}
	private void editar() {

		editar.addActionListener(acaoeditar -> {
			if (tabela.getSelectedRow() >= 0) {
				String id = tabela.getValueAt(tabela.getSelectedRow(), 0).toString();
				String dataTerra = tabela.getValueAt(tabela.getSelectedRow(), 1).toString();
				String nrDiasMarte = tabela.getValueAt(tabela.getSelectedRow(), 2).toString();
				String longSolar = tabela.getValueAt(tabela.getSelectedRow(), 3).toString();
				String mesMarte = tabela.getValueAt(tabela.getSelectedRow(), 4).toString();
				String minTemp = tabela.getValueAt(tabela.getSelectedRow(), 5).toString();
				String maxTemp = tabela.getValueAt(tabela.getSelectedRow(), 6).toString();
				String pressaoAtm = tabela.getValueAt(tabela.getSelectedRow(), 7).toString();
				
				App.abas.setSelectedIndex(0);
				Cadastro cadastro = (Cadastro) App.abas.getComponent(0);

				JTextField campoId = cadastro.getCampos().getId();
				campoId.setText(id);
				
				JTextField campoDataTerra = cadastro.getCampos().getDateTime();
				campoDataTerra.setText(dataTerra);
				
				JTextField campoDiasMarte = cadastro.getCampos().getDiasMarte();
				campoDiasMarte.setText(nrDiasMarte);
				
				JTextField campoLongSolar = cadastro.getCampos().getLongSolar();
				campoLongSolar.setText(longSolar);
				
				JTextField campoMesMarte = cadastro.getCampos().getMesMarte();
				campoMesMarte.setText(mesMarte);
				
				JTextField campoMinTemp = cadastro.getCampos().getMinTemp();
				campoMinTemp.setText(minTemp);
				
				JTextField campoMaxTemp = cadastro.getCampos().getMaxTemp();
				campoMaxTemp.setText(maxTemp);
				
				JTextField campoPressaoAtm = cadastro.getCampos().getPressaoAtm();
				campoPressaoAtm.setText(pressaoAtm);
				
			} else {
				System.out.println("selecione uma linha");
			}
			carregaDados();
		});
	}
	
	private void apagar() {
		MissoesDao dao = new MissoesDao();
		int linha = tabela.getSelectedRow();
		String id = tabela.getValueAt(linha, 0).toString();
		Missoes missoes = dao.buscarPorId(Long.valueOf(id));
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer apagar a missao selecionada?");
		if (resposta == JOptionPane.YES_OPTION) {
			dao.apagar(missoes);
			carregaDados();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == editar) editar();		
		if (e.getSource() == apagar) apagar();
	}




}
