package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import control.*; //control

public class MenuPrincipal implements ActionListener {
	
	private static JFrame janela = new JFrame("Lista de Compras");
	private static JLabel titulo = new JLabel("Menu Principal");
	private static JButton lista = new JButton("Lista de compras");
	private static JButton carrinho = new JButton("Carrinho");
	public static ControleDados dados = new ControleDados(); // control
	
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
	
	public static void main(String[] args) {
		MenuPrincipal menu = new MenuPrincipal();
		
		lista.addActionListener(menu);
		carrinho.addActionListener(menu);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == lista) {
			new TelaLista().mostrarDados(dados); //control 
		}
		if(src == carrinho)
			new TelaCarrinho().mostrarValorTotal(dados);
	}
}
