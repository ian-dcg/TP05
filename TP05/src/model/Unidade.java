package model;

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
