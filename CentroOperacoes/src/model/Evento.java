package model;

import java.util.Date;

public class Evento {
	
	private Integer evento_id;
	private Date evento_data;
	private String evento_descricao;
	private Integer evento_status;
	private Integer evento_prioridade;
	
	public Integer getEvento_id() {
		return evento_id;
	}
	public void setEvento_id(Integer evento_id) {
		this.evento_id = evento_id;
	}
	public Date getEvento_data() {
		return evento_data;
	}
	public void setEvento_data(Date evento_data) {
		this.evento_data = evento_data;
	}
	public String getEvento_descricao() {
		return evento_descricao;
	}
	public void setEvento_descricao(String evento_descricao) {
		this.evento_descricao = evento_descricao;
	}
	public Integer getEvento_status() {
		return evento_status;
	}
	public void setEvento_status(Integer evento_status) {
		this.evento_status = evento_status;
	}
	public Integer getEvento_prioridade() {
		return evento_prioridade;
	}
	public void setEvento_prioridade(Integer evento_prioridade) {
		this.evento_prioridade = evento_prioridade;
	}
	
	

}
