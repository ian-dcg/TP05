package control;

import model.*;

public class ControleDados {
	private Dados d = new Dados();
	
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
	


	public boolean inserirEditarItem(String[] dadosItens) {
		Double.parseDouble(dadosItens[2]);
		if(!dadosItens[2].matches("^[0-9]+(.|,)?[0-9]*$") || !dadosItens[5].matches("[0-9]+")) {
			return false;
		} else {
				Itens it = new Itens(dadosItens[1], Double.parseDouble(dadosItens[2]), 
						dadosItens[3], dadosItens[4], Integer.parseInt(dadosItens[5]));
				d.inserirEditaItem(it, Integer.parseInt(dadosItens[0]));
				return true;
		}
	}
	
	
	
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
