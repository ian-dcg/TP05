package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import control.*; //control

/**
 * Classe respons�vel pelo cadastro de um novo item, edi��o de um item j� existente, exclus�o de um item ou apenas leitura dos dados de um item.
 * 
 * @author Ian e Jo�o
 * @version 1.0 (28/04/2021)
 */
public class TelaCadastroItem implements ActionListener {

	private JFrame janela;
	private JLabel labelNomeProduto = new JLabel("Produto: ");
	private JTextField valorNomeProduto;
	private JLabel labelPreco = new JLabel("Pre�o (R$): ");
	private JTextField valorPreco;
	private JLabel labelSetor = new JLabel("Setor: ");
	private JTextField valorSetor;
	private JLabel labelUnidade = new JLabel("Unidade (medida): ");
	private JTextField valorUnidade;
	private JLabel labelQuantidade = new JLabel("Quantidade:  ");
	private JTextField valorQuantidade;
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private String[] novoDado = new String[9];
	private static ControleDados dados; 	
	private int posicao;
	private int opcao;
	private String tituloJanela;
	 /**
	  * Esse m�todo � respons�vel por criar uma tela que dependendo se o item existe, ir� preencher com os dados do item para edi��o,
	  * caso n�o exista ir� criar a tela com as caixas de texto vazias.
	  * @param op
	  * @param d
	  * @param p
	  * @param pos
	  */
	public void inserirEditar(int op, ControleDados d,  
			TelaLista p, int pos) { 

		opcao = op;
		posicao = pos;
		dados = d; //control
		
		// AS OP�OES POSSIVEIS SAO 1 OU 2 
		//	1- CADASTRAR ITEM
		//  2- EDITAR ITEM EXISTENTE
	
		if (op == 1) tituloJanela = "Cadastro de Item";   
		if (op == 2) tituloJanela = "Editar Item";  

		janela = new JFrame(tituloJanela);

		//Preenche dados com dados do item clicado (Edi��o de item)
		if (op == 2) {
			valorNomeProduto = new JTextField(dados.getItens()[pos].getProduto(), 200);          		
			valorPreco = new JTextField(String.valueOf(dados.getItens()[pos].getValorProduto()),200);	
			valorSetor = new JTextField(String.valueOf(dados.getItens()[pos].getSetor()), 200);			
			valorUnidade = new JTextField(String.valueOf(dados.getItens()[pos].getUnidade()), 200);		
			valorQuantidade = new JTextField(String.valueOf(dados.getItens()[pos].getQuantidade()), 3);	
			
		} else { //N�o preenche com dados (Cadastro de novo Item)

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

	/**
	 * m�todo que captura eventos de bot�es da interface e coloca insere dados cadastrados pelo usu�rio no pacote controle.
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if (opcao == 1) { // cadastro de novo item
					novoDado[0] = Integer.toString(dados.getQtdItens());
				} else { // edicao de dado existente
					novoDado[0] = Integer.toString(posicao);
				}
					
					novoDado[1] =  valorNomeProduto.getText();
					novoDado[2] =  valorPreco.getText();
					novoDado[3] =  valorSetor.getText();
					novoDado[4] =  valorUnidade.getText();
					novoDado[5] =  valorQuantidade.getText();
					
					res = dados.inserirEditarItem(novoDado); 	
					
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
				res = dados.removerItem(posicao); 	
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
				+ "Verifique se todos os campos foram preenchidos.\n" + "Certifique-se de usar ponto (.) e n�o v�rgula (,) para n�meros n�o inteiros\n"
				, null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	public void mensagemErroExclusaoItem() {
		JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
				+ "Verifique se o item est� mesmo cadastrado\n", null, 
				JOptionPane.ERROR_MESSAGE);
	}


}