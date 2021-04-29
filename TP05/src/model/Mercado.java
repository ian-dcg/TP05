package model;

/**
 * Esta classe contém os principais atributos do programa e o construtor da superclasse.
 * @author Ian e João
 * @version 1.0 (28/04/2021)
 */

public abstract class Mercado {
	protected String produto;
	protected String unidade;
	protected String setor; 
	protected int quantidade;
	
	public Mercado() {
		super();
	}
	

	public String getProduto() {
		return produto;
	}
	

	public void setProduto(String produto) {
		this.produto = produto;
	}
	

	public String getUnidade() {
		return unidade;
	}
	

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}
	

	public String getSetor() {
		return setor;
	}
	

	public void setSetor(String setor) {
		this.setor = setor;
	}
	

	public int getQuantidade() {
		return quantidade;
	}
	

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
