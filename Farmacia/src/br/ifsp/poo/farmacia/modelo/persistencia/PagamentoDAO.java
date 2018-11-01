package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;

/**
 * @author Alice Lima
 * Classe responsável por realizar as operações de pagamento com o banco de dados
 */

public class PagamentoDAO implements IPagamentoDAO {

	@Override
	public boolean insertPagamento(Pagamento pagamento) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			String query = "{call inserir_pagamento(?, ?, ?, ?)}"; 
			
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, pagamento.getVenda().getId());
			ps.setString(2, pagamento.getFormaPagamento());
			ps.setDate(3, pagamento.getDataPagamentoSql());
			ps.setDouble(4, pagamento.getValorPago());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao inserir!");
			}
			else {
				System.out.println("Dado inserido com sucesso!");
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}

	@Override
	public boolean removePagamento(Pagamento pagamento) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			String query = "{call excluir_pagamento(?)}"; 
			
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, pagamento.getId());

			if(ps.executeUpdate() == 0) {
				System.out.println("Erro ao excluir!");
			}
			else {
				System.out.println("Dado excluído com sucesso!");
				return true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}
		return false;
	}
}