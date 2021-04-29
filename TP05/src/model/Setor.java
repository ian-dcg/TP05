package model;
/**Classe inutilizada na atual versão do código, os dados de Setores foram transferidos para classe Mercado/Itens.
 * 
 * @author Ian e João
 *@version 1.0 (28/04/2021)
 */

public class Setor {
	private String categoria;
	private int prioridade;
	/**Os setores seriam classificados a partir de uma prioridade, mas isso se tornou um problema pois o usuário não deveria digitar essa prioridade 
	 * Se tornou mais fácil apenas receber a String
	 * @param cat
	 * @param prio
	 */
	public Setor(String cat, int prio) {
		categoria = cat;
		prioridade = prio;
		
	}
	
	public Setor(String cat) {
		categoria = cat;
		
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getPrioridade() {
		return prioridade;
	}
	
	public void setPrioridade(int prio) {
		prioridade = prio;
	}
	
	public String toString() {
		return categoria + "/" + prioridade; 
	}

}
