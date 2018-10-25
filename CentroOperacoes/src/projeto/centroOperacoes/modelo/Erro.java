package projeto.centroOperacoes.modelo;

public class Erro {
	
	private Integer erro_id;
	private String erro_nome;
	private String erro_descricao;
	private String erro_tipo;
	private Integer erro_prioridade;
	private Integer erro_status;
	
	private Equipamento equipamento;
	
	public Integer getErro_id() {
		return erro_id;
	}
	public void setErro_id(Integer erro_id) {
		this.erro_id = erro_id;
	}
	public String getErro_nome() {
		return erro_nome;
	}
	public void setErro_nome(String erro_nome) {
		this.erro_nome = erro_nome;
	}
	public String getErro_descricao() {
		return erro_descricao;
	}
	public void setErro_descricao(String erro_descricao) {
		this.erro_descricao = erro_descricao;
	}
	public String getErro_tipo() {
		return erro_tipo;
	}
	public void setErro_tipo(String erro_tipo) {
		this.erro_tipo = erro_tipo;
	}
	public Integer getErro_prioridade() {
		return erro_prioridade;
	}
	public void setErro_prioridade(Integer erro_prioridade) {
		this.erro_prioridade = erro_prioridade;
	}
	public Integer getErro_status() {
		return erro_status;
	}
	public void setErro_status(Integer erro_status) {
		this.erro_status = erro_status;
	}
	public Equipamento getEquipamento() {
		return equipamento;
	}
	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

}
