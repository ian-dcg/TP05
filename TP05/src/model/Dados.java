package model;

import java.util.*;

public class Dados {
	private Itens[] itens = new Itens[50];
	private int qtdItens = 0;
	
	
	public void fillWithSomeData() {
		for(int i = 0; i < 5; i++) {
			itens[i] = new Itens("Produto"+i, (i+1)*1000, "Setor"+i, "Unidade"+i, (i+1)*10);		
		}
		
		qtdItens = 5;
		
	}


	public Itens[] getItens() {
		return itens;
	}


	public void setItens(Itens[] itens) {
		this.itens = itens;
	}
	
	public void inserirEditaItem(Itens i, int pos) {
		this.itens[pos] = i;
		if(pos == qtdItens) qtdItens++;
	}


	public int getQtdItens() {
		return qtdItens;
	}


	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}

	
}
