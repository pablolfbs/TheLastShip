package view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.context.RequestContext;

import controller.UsuarioController;
import model.Usuario;;

@ManagedBean
@RequestScoped
public class LoginView {

	private Usuario usuario;
	private String username;
	private String password;
 
	public void setUsername(String name) {
		this.username = name;
	}
 
	public String getUsername() {
		return username;
	}
 
	public String getPassword() {
		return password;
	}
  
	public void setPassword(String password) {
		this.password = password;
	}
  
	public void login(ActionEvent event) {
		try {    	
	        RequestContext context = RequestContext.getCurrentInstance();
	        FacesMessage message = null;
	        boolean loggedIn = false;
	        
	        UsuarioController usuarioController = new UsuarioController();
	        usuario = usuarioController.usuarioBuscado(username, password);
	        
	        if (usuario == null) {
	            FacesContext.getCurrentInstance().validationFailed();
	            loggedIn = false;
	            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro de Login", "Acesso inválido");	          
	        }else{          
					loggedIn = true;
					FacesContext.getCurrentInstance().getExternalContext().redirect("main.xhtml");
					message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem vindo ", usuario.getUsuario_nome());
	        }
	        	        
		} catch (Exception e) {
			e.printStackTrace();
		}        
	}  

}