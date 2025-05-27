package io.github.unlp_oo.OO2_Ej1;

public class Tweet implements Post {
	private String texto;
	
	public Tweet (String texto) {
		this.texto = texto;
	}
	
	public String getTexto() {
		return this.texto;
	}
	
	public boolean debeEliminarse (Post post) {
		return post.equals(this);
	}
}
