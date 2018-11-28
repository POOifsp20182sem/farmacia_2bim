package br.ifsp.poo.farmacia.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import br.ifsp.poo.farmacia.control.ListVendasControl;
import br.ifsp.poo.farmacia.control.ProdutoControl;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;

public class FormEstoque extends JFrame{

	private static JPanel painel;
	private static JScrollPane barraRolagem;
	private static JTable dtListaEstoque;
	private static DefaultTableModel modelo = new DefaultTableModel();
	static ProdutoControl pcontrol = new ProdutoControl(); 
	
	public FormEstoque() {
		criaJTable("");
		FormEstoque();
	}
	
	public static void main(String[] args) {
		criaJTable("");
		FormEstoque();
	}
	
	private static void FormEstoque() {
		JFrame frame = new JFrame("Estoque");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		painel = new JPanel();
		
		frame.setContentPane(painel);
		
		JPanel pBotoes = new JPanel();
		JPanel pPesquisa = new JPanel();
		
		barraRolagem = new JScrollPane(dtListaEstoque);
		
		pBotoes.setLayout(new FlowLayout());
		pPesquisa.setLayout(new FlowLayout());
		
		JLabel lbl = new JLabel("Pesquisar:");
		JTextField txtPesquisar = new JTextField();
		txtPesquisar.setColumns(25);
		lbl.setBounds(40, 40, 70, 20);
		pPesquisa.add(lbl);
		
		txtPesquisar.setBounds(100, 100, 120, 100);
		pPesquisa.add(txtPesquisar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				criaJTable(txtPesquisar.getText());
			}
		});
		btnPesquisar.setBounds(200, 40, 89, 23);
		pPesquisa.add(btnPesquisar);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		JTextField txtQuantidade = new JTextField(); 
		txtQuantidade.setColumns(10);
		lblQuantidade.setBounds(40, 40, 70, 20);
		pBotoes.add(lblQuantidade);
		txtQuantidade.setBounds(100, 100, 120, 100);
		pBotoes.add(txtQuantidade);
		
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = dtListaEstoque.getSelectedRow();
				            
				if (linhaSelecionada >= 0) {
				     int idProduto = (int) dtListaEstoque.getValueAt(linhaSelecionada, 0);
				     // AtualizarVenda ic = new AtualizarVenda(modelo, idVenda, linhaSelecionada);
				    // ic.setVisible(true);
				   } else {
				        JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
				   }
			}
		});
		btnInserir.setBounds(450, 150, 89, 27);
		pBotoes.add(btnInserir);
		
		painel.add(pPesquisa, BorderLayout.NORTH);
		painel.add(barraRolagem, BorderLayout.CENTER);
		painel.add(pBotoes, BorderLayout.SOUTH);
		
		frame.setBounds(500, 500, 600, 600);
		frame.setVisible(true);
	}
	
	private static void criaJTable(String filtro) {
		try {
			dtListaEstoque = new JTable(modelo);
			modelo.addColumn("ID");
			modelo.addColumn("Nome Comercial");
			modelo.addColumn("Forma Farmaco");
			modelo.addColumn("Codigo de Barras");
			modelo.addColumn("Principio Ativo");
			modelo.addColumn("Classe Terapeutica");
			modelo.addColumn("Preço Unitario");
			modelo.addColumn("Quan	tidade");
			
			dtListaEstoque.getColumnModel().getColumn(0).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(1).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(2).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(3).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(5).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(6).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(7).setPreferredWidth(80);
			
			pesquisar(modelo, filtro);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela.");
		}
		
	}
	
	public static void pesquisar(DefaultTableModel modelo, String filtro) {
		modelo.setNumRows(0);
        
		try {
        	
	        for (Produto pro : pcontrol.listarProduto(filtro)) {
	            modelo.addRow(new Object[]{pro.getId(), pro.getNomeComercial()});
	        }
        } catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
