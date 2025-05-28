package io.github.unlp_oo.OO2_Ej1;
import java.util.*;

public class Twitter {
	private List<Usuario> usuarios; 
	
	public Twitter () {
		usuarios = new LinkedList<>();
	}
	
	public boolean existeUsuario (String screenName) {
		return this.usuarios.stream()
                .anyMatch(u -> u.getScreenName().equals(screenName));
	}
	
	public Usuario crearUsuario(String screenName) {	  
		Usuario u = null;
	    if (!existeUsuario(screenName)) {
	    	u = new Usuario(screenName);
	    	usuarios.add(u);
	    }
	    return u;
	}
	
	public void eliminarUsuario (Usuario usuario) {
		if (usuarios.contains(usuario)) {
			
			List<Post> tweets = new LinkedList<>(usuario.getTweets());
			usuarios.remove(usuario);
			
			tweets.stream().forEach(p -> borrarReferenciados(p));
		}
	}
	
	public void borrarReferenciados (Post post) {
		this.usuarios.stream()
			.forEach(usuario -> usuario.eliminarReferencias(post));
	}
}



