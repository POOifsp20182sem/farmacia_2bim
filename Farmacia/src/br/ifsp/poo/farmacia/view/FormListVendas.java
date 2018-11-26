package br.ifsp.poo.farmacia.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
import br.ifsp.poo.farmacia.control.VendaControl;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;

public class FormListVendas extends JFrame {
	
	private static JPanel contentPane;
	private static JTable tabela;
	private static JScrollPane barraRolagem;
	private static DefaultTableModel modelo = new DefaultTableModel();
	private static JTextField txtPesquisar; 
	
	static ListVendasControl lvControl = new ListVendasControl();

	public FormListVendas() {
		criaJTable("");
		criaJanela();
	}
	
	public static void main(String[] args) {
		criaJTable("");
		criaJanela();
	}
	
	private static void criaJanela() {
		
		JFrame frame = new JFrame("Histórico de Vendas");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		contentPane = new JPanel();
		
		frame.setContentPane(contentPane);
		
		JPanel pBotoes = new JPanel();
		JPanel pPesquisa = new JPanel();
		
		barraRolagem = new JScrollPane(tabela);
		
		pBotoes.setLayout(new FlowLayout());
		pPesquisa.setLayout(new FlowLayout());
		
		JLabel lbl = new JLabel("Pesquisar:");
		txtPesquisar = new JTextField();
		txtPesquisar.setColumns(25);
		lbl.setBounds(40, 40, 70, 20);
		pPesquisa.add(lbl);
		
		txtPesquisar.setBounds(100, 100, 120, 100);
		pPesquisa.add(txtPesquisar);
		
		// Botao Pesquisar
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pesquisar(modelo, txtPesquisar.getText());
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Erro ao buscar a venda. (GUI)");
				}
				tabela.repaint();
			}
		});
		btnPesquisar.setBounds(200, 40, 89, 23);
		pPesquisa.add(btnPesquisar);
		
		
		// Botao Excluir
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int linhaSelecionada = -1;
	            linhaSelecionada = tabela.getSelectedRow();
	            
	            if (linhaSelecionada >= 0) {
	                int idVenda = (int) tabela.getValueAt(linhaSelecionada, 0);
	                
	                lvControl.deleteVenda(idVenda);
	                modelo.removeRow(linhaSelecionada);
	            } else {
	                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
	            }
			}
		});
		btnExcluir.setBounds(450, 150, 89, 23);
		pBotoes.add(btnExcluir);
		
		contentPane.add(pPesquisa, BorderLayout.NORTH);
		contentPane.add(barraRolagem, BorderLayout.CENTER);
		contentPane.add(pBotoes, BorderLayout.SOUTH);

		frame.setBounds(100, 100, 500, 570);
		frame.setVisible(true);
	}
	
	private static void criaJTable(String filtro) {
		
		try {
			tabela = new JTable(modelo);
	        modelo.addColumn("ID");
	        modelo.addColumn("Data");
	        modelo.addColumn("Cliente");
	        modelo.addColumn("Funcionario");
	        modelo.addColumn("Total");
	        modelo.addColumn("Desconto");
	        
	        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
	        tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
	        tabela.getColumnModel().getColumn(2).setPreferredWidth(100);
	        tabela.getColumnModel().getColumn(3).setPreferredWidth(100);
	        tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
	        tabela.getColumnModel().getColumn(5).setPreferredWidth(50);
	        
	        pesquisar(modelo, filtro);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar tabela.");
		}
		
	}
	
	public static void pesquisar(DefaultTableModel modelo, String filtro) throws SQLException {
        modelo.setNumRows(0);
        
        try {
	        for (Venda ven : lvControl.selectVenda(filtro)) {
	            modelo.addRow(new Object[]{ven.getId(), ven.getData(), ven.getCliente().getNome(),
	            		ven.getFuncionario().getNome(), ven.getTotal(), ven.getDesconto()});
	        }
        } catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela.");
		}
    }
}
