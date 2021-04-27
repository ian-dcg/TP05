package model;

public class Lista  extends Mercado {
	private String nomeLista;
	private Itens [] itensRegistrados = new Itens[50];
	int numItens = 0;
	double ValorTotal = 0;
	
	
	//Sobrecarga
	public Lista (String nome) {
		nome = "Minha Lista";
		nomeLista = nome;
	}
	
	public Lista (String nome, int num, double tot) {
		nomeLista = nome;
		numItens = num;
		valorTotal = tot;
	}
	
	public String toString() {
		return nomeLista;
	}
	
	public Itens[] getItens() {
		return this.itensRegistrados;
	}
	
	public void setArrayItensRegistrados(Itens[] a) {
		this.itensRegistrados = a;
	}
	
	public String getNomeLista() {
		return nomeLista;
	}
	
	public void setNomeLista(String nome) {
		this.nomeLista = nome;
	}
	
	@Override
	
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
}
