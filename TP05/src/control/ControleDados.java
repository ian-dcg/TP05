package control;

import model.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.fillWithSomeData();
	}
	
	public Dados getDados() {
		return d;
	}
	public void setDados(Dados d) {
		this.d = d;
	}
	
	public int getQtdItens() {
		return this.d.getQtdItens();
	}
	
	public Itens[] getItens() {
		return this.d.getItens();
	}
	


	public boolean inserirEditarItem(String[] dadosItens) {
		if(!dadosItens[3].matches("[0-9]+") || !dadosItens[4].matches("[0-9]+") || 
				!dadosItens[5].matches("[0-9]+") || !dadosItens[6].matches("[0-9]+")) {
			return false;
		} else {
				Itens it = new Itens(dadosItens[1], Double.parseDouble(dadosItens[2]), 
						dadosItens[3], dadosItens[4], Integer.parseInt(dadosItens[5]));
				d.inserirEditaItem(it, Integer.parseInt(dadosItens[0]));
				return true;
		}
	}
	// a posicao 0 do vetor dadosAlunos indica onde os dados devem ser inseridos
	/*public boolean inserirEditarAluno(String[] dadosAlunos) {
		if(!dadosAlunos[3].matches("[0-9]+") || !dadosAlunos[4].matches("[0-9]+") || 
				!dadosAlunos[5].matches("[0-9]+") || !dadosAlunos[6].matches("[0-9]+")) {
			return false;
		} else {
				Aluno a = new Aluno(dadosAlunos[1], dadosAlunos[2], Integer.parseInt(dadosAlunos[3]), 
						Integer.parseInt(dadosAlunos[4]), new Telefone(Integer.parseInt(dadosAlunos[5]),
								Integer.parseInt(dadosAlunos[6])));
				d.inserirEditarAluno(a, Integer.parseInt(dadosAlunos[0]));
				return true;
		}
	}*/
	
	/*public boolean removerAluno(int i) {
		int qtdMat = d.getQtdMatriculados();
		String alunoRemovido = d.getAlunos()[i].getNome();
		String aux;
		for (int j = 0; j < qtdMat; j++) { 
			aux = d.getMatr()[j].getAluno().getNome();
			if(alunoRemovido.compareTo(aux) == 0) 
				return false; //não é possível remover aluno pois ele está matriculado em um curso
		}
		
		if(i == (d.getQtdAlunos() - 1)) { // O aluno a ser removido está no final do array
			d.setQtdAlunos(d.getQtdAlunos() - 1);
			d.getAlunos()[d.getQtdAlunos()] = null;
			return true;
		} else { // o aluno a ser removido está no meio do array
			int cont = 0;
			while(d.getAlunos()[cont].getNome().compareTo(alunoRemovido) != 0) {
				cont++;
			}
			//Rotina swap
			for(int j = cont; j < d.getQtdAlunos() - 1; j++) {
				d.getAlunos()[j] = null;
				d.getAlunos()[j] = d.getAlunos()[j+1];
			}
			d.getAlunos()[d.getQtdAlunos()] = null;
			d.setQtdAlunos(d.getQtdAlunos() - 1);
			return true;
		}
	}*/
	
	public boolean removerItem(int i) {
		String itemRemovido = d.getItens()[i].getProduto();
		
		if(i == (d.getQtdItens() - 1)) { // O item a ser removido está no final do array
			d.setQtdItens(d.getQtdItens() - 1);
			d.getItens()[d.getQtdItens()] = null;
			return true;
		} else { // o prof a ser removido está no meio do array
			int cont = 0;
			while(d.getItens()[cont].getProduto().compareTo(itemRemovido) != 0)
				cont++;
			//Rotina swap
			for(int j = cont; j < d.getQtdItens() - 1; j++) {
				d.getItens()[j] = null;
				d.getItens()[j] = d.getItens()[j+1];
			}
			d.getItens()[d.getQtdItens()] = null;
			d.setQtdItens(d.getQtdItens() - 1);
			return true;
		}
	}
}
