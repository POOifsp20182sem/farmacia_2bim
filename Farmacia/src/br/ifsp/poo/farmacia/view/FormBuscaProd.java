package br.ifsp.poo.farmacia.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import br.ifsp.poo.farmacia.modelo.entidade.EnumFormaFarmaco;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;

public class FormBuscaProd {

	private static JPanel panel;
	static JTable dtListaMedicamentos = new JTable();
	static JScrollPane barraRolagem;
	static DefaultTableModel modelo = new DefaultTableModel();
	static ProdutoControl pcontrol = new ProdutoControl(); 
	
	public FormBuscaProd(){
		BuscaProd();
		
	}
	
	public static void main(String[] args) {
		BuscaProd();
	}
	
	public static void BuscaProd() {
		JFrame frame = new JFrame("Busca de Produtos");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		panel = new JPanel();
		
		frame.setContentPane(panel);
		
		barraRolagem = new JScrollPane(dtListaMedicamentos);
		
		dtListaMedicamentos.setBounds(20, 90, 400, 100);
		
		panel.add(barraRolagem);
		
		JPanel pBotoes = new JPanel();
		JPanel pPesquisa = new JPanel();
		
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
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormVenda ven = new FormVenda(produto);
				int linhaSelecionada = -1;
	            linhaSelecionada = dtListaMedicamentos.getSelectedRow();
	            
	            if (linhaSelecionada >= 0) {
	            	Produto prod = new Produto();
	                int idProd = (int) dtListaMedicamentos.getValueAt(linhaSelecionada, 0);
	                String comercial = (String) dtListaMedicamentos.getValueAt(linhaSelecionada, 1);
	                EnumFormaFarmaco farmaco = (EnumFormaFarmaco) dtListaMedicamentos.getValueAt(linhaSelecionada, 2); 
	                String codigo = (String) dtListaMedicamentos.getValueAt(linhaSelecionada, 3);
	                int idPrincipio = (int) dtListaMedicamentos.getValueAt(linhaSelecionada, 4);
	                int idTerapeutica = (int) dtListaMedicamentos.getValueAt(linhaSelecionada, 5);
	                double preco = (Double) dtListaMedicamentos.getValueAt(linhaSelecionada, 6);
	                
	                ListVendasControl vc = new ListVendasControl();
	                vc.deleteVenda(idVenda);
	                modelo.removeRow(linhaSelecionada);
	            } else {
	                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
	            }
				
				
			}
		});
		btnPesquisar.setBounds(200, 40, 89, 23);
		pBotoes.add(btnSelecionar);
		
		panel.add(pPesquisa, BorderLayout.NORTH);
		panel.add(barraRolagem, BorderLayout.CENTER);
		panel.add(pBotoes, BorderLayout.SOUTH); 
		
		frame.setVisible(true);
		frame.setBounds(200, 200, 500, 550);
	}
	
	private static void criaJTable(String filtro) {
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
		
		pesquisar(modelo, filtro);
	}
	
	private static void pesquisar(DefaultTableModel modelo, String filtro) {
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
