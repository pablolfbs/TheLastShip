package model;

public class AlocacaoEquipamento {
	
	private Integer alocacaoequipamento_id;
	private String alocacaoequipamento_zona;
	private Integer alocacaoequipamento_status;
	
	private Navio navio_id;
	
	private Equipamento equipamento_id;
	
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

	public Navio getNavio_id() {
		return navio_id;
	}

	public void setNavio_id(Navio navio_id) {
		this.navio_id = navio_id;
	}

	public Equipamento getEquipamento_id() {
		return equipamento_id;
	}

	public void setEquipamento_id(Equipamento equipamento_id) {
		this.equipamento_id = equipamento_id;
	}
	
}
