package model;
/**Classe inutilizada na atual vers�o do c�digo, os dados de Unidades foram transferidos para as classe Mercado/Itens.
 * @author Jo�o e Ian
 * @version 1.0 (28/04/2021)
 *
 */
public class Unidade {
	private String tipoUnidade;
	
	public Unidade(String u) {
		tipoUnidade = u;
	}
	
	public String toString() {
		return tipoUnidade + ", ";
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	

}
