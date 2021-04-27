package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import control.*; //control


public class TelaLista implements ActionListener, ListSelectionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroItem;
	private JButton refreshItem;
	private static ControleDados dados; // control
	private JList<String> listaItensCadastrados;
	private String[] listaItens = new String[50];

	public void mostrarDados(ControleDados d){ // control
		dados = d; // control 

		
			// Mostrar dados de itens cadastrados (JList)
			listaItens = new ControleItens(dados).getNomeItem(); // control
			listaItensCadastrados = new JList<String>(listaItens);
			janela = new JFrame("Lista");
			titulo = new JLabel("Itens Cadastrados");
			cadastroItem = new JButton("Cadastrar");
			refreshItem = new JButton("Refresh");

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
			new TelaCadastroItem().inserirEditar(1, dados, this, 0); //control 
		

		// Atualiza a lista de itens mostrados no JList
		if(src == refreshItem) {
			listaItensCadastrados.setListData(new ControleItens(dados).getNomeItem()); //control		
			listaItensCadastrados.updateUI();
		}



	}

	//Captura eventos relacionados ao JList
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();

		if(e.getValueIsAdjusting() && src == listaItensCadastrados) {
			new TelaCadastroItem().inserirEditar(2, dados, this,   	//control
					listaItensCadastrados.getSelectedIndex()); 		//control 
		}

	}

}