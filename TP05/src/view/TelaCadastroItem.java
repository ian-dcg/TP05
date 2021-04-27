package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control.*; //control

public class TelaCadastroItem implements ActionListener {

	private JFrame janela;
	private JLabel labelNomeProduto = new JLabel("Produto: ");
	private JTextField valorNomeProduto;
	private JLabel labelPreco = new JLabel("Preço (R$): ");
	private JTextField valorPreco;
	private JLabel labelSetor = new JLabel("Setor: ");
	private JTextField valorSetor;
	private JLabel labelUnidade = new JLabel("Unidade: ");
	private JTextField valorUnidade;
	private JLabel labelQuantidade = new JLabel("Quantidade:  ");
	private JTextField valorQuantidade;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados; 	//control 
	private int posicao;
	private int opcao;
	private String s;

	public void inserirEditar(int op, ControleDados d,  //control
			TelaLista p, int pos) { 

		opcao = op;
		posicao = pos;
		dados = d; //control
		
		// AS OPÇOES POSSIVEIS SAO 1 OU 2 
		//	1- CADASTRAR ITEM
		//  2- EDITAR ITEM EXISTENTE
	
		if (op == 1) s = "Cadastro de Item";   //transformar em opçao 1
		if (op == 2) s = "Editar Item";  //transformar em opção 2 

		janela = new JFrame(s);

		//Preenche dados com dados do item clicado
		if (op == 2) {
			valorNomeProduto = new JTextField(dados.getItens()[pos].getNomeProduto(), 200);          	//control
			valorPreco = new JTextField(String.valueOf(dados.getItens()[pos].getPreco()),200);			//control
			valorSetor = new JTextField(String.valueOf(dados.getItens()[pos].getSetor()), 200);			//control
			valorUnidade = new JTextField(String.valueOf(dados.getItens()[pos].getUnidade()), 200);		//control
			valorQuantidade = new JTextField(String.valueOf(dados.getItens()[pos].getQuantidade()), 3);	//control
			
		} else { //Não preenche com dados

			valorNomeProduto = new JTextField(200);
			valorPreco = new JTextField(200);
			valorSetor = new JTextField(200);
			valorUnidade = new JTextField(200);
			valorQuantidade = new JTextField(3);

			botaoSalvar.setBounds(245, 175, 115, 30);
		}

		labelNomeProduto.setBounds(30, 20, 150, 25);
		valorNomeProduto.setBounds(180, 20, 180, 25);
		labelPreco.setBounds(30, 50, 180, 25);
		valorPreco.setBounds(180, 50, 180, 25);		
		labelSetor.setBounds(30, 80, 150, 25);
		valorSetor.setBounds(180, 80, 180, 25);
		labelUnidade.setBounds(30, 110, 150, 25);
		valorUnidade.setBounds(180, 110, 180, 25);
		labelQuantidade.setBounds(30, 140, 150, 25);
		valorQuantidade.setBounds(180, 140, 28, 25);

		//Coloca botoes de excluir e salvar (caso seja editar item)
		if (op == 2) { 
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}

		this.janela.add(labelNomeProduto);
		this.janela.add(valorNomeProduto);
		this.janela.add(labelPreco);
		this.janela.add(valorPreco);
		this.janela.add(labelSetor);
		this.janela.add(valorSetor);
		this.janela.add(labelUnidade);
		this.janela.add(valorUnidade);
		this.janela.add(labelQuantidade);
		this.janela.add(valorQuantidade);
		this.janela.add(botaoSalvar);

		this.janela.setLayout(null);

		this.janela.setSize(400, 250);
		this.janela.setVisible(true);

		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
	}


	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if (opcao == 1) { // cadastro de novo item
					novoDado[0] = Integer.toString(dados.getNumItens());
				} else { // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);
				}
					
					novoDado[1] =  valorNomeProduto.getText();
					novoDado[2] =  valorPreco.getText();
					novoDado[3] =  valorSetor.getText();
					novoDado[4] =  valorUnidade.getText();
					novoDado[5] =  valorQuantidade.getText();
					
					res = dados.inserirEditarItem(novoDado); 	//control
					
				if(res) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();
			} catch (NullPointerException exc1) {
				mensagemErroCadastro();
			} catch (NumberFormatException exc2) {
				mensagemErroCadastro();
			}
		}
		if(src == botaoExcluir) {
			boolean res = false;
				
			if (opcao == 2){ //exclui item
				res = dados.removerItem(posicao); 	//control
				if (res) mensagemSucessoExclusao(); 
				else mensagemErroExclusaoItem(); 
			}
			
		}
	}

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				+ "Verifique se todos os campos foram preenchidos corretamente.\n", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusaoItem() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o item está mesmo cadastrado\n", null, 
				JOptionPane.ERROR_MESSAGE);
	}


}