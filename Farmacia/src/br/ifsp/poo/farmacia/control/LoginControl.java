package br.ifsp.poo.farmacia.control;

import java.nio.file.AccessDeniedException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.ifsp.poo.farmacia.modelo.entidade.Global;
import br.ifsp.poo.farmacia.modelo.entidade.Login;
import br.ifsp.poo.farmacia.modelo.persistencia.GlobalDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.IGlobalDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.ILoginDAO;
import br.ifsp.poo.farmacia.modelo.persistencia.LoginDAO;
import br.ifsp.poo.farmacia.view.FormMenuPrincipal;

public class LoginControl {

	ILoginDAO ld = new LoginDAO();
	IGlobalDAO gd = new GlobalDAO();

	public void validarLogin(Login login){
		try {
			login.criptografarSenha();
			ld.validarLogin(login);
			gd.recuperarLogado(login.getUserName());
			
			FormMenuPrincipal formPrincipal = new FormMenuPrincipal();
		} catch (AccessDeniedException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		} catch (SQLException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
		} catch (Exception e3) {
			JOptionPane.showMessageDialog(null, e3.getMessage());
		}
	}
}
