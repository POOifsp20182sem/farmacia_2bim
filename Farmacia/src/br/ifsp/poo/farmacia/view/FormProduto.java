package br.ifsp.poo.farmacia.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.ifsp.poo.farmacia.control.ProdutoControl;
import br.ifsp.poo.farmacia.modelo.entidade.ClasseTerapeutica;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFormaFarmaco;
import br.ifsp.poo.farmacia.modelo.entidade.PrincipioAtivo;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;



import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FormProduto extends JFrame {

	private JPanel contentPane;
	private static int idProduto;
	private static JTextField txtNomeComercial;
	private static JTextField txtApresentacao;
	private static JTextField txtCodigoBarras;
	private static JTextField txtPesquisar;
	private static JComboBox<EnumFormaFarmaco> cboForma = new JComboBox<>();
	private static JComboBox<ClasseTerapeutica> cboClasseTerapeutica = new JComboBox<>();
	private static JComboBox<PrincipioAtivo> cboPrincipioAtivo = new JComboBox<>();
	private static JFormattedTextField txtPrecoUnitario;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormProduto frame = new FormProduto();
					frame.setVisible(true);
					//carregarComboBox();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FormProduto() {
		
		setTitle("Produto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 639, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNomeComercial = new JLabel("Nome Comercial:");
		lblNomeComercial.setBounds(10, 24, 123, 14);
		contentPane.add(lblNomeComercial);

		txtNomeComercial = new JTextField();
		txtNomeComercial.setBounds(143, 21, 149, 20);
		contentPane.add(txtNomeComercial);
		txtNomeComercial.setColumns(10);

		JLabel lblApresentao = new JLabel("Apresentação:");
		lblApresentao.setBounds(10, 72, 123, 14);
		contentPane.add(lblApresentao);

		txtApresentacao = new JTextField();
		txtApresentacao.setBounds(143, 69, 149, 20);
		contentPane.add(txtApresentacao);
		txtApresentacao.setColumns(10);

		JLabel lblFormaFarmaco = new JLabel("Forma Farmaco:");
		lblFormaFarmaco.setBounds(10, 120, 107, 14);
		contentPane.add(lblFormaFarmaco);

		//comboBox TipoFarmaco
		cboForma.setModel(new DefaultComboBoxModel<>(EnumFormaFarmaco.values())); 
		cboForma.setBounds(143, 117, 149, 20);
		contentPane.add(cboForma);
		
		//comboBox ClasseTerapeutica
		JLabel lblClasseTerapeutica = new JLabel("Classe Terapeutica:");
		lblClasseTerapeutica.setBounds(314, 71, 140, 14);
		contentPane.add(lblClasseTerapeutica);
		
		cboClasseTerapeutica.setModel(new DefaultComboBoxModel<>());
		cboClasseTerapeutica.setBounds(464, 69, 149, 20);
		contentPane.add(cboClasseTerapeutica);
		
		//comboBox PrincipioAtivo
		JLabel lblPrincipioAtivo = new JLabel("Principio Ativo:");
		lblPrincipioAtivo.setBounds(10, 170, 107, 14);
		contentPane.add(lblPrincipioAtivo);
		
		cboPrincipioAtivo.setModel(new DefaultComboBoxModel<>());
		cboPrincipioAtivo.setBounds(143, 167, 149, 20);
		contentPane.add(cboPrincipioAtivo);
		
		try {
			carregarComboBox();
		} catch (Exception e) {
			// TODO: handle exception
		}

		JLabel lblCodigoDeBarras = new JLabel("Código de Barras:");
		lblCodigoDeBarras.setBounds(325, 21, 122, 14);
		contentPane.add(lblCodigoDeBarras);

		txtCodigoBarras = new JTextField();
		txtCodigoBarras.setBounds(464, 21, 136, 20);
		contentPane.add(txtCodigoBarras);
		txtCodigoBarras.setColumns(10);

		JLabel lblPrecoUnitario = new JLabel("Pre\u00E7o Unit\u00E1rio:");
		lblPrecoUnitario.setBounds(335, 120, 119, 14);
		contentPane.add(lblPrecoUnitario);

		SpinnerModel sm = new SpinnerNumberModel(0, 0, 100, 1);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 391, 66, 14);
		contentPane.add(lblPesquisar);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(86, 388, 136, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProdutoControl ctProduto = new ProdutoControl();
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.cadastrarProduto(produto);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(464, 387, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ProdutoControl ctProduto = new ProdutoControl();
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.deletarProduto(produto);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(464, 297, 89, 23);
		contentPane.add(btnExcluir);


		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProdutoControl ctProduto = new ProdutoControl();
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.atualizarProduto(produto);

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAlterar.setBounds(464, 342, 89, 23);
		contentPane.add(btnAlterar);		

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ProdutoControl ctProduto = new ProdutoControl();
					ArrayList produtos = ctProduto.listarProduto(txtPesquisar.toString());
					JList jlist = new JList((ListModel) produtos);
					contentPane.add(jlist);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(245, 387, 97, 23);
		contentPane.add(btnPesquisar);
		
		try {
			MaskFormatter jF = new MaskFormatter("##.##");
			txtPrecoUnitario = new JFormattedTextField(jF);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtPrecoUnitario.setBounds(466, 117, 107, 20);
		contentPane.add(txtPrecoUnitario);
		txtPrecoUnitario.setColumns(10);
	}
	
	public static void carregarComboBox() 
			throws SQLException {
		ProdutoControl ctProduto = new ProdutoControl();
		
		//TODO:Acho que daria para usar lambda
		
		for(PrincipioAtivo p: ctProduto.listarPrincipioAtivo())
			cboPrincipioAtivo.addItem(p);
		
		for(ClasseTerapeutica c: ctProduto.listarClasseTerapeutica())
			cboClasseTerapeutica.addItem(c);
	}

	public static void popularMedicamento(Produto prod) {
		prod.setId(idProduto);
		prod.setApresentacao(txtApresentacao.getText());
		prod.setClasseTerapeutica((ClasseTerapeutica)cboClasseTerapeutica.getSelectedItem());
		prod.setCodigoBarras(txtCodigoBarras.getText());
		prod.setNomeComercial(txtNomeComercial.getText());
		prod.setPrincipioAtivo((PrincipioAtivo)cboPrincipioAtivo.getSelectedItem());
		prod.setFormaFarmaco((EnumFormaFarmaco) cboForma.getSelectedItem());
<<<<<<< HEAD
		prod.setPrecoUnitario(Double.parseDouble(txtPrecoUnitario.getText()));
=======
		//prod.setPrecoUnitario((double)txtPrecoUnitario.getText());
>>>>>>> d2f832d4fc188fb800cf9df89e3607cd1a244987
	}
}
