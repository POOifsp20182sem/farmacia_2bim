package br.ifsp.poo.farmacia.view;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.Color;

public class FormMenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	
	public FormMenuPrincipal() {
		criarJanela();
		setVisible(true);
	}

	public void criarJanela() {
		setTitle("Inicio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 496, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JSeparator separator_ = new JSeparator();
		separator_.setBounds(10, 111, 146, 2);
		contentPane.add(separator_);

		JButton btnCliente = new JButton("Cliente");
		btnCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCliente.setBounds(10, 70, 146, 30);
		contentPane.add(btnCliente);

		btnCliente.addActionListener((e) -> {	
			try {
				//FormListaClientes formCliente = new FormListaClientes();
				//formCliente.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		JSeparator separator = new JSeparator();
		separator.setBounds(10, 162, 146, 2);
		contentPane.add(separator);

		JButton btnFuncionario = new JButton("Funcionário");
		btnFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFuncionario.setBounds(10, 121, 146, 30);
		contentPane.add(btnFuncionario);

		btnFuncionario.addActionListener((e) -> {	
			try {
			//	FormFuncionario formFuncionario = new FormFuncionario();
			//	formFuncionario.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 216, 146, 2);
		contentPane.add(separator_1);

		JButton btnMedicamento = new JButton("Medicamento");
		btnMedicamento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnMedicamento.setBounds(10, 175, 146, 30);
		contentPane.add(btnMedicamento);

		btnMedicamento.addActionListener((e) -> {	
			try {
				//FormProduto formMedicamento = new FormProduto();
			//	formMedicamento.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 270, 146, 2);
		contentPane.add(separator_2);

		JButton btnVenda = new JButton("Venda");
		btnVenda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVenda.setBounds(10, 229, 146, 30);
		contentPane.add(btnVenda);

		btnVenda.addActionListener((e) -> {	
			try {
			//	FormVenda formVenda = new FormVenda();
			//	formVenda.setVisible(true);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 57, 146, 2);
		contentPane.add(separator_3);

		JLabel lblFarmcia = new JLabel("Farm\u00E1cia");
		lblFarmcia.setForeground(Color.BLUE);
		lblFarmcia.setFont(new Font("Modern No. 20", Font.ITALIC, 40));
		lblFarmcia.setBounds(236, 36, 175, 64);
		contentPane.add(lblFarmcia);

		JLabel lblSejaBemVindo = new JLabel("Seja Bem-Vindo!");
		lblSejaBemVindo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSejaBemVindo.setBounds(235, 121, 123, 30);
		contentPane.add(lblSejaBemVindo);
	}
}
