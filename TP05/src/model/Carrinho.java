package model;
/**Classe inutilizada na versão atual do código, os dados de carrinho foram transferidos para o pacote control - classe ControleDados
 * @author Ian e João
 * @version 1.0 (28/04/2021)
 *
 */
public class Carrinho {
	private boolean check;
	private double valorTotal;
	private int numItens;
	
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
