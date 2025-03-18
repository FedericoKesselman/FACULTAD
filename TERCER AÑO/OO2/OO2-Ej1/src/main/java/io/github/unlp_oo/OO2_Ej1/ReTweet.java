package io.github.unlp_oo.OO2_Ej1;

public class ReTweet implements Post {
	private Post tweetOrigen;

	public ReTweet (Post tweetOrigen) {
		this.tweetOrigen = tweetOrigen;
	}
	
	public String getTexto() {
		return this.tweetOrigen.getTexto();
	}
	
	public boolean debeEliminarse(Post post) {
		return this.tweetOrigen.equals(post);
	}
	
 }
