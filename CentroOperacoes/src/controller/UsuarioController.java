package controller;

import java.util.List;

import javax.faces.context.FacesContext;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioController {
	
	private UsuarioDAO uDao = new UsuarioDAO();
	
	public Usuario usuarioBuscado(String login, String pass) {
		try {
			login = login.toLowerCase().trim();
			List<Usuario> u = uDao.buscarUsuario(login);
			if(u.size()>0) {
				Usuario usuarioEncontrado = (Usuario) u.get(0);
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loggeduser", usuarioEncontrado);
				return usuarioEncontrado;
			}
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return null;
	}

}
