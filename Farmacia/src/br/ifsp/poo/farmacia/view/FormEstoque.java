package br.ifsp.poo.farmacia.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import br.ifsp.poo.farmacia.modelo.entidade.Venda;

public class FormEstoque extends JFrame{

	private static JPanel painel;
	private static JScrollPane barraRolagem;
	private static JTable dtListaEstoque;
	private static DefaultTableModel modelo = new DefaultTableModel();
	
	public FormEstoque() {
		criaJTable();
		FormEstoque();
	}
	
	public static void main(String[] args) {
		criaJTable();
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
				
			}
		});
		btnPesquisar.setBounds(200, 40, 89, 23);
		pPesquisa.add(btnPesquisar);
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnInserir.setBounds(450, 150, 89, 27);
		pBotoes.add(btnInserir);
		
		painel.add(pPesquisa, BorderLayout.NORTH);
		painel.add(barraRolagem, BorderLayout.CENTER);
		painel.add(pBotoes, BorderLayout.PAGE_END);
		
		frame.setLocation(350, 200);
		frame.setBounds(500, 500, 574, 463);
		frame.setVisible(true);
	}
	
	private static void criaJTable() {
		try {
			dtListaEstoque = new JTable(modelo);
			modelo.addColumn("ID");
			modelo.addColumn("Nome Comercial");
			modelo.addColumn("Forma Farmaco");
			modelo.addColumn("Codigo de Barras");
			modelo.addColumn("Principio Ativo");
			modelo.addColumn("Classe Terapeutica");
			modelo.addColumn("Preço Unitario");
			modelo.addColumn("Quantidade");
			
			dtListaEstoque.getColumnModel().getColumn(0).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(1).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(2).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(3).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(4).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(5).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(6).setPreferredWidth(80);
			dtListaEstoque.getColumnModel().getColumn(7).setPreferredWidth(80);
			
			pesquisar(modelo);
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela.");
		}
		
	}
	
	public static void pesquisar(DefaultTableModel modelo) {
		modelo.setNumRows(0);
        
        ListVendasControl lvControl = new ListVendasControl();
 
        try {
        	
	        for (Venda ven : lvControl.selectVenda()) {
	            modelo.addRow(new Object[]{ven.getId(), ven.getData(), ven.getCliente().getNome(),
	            		ven.getFuncionario().getNome(), ven.getTotal(), ven.getDesconto()});
	        }
        } catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
