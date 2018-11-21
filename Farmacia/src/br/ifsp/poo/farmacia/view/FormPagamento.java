package br.ifsp.poo.farmacia.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.ifsp.poo.farmacia.control.PagamentoControl;
import br.ifsp.poo.farmacia.modelo.entidade.EnumPagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;
import br.ifsp.poo.farmacia.modelo.entidade.Venda;
import javax.swing.JButton;

public class FormPagamento {
	
	private static Pagamento pagamento = new Pagamento();
	private static Venda venda;
	private static PagamentoControl pgControl = new PagamentoControl();
	
	public FormPagamento(Venda ven) {
		venda = ven;
		criarJanela();
	}

	public static void main(String[] args) {
		criarJanela();
	}

	public static void criarJanela() {
		
		JFrame frame = new JFrame("Pagamento");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		JPanel contentPane = new JPanel();
		
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblValorTotal = new JLabel("Valor Total:");
		lblValorTotal.setBounds(45, 182, 77, 14);
		contentPane.add(lblValorTotal);

		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(45, 222, 71, 14);
		contentPane.add(lblDesconto);

		JLabel lblValorFinal = new JLabel("Valor Final:");
		lblValorFinal.setBounds(45, 258, 75, 14);
		contentPane.add(lblValorFinal);

		JTextField txtValorTotal = new JTextField();
		txtValorTotal.setEditable(false);
		txtValorTotal.setBounds(132, 179, 86, 20);
		contentPane.add(txtValorTotal);
		txtValorTotal.setColumns(10);

		JTextField txtDesconto = new JTextField();
		txtDesconto.setEditable(false);
		txtDesconto.setBounds(132, 219, 86, 20);
		contentPane.add(txtDesconto);
		txtDesconto.setColumns(10);

		JTextField txtValorFinal = new JTextField();
		txtValorFinal.setEditable(false);
		txtValorFinal.setBounds(132, 255, 86, 20);
		contentPane.add(txtValorFinal);
		txtValorFinal.setColumns(10);

		JLabel lblFormaPagamento = new JLabel("Forma Pagamento:");
		lblFormaPagamento.setBounds(45, 50, 142, 14);
		contentPane.add(lblFormaPagamento);

		JLabel lblValorPago = new JLabel("Valor Pago:");
		lblValorPago.setBounds(273, 182, 77, 14);
		contentPane.add(lblValorPago);

		JLabel lblTroco = new JLabel("Troco:");
		lblTroco.setBounds(295, 222, 47, 14);
		contentPane.add(lblTroco);

		JTextField txtValorPago = new JTextField();
		txtValorPago.setColumns(10);
		txtValorPago.setBounds(369, 179, 86, 20);
		contentPane.add(txtValorPago);

		JTextField txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setColumns(10);
		txtTroco.setBounds(369, 219, 86, 20);
		contentPane.add(txtTroco);
		
		JRadioButton rdbtnDinheiro = new JRadioButton("Dinheiro");
		rdbtnDinheiro.setBounds(96, 71, 91, 23);
		rdbtnDinheiro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				pagamento.setFormaPagamento(EnumPagamento.DINHEIRO);
			}
		});
		contentPane.add(rdbtnDinheiro);
		
		JRadioButton rdbtnCarto = new JRadioButton("Cartão");
		rdbtnCarto.setBounds(214, 71, 77, 23);
		rdbtnCarto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pagamento.setFormaPagamento(EnumPagamento.CARTAO);
			}
		});
		contentPane.add(rdbtnCarto);

		ButtonGroup btnGroup = new ButtonGroup();

		btnGroup.add(rdbtnDinheiro);
		btnGroup.add(rdbtnCarto);
		
		frame.setIconImage(new ImageIcon("resources/payment.png").getImage());

		// imageIcon

		ImageIcon image1 = new ImageIcon("resources/payment.png");
		JLabel lblImage = new JLabel(image1);
		lblImage.setBounds(372, 19, 128, 128);
		contentPane.add(lblImage);
		
		JButton btnDesconto = new JButton("Desconto");
		btnDesconto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
				double desconto = 0;
				double vFinal = 0;
				
				desconto = pgControl.calcularDesconto(venda.getTotal(), venda.getCliente(), pagamento.getFormaPagamento());
				vFinal = pgControl.calcularValorFinal(venda.getTotal(), desconto);
				
				venda.setDesconto(desconto);
				
				txtValorTotal.setText(String.valueOf(venda.getTotal()));
				txtDesconto.setText(String.valueOf(desconto));
				txtValorFinal.setText(String.valueOf(vFinal));
				
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao calcular.");
				}
			}
		});
		btnDesconto.setBounds(194, 124, 89, 23);
		contentPane.add(btnDesconto);
		
		JButton btnFinalizar = new JButton("Finalizar");
		btnFinalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					if(txtValorPago.getText() == "" && rdbtnDinheiro.isSelected()) {
						JOptionPane.showMessageDialog(null, "Insira o valor pago." );
					}
					else {
						String troco = String.valueOf(pgControl.calcularTroco(Double.parseDouble(txtValorPago.getText()), Double.parseDouble(txtValorFinal.getText())));		
						txtTroco.setText(troco);
						
						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						Date data;
										
							
						data = formato.parse(venda.getData());
						pagamento.setDataPagamento(data);				
						pagamento.setValorPago(Double.parseDouble(txtValorPago.getText()));		
						pagamento.setVenda(venda);
						pgControl.insertPagamento(pagamento);
						
						pgControl.updateVenda(venda);	
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao concluir pagamento." );
				}
			}
		});
		btnFinalizar.setBounds(366, 294, 89, 23);
		contentPane.add(btnFinalizar);
		
		frame.setVisible(true);
		frame.setBounds(400, 200, 550, 400);
	}
}
