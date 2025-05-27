package ar.edu.unlp.info.oo1.OO2_EJ3_PD;

public class VideoStreamAdapter extends Media{
	private VideoStream videoStream;

	@Override
	public String play() {
		return this.videoStream.reproduce();
	}
}
