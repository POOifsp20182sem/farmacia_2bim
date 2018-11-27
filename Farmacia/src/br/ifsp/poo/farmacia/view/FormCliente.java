package br.ifsp.poo.farmacia.view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import br.ifsp.poo.farmacia.control.ClienteControl;
import br.ifsp.poo.farmacia.control.FuncionarioControl;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFuncionario;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;
import br.ifsp.poo.farmacia.modelo.entidade.Login;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FormCliente extends JFrame {

	private JPanel contentPane;
	private static int idCliente = -1;
	private static JTextField txtNome;
	private static JTextField txtLogradouro;
	private static JTextField txtNumero;
	private static JTextField txtCidade;
	private static JTextField txtBairro;
	private static JTextField txtEmail;
	private static JTextField txtPesquisar;
	private static JFormattedTextField mskDataNasc;
	private static JFormattedTextField mskTelefone;
	private static JFormattedTextField mskCelular;
	private static JFormattedTextField mskCpf;
	private static String endereco;
	private static JTable table;
	private static JScrollPane barra;
	private DefaultTableModel modelo = new DefaultTableModel();
	static ClienteControl ctCli = new ClienteControl();


	public static void main(String[] args) {
		FormCliente form = new FormCliente();
	}

	public FormCliente() {
		criaTabela();
		criaJanela();
		setVisible(true);
	}


	public void criaJanela() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 29, 46, 14);
		contentPane.add(lblNome);

		JLabel lblDataNascimento = new JLabel("Data Nascimento:");
		lblDataNascimento.setBounds(10, 63, 97, 14);
		contentPane.add(lblDataNascimento);

		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(10, 104, 52, 14);
		contentPane.add(lblTelefone);

		JLabel lblEndereco = new JLabel("Endere\u00E7o:");
		lblEndereco.setBounds(10, 187, 52, 14);
		contentPane.add(lblEndereco);

		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(204, 104, 46, 14);
		contentPane.add(lblCelular);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 146, 46, 14);
		contentPane.add(lblEmail);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(15, 273, 77, 14);
		contentPane.add(lblDocumento);

		txtNome = new JTextField();
		txtNome.setBounds(53, 26, 293, 20);
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
		txtLogradouro.setBounds(83, 204, 136, 20);
		contentPane.add(txtLogradouro);
		txtLogradouro.setColumns(10);

		txtNumero = new JTextField();
		txtNumero.setBounds(283, 204, 63, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);

		txtEmail = new JTextField();
		txtEmail.setBounds(53, 143, 293, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);

		MaskFormatter forCpf = instanciarMascara("###.###.###-##");
		mskCpf = new JFormattedTextField(forCpf);
		mskCpf.setBounds(100, 273, 112, 20);
		contentPane.add(mskCpf);

		ClienteControl ctCliente = new ClienteControl();

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(
				(e) -> {
					Cliente cli = new Cliente();
					popularCliente(cli);
					ctCli.CadastrarCliente(cli);
				}
				);
		btnSalvar.setBounds(325, 275, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener((e) -> {

			Cliente cli = new Cliente();
			popularCliente(cli);
			ctCli.AtualizarCliente(cli);
		});
		btnAlterar.setBounds(325, 315, 89, 23);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener((e) -> {

			Cliente cli = new Cliente();
			popularCliente(cli);
			System.out.println(cli.getId());
			ctCli.DeletarCliente(cli);
			
			table.clearSelection();
		});
		btnExcluir.setBounds(325, 350, 89, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 207, 63, 14);
		contentPane.add(lblLogradouro);

		JLabel lblNumero = new JLabel("N˙mero:");
		lblNumero.setBounds(237, 207, 46, 14);
		contentPane.add(lblNumero);

		txtBairro = new JTextField();
		txtBairro.setColumns(10);
		txtBairro.setBounds(83, 235, 136, 20);
		contentPane.add(txtBairro);

		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(283, 235, 63, 20);
		contentPane.add(txtCidade);

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 238, 63, 14);
		contentPane.add(lblBairro);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(237, 238, 46, 14);
		contentPane.add(lblCidade);
		
		JButton btnSelecionar = new JButton("Selecionar");
		btnSelecionar.addActionListener((a) -> {
			int linhaSelecionada = -1;
			linhaSelecionada = table.getSelectedRow();
			String idS = String.valueOf(table.getModel().getValueAt(linhaSelecionada, 0));
			int id = Integer.parseInt(idS);
			Cliente f = ctCli.buscarCliente(id);
			
				txtNome.setText(f.getNome());
				mskCpf.setText(f.getDocumento());
				txtLogradouro.setText(f.getEndereco());
				System.out.println(f.getEndereco());
				txtEmail.setText(f.getEmail());
				mskTelefone.setText(f.getTelefone());
				mskCelular.setText(f.getCelular());
				//n√£o carrega quando √© dia/mes de um caracter s√≥
				mskDataNasc.setText(f.getStrDataNascimento().replace(".", "/"));
				System.out.println(f.getStrDataNascimento().replace(".", "/"));			
		});
		btnSelecionar.setBounds(800, 300, 89, 23);
		contentPane.add(btnSelecionar);
		
		barra = new JScrollPane(table);
		barra.setBounds(416, 45, 750, 250);
		contentPane.add(barra);

	}

	public static void popularCliente(Cliente cli){
		int linhaSelecionada = -1;
		linhaSelecionada = table.getSelectedRow();
		String idS = String.valueOf(table.getModel().getValueAt(linhaSelecionada, 0));
		int id = Integer.parseInt(idS);
		cli.setId(id);
		cli.setNome(txtNome.getText()); 
		cli.setEmail(txtEmail.getText());
		endereco = new String("Logradouro: " + txtLogradouro.getText() + ", " + txtNumero.getText() + ". Bairro: " 
				+ txtBairro.getText() + ". Cidade: " + txtCidade.getText() + ".");
		cli.setEndereco(endereco);
		cli.setCelular(mskCelular.getText().replaceAll("\\D",""));
		cli.setDocumento(mskCpf.getText().replaceAll("\\D", ""));
		cli.setDataNascimento((String)mskDataNasc.getText());
		cli.setTelefone(mskTelefone.getText().replaceAll("\\D",""));
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
	
	public void criaTabela() {
		try {
			table = new JTable(modelo);
			modelo.addColumn("ID");
			modelo.addColumn("Nome");
			modelo.addColumn("CPF");
			modelo.addColumn("EndereÁo");
			modelo.addColumn("Email");
			modelo.addColumn("Telefone");
			modelo.addColumn("Celular");
			modelo.addColumn("Data Nascimento");

			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(1).setPreferredWidth(100);
			table.getColumnModel().getColumn(2).setPreferredWidth(50);
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setPreferredWidth(30);
			table.getColumnModel().getColumn(5).setPreferredWidth(20);
			table.getColumnModel().getColumn(6).setPreferredWidth(20);
			table.getColumnModel().getColumn(7).setPreferredWidth(20);

			pesquisar(modelo, "");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao criar tabela.");
		}
	}

	public static void pesquisar(DefaultTableModel modelo, String filtro) throws SQLException {
		modelo.setNumRows(0);

		try {
			ArrayList<Cliente> cli = ctCli.listarCliente(filtro);
			for(Cliente c:cli) {
				String[] dados = new String[8];
				dados[0] = String.valueOf(c.getId());
				dados[1] = c.getNome();
				dados[2] = c.getDocumento();
				dados[3] = c.getEndereco();
				dados[4] = c.getEmail();
				dados[5] = c.getTelefone();
				dados[6] = c.getCelular();
				dados[7] = c.getDataNascFormatado();

				modelo.addRow(dados);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}
}
