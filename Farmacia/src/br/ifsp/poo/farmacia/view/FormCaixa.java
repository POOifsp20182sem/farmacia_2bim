package br.ifsp.poo.farmacia.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.ifsp.poo.farmacia.modelo.entidade.Caixa;

public class FormCaixa {
	private static JFrame tela;
	private static JPanel backgroundPane;
	private static JPanel buttonsPane;
	private static JComboBox<Caixa> cboCaixas;
	private static JButton btnCaixa;
	private static JButton btnRelatorio;
	private static JTextField txtDinheiro;

	public static void main(String args[]) {
		invocar();
	}

	/**
	 * Instancia uma nova tela de caixa.
	 */
	public static void invocar() {
		btnCaixa = new JButton(" Abrir Caixa ");
		btnRelatorio = new JButton(" Relatórios ");

		// buttons panel
		buttonsPane = new JPanel(new FlowLayout());
		buttonsPane.add(btnCaixa);
		buttonsPane.add(btnRelatorio);

		// background panel
		backgroundPane = new JPanel();
		backgroundPane.setLayout(new BorderLayout());
		backgroundPane.add(buttonsPane, BorderLayout.SOUTH);

		// frame
		tela = new JFrame();
		tela.setIconImage(new ImageIcon("resources/icon.png").getImage());
		tela.setLocationRelativeTo(null);
		tela.setSize(800, 500);
		tela.setTitle("Caixa");
		tela.setContentPane(backgroundPane);
		tela.setResizable(false);
		tela.setVisible(true);
	}
}
