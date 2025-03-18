package io.github.unlp_oo.OO2_Ej1;
import java.util.*;
import java.util.stream.Collectors;


public class Usuario {
	private String screenName;
	private List<Post> tweets;
	
	public Usuario (String screenName) {
		this.tweets = new LinkedList<>();
	}
	
	public String getScreenName () {
		return this.screenName;
	}
	
	public void eliminarTweets () {
		tweets = new LinkedList<>();
	}
	
	public void eliminarReferencias(Post tweet) {
	    this.tweets = this.tweets.stream()
	        .filter(post -> !(post instanceof ReTweet && ((ReTweet) post).getTweetOrigen().equals(tweet)))
	        .collect(Collectors.toList());
	}
	
	public List<Post> getTweets () {
		return this.tweets;
	}

	
	public Post twittear (String texto) {
		Post tweet = null;
		if (cumpleLongitud(texto)) {
			tweet = new Tweet(texto);
			tweets.add(tweet);
		}
		return tweet;
		
	}
	
	private boolean cumpleLongitud (String texto) {
		return texto.length() > 0 && texto.length() < 281;
	}
	
	public Post reTwittear (Tweet tweet) {
		ReTweet rt = new ReTweet (tweet);
		this.tweets.add(rt);
		return rt;
	}
	
	
	
	
	
	
}
