package br.com.ps.missoes.panels;

import java.awt.BorderLayout;

import javax.swing.JPanel;


public class Cadastro extends JPanel  {
	private static final long serialVersionUID = 7077408557425378389L;
	
	private Campos campos = new Campos();
	private Botoes botoes = new Botoes(this);
	public Cadastro() {
		setLayout(new BorderLayout());
		init();
	}

	private void init() {
		add(getCampos(), BorderLayout.CENTER);
		add(getBotoes(), BorderLayout.SOUTH);
	}
	public Campos getCampos() {
		return campos;
	}
	public Botoes getBotoes() {
		return botoes;
	}
	
}
