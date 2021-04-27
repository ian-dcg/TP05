package model;

public class Carrinho extends Mercado{
	private boolean check;
	
	public Carrinho (int num, double tot, boolean ck) {
		numItens = num;
		valorTotal = tot;
		check = ck;
	}
	
	public boolean getCheck() {
		return check;
	}
	
	public void setcheck(boolean ck) {
		this.check = ck;
	}
	
	public void setItens(Itens itens) {
		this.itens = itens;
	}
	
	public int getNumItens() {
		return numItens;
	}
	
	public void setNumItens(int numItens) {
		this.numItens = numItens;
	}
	
	public double getValorTotal() {
		return valorTotal;
	}
	
	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	
	
	public String toString() {
		String saida = "Valor total do Carrinho: " + valorTotal;
		return saida;
		
	}

}
