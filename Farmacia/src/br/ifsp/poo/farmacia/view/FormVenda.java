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

import br.ifsp.poo.farmacia.modelo.entidade.Login;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class FormVenda {

	public static void main(String[] args) throws ParseException {
		
		JFrame frame = new JFrame("Venda");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		JPanel contentPane = new JPanel();
		
		JLabel lbl1 = new JLabel("Data:");
		JLabel lblData = new JLabel();
		lblData.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		lblData.setBounds(67, 368, 67, 14);
		lbl1.setBounds(20, 368, 37, 14);
		contentPane.setLayout(null);
		
		contentPane.add(lbl1);
		contentPane.add(lblData);
		
		JLabel lbl2 = new JLabel("User:");
		JLabel lblUser = new JLabel();
		lblUser.setText(Login.class.getSimpleName());
		lbl2.setBounds(197, 368, 37, 14);
		lblUser.setBounds(244, 368, 70, 14);
		
		contentPane.add(lbl2);
		contentPane.add(lblUser);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(20, 25, 37, 14);
		JComboBox cboCliente = new JComboBox();
		cboCliente.setBounds(78, 22, 156, 20);
		
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
		
		JRadioButton rdbtnCarto = new JRadioButton("Cart�o");
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
		frame.setVisible(true);
		frame.setLocation(350, 200);
		
		JButton btnBuscaMed = new JButton();
		btnBuscaMed.setSize(37, 33);
		btnBuscaMed.setLocation(354, 46);
		ImageIcon image1 = new ImageIcon("resources/search.ico");
		btnBuscaMed.setIcon(image1);
		contentPane.add(btnBuscaMed);
	}
}
