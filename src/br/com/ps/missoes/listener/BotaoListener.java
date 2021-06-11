package br.com.ps.missoes.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import br.com.ps.missoes.dao.MissoesDao;
import br.com.ps.missoes.model.Missoes;
import br.com.ps.missoes.panels.Banco;
import br.com.ps.missoes.panels.Cadastro;

public class BotaoListener implements ActionListener {

	private Cadastro cadastro;
	private Banco banco;
	private MissoesDao dao = new MissoesDao();

	public BotaoListener(Cadastro cadastro) {
		this.cadastro = cadastro;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Missoes missao = new Missoes();
		missao.setDataTerra(cadastro.getCampos().getData().getText());
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
			banco.carregaDados();
		} else {
			dao.create(missao);
			banco.carregaDados();
		}
		

	}
}
