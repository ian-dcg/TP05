package control;

import model.*;

/**
 * Classe respons�vel por coletar dados da classe Dados do pacote modelo e inserir em classes do pacote view.
 * 
 * @author Ian e Jo�o
 * @version 1.0 (28/04/2021)
 */
public class ControleDados {
	private Dados d = new Dados();
	
	/**
	 * m�todo que chama a fun��o de adicionar itens pr� cadastrados.
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
	 * m�todo que faz a valida��o dos dados inseridos pelo usu�rio na view e verifica se podem ser inseridos ou n�o.
	 * @param dadosItens (ex: pre�o, quantidade, etc)
	 * @return true or false
	 */
	public boolean inserirEditarItem(String[] dadosItens) {
		//valida se o pre�o � um n�mero que pode ou n�o ser decimal e valida se quantidade � um n�mero inteiro
		if(!dadosItens[2].matches("^[0-9]+(.|,)?[0-9]*$") || !dadosItens[5].matches("[0-9]+")) {
			return false;
		//valida se algum campo est� vazio	
		} else if (dadosItens[1].isEmpty() || dadosItens[2].isEmpty() || dadosItens[3].isEmpty() || dadosItens[4].isEmpty() ||
				   dadosItens[5].isEmpty()) {
			return false;
		//caso tenha passado por todas as valida��es	
		} else {
				Itens it = new Itens(dadosItens[1], Double.parseDouble(dadosItens[2]), 
						dadosItens[3], dadosItens[4], Integer.parseInt(dadosItens[5]));
				d.inserirEditaItem(it, Integer.parseInt(dadosItens[0]));
				return true;
		}
	}
	
	
	/**
	 * m�todo respons�vel pela exclus�o de um item
	 * @param i
	 * @return true or false
	 */
	public boolean removerItem(int i) {
		String itemRemovido = d.getItens()[i].getProduto();
		
		if(i == (d.getQtdItens() - 1)) { // O item a ser removido est� no final do array
			d.setQtdItens(d.getQtdItens() - 1);
			d.getItens()[d.getQtdItens()] = null;
			return true;
		} else { // o item a ser removido est� no meio do array
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
