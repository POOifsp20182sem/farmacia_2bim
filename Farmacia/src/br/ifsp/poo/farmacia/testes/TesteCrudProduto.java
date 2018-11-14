package br.ifsp.poo.farmacia.testes;

import br.ifsp.poo.farmacia.modelo.entidade.ClasseTerapeutica;
import br.ifsp.poo.farmacia.modelo.entidade.EnumFormaFarmaco;
import br.ifsp.poo.farmacia.modelo.entidade.PrincipioAtivo;
import br.ifsp.poo.farmacia.modelo.entidade.Produto;
import br.ifsp.poo.farmacia.modelo.persistencia.ProdutoDAO;

public class TesteCrudProduto {

	public static void main(String[] args) {
		/*Produto prod = new Produto("Remédio forte", "Poderoso", EnumFormaFarmaco.DRAGEA,
				"eu que fiz", "batata frita", "tonela cúbica", "42666404",
				"numero aqui", "psicotropico", 120);*/

		ProdutoDAO prodDAO = new ProdutoDAO();
		Produto prod = new Produto();
		ClasseTerapeutica classe = new ClasseTerapeutica();
		PrincipioAtivo prin = new PrincipioAtivo();
		
		classe.setId(2);
		prin.setId(2);
		
		/*prod.setNomeComercial("Alice Bueno");
		prod.setPrecoUnitario(2132);
		prod.setFormaFarmaco(EnumFormaFarmaco.DRAGEA);
		prod.setClasseTerapeutica(classe);
		prod.setCodigoBarras("dfa");
		prod.setPrincipioAtivo(prin);
		prod.setApresentacao("dfadf");*/
		
		/*for(EnumFormaFarmaco s : EnumFormaFarmaco.values()) {
			System.out.println(s.getFormaFarmaco());
		}*/
		
		
		
	
		try {
			//TODO:FormaFarmaco está sendo inserido em letras maiúsculas
			
			//prodDAO.insertProduto(prod);
			
			/*prod.setId(15);
			prodDAO.updateProduto(prod);*/
			
			prod.setId(13);
			prodDAO.deleteProduto(prod);
			
			
			/*for(Produto p: prodDAO.selectProduto()) {
				System.out.println(p.toString());
			}*/
				
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
