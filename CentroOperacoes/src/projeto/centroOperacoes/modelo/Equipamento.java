package projeto.centroOperacoes.modelo;

import java.util.List;

public class Equipamento {
	
	private Integer equipamento_id;
	private String equipamento_descricao;
	private Integer equipamento_status;
	
	private List<AlocacaoEquipamento> alocacaoEquipamentos;
	
	private List<Erro> erros;
	
	public Integer getEquipamento_id() {
		return equipamento_id;
	}
	public void setEquipamento_id(Integer equipamento_id) {
		this.equipamento_id = equipamento_id;
	}
	public String getEquipamento_descricao() {
		return equipamento_descricao;
	}
	public void setEquipamento_descricao(String equipamento_descricao) {
		this.equipamento_descricao = equipamento_descricao;
	}
	public Integer getEquipamento_status() {
		return equipamento_status;
	}
	public void setEquipamento_status(Integer equipamento_status) {
		this.equipamento_status = equipamento_status;
	}
	public List<AlocacaoEquipamento> getAlocacaoEquipamentos() {
		return alocacaoEquipamentos;
	}
	public void setAlocacaoEquipamentos(List<AlocacaoEquipamento> alocacaoEquipamentos) {
		this.alocacaoEquipamentos = alocacaoEquipamentos;
	}
	public List<Erro> getErros() {
		return erros;
	}
	public void setErros(List<Erro> erros) {
		this.erros = erros;
	}

}
