package br.com.ps.missoes;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import br.com.ps.missoes.panels.Banco;
import br.com.ps.missoes.panels.Cadastro;


public class App extends JFrame{
	private static final long serialVersionUID = -1884515411007942866L;
	private Cadastro abaCadastro = new Cadastro();
	private Banco abaBanco = new Banco();
	public static JTabbedPane abas = new JTabbedPane();
	
	public static void main(String[] args) {
		new App().init();
	}

	private void init() {
		JFrame janela = new JFrame("Prova semestral");
		JFrame janelaBanco = new JFrame("Prova semestral");
		abas.add("Cadastro",abaCadastro);
		abas.add("Lista",abaBanco);
		abas.addChangeListener(acaoMudar -> {
			abas.setComponentAt(1, new Banco());
		});
		janelaBanco.add(abaBanco);
		janelaBanco.setSize(800, 450);
		janelaBanco.setLocationRelativeTo(null);
		janelaBanco.setVisible(true);
		janelaBanco.setResizable(false);
		janelaBanco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		janela.add(abas);
		janela.setSize(550, 450);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);
		janela.setResizable(false);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
