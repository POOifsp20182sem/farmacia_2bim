package br.ifsp.poo.farmacia.view;

import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import br.ifsp.poo.farmacia.control.VendaControl;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.EnumPagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Login;
import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.entidade.ProdutosPedidos;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FormVenda {
	
	private static JTable tabela;
	private static JScrollPane barraRolagem;
	private static DefaultTableModel modelo = new DefaultTableModel();
	private static Venda venda = new Venda();
	private static JTextField txtQuantidade;
	private static JComboBox cboProduto;
	
	
	public FormVenda() {
		criarJanela();
		criarJTable();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ParseException {
		
		criarJanela();
		criarJTable();
	}
		
	private static void criarJanela() {
		JFrame frame = new JFrame("Venda");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		JPanel contentPane = new JPanel();
		
		frame.setContentPane(contentPane);
		
		VendaControl vc = new VendaControl();
		
		JLabel lbl1 = new JLabel("Data:");
		JLabel lblData = new JLabel();
		lblData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		lblData.setBounds(452, 61, 67, 14);
		lbl1.setBounds(452, 44, 37, 14);
		contentPane.setLayout(null);
		
		contentPane.add(lbl1);
		contentPane.add(lblData);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(20, 157, 405, 171);
		contentPane.add(barraRolagem);
		
		JLabel lbl2 = new JLabel("User:");
		JLabel lblUser = new JLabel();
		//lblUser.setText(vc.getLogin());
		lbl2.setBounds(20, 399, 37, 14);
		lblUser.setBounds(78, 399, 70, 14);
		
		contentPane.add(lbl2);
		contentPane.add(lblUser);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(20, 30, 86, 14);
		JComboBox cboCliente = new JComboBox();
		cboCliente.setBounds(20, 44, 236, 20);
		
		for(Cliente c : vc.selecionarCliente()) {
			cboCliente.addItem(c);
		}
		
		cboCliente.setSelectedIndex(-1);
		contentPane.add(lblCliente);
		contentPane.add(cboCliente);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(26, 339, 68, 14);
		contentPane.add(lblValorTotal);

		JTextField txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(104, 339, 86, 20);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(20, 79, 86, 14);
		contentPane.add(lblProduto);
		
		JTextField txtProduto = new JTextField();
		txtProduto.setBounds(20, 124, 236, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);		
		
		ArrayList<ProdutosPedidos> produtos = new ArrayList<ProdutosPedidos>();
		
		JButton btnAdicionarPP = new JButton("Adicionar");
		btnAdicionarPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ProdutosPedidos pp = new ProdutosPedidos();
					pp.setProduto((Produto)cboProduto.getSelectedItem());
					pp.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
					
					double subtotal = venda.getTotal() + vc.calcularSubtotal(pp);
					
					txtValorTotal.setText(String.valueOf(subtotal));
					venda.setTotal(subtotal);
					produtos.add(pp);
					tabela.revalidate();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}					
			}
		});
		btnAdicionarPP.setBounds(436, 199, 89, 23);
		contentPane.add(btnAdicionarPP);
		
		JButton btnRemoverPP = new JButton("Remover");
		btnRemoverPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ProdutosPedidos pp = new ProdutosPedidos();
					
					int linhaSelecionada = -1;
		            linhaSelecionada = tabela.getSelectedRow();
		            
		            if (linhaSelecionada >= 0) {
		                pp = (ProdutosPedidos) tabela.getValueAt(linhaSelecionada, 0);
		                modelo.removeRow(linhaSelecionada);
		                produtos.remove(pp);
		                tabela.revalidate();
		            } else {
		                JOptionPane.showMessageDialog(null, "É necesário selecionar uma linha.");
		            }
					
					double subtotal = venda.getTotal() - vc.calcularSubtotal(pp);
					venda.setTotal(subtotal);	
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});
		btnRemoverPP.setBounds(436, 240, 89, 23);
		contentPane.add(btnRemoverPP);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {									
					// TODO: BUSCAR UMA FORMA DE PEGAR O FUNCIONARIO LOGADO
					venda.setFuncionario(null);
					venda.setCliente((Cliente)cboCliente.getSelectedItem());				
					venda.setData(lblData.getText());
					venda.setTotal(Double.parseDouble(txtValorTotal.getText()));
					venda.setProdutos(produtos);
					vc.insertVenda(venda);
					
					FormPagamento pag = new FormPagamento(venda);
					frame.dispose();
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}		
			}
		});
		btnConcluir.setBounds(436, 395, 89, 23);
		contentPane.add(btnConcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(275, 395, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormBuscaProd formBusca = new FormBuscaProd();
			}
		});
		btnBuscar.setBounds(272, 123, 89, 23);
		contentPane.add(btnBuscar);
		
		cboProduto = new JComboBox();
		cboProduto.setBounds(20, 93, 236, 20);
		
		for(Produto p : vc.selecionarMedicamento()) {
			cboProduto.addItem(p);
		}
		
		cboProduto.setSelectedIndex(-1);
		contentPane.add(cboProduto);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(275, 93, 86, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(277, 79, 109, 14);
		contentPane.add(lblQuantidade);
		
		frame.setVisible(true);
		frame.setBounds(400, 200, 574, 487);
	}
	
	private static void criarJTable() {
		try {
			tabela = new JTable(modelo);
	        modelo.addColumn("Produto");
	        modelo.addColumn("Quantidade");
	        modelo.addColumn("Valor Item");
	        
	        tabela.getColumnModel().getColumn(0).setPreferredWidth(100);
	        tabela.getColumnModel().getColumn(1).setPreferredWidth(30);
	        tabela.getColumnModel().getColumn(2).setPreferredWidth(60);
	        
	        carregar(modelo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar tabela.");
		}
	}
	
	private static void carregar(DefaultTableModel modelo) {
        modelo.setNumRows(0);
 
        try {
        	ArrayList<ProdutosPedidos> produtos = venda.getProdutos();
        	
	        for (ProdutosPedidos pro : produtos) {
	            modelo.addRow(new Object[]{pro.getProduto().getNomeComercial(), pro.getQuantidade(), pro.getValorItem()});
	        }
        } catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
    }
}
