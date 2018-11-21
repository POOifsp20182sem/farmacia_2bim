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
	
	
	public FormVenda() {
		criaJanela();
		criaJTable();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ParseException {
		
		criaJanela();
		criaJTable();
	}
		
	private static void criaJanela() {
		JFrame frame = new JFrame("Venda");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		JPanel contentPane = new JPanel();
		
		frame.setContentPane(contentPane);
		
		VendaControl vc = new VendaControl();
		
		JLabel lbl1 = new JLabel("Data:");
		JLabel lblData = new JLabel();
		lblData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		lblData.setBounds(452, 42, 67, 14);
		lbl1.setBounds(452, 25, 37, 14);
		contentPane.setLayout(null);
		
		contentPane.add(lbl1);
		contentPane.add(lblData);
		
		barraRolagem = new JScrollPane(tabela);
		barraRolagem.setBounds(20, 138, 405, 102);
		contentPane.add(barraRolagem);
		
		JLabel lbl2 = new JLabel("User:");
		JLabel lblUser = new JLabel();
		//lblUser.setText(vc.getLogin());
		lbl2.setBounds(26, 423, 37, 14);
		lblUser.setBounds(73, 423, 70, 14);
		
		contentPane.add(lbl2);
		contentPane.add(lblUser);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(20, 11, 37, 14);
		JComboBox cboCliente = new JComboBox();
		cboCliente.setBounds(20, 25, 236, 20);
		
		for(Cliente c : vc.selecionarCliente()) {
			cboCliente.addItem(c);
		}
		
		contentPane.add(lblCliente);
		contentPane.add(cboCliente);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(26, 320, 68, 14);
		contentPane.add(lblValorTotal);

		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(26, 345, 68, 14);
		contentPane.add(lblDesconto);

		JLabel lblValorFinal = new JLabel("Valor Final:");
		lblValorFinal.setBounds(26, 372, 68, 14);
		contentPane.add(lblValorFinal);

		JTextField txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(104, 320, 86, 20);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);

		JTextField txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setBounds(104, 345, 86, 20);
		contentPane.add(txtDesconto);
		txtDesconto.setColumns(10);

		JTextField txtValorFinal = new JTextField();
		txtValorFinal.setEditable(false);
		txtValorFinal.setBounds(104, 372, 86, 20);
		contentPane.add(txtValorFinal);
		txtValorFinal.setColumns(10);

		JLabel lblFormaPagamento = new JLabel("Forma Pagamento:");
		lblFormaPagamento.setBounds(26, 251, 115, 14);
		contentPane.add(lblFormaPagamento);

		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setBounds(354, 320, 71, 14);
		contentPane.add(lblValorPago);

		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setBounds(354, 345, 71, 14);
		contentPane.add(lblTroco);

		JTextField txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		txtValorPago.setBounds(429, 320, 86, 20);
		contentPane.add(txtValorPago);

		JTextField txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setColumns(10);
		txtTroco.setBounds(429, 345, 86, 20);
		contentPane.add(txtTroco);

		JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(47, 272, 109, 23);
		contentPane.add(rdbtnDinheiro);
		
		JRadioButton rdbtnCarto = new JRadioButton("Cartão");
		rdbtnCarto.setBounds(171, 272, 109, 23);
		contentPane.add(rdbtnCarto);

		ButtonGroup btnGroup = new ButtonGroup();

		btnGroup.add(rdbtnDinheiro);
		btnGroup.add(rdbtnCarto);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(20, 60, 46, 14);
		contentPane.add(lblProduto);
		
		JTextField txtProduto = new JTextField();
		txtProduto.setBounds(20, 105, 236, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);		
		
		ArrayList<ProdutosPedidos> produtos = new ArrayList<ProdutosPedidos>();
		
		JButton btnAdicionarPP = new JButton("Adicionar");
		btnAdicionarPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutosPedidos pp = new ProdutosPedidos();
				
				produtos.add(pp);
				
				double subtotal = venda.getTotal() + vc.calcularSubtotal(pp);
				venda.setTotal(subtotal);
				pp.setVenda(venda);
			}
		});
		btnAdicionarPP.setBounds(436, 154, 89, 23);
		contentPane.add(btnAdicionarPP);
		
		JButton btnRemoverPP = new JButton("Remover");
		btnRemoverPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutosPedidos pp = new ProdutosPedidos();
				
				produtos.remove(pp);
				
				double subtotal = venda.getTotal() - vc.calcularSubtotal(pp);
				venda.setTotal(subtotal);
				pp.setVenda(venda);		
			}
		});
		btnRemoverPP.setBounds(436, 195, 89, 23);
		contentPane.add(btnRemoverPP);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				venda.setProdutos(produtos);
				vc.insertVenda(venda);
			}
		});
		btnConcluir.setBounds(436, 414, 89, 23);
		contentPane.add(btnConcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(283, 414, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormBuscaProd formBusca = new FormBuscaProd();
			}
		});
		btnBuscar.setBounds(272, 104, 89, 23);
		contentPane.add(btnBuscar);
		
		JComboBox cboProduto = new JComboBox();
		cboProduto.setBounds(20, 74, 236, 20);
		contentPane.add(cboProduto);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(275, 74, 86, 20);
		contentPane.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		JLabel lblQuantidade = new JLabel("Quantidade:");
		lblQuantidade.setBounds(277, 60, 60, 14);
		contentPane.add(lblQuantidade);
		
		frame.setVisible(true);
		frame.setLocation(350, 200);
		frame.setBounds(500, 500, 574, 487);
	}
	
	private static void criaJTable() {
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
	
	public static void carregar(DefaultTableModel modelo) {
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
