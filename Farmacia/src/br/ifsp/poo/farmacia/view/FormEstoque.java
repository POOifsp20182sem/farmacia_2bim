package br.ifsp.poo.farmacia.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import br.ifsp.poo.farmacia.control.ListVendasControl;
import br.ifsp.poo.farmacia.control.ProdutoControl;
import br.ifsp.poo.farmacia.modelo.entidade.ClasseTerapeutica;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFormaFarmaco;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.PrincipioAtivo;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;

public class FormEstoque extends JFrame{

	private static JPanel painel;
	private static JScrollPane barraRolagem;
	private static JTable dtListaEstoque;
	private static DefaultTableModel modelo = new DefaultTableModel();
	static ProdutoControl ctProduto = new ProdutoControl(); 
	
	
	public FormEstoque() {
		criaJTable("");
		criaJanela();
		setVisible(true);
	}
	
	public static void main(String[] args) {
		FormEstoque form = new FormEstoque();
	}
	
	private void criaJanela() {
		setTitle("Estoque");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 473);
		painel = new JPanel();
		painel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(painel);
		painel.setLayout(null);
			
		JLabel lbl = new JLabel("Pesquisar:");
		JTextField txtPesquisar = new JTextField();
		txtPesquisar.setColumns(25);
		lbl.setBounds(20, 20, 70, 20);
		painel.add(lbl);
		
		txtPesquisar.setBounds(100, 20, 350, 20);
		painel.add(txtPesquisar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisar(modelo, "");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(470, 19, 100, 23);
		painel.add(btnPesquisar);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		JTextField txtQuantidade = new JTextField(); 
		txtQuantidade.setColumns(10);
		lblQuantidade.setBounds(144, 400, 70, 20);
		painel.add(lblQuantidade);
		txtQuantidade.setBounds(237, 400, 100, 20);
		painel.add(txtQuantidade);
		
		
		JButton btnInserir = new JButton("Inserir");
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = -1;
				linhaSelecionada = dtListaEstoque.getSelectedRow();
				            
				if (linhaSelecionada >= 0) {
				     int idProduto = (int) dtListaEstoque.getValueAt(linhaSelecionada, 0);
				     int qtdProduto = (int) dtListaEstoque.getValueAt(linhaSelecionada, 7);
				     qtdProduto =+ Integer.parseInt(txtQuantidade.getText());
				     Produto prod = new Produto();
				     prod.setNomeComercial((String) dtListaEstoque.getValueAt(linhaSelecionada, 1));
				     prod.setApresentacao((String) dtListaEstoque.getValueAt(linhaSelecionada, 2));
				     prod.setFormaFarmaco((EnumFormaFarmaco)(dtListaEstoque.getValueAt(linhaSelecionada, 3)));
				     prod.setCodigoBarras((String) dtListaEstoque.getValueAt(linhaSelecionada, 4));
				     prod.setPrincipioAtivo((PrincipioAtivo) dtListaEstoque.getValueAt(linhaSelecionada, 5));
				     prod.setClasseTerapeutica((ClasseTerapeutica) dtListaEstoque.getValueAt(linhaSelecionada, 6));
				     prod.setPrecoUnitario((int) dtListaEstoque.getValueAt(linhaSelecionada, 7));
				     prod.setQuantidade(qtdProduto);
 				     try {
						ctProduto.atualizarProduto(prod);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				   } else {
				        JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
				   }
			}
		});
		btnInserir.setBounds(347, 399, 89, 23);
		painel.add(btnInserir);
		
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstoque.setBounds(10, 60, 123, 14);
		painel.add(lblEstoque);

		/*JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener((a) -> {
			int linhaSelecionada = -1;
			linhaSelecionada = dtListaEstoque.getSelectedRow();
			String idS = String.valueOf(dtListaEstoque.getModel().getValueAt(linhaSelecionada, 0));
			int id = Integer.parseInt(idS);
			Produto p = ctProduto.buscarProduto(id);
			
				ctProduto.atualizarProduto(p.getQuantidade());
			
				
				txtNome.setText(f.getNome());
				mskCpf.setText(f.getDocumento());
				txtLogradouro.setText(f.getEndereco());
				txtEmail.setText(f.getEmail());
				mskTelefone.setText(f.getTelefone());
				mskCelular.setText(f.getCelular());
				//nÃ£o carrega quando Ã© dia/mes de um caracter sÃ³
				mskDataNasc.setText(f.getStrDataNascimento().replace(".", "/"));
				cboTipo.setSelectedItem(f.getTipoFuncionario());
				System.out.println(f.getStrDataNascimento().replace(".", "/"));
				mskSalario.setText(String.valueOf(f.getSalario()).replace(".", ","));
				txtUser.setText(f.getLogin().getUserName());
				pswSenha.setText(f.getLogin().getPassword());
			
		});
		btnSelecionar.setBounds(243, 333, 106, 23);
		painel.add(btnSelecionar);*/
		
		barraRolagem = new JScrollPane(dtListaEstoque);
		barraRolagem.setBounds(20, 100, 590, 280);
		painel.add(barraRolagem);
		
	}
	
	private static void criaJTable(String filtro) {
		try {
			dtListaEstoque = new JTable(modelo);
			modelo.addColumn("ID");
			modelo.addColumn("Nome Comercial");
			modelo.addColumn("Apresentação");
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
			dtListaEstoque.getColumnModel().getColumn(8).setPreferredWidth(80);
			
			pesquisar(modelo, "");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar a tabela.");
		}
		
	}
	
	
	public static void pesquisar(DefaultTableModel modelo, String filtro) throws SQLException {
		modelo.setNumRows(0);
		ProdutoControl ctProduto = new ProdutoControl();
		
		try {
			ArrayList<Produto> prod = ctProduto.listarProduto(filtro);
			for(Produto p:prod) {
				String[] dados = new String[9];
				dados[0] = String.valueOf(p.getId());
				dados[1] = p.getNomeComercial();
				dados[2] = p.getApresentacao();
				dados[3] = p.getCodigoBarras();
				dados[4] = p.getFormaFarmaco();
				dados[5] = String.valueOf(p.getPrincipioAtivo());
				dados[6] = String.valueOf(p.getClasseTerapeutica());
				dados[7] = String.valueOf(p.getPrecoUnitario());
				dados[8] = String.valueOf(p.getQuantidade());
				
				modelo.addRow(dados);
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
