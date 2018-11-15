package br.ifsp.poo.farmacia.view;

//import com.sun.glass.events.WindowEvent;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.ifsp.poo.farmacia.control.LoginControl;
import br.ifsp.poo.farmacia.modelo.entidade.Login;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField pswSenha;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FormLogin() {
		criarJanela();
		setVisible(true);
	}

	public void criarJanela() {

		// Setup configurations

		int height = 300;
		int width = 450;

		setForeground(new Color(240, 248, 255));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(width, height);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		setIconImage(new ImageIcon("resources/icon.png").getImage());

		// imageIcon

		ImageIcon image1 = new ImageIcon("resources/login.png");
		JLabel lblLoginImage = new JLabel(image1);
		lblLoginImage.setBounds(20, getHeight() / 7, 128, 128);
		contentPane.add(lblLoginImage);

		// Fields

		JLabel lblUsuario = new JLabel("Usu\u00E1rio:");
		lblUsuario.setLabelFor(this);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setBounds(170, 80, 60, 15);
		contentPane.add(lblUsuario);

		txtUser = new JTextField();
		txtUser.setBounds(240, 80, 120, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setLabelFor(this);
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSenha.setBounds(170, 110, 60, 15);
		contentPane.add(lblSenha);

		pswSenha = new JPasswordField();
		pswSenha.setBounds(240, 110, 120, 20);
		contentPane.add(pswSenha);

		// Buttons

		JButton btnAcessar = new JButton("Acessar");
		btnAcessar.addActionListener((e) -> {
			LoginControl loginControl = new LoginControl();
			Login login = new Login(txtUser.getText(), new String(pswSenha.getPassword()));
			loginControl.validarLogin(login);
		});

		btnAcessar.setBounds(getWidth() / 2 - 100, 200, 90, 25);
		contentPane.add(btnAcessar);

		JButton btnSair = new JButton("Sair");

		btnSair.addActionListener((e) -> {
			System.exit(0);
		});

		btnSair.setBounds(getWidth() / 2, 200, 90, 25);
		contentPane.add(btnSair);
	}

}
