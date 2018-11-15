package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.SQLException;

import br.ifsp.poo.farmacia.modelo.entidade.Pagamento;

/**
 * @author Alice Lima
 * Interface responsável por definir as operações realizadas com o pagamento
 */
public interface IPagamentoDAO {

	public void insertPagamento(Pagamento pagamento) throws SQLException, Exception;
	public void removePagamento(Pagamento pagamento) throws SQLException, Exception;
}
