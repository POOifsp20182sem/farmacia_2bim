package br.ifsp.poo.farmacia.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

import java.awt.Font;
import java.text.ParseException;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class FormMenuPrincipal extends JFrame {

	private JPanel contentPane;
	private JPanel menubar;
	private JPanel middleScreen;
	private JPanel footer;

	public static void main(String[] args) {
		FormMenuPrincipal f = new FormMenuPrincipal();
	}
	
	public FormMenuPrincipal() {
		criarJanela();
		setVisible(true);
	}

	public void criarJanela() {
		
		//Setup configurations
		
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		setMinimumSize(new Dimension(500, 400));
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setIconImage(new ImageIcon("resources/icon.png").getImage());
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu cadastroMenu = new JMenu("Cadastro");
		JMenu administracaoMenu = new JMenu("Administração");
		
		menuBar.add(cadastroMenu);
		menuBar.add(administracaoMenu);
		
		JMenuItem funcionarios = new JMenuItem("Funcionários");
		JMenuItem clientes = new JMenuItem("Clientes");
		JMenuItem produtos = new JMenuItem("Produtos");
		
		funcionarios.addActionListener((e) -> {
				FormFuncionario formFuncionario = new FormFuncionario();
		});
		
		produtos.addActionListener((e)->{
			//FormProduto formProduto = new FormProduto();
		});
		
		clientes.addActionListener((e)->{
			FormCliente formCliente = new FormCliente();
		});
		
		
		cadastroMenu.add(funcionarios);
		cadastroMenu.add(clientes);
		cadastroMenu.add(produtos);
		
		JMenuItem caixa = new JMenuItem("Caixa");
		JMenuItem venda = new JMenuItem("Venda");
		
		administracaoMenu.add(caixa);
		administracaoMenu.add(venda);

		//Menubar configurations
		menubar = new JPanel(new FlowLayout(FlowLayout.LEADING));
		menubar.setSize(new Dimension(500,100));
		contentPane.add(menubar, BorderLayout.PAGE_START);
		
		//Footer configurations
		footer = new JPanel(new FlowLayout());
		contentPane.add(footer,BorderLayout.PAGE_END);
		
		JLabel lblCopyright = new JLabel("© 2018 Grupo AACEJ");
		lblCopyright.setFont(new Font("Tahoma", Font.PLAIN, 12));
		footer.add(lblCopyright);
	}
}
