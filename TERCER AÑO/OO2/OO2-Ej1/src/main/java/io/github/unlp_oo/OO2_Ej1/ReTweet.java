package io.github.unlp_oo.OO2_Ej1;

public class ReTweet implements Post {
	private Post tweetOrigen;

	public ReTweet (Tweet tweetOrigen) {
		this.tweetOrigen = tweetOrigen;
	}
	
	public String getTexto() {
		return this.tweetOrigen.getTexto();
	}
	
	public Post getTweetOrigen () {
		return this.tweetOrigen;
	}
	
 }
