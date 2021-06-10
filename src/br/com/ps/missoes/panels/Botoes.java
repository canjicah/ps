package br.com.ps.missoes.panels;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.ps.missoes.dao.MissoesDao;
import br.com.ps.missoes.model.Missoes;


public class Botoes extends JPanel {

	private static final long serialVersionUID = 1L;
	private MissoesDao dao = new MissoesDao();
	private JButton salvar = new JButton("Salvar");
	private JButton cancelar = new JButton("Cancelar");
	private Cadastro cadastro;
	
	public Botoes(Cadastro cadastro) {
		this.cadastro = cadastro;
		init();
	}

	private void init() {
		add(salvar);
		add(cancelar);
		apagar();
		salvar();
	}
	private void salvar() {
		salvar.addActionListener(acao -> {
		Missoes missao = new Missoes();
		missao.setDataTerra(cadastro.getCampos().getDateTime().getText());
		missao.setDiasMarte(Integer.parseInt(cadastro.getCampos().getDiasMarte().getText()));
		missao.setLongSolar(Long.parseLong(cadastro.getCampos().getLongSolar().getText()));
		missao.setMesMarte(Integer.parseInt(cadastro.getCampos().getMesMarte().getText()));
		missao.setMaxTemp(Long.parseLong(cadastro.getCampos().getMaxTemp().getText()));
		missao.setMinTemp(Long.parseLong(cadastro.getCampos().getMinTemp().getText()));
		missao.setPressaoAtm(Long.parseLong(cadastro.getCampos().getPressaoAtm().getText()));
		
		System.out.println(missao);	
		String id = cadastro.getCampos().getId().getText();
		if (id != null && !id.trim().equals("")) {
			missao.setId(Integer.parseInt(id));
			dao.editar(missao);
		} else {
			dao.create(missao);
		}
		});
	}
	private void apagar() {
		cancelar.addActionListener(acao -> {
			cadastro.getCampos().getId().setText("");
			cadastro.getCampos().getDateTime().setText("");
			cadastro.getCampos().getMesMarte().setText("");
			cadastro.getCampos().getLongSolar().setText("");
			cadastro.getCampos().getDiasMarte().setText("");
			cadastro.getCampos().getMaxTemp().setText("");
			cadastro.getCampos().getMinTemp().setText("");
			cadastro.getCampos().getPressaoAtm().setText("");
			
		});
	}
}
