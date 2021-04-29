package control;

import model.*;

/**
 * Classe responsável por coletar dados da classe Itens do pacote modelo e inserir em classes do pacote view.
 * 
 * @author Ian e João
 * @version 1.0 (28/04/2021)
 */

public class ControleItens {
	private Itens[] it;
	private int qtdItens;

	public ControleItens(ControleDados d) {
		this.it = d.getItens();
		this.qtdItens = d.getQtdItens();
	}
	
	/**
	 * método responsável por coletar a String de cada nome de Item para inserção posterior no JList.
	 * @return s 
	 */
	public String[] getNomeItem() {
		String[] s = new String[qtdItens];
		for(int i = 0; i < qtdItens; i++) {
			s[i] = it[i].getProduto();
		}

		return s;
	}
	
	public int getQtd() {
		return qtdItens;
	}

	public void setQtd(int qtd) {
		this.qtdItens = qtd;
	}

	public String getProduto(int i) {		
		return it[i].getProduto();
	}

	public String getSetor(int i) {
		return it[i].getSetor();
	}

	public String getUnidade(int i) {
		return it[i].getUnidade();
	}

	public String getQuantidade(int i) {
		String quantity = String.valueOf(it[i].getQuantidade());
		return quantity;
	}
	
	public double getValorProduto (int i) {
		return it[i].getValorProduto();
	}
}
