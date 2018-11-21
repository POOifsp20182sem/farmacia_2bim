package br.ifsp.poo.farmacia.view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import br.ifsp.poo.farmacia.control.ClienteControl;
import br.ifsp.poo.farmacia.modelo.entidade.Cliente;
import br.ifsp.poo.farmacia.modelo.entidade.EnumCliente;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
	private static JFormattedTextField mskCnpj;
	private static JComboBox<EnumCliente> cboTipoCliente = new JComboBox<>();
	private static String endereco;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormCliente frame = new FormCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public FormCliente() throws ParseException {
		criaJanela();
	}
	
	public FormCliente(int id) throws ParseException, SQLException {
		criaJanela();
		Cliente cli = buscarCliente(id);
		popularForm(cli);
	}

	public void criaJanela() throws ParseException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 439);
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

		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 273, 46, 14);
		contentPane.add(lblTipo);

		JLabel lblDocumento = new JLabel("Documento:");
		lblDocumento.setBounds(240, 273, 77, 14);
		contentPane.add(lblDocumento);

		txtNome = new JTextField();
		txtNome.setBounds(53, 26, 293, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		MaskFormatter forData = new MaskFormatter("##/##/####");
		mskDataNasc = new JFormattedTextField(forData);
		mskDataNasc.setBounds(117, 60, 77, 20);
		contentPane.add(mskDataNasc);

		MaskFormatter forTelefone = new MaskFormatter("(##) ####-####");
		mskTelefone = new JFormattedTextField(forTelefone);
		mskTelefone.setBounds(67, 101, 110, 20);
		contentPane.add(mskTelefone);

		MaskFormatter forCelular = new MaskFormatter("(##) #####-####");
		mskCelular = new JFormattedTextField(forCelular);
		mskCelular.setBounds(249, 101, 97, 20);
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

		MaskFormatter forCpf = new MaskFormatter("###.###.###-##");
		mskCpf = new JFormattedTextField(forCpf);
		MaskFormatter forCnpj = new MaskFormatter("##.###.###/####-##");
		mskCnpj = new JFormattedTextField(forCnpj);


		mskCpf.setBounds(327, 270, 116, 20);
		contentPane.add(mskCpf);
		mskCnpj.setBounds(327, 298, 116, 20);
		contentPane.add(mskCnpj);

		cboTipoCliente.setModel(new DefaultComboBoxModel<>(EnumCliente.values()));
		cboTipoCliente.setBounds(53, 270, 124, 20);
		contentPane.add(cboTipoCliente);

		ClienteControl ctCliente = new ClienteControl();

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Cliente cliente = new Cliente();
					popularCliente(cliente);
					if(idCliente > 0) {
						cliente.setId(idCliente);
						if(ctCliente.AtualizarCliente(cliente)) {
							JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!");
						}
					}else {
						if(ctCliente.CadastrarCliente(cliente)) {
							JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
						}
						}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(507, 348, 89, 23);
		contentPane.add(btnSalvar);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					ArrayList clientes = ctCliente.listarCliente(txtPesquisar.toString());
					JList list = new JList((ListModel) clientes);
					list.setBounds(425, 284, 109, -263);
					contentPane.add(list);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPesquisar.setBounds(249, 348, 89, 23);
		contentPane.add(btnPesquisar);
		
		JLabel lblPesquisar = new JLabel("Pesquisar:");
		lblPesquisar.setBounds(10, 331, 63, 14);
		contentPane.add(lblPesquisar);

		txtPesquisar = new JTextField();
		txtPesquisar.setBounds(10, 349, 209, 20);
		contentPane.add(txtPesquisar);
		txtPesquisar.setColumns(10);

		JLabel lblLogradouro = new JLabel("Logradouro:");
		lblLogradouro.setBounds(10, 207, 63, 14);
		contentPane.add(lblLogradouro);

		JLabel lblNumero = new JLabel("Número:");
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
		
		endereco = txtLogradouro.getText() + ", " + txtNumero.getText() + ", " + txtBairro.getText() + ", " + txtCidade.getText() + ".";
	}

	public static void popularCliente(Cliente cliente) {
		
		cliente.setNome(txtNome.getText()); 
		cliente.setEmail(txtEmail.getText());
		cliente.setEndereco(endereco);
		cliente.setTipoCliente((EnumCliente)cboTipoCliente.getSelectedItem());
		cliente.setCelular(mskCelular.getText().replaceAll("\\D",""));
		cliente.setDataNascimento((String)mskDataNasc.getText());
		cliente.setTelefone(mskTelefone.getText().replaceAll("\\D",""));
		
		if(cliente.getTipoCliente().equals(EnumCliente.FISICA))
			cliente.setDocumento(mskCpf.getText().replaceAll("\\D", ""));
		else
			cliente.setDocumento(mskCnpj.getText().replaceAll("\\D", ""));
	}

	public static void popularForm(Cliente cli) {
		String [] strs = cli.getEndereco().toString().split(",");
		idCliente = cli.getId();
		txtNome.setText(cli.getNome());
		txtCidade.setText(strs[0]);
		txtLogradouro.setText(strs[1]);
		txtNumero.setText(strs[2]);
		txtBairro.setText(strs[3]);
		txtEmail.setText(cli.getEmail());;
		cboTipoCliente.setSelectedItem(cli.getTipoCliente());
		
		if(cli.getTipoCliente().equals(EnumCliente.FISICA))
			mskCpf.setText(cli.getDocumento());
		else
				mskCpf.setText(cli.getDocumento());
				mskTelefone.setText(cli.getTelefone());
				mskCelular.setText(cli.getCelular());
		
		
	}
	
	public static Cliente buscarCliente(int id) throws SQLException {
		ClienteControl ctCliente = new ClienteControl();
		Cliente cli = ctCliente.buscarCliente(id);
		return cli;
	}
	
	public static boolean excluirCliente(int id) {
		ClienteControl ctCliente = new ClienteControl();
		try {
			Cliente cliente = new Cliente();
			cliente.setId(id);
			if(ctCliente.DeletarCliente(cliente)) {
				JOptionPane.showMessageDialog(null, "Cliente excluído com sucesso!");
			}else {
				JOptionPane.showMessageDialog(null, "Erro ao excluir");
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
}
