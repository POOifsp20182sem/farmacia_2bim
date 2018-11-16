package br.ifsp.poo.farmacia.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ifsp.poo.farmacia.control.ProdutoControl;

public class FormBuscaProd {

	private static JPanel panel;
	JTable dtListaMedicamentos = new JTable();
	DefaultTableModel modelo = new DefaultTableModel();
	
	public FormBuscaProd() {
		JFrame frame = new JFrame("Busca de Produtos");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setContentPane(panel);
		
		dtListaMedicamentos.setBounds(20, 90, 400, 100);
		
		panel.add(dtListaMedicamentos);
		
		JButton btnRemover = new JButton("Remover");
		JButton btnAlterar = new JButton("Alterar");
		JButton btnInserir = new JButton("Inserir");
		
		panel.add(btnInserir);
		panel.add(btnAlterar);
		panel.add(btnRemover);
		
		frame.setVisible(true);
		frame.setLocation(350, 200);
		frame.setBounds(500, 500, 574, 463);
	}
	
	private void criaJTable() {
		modelo.addColumn("ID");
		modelo.addColumn("Nome Comercial");
		modelo.addColumn("Forma Farmaco");
		modelo.addColumn("Codigo de Barras");
		modelo.addColumn("Principio Ativo");
		modelo.addColumn("Classe Terapeutica");
		modelo.addColumn("Preço Unitario");
		
		dtListaMedicamentos.getColumnModel().getColumn(0).setPreferredWidth(80);
		dtListaMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(80);
		dtListaMedicamentos.getColumnModel().getColumn(2).setPreferredWidth(80);
		dtListaMedicamentos.getColumnModel().getColumn(3).setPreferredWidth(80);
		dtListaMedicamentos.getColumnModel().getColumn(4).setPreferredWidth(80);
		dtListaMedicamentos.getColumnModel().getColumn(5).setPreferredWidth(80);
		dtListaMedicamentos.getColumnModel().getColumn(6).setPreferredWidth(80);
		
		pesquisar(modelo);
	}
	
	private void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
		
		ProdutoControl pc = new ProdutoControl();
		
//		pc.selectProduto();
	}
}
