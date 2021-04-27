package model;

public class Itens extends Mercado {
	private double valorProduto;
	
	public Itens(){
		super();
	}

	public Itens(String n, double v, String set, String und, int qtd) {
		this.produto = n;
		valorProduto = v;
		this.quantidade = qtd;
		this.setor = set;
		this.unidade = und;
				
	}
	
	public String toString() {
		return "Nome do Item: " + produto + ", Preço: R$" + valorProduto;
	}
	
	
	public String getProduto() {
		return produto;
	}

	public void setProduto(String produto) {
		this.produto = produto;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(double valorProduto) {
		this.valorProduto = valorProduto;
	}
	
	
}
