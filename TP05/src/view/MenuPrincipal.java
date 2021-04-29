package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import control.*; //control

/**
 * Classe responsável pela inicialização do programa. 
 * É a única classe que possui o método MAIN.
 * Essa classe cria a Tela principal onde o usuário irá começar sua navegação no programa.
 * 
 * @author Ian
 * @version 1.0 (28/04/2021)
 */

public class MenuPrincipal implements ActionListener {
	
	private static JFrame janela = new JFrame("Lista de Compras");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton lista = new JButton("Lista de compras");
	private static JButton carrinho = new JButton("Carrinho");
	public static ControleDados dados = new ControleDados(); 
	
	public MenuPrincipal() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(120, 10, 150, 30);
		lista.setBounds(127, 50, 130, 30);
		carrinho.setBounds(127, 100, 130, 30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(lista);
		janela.add(carrinho);
		
		janela.setSize(400, 250);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	/**
	 * Função main do programa.
	 * @param args
	 */
	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		
		lista.addActionListener(menu);
		carrinho.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == lista) {
			new TelaLista().mostrarDados(dados); 
		}
		if(src == carrinho)
			new TelaCarrinho().mostrarValorTotal(dados);
	}
}
