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
	public void insertPagamento(Pagamento pagamento) throws SQLException, Exception {
		PreparedStatement ps = null;
		
		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call inserir_pagamento(?, ?, ?, ?)}"; 
			ps = conn.prepareStatement(query);		

			ps.setInt(1, pagamento.getVenda().getId());
			ps.setString(2, pagamento.getFormaPagamento());
			ps.setDate(3, pagamento.getDataPagamentoSql());
			ps.setDouble(4, pagamento.getValorPago());

			ps.executeUpdate();
				
		} catch (SQLException e) {
			throw new SQLException("Erro ao registrar o pagamento.");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
	}
	
	@Override
	public void removePagamento(Pagamento pagamento) throws SQLException, Exception {
		PreparedStatement ps = null;
		try (Connection conn = MySqlConnection.getConnection()) {
			
			String query = "{call excluir_pagamento(?)}"; 
			ps = conn.prepareStatement(query);		

			ps.setInt(1, pagamento.getId());

			ps.executeUpdate();
			
		} catch (SQLException e) {
			throw new SQLException("Erro ao remover o pagamento.");
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		} 
	}
}