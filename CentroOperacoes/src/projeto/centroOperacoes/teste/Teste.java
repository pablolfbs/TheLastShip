package projeto.centroOperacoes.teste;

import projeto.centroOperacoes.modelo.Navio;
import projeto.centroOperacoes.modelo.dao.NavioDAO;

public class Teste {

	public static void main(String[] args) {

		NavioDAO nDAO = new NavioDAO();
		Navio n = new Navio();
//		
//		n.setNavio_id(10);
//		n.setNavio_nome("Navio 10");
//		n.setNavio_status(1);
//		
//		nDAO.inserir(n);
		
		nDAO.excluir(1);

	}

}
