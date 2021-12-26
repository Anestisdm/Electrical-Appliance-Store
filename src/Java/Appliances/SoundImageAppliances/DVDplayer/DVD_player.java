package Appliances.SoundImageAppliances.DVDplayer;
import Appliances.SoundImageAppliances.Sound_Image;

public class DVD_player extends Sound_Image {

private final String resolution;
private final String format_playback;
private static final String name="DVD player";


public DVD_player(String code,String model_name, int model_year, String manufacturer, double price, int stock, String type,
		String resolution, String format_playback) {
	super(code,model_name, model_year, manufacturer, price, stock, type);
	this.resolution = resolution;
	this.format_playback = format_playback;
}

public String getName() {
	return name;
}

public String getResolution() {
	return resolution;
}

public String getFormat_playback() {
	return format_playback;
}

@Override
public String toString() {
	return "DVD Player"+super.toString()+"\n�������=" + resolution + "\nFormat ������������=" + format_playback;
}


}


