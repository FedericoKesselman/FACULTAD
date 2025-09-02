package ar.edu.unlp.oo1.ejercicio1.impl;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Completar esta clase de acuerdo a lo especificado en el cuadernillo
 *
 */
public class WallPostImpl implements WallPost {
	private static final Logger logger = Logger.getLogger("WallPostImpl");
	private static final Logger loggerUI = Logger.getLogger("WallPostUI");


	private String text;
	private int likes;
	private boolean isFeatured;

	public WallPostImpl() {
		this.text = "Undefined post";
	}

	public WallPostImpl(String text, int likes, boolean isFeaured) {
		this.text = text;
		this.likes = likes;
		this.isFeatured = isFeaured;
	}

	@Override
	public String getText() {
		return text;
	}

	@Override
	public void setText(String text) {
		this.text = text;
		// loggerUI.log(Level.INFO, "Nombre del post actualizado:" + text);
	}

	@Override
	public int getLikes() {
		return likes;
	}

	@Override
	public void like() {
		this.likes = this.likes + 1;
		loggerUI.log(Level.INFO, "Like clickeado");
		if (this.likes == 10)
			logger.log(Level.WARNING, "Se alcanzaron los 10 likes.");
	}

	@Override
	public void dislike() {
		if (likes > 0) {
			this.likes = this.likes - 1;
			loggerUI.log(Level.INFO, "Dislike clickeado");	
		}
		if (this.likes == 0)
			logger.log(Level.WARNING, "Se llego a los 0 likes.");
	}

	@Override
	public boolean isFeatured() {
		return this.isFeatured;
	}

	@Override
	public void toggleFeatured() {
		this.isFeatured = !this.isFeatured;

	}

	/*
	 * Este mensaje se utiliza para que una instancia de Wallpost se muestre de
	 * forma adecuada
	 */

	@Override
	public String toString() {
		return "WallPost {" + "text: " + getText() + ", likes: '" + getLikes() + "'" + ", featured: '" + isFeatured()
				+ "'" + "}";
	}

}
