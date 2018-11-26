package br.ifsp.poo.farmacia.view;

import java.awt.Font;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
<<<<<<< HEAD
import javax.swing.border.EmptyBorder;
=======
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
>>>>>>> parent of 812d302... Update FormFuncionario.java
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import br.ifsp.poo.farmacia.control.FuncionarioControl;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Login;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class FormFuncionario extends JFrame {

	private JPanel contentPane;
	private static JTextField txtNome =  new JTextField();
	private static JTextField txtLogradouro =  new JTextField();
	private static JTextField txtNumero =  new JTextField();
	private static JTextField txtCidade =  new JTextField();
	private static JTextField txtBairro =  new JTextField();
	private static JTextField txtEmail =  new JTextField();
	private static JFormattedTextField mskDataNasc;
	private static JFormattedTextField mskTelefone;
	private static JFormattedTextField mskCelular;
	private static JFormattedTextField mskSalario;
	private static JFormattedTextField mskCpf;
	private static JComboBox<EnumFuncionario> cboTipo = new JComboBox<>();
	private static JTextField txtUser;
	private static JPasswordField pswSenha;
<<<<<<< HEAD
	private static JTable table;
	private static JScrollPane barraRolagemT, barraRolagemJ;
	private static String filtro;
	private static DefaultTableModel modelo = new DefaultTableModel();
	static FuncionarioControl ctFunc = new FuncionarioControl();
=======
	private JTable table;
	private JTable table_1;
>>>>>>> parent of 812d302... Update FormFuncionario.java

	public static void main(String[] args) {
		FormFuncionario form = new FormFuncionario();
	}

	public FormFuncionario() {
		criarTabela();
		criarJanela();
		setVisible(true);
	}

	public void criarJanela() {
		setTitle("Funcionário");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
<<<<<<< HEAD
		setBounds(100, 100, 633, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
=======
		setBounds(100, 100, 660, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
>>>>>>> parent of 812d302... Update FormFuncionario.java

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 22, 39, 14);
		contentPane.add(lblNome);

		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(10, 63, 97, 14);
		contentPane.add(lblDataNascimento);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 104, 52, 14);
		contentPane.add(lblTelefone);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEndereco.setBounds(10, 280, 63, 14);
		contentPane.add(lblEndereco);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(215, 104, 46, 14);
		contentPane.add(lblCelular);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 147, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 228, 46, 14);
		contentPane.add(lblTipo);

		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setBounds(215, 228, 34, 14);
		contentPane.add(lblCpf);

		txtNome.setBounds(59, 19, 322, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);


		MaskFormatter forData = instanciarMascara("##/##/####");
		mskDataNasc = new JFormattedTextField(forData);
		mskDataNasc.setBounds(117, 60, 66, 20);
		contentPane.add(mskDataNasc);

		MaskFormatter forTelefone = instanciarMascara("(##) ####-####");
		mskTelefone = new JFormattedTextField(forTelefone);
		mskTelefone.setBounds(73, 101, 110, 20);
		contentPane.add(mskTelefone);

		MaskFormatter forCelular = instanciarMascara("(##) #####-####");
		mskCelular = new JFormattedTextField(forCelular);
		mskCelular.setBounds(284, 101, 97, 20);
		contentPane.add(mskCelular);

		txtLogradouro = new JTextField();
		txtLogradouro.setBounds(83, 310, 166, 20);
		contentPane.add(txtLogradouro);
		txtLogradouro.setColumns(10);

		txtEmail.setBounds(53, 144, 328, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		cboTipo.setModel(new DefaultComboBoxModel(EnumFuncionario.values()));
		cboTipo.setBounds(53, 225, 120, 20);
		contentPane.add(cboTipo);

		MaskFormatter forCpf = instanciarMascara("###.###.###-##");
		mskCpf = new JFormattedTextField(forCpf);
		mskCpf.setBounds(269, 225, 112, 20);
		contentPane.add(mskCpf);

		JLabel lblSalario = new JLabel("Sal\u00E1rio:");
		lblSalario.setBounds(215, 63, 46, 14);
		contentPane.add(lblSalario);

		MaskFormatter forSalario = instanciarMascara("####,##");
		mskSalario = new JFormattedTextField(forSalario);
		mskSalario.setBounds(271, 60, 110, 20);
		contentPane.add(mskSalario);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio:");
		lblUsurio.setLabelFor(this);
		lblUsurio.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsurio.setBounds(10, 185, 40, 14);
		contentPane.add(lblUsurio);

		txtUser = new JTextField();
		txtUser.setBounds(63, 182, 110, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setLabelFor(this);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblSenha.setBounds(204, 185, 34, 14);
		contentPane.add(lblSenha);

		pswSenha = new JPasswordField();
		pswSenha.setBounds(247, 182, 134, 20);
		contentPane.add(pswSenha);

		txtNumero = new JTextField();
		txtNumero.setBounds(318, 310, 63, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(83, 341, 136, 20);
		contentPane.add(txtBairro);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(283, 341, 98, 20);
		contentPane.add(txtCidade);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 344, 63, 14);
		contentPane.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(237, 344, 46, 14);
		contentPane.add(lblCidade);

		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 393, 66, 14);
		contentPane.add(lblPesquisar);

		JTextField txtPesquisar = new JTextField();
		txtPesquisar.setBounds(78, 390, 193, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		FuncionarioControl ctFunc = new FuncionarioControl();

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(
				(e) -> {
					Funcionario func = new Funcionario();
					popularFuncionarios(func);
					ctFunc.cadastrarFuncionario(func);
				}
				);
		btnSalvar.setBounds(468, 384, 89, 23);
		contentPane.add(btnSalvar);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener((e) -> {

			Funcionario func = new Funcionario();
			popularFuncionarios(func);
			ctFunc.atualizarFuncionario(func);

		});
		btnAlterar.setBounds(468, 321, 89, 23);
		contentPane.add(btnAlterar);

		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener((e) -> {

			Funcionario func = new Funcionario();
			popularFuncionarios(func);
			ctFunc.excluirFuncionario(func);
		});
		btnExcluir.setBounds(391, 364, 89, 23);
		contentPane.add(btnExcluir);
		
		String [] cabecalho = new String[] {"ID", "nome", "Endereço", "Email", "Telefone","Celular", "Data Nacimento","Tipo","Salário"};
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener((e) -> {
		ArrayList<Funcionario> fun = ctFunc.listarFuncionarios(txtPesquisar.getText());
		DefaultTableModel model = new DefaultTableModel(cabecalho,0);
		for(Funcionario f:fun) {
			String[] dados = new String[10];
			dados[0] = String.valueOf(f.getId());
			dados[1] = f.getNome();
			dados[2] = f.getEndereco();
			dados[3] = f.getEmail();
			dados[4] = f.getTelefone();
			dados[5] = f.getCelular();
			dados[6] = f.getDataNascFormatado();
			dados[7] = String.valueOf(f.getTipoFuncionario());
			dados[8] = String.valueOf(f.getSalario());
			
			model.addRow(dados);
		}
		table.setModel(model);
		});

		btnPesquisar.setBounds(292, 389, 89, 23);
		contentPane.add(btnPesquisar);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 313, 63, 14);
		contentPane.add(lblLogradouro);

		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(262, 313, 46, 14);
		contentPane.add(lblNmero);


		JLabel lblResultado = new JLabel("Resultado:");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResultado.setBounds(416, 32, 80, 14);
		contentPane.add(lblResultado);
		
		/*barraRolagemT = new JScrollPane(table);
		barraRolagemT.setBounds(452, 61, 67, 14);
		contentPane.add(barraRolagemT);*/
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.setBounds(545, 242, 89, 23);
		contentPane.add(btnSelecionar);
		
<<<<<<< HEAD
		setVisible(true);
=======
		table = new JTable();
		table.setToolTipText("");
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		table.setBounds(416, 228, 218, -182);
		contentPane.add(table);
>>>>>>> parent of 812d302... Update FormFuncionario.java
		}

		public static void popularFuncionarios(Funcionario func){
			func.setNome(txtNome.getText()); 
			func.setEmail(txtEmail.getText());
			String endereco = new String("Logradouro: " + txtLogradouro.getText() + ", " + txtNumero.getText() + ". Bairro: " 
					+ txtBairro.getText() + ". Cidade: " + txtCidade.getText() + ".");
			func.setEndereco(endereco);
			func.setCelular(mskCelular.getText().replaceAll("\\D",""));
			func.setDocumento(mskCpf.getText().replaceAll("\\D", ""));
			func.setDataNascimento((String)mskDataNasc.getText());
			func.setTelefone(mskTelefone.getText().replaceAll("\\D",""));
			func.setTipoFuncionario((EnumFuncionario) cboTipo.getSelectedItem());
			func.setSalario(Double.parseDouble(mskSalario.getText().replace(",", ".")));
			String senha = new String(pswSenha.getPassword());
			Login login = new Login(txtUser.getText(), senha);
			func.setLogin(login);
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
	}
<<<<<<< HEAD
			public static void criarTabela() {
				try {
					table = new JTable(modelo);
			        modelo.addColumn("ID");
			        modelo.addColumn("Nome");
			        modelo.addColumn("Endereço");
			        modelo.addColumn("Email");
			        modelo.addColumn("Telefone");
			        modelo.addColumn("Celular");
			        modelo.addColumn("Data Nacimento");
			        modelo.addColumn("Tipo");
			        modelo.addColumn("Salário");
			        		        
			        table.getColumnModel().getColumn(0).setPreferredWidth(5);
			        table.getColumnModel().getColumn(1).setPreferredWidth(100);
			        table.getColumnModel().getColumn(2).setPreferredWidth(150);
			        table.getColumnModel().getColumn(3).setPreferredWidth(30);
			        table.getColumnModel().getColumn(4).setPreferredWidth(20);
			        table.getColumnModel().getColumn(5).setPreferredWidth(20);
			        table.getColumnModel().getColumn(6).setPreferredWidth(20);
			        table.getColumnModel().getColumn(7).setPreferredWidth(15);
			        table.getColumnModel().getColumn(8).setPreferredWidth(10);
			        
			        pesquisar(modelo, filtro);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao criar tabela.");
				}
			}
		}
=======
>>>>>>> parent of 812d302... Update FormFuncionario.java
