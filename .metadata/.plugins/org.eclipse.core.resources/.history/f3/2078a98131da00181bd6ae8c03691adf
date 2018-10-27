package br.ifsp.farmacia.model.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import br.ifsp.farmacia.model.entities.Cliente;
import br.ifsp.farmacia.model.entities.Funcionario;
import br.ifsp.farmacia.model.entities.Venda;

public class VendaDAO implements IVendaDAO{

	@Override
	public boolean insertVenda(Venda ven) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			
			String query = "{call inserir_pedido(?, ?, ?, ?, ?)}"; 
			// TODO: ver com base no mysql
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, ven.getCliente().getId());
			ps.setInt(2, ven.getFuncionario().getId());
			ps.setDouble(3, ven.getDesconto());
			ps.setDouble(4, ven.getTotal());
			ps.setString(5, ven.getData());

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
	public boolean updateVenda(Venda ven) throws SQLException {
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			String query = "{call alterar_pedido(?, ?, ?, ?, ?, ?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setInt(1, ven.getId());
			ps.setInt(2, ven.getCliente().getId());
			ps.setInt(3, ven.getFuncionario().getId());
			ps.setDouble(4, ven.getDesconto());
			ps.setDouble(5, ven.getTotal());
			ps.setString(6, ven.getData());
			
		if(ps.executeUpdate() == 0) {
			System.out.println("Erro ao alterar!");
		}
		else {
			System.out.println("Dado alterado com sucesso!");
			return true;
		}
		
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		conn.close();
	}		return false;
	}

	@Override
	public boolean deleteVenda(Venda ven) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		try {

			String query = "{call excluir_pedido(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		
			
			ps.setInt(1, ven.getId());

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
		}		return false;
	}

	@Override
	public ArrayList<Venda> selectVenda(String filter) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<Venda> listVendas = new ArrayList<>();
		Venda ven = new Venda();
		
		try {
			String query = "{call buscar_pedidos(?)}"; 

			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		

			ps.setString(1, filter);

			ResultSet result = ps.executeQuery();

			while(result.next()) {
				ven = new Venda();
				
				Cliente cli = new Cliente();
				Funcionario fun = new Funcionario();
				
				cli.setId(result.getInt("cliente_id"));
				cli.setNome(result.getString("nome"));
				
				fun.setId(result.getInt("funcionario_id"));
				fun.setNome(result.getString("nome_fun"));
				
				ven.setId(result.getInt("id"));
				ven.setCliente(cli);				
				ven.setFuncionario(fun);
				ven.setTotal(result.getDouble("total"));
				ven.setDesconto(result.getDouble("desconto"));
				ven.setData(result.getString("data_compra"));

				listVendas.add(ven);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return listVendas;
	}

	@Override
	public ArrayList<Venda> selectVenda() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		ArrayList<Venda> listVendas = new ArrayList<>();
		Venda ven = new Venda();
		
		try {
			String query = "{call buscar_pedidos(?)}"; 
			conn = MySqlConnection.getConnection();
			ps = conn.prepareStatement(query);		
			
			ps.setString(1, "");
			
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				ven = new Venda();
				
				Cliente cli = new Cliente();
				Funcionario fun = new Funcionario();
				
				cli.setId(result.getInt("cliente_id"));
				cli.setNome(result.getString("nome"));
				
				fun.setId(result.getInt("funcionario_id"));
				fun.setNome(result.getString("nome_fun"));
				
				ven.setId(result.getInt("id"));
				ven.setCliente(cli);				
				ven.setFuncionario(fun);
				ven.setTotal(result.getDouble("total"));
				ven.setDesconto(result.getDouble("desconto"));
				ven.setData(result.getString("data_compra"));
				
				listVendas.add(ven);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			conn.close();
		}
		return listVendas;
	}

}
