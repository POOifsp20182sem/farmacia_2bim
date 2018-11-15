package br.ifsp.poo.farmacia.modelo.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.ifsp.poo.farmacia.modelo.entidade.Caixa;
import br.ifsp.poo.farmacia.modelo.entidade.EnumStatusCaixa;
import br.ifsp.poo.farmacia.modelo.entidade.Funcionario;

public class CaixaDAO implements ICaixaDAO {
	@Override
	public void insertCaixa(Caixa caixa) throws SQLException, Exception {
		String queryInsert = "{call inserir_caixa(?, ?, ?, ?)}";
		String querySelect = "select last_insert_id()";
		ResultSet id;
		PreparedStatement insert;
		PreparedStatement selectId;

		try (Connection conexao = MySqlConnection.getConnection();) {
			insert = conexao.prepareStatement(queryInsert);
			selectId = conexao.prepareStatement(querySelect);

			insert.setInt(1, caixa.getFuncAbertura().getId());
			insert.setDouble(2, caixa.getSaldoInicial());
			insert.setString(3, caixa.getAbertura().toString());
			insert.setString(4, caixa.getStatus().toString());
			insert.executeQuery();

			id = selectId.executeQuery();
			if (!id.next())
				throw new SQLException();
			caixa.setId(id.getInt(1));
		} catch (SQLException sqle) {
			throw new SQLException("Não foi possivel criar caixa.");
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void updateCaixa(Caixa caixa) throws SQLException, Exception {
		String query = "{call alterar_caixa(?, ?, ?, ?, ?, ?, ?, ?)}";
		PreparedStatement update;

		try (Connection conexao = MySqlConnection.getConnection()) {
			update = conexao.prepareStatement(query);

			update.setInt(1, caixa.getId());
			update.setInt(2, caixa.getFuncAbertura().getId());
			update.setInt(3, caixa.getFuncFechamento().getId());
			update.setDouble(4, caixa.getSaldoInicial());
			update.setDouble(5, caixa.getSaldoFinal());
			update.setString(6, caixa.getAbertura().toString());
			update.setString(7, caixa.getFechamento().toString());
			update.setString(8, caixa.getStatus().toString());

			if (update.executeUpdate() <= 0)
				throw new SQLException();
		} catch (SQLException sqle) {
			throw new SQLException("Não foi possível alterar o caixa " + caixa.getId() + ".");
		} catch (Exception ex) {
			throw ex;
		}
	}

	@Override
	public void removeCaixa(Caixa caixa) throws SQLException, Exception {
		String query = "{call excluir_sessao(?)}";
		PreparedStatement delete;

		try (Connection conexao = MySqlConnection.getConnection()) {
			delete = conexao.prepareStatement(query);
			delete.setInt(1, caixa.getId());
			delete.executeUpdate();
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public ArrayList<Caixa> selectCaixa(String filtro) throws SQLException, Exception {
		String query = "{call buscar_sessao(?)}";
		PreparedStatement select;
		ResultSet resultado;
		ArrayList<Caixa> caixas = new ArrayList<Caixa>();
		FuncionarioDAO funcDao = new FuncionarioDAO();

		try (Connection conexao = MySqlConnection.getConnection()) {
			select = conexao.prepareStatement(query);
			select.setString(1, filtro);
			resultado = select.executeQuery();

			while (resultado.next()) {
				Caixa caixa = new Caixa();
				caixa.setId(resultado.getInt("id"));

				Funcionario funcAbertura = funcDao.selectFuncionario(resultado.getInt("func_abertura_id") + "").get(0);
				caixa.setFuncAbertura(funcAbertura);

				Funcionario funcFechamento = funcDao.selectFuncionario(resultado.getInt("func_fechamento_id") + "")
						.get(0);
				caixa.setFuncAbertura(funcFechamento);

				caixa.setSaldoInicial(resultado.getDouble("saldo_inicial"));
				caixa.setSaldoFinal(resultado.getDouble("saldo_final"));

				Timestamp abertura = resultado.getTimestamp("data_abertura");
				if (abertura != null)
					caixa.setAbertura(abertura.toLocalDateTime());

				Timestamp fechamento = resultado.getTimestamp("data_fechamento");
				if (fechamento != null)
					caixa.setFechamento(fechamento.toLocalDateTime());

				caixa.setStatus(EnumStatusCaixa.ofValue(resultado.getString("status")));

				caixas.add(caixa);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw new SQLException("Não foi possível pesquisar o caixa.");
		} catch (Exception e) {
			throw e;
		}

		return caixas;
	}

	public ArrayList<Caixa> selectCaixa() throws SQLException, Exception {
		return selectCaixa("%");
	}
}
