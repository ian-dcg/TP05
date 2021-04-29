package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import control.*; //control
 /**
  * Classe responsável pela criação do JList que constitui a Lista de Itens do Usuário.
  * 
  * @author Ian e João
  * @version 1.0 (28/04/2021)
  */

public class TelaLista implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroItem;
	private JButton refreshItem;
	private static ControleDados dados; 
	private JList<String> listaItensCadastrados;
	private String[] listaItens = new String[50];

	/**
	 * método que irá criar o Jlist e adicionar botões para novos cadastros e atualização de lista.
	 * @param d
	 */
	public void mostrarDados(ControleDados d){ 
		dados = d; 
		
			// Mostrar dados de itens cadastrados (JList)
			listaItens = new ControleItens(dados).getNomeItem(); 
			listaItensCadastrados = new JList<String>(listaItens);
			janela = new JFrame("Lista");
			titulo = new JLabel("Itens Cadastrados");
			cadastroItem = new JButton("Cadastrar");
			refreshItem = new JButton("Atualizar");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaItensCadastrados.setBounds(20, 50, 350, 120);
			listaItensCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaItensCadastrados.setVisibleRowCount(10);

			cadastroItem.setBounds(70, 177, 100, 30);
			refreshItem.setBounds(200, 177, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(listaItensCadastrados);
			janela.add(cadastroItem);
			janela.add(refreshItem);

			janela.setSize(400, 250);
			janela.setVisible(true);

			cadastroItem.addActionListener(this);
			refreshItem.addActionListener(this);
			listaItensCadastrados.addListSelectionListener(this);

	}



	//Captura eventos relacionados aos botões da interface
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		//Cadastro de novo item
		if(src == cadastroItem)
			new TelaCadastroItem().inserirEditar(1, dados, this, 0); 
		

		// Atualiza a lista de itens mostrados no JList
		if(src == refreshItem) {
			listaItensCadastrados.setListData(new ControleItens(dados).getNomeItem()); 	
			listaItensCadastrados.updateUI();
		}



	}
	 /**
	  * método resposável pelo clique em um item, permitirá a edição do mesmo.
	  */
	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaItensCadastrados) {
			new TelaCadastroItem().inserirEditar(2, dados, this,   	
					listaItensCadastrados.getSelectedIndex()); 		
		}

	}

}