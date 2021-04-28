package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import control.*; //control


public class TelaCarrinho implements ActionListener {		
	private JFrame janela;
	private JLabel titulo;
	private JLabel valorCarrinho;
	private JButton fechar;
	private static ControleDados dados; // control

	
	
	public void mostrarValorTotal(ControleDados d){ // control
		dados = d; // control 
		double valorTotal = 0;
		
		for(int i = 0; i < dados.getQtdItens(); i++) {
			valorTotal = valorTotal + (dados.getItens()[i].getValorProduto() * dados.getItens()[i].getQuantidade());
		}
		
		
			janela = new JFrame("Carrinho");
			titulo = new JLabel("Seu Carrinho");
			valorCarrinho = new JLabel("Valor total do Carrinho: "+ String.valueOf(valorTotal));
			fechar = new JButton("OK");

			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			valorCarrinho.setFont(new Font("Arial", Font.BOLD, 14));
			titulo.setBounds(120, 10, 150, 30);
			valorCarrinho.setBounds(80, 50, 290, 60);

			fechar.setBounds(140, 150, 100, 30);

			janela.setLayout(null);

			janela.add(titulo);
			janela.add(valorCarrinho);
			janela.add(fechar);

			janela.setSize(400, 250);
			janela.setVisible(true);

			fechar.addActionListener(this);

	}



	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		
		if(src == fechar)
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

	}

}