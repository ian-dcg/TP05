package model;

/**Classe inutilizada na atual vers�o do c�digo, os dados de Lista foram transferidos para classe Itens.
 * @author Ian e Jo�o
 *@version 1.0 (28/04/2021)
 */

public class Lista  {
	private String nomeLista;
	private Itens [] itensRegistrados = new Itens[50];
	int numItens = 0;
	double valorTotal = 0;
	
	
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
