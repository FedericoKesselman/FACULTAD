package ar.edu.unlp.info.oo1.OO2_EJ3_PD;

import java.util.*;

public class MediaPlayer {
	private List<Media> mediaList;
	
	public MediaPlayer() {
		this.mediaList = new LinkedList<>();
	}
	
	public void play() {
		this.mediaList.stream()
			.forEach(media -> System.out.println(media.play()));
	}
}
