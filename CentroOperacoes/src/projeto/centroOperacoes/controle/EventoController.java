package projeto.centroOperacoes.controle;

import java.util.List;

import projeto.centroOperacoes.modelo.Evento;
import projeto.centroOperacoes.modelo.dao.EquipamentoDAO;
import projeto.centroOperacoes.modelo.dao.EventoDAO;
import projeto.centroOperacoes.modelo.dao.NavioDAO;
import projeto.centroOperacoes.modelo.dao.UsuarioDAO;

public class EventoController {

	private UsuarioDAO usuarioDao = new UsuarioDAO();
	private EventoDAO eventoDAO = new EventoDAO();
	private NavioDAO navioDAO = new NavioDAO();
	private EquipamentoDAO equipamentoDAO = new EquipamentoDAO();

	public Evento buscarEvento(Evento evento) {
		try {
			List<Evento> eventoLista = eventoDAO.buscar(evento.getEvento_id());
			if (eventoLista.size() > 0) {
				return eventoLista.get(0);
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}