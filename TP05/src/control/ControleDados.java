package control;

import model.*;

/**
 * Classe responsável por coletar dados da classe Dados do pacote modelo e inserir em classes do pacote view.
 * 
 * @author Ian e João
 * @version 1.0 (28/04/2021)
 */
public class ControleDados {
	private Dados d = new Dados();
	
	/**
	 * método que chama a função de adicionar itens pré cadastrados.
	 */
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}
	
	public int getQtdItens() {
		return this.d.getQtdItens();
	}
	
	public Itens[] getItens() {
		return this.d.getItens();
	}
	

	/**
	 * método que faz a validação dos dados inseridos pelo usuário na view e verifica se podem ser inseridos ou não.
	 * @param dadosItens (ex: preço, quantidade, etc)
	 * @return true or false
	 */
	public boolean inserirEditarItem(String[] dadosItens) {
		//valida se o preço é um número que pode ou não ser decimal e valida se quantidade é um número inteiro
		if(!dadosItens[2].matches("^[0-9]+(.|,)?[0-9]*$") || !dadosItens[5].matches("[0-9]+")) {
			return false;
		//valida se algum campo está vazio	
		} else if (dadosItens[1].isEmpty() || dadosItens[2].isEmpty() || dadosItens[3].isEmpty() || dadosItens[4].isEmpty() ||
				   dadosItens[5].isEmpty()) {
			return false;
		//caso tenha passado por todas as validações	
		} else {
				Itens it = new Itens(dadosItens[1], Double.parseDouble(dadosItens[2]), 
						dadosItens[3], dadosItens[4], Integer.parseInt(dadosItens[5]));
				d.inserirEditaItem(it, Integer.parseInt(dadosItens[0]));
				return true;
		}
	}
	
	
	/**
	 * método responsável pela exclusão de um item
	 * @param i
	 * @return true or false
	 */
	public boolean removerItem(int i) {
		String itemRemovido = d.getItens()[i].getProduto();
		
		if(i == (d.getQtdItens() - 1)) { // O item a ser removido está no final do array
			d.setQtdItens(d.getQtdItens() - 1);
			d.getItens()[d.getQtdItens()] = null;
			return true;
		} else { // o item a ser removido está no meio do array
			int cont = 0;
			while(d.getItens()[cont].getProduto().compareTo(itemRemovido) != 0)
				cont++;
			//Rotina swap
			for(int j = cont; j < d.getQtdItens() - 1; j++) {
				d.getItens()[j] = null;
				d.getItens()[j] = d.getItens()[j+1];
			}
			d.getItens()[d.getQtdItens()] = null;
			d.setQtdItens(d.getQtdItens() - 1);
			return true;
		}
	}
}
