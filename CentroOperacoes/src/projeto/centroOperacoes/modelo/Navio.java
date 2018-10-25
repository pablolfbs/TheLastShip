package projeto.centroOperacoes.modelo;

import java.util.List;

public class Navio {
	
	private Integer navio_id;
	private String navio_nome;
	private Integer navio_status;
	
	private List<Evento> eventos;
	
	private List<AlocacaoEquipamento> alocacaoEquipamentos;
	
	public Integer getNavio_id() {
		return navio_id;
	}
	
	public void setNavio_id(Integer navio_id) {
		this.navio_id = navio_id;
	}
	
	public String getNavio_nome() {
		return navio_nome;
	}
	
	public void setNavio_nome(String navio_nome) {
		this.navio_nome = navio_nome;
	}

	public Integer getNavio_status() {
		return navio_status;
	}

	public void setNavio_status(Integer navio_status) {
		this.navio_status = navio_status;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<AlocacaoEquipamento> getAlocacaoEquipamentos() {
		return alocacaoEquipamentos;
	}

	public void setAlocacaoEquipamentos(List<AlocacaoEquipamento> alocacaoEquipamentos) {
		this.alocacaoEquipamentos = alocacaoEquipamentos;
	}

}
