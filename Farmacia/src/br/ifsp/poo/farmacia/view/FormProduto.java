package br.ifsp.poo.farmacia.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import br.ifsp.poo.farmacia.control.ProdutoControl;
import br.ifsp.poo.farmacia.modelo.entidade.ClasseTerapeutica;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFormaFarmaco;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Login;
import br.ifsp.poo.farmacia.modelo.entidade.PrincipioAtivo;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;



import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FormProduto extends JFrame {

	
	private static JPanel contentPane;
	private static int idProduto;
	private static JTextField txtNomeComercial;
	private static JTextField txtApresentacao;
	private static JTextField txtCodigoBarras;
	private static JTextField txtPesquisar;
	private static JComboBox<EnumFormaFarmaco> cboForma = new JComboBox<>();
	private static JComboBox<ClasseTerapeutica> cboClasseTerapeutica = new JComboBox<>();
	private static JComboBox<PrincipioAtivo> cboPrincipioAtivo = new JComboBox<>();
	private static JFormattedTextField txtPrecoUnitario;
	private static JTable tabela;
	private static JScrollPane barra;
	private static DefaultTableModel modelo = new DefaultTableModel();
	ProdutoControl ctProduto = new ProdutoControl(); 
	
	
	public static void main(String[] args) {
		FormProduto form = new FormProduto();
	}

	/**
	 * Launch the application.
	 */
	
	public FormProduto() {
		criaJTable("");
		criaJanela();
		setVisible(true);
	}
	
	/**
	 * Create the frame.
	 */
	public void criaJanela() {
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
		
		MaskFormatter fPreco = instanciarMascara("###.##");
		txtPrecoUnitario = new JFormattedTextField(fPreco);
		txtPrecoUnitario.setBounds(466, 117, 107, 20);
		contentPane.add(txtPrecoUnitario);
		txtPrecoUnitario.setColumns(10);

		/*JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 391, 66, 14);
		contentPane.add(lblPesquisar);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(86, 388, 136, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);*/

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.cadastrarProduto(produto);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(511, 365, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Produto produto = new Produto();
					popularMedicamento(produto);
					ctProduto.deletarProduto(produto);
					
					tabela.clearSelection();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(511, 265, 89, 23);
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
		btnAlterar.setBounds(511, 313, 89, 23);
		contentPane.add(btnAlterar);		

		/*JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					pesquisa(modelo, "");
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(245, 387, 97, 23);
		contentPane.add(btnPesquisar);
		*/
		
		JLabel lblCadastrados = new JLabel("Cadastrados:");
		lblCadastrados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCadastrados.setBounds(30, 220, 80, 14);
		contentPane.add(lblCadastrados);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener((a) -> {
			int linhaSelecionada = -1;
			linhaSelecionada = tabela.getSelectedRow();
			String idS = String.valueOf(tabela.getModel().getValueAt(linhaSelecionada, 0));
			int id = Integer.parseInt(idS);
			Produto p = ctProduto.buscarProduto(id);
			
				txtCodigoBarras.setText(p.getCodigoBarras());
				txtNomeComercial.setText(p.getNomeComercial());
				txtApresentacao.setText(p.getApresentacao());
				cboClasseTerapeutica.setSelectedItem(p.getClasseTerapeutica());
				cboForma.setSelectedItem(p.getFormaFarmaco());
				txtPrecoUnitario.setText(String.valueOf(p.getPrecoUnitario()));
				cboPrincipioAtivo.setSelectedItem(p.getPrincipioAtivo());			
		});
		btnSelecionar.setBounds(200, 405, 107, 23);
		contentPane.add(btnSelecionar);
				
		barra = new JScrollPane(tabela);
		barra.setBounds(20, 250, 450, 150);
		contentPane.add(barra);
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
		
		int linhaSelecionada = 0;
		linhaSelecionada = tabela.getSelectedRow();
		String idS = String.valueOf(tabela.getModel().getValueAt(linhaSelecionada, 0));
		int id = Integer.parseInt(idS);
		prod.setId(id);	
		prod.setApresentacao(txtApresentacao.getText()); 
		prod.setClasseTerapeutica((ClasseTerapeutica)cboClasseTerapeutica.getSelectedItem());
		prod.setCodigoBarras(txtCodigoBarras.getText());
		prod.setNomeComercial(txtNomeComercial.getText());
		prod.setPrincipioAtivo((PrincipioAtivo)cboPrincipioAtivo.getSelectedItem());
		prod.setFormaFarmaco((EnumFormaFarmaco) cboForma.getSelectedItem());
		prod.setPrecoUnitario(Double.parseDouble(txtPrecoUnitario.getText()));
	}
	
	public MaskFormatter instanciarMascara(String formatacao) {
		try {
			MaskFormatter mask = new MaskFormatter(formatacao);
			return mask;
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null,"Erro ao carregar os campos formatados");
		}
		return null;
	}
	
	private static void criaJTable(String filtro) {
		try {
			tabela  = new JTable(modelo);
			modelo.addColumn("ID");
			modelo.addColumn("Nome Comercial");
			modelo.addColumn("Apresentação");
			modelo.addColumn("Codigo de Barras");
			modelo.addColumn("Forma Farmaco");
			modelo.addColumn("Principio Ativo");
			modelo.addColumn("Classe Terapeutica");
			modelo.addColumn("Preço Unitario");
			
			tabela.getColumnModel().getColumn(0).setPreferredWidth(80);
			tabela.getColumnModel().getColumn(1).setPreferredWidth(80);
			tabela.getColumnModel().getColumn(2).setPreferredWidth(80);
			tabela.getColumnModel().getColumn(3).setPreferredWidth(80);
			tabela.getColumnModel().getColumn(4).setPreferredWidth(80);
			tabela.getColumnModel().getColumn(5).setPreferredWidth(80);
			tabela.getColumnModel().getColumn(6).setPreferredWidth(80);
			tabela.getColumnModel().getColumn(7).setPreferredWidth(80);
			
			pesquisar(modelo, "");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar tabela.");
		}
		}
	
	public static void pesquisar(DefaultTableModel modelo, String filtro) throws SQLException {
		modelo.setNumRows(0);
		ProdutoControl ctProduto = new ProdutoControl();
		
		try {
			ArrayList<Produto> prod = ctProduto.listarProduto(filtro);
			for(Produto p:prod) {
				String[] dados = new String[8];
				dados[0] = String.valueOf(p.getId());
				dados[1] = p.getNomeComercial();
				dados[2] = p.getApresentacao();
				dados[3] = p.getCodigoBarras();
				dados[4] = p.getFormaFarmaco();
				dados[5] = String.valueOf(p.getPrincipioAtivo());
				dados[6] = String.valueOf(p.getClasseTerapeutica());
				dados[7] = String.valueOf(p.getPrecoUnitario());
				
				modelo.addRow(dados);
				
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
