package projeto.centroOperacoes.modelo;

import java.util.List;

public class AlocacaoEquipamento {
	
	private Integer alocacaoequipamento_id;
	private String alocacaoequipamento_zona;
	private Integer alocacaoequipamento_status;
	
	private Navio navio;
	
	private Equipamento equipamento;
	
	private List<Evento> eventos;
	
	private List<Erro> erros;
	
	public Integer getAlocacaoequipamento_id() {
		return alocacaoequipamento_id;
	}
	
	public void setAlocacaoequipamento_id(Integer alocacaoequipamento_id) {
		this.alocacaoequipamento_id = alocacaoequipamento_id;
	}
	
	public String getAlocacaoequipamento_zona() {
		return alocacaoequipamento_zona;
	}
	
	public void setAlocacaoequipamento_zona(String alocacaoequipamento_zona) {
		this.alocacaoequipamento_zona = alocacaoequipamento_zona;
	}
	
	public Integer getAlocacaoequipamento_status() {
		return alocacaoequipamento_status;
	}
	
	public void setAlocacaoequipamento_status(Integer alocacaoequipamento_status) {
		this.alocacaoequipamento_status = alocacaoequipamento_status;
	}

	public Navio getNavio() {
		return navio;
	}

	public void setNavio(Navio navio) {
		this.navio = navio;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Erro> getErros() {
		return erros;
	}

	public void setErros(List<Erro> erros) {
		this.erros = erros;
	}
	
}
