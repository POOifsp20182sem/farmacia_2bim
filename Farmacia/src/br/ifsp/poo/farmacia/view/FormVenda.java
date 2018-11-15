package br.ifsp.poo.farmacia.view;

import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) throws ParseException {
		
		JFrame frame = new JFrame("Venda");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		JPanel contentPane = new JPanel();
		
		Venda venda = new Venda();
		
		JLabel lbl1 = new JLabel("Data:");
		JLabel lblData = new JLabel();
		lblData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		lblData.setBounds(452, 28, 67, 14);
		lbl1.setBounds(452, 11, 37, 14);
		contentPane.setLayout(null);
		
		contentPane.add(lbl1);
		contentPane.add(lblData);
		
		VendaControl vc = new VendaControl();
		
		JLabel lbl2 = new JLabel("User:");
		JLabel lblUser = new JLabel();
		lblUser.setText(vc.getLogin());
		lbl2.setBounds(20, 373, 37, 14);
		lblUser.setBounds(67, 373, 70, 14);
		
		contentPane.add(lbl2);
		contentPane.add(lblUser);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(20, 25, 37, 14);
		JComboBox cboCliente = new JComboBox();
		cboCliente.setBounds(78, 22, 236, 20);
		
		for(Cliente c : vc.selecionarCliente()) {
			cboCliente.addItem(c);
		}
		
		contentPane.add(lblCliente);
		contentPane.add(cboCliente);
		
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(20, 270, 68, 14);
		contentPane.add(lblValorTotal);

		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(20, 295, 68, 14);
		contentPane.add(lblDesconto);

		JLabel lblValorFinal = new JLabel("Valor Final:");
		lblValorFinal.setBounds(20, 322, 68, 14);
		contentPane.add(lblValorFinal);

		JTextField txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(98, 270, 86, 20);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);

		JTextField txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setBounds(98, 295, 86, 20);
		contentPane.add(txtDesconto);
		txtDesconto.setColumns(10);

		JTextField txtValorFinal = new JTextField();
		txtValorFinal.setEditable(false);
		txtValorFinal.setBounds(98, 322, 86, 20);
		contentPane.add(txtValorFinal);
		txtValorFinal.setColumns(10);

		JLabel lblFormaPagamento = new JLabel("Forma Pagamento:");
		lblFormaPagamento.setBounds(20, 201, 115, 14);
		contentPane.add(lblFormaPagamento);

		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setBounds(348, 270, 71, 14);
		contentPane.add(lblValorPago);

		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setBounds(348, 295, 71, 14);
		contentPane.add(lblTroco);

		JTextField txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		txtValorPago.setBounds(423, 270, 86, 20);
		contentPane.add(txtValorPago);

		JTextField txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setColumns(10);
		txtTroco.setBounds(423, 295, 86, 20);
		contentPane.add(txtTroco);

		JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(41, 222, 109, 23);
		contentPane.add(rdbtnDinheiro);
		
		JRadioButton rdbtnCarto = new JRadioButton("Cartão");
		rdbtnCarto.setBounds(165, 222, 109, 23);
		contentPane.add(rdbtnCarto);

		ButtonGroup btnGroup = new ButtonGroup();

		btnGroup.add(rdbtnDinheiro);
		btnGroup.add(rdbtnCarto);
		
		JTable dtListaMedicamentos = new JTable();
		dtListaMedicamentos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
						"Medicamento", "Quantidade", "Valor Item"
				}
				) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
					String.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		dtListaMedicamentos.getColumnModel().getColumn(1).setPreferredWidth(80);
		dtListaMedicamentos.setBounds(20, 90, 400, 100);
		contentPane.add(dtListaMedicamentos);
		
		frame.setContentPane(contentPane);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(20, 60, 46, 14);
		contentPane.add(lblProduto);
		
		JTextField txtProduto = new JTextField();
		txtProduto.setBounds(78, 57, 236, 20);
		contentPane.add(txtProduto);
		txtProduto.setColumns(10);		
		
		JButton btnAdicionarPP = new JButton("Adicionar");
		btnAdicionarPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutosPedidos pp = new ProdutosPedidos();
				
				double subtotal = venda.getTotal() + vc.calcularSubtotal(pp);
				venda.setTotal(subtotal);
				pp.setVenda(venda);
			}
		});
		btnAdicionarPP.setBounds(430, 104, 89, 23);
		contentPane.add(btnAdicionarPP);
		
		JButton btnRemoverPP = new JButton("Remover");
		btnRemoverPP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProdutosPedidos pp = new ProdutosPedidos();
				
				double subtotal = venda.getTotal() - vc.calcularSubtotal(pp);
				venda.setTotal(subtotal);
				pp.setVenda(venda);		
			}
		});
		btnRemoverPP.setBounds(430, 145, 89, 23);
		contentPane.add(btnRemoverPP);
		
		JButton btnConcluir = new JButton("Concluir");
		btnConcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				vc.insertVenda(venda);
			}
		});
		btnConcluir.setBounds(430, 364, 89, 23);
		contentPane.add(btnConcluir);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnCancelar.setBounds(277, 364, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FormBuscaProd formBusca = new FormBuscaProd();
			}
		});
		btnBuscar.setBounds(330, 56, 89, 23);
		contentPane.add(btnBuscar);
		
		frame.setVisible(true);
		frame.setLocation(350, 200);
		frame.setBounds(500, 500, 574, 463);
	}
}
