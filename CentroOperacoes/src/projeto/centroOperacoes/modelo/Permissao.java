package projeto.centroOperacoes.modelo;

import java.util.List;

public class Permissao {
	
	private Integer permissao_id;
	private String permissao_nome;
	private Integer permissao_status;
	
	private List<Usuario> usuarios;
	
	public Integer getPermissao_id() {
		return permissao_id;
	}
	public void setPermissao_id(Integer permissao_id) {
		this.permissao_id = permissao_id;
	}
	public String getPermissao_nome() {
		return permissao_nome;
	}
	public void setPermissao_nome(String permissao_nome) {
		this.permissao_nome = permissao_nome;
	}
	public Integer getPermissao_status() {
		return permissao_status;
	}
	public void setPermissao_status(Integer permissao_status) {
		this.permissao_status = permissao_status;
	}
	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
