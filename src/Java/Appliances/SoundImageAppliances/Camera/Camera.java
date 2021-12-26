package Appliances.SoundImageAppliances.Camera;

import Appliances.SoundImageAppliances.Sound_Image;

public class Camera extends Sound_Image {

private final String megapixel;
private final String optical_zoom;
private final String digital_zoom;
private final String screen_size;
private static final String name="Camera";

public Camera(String code,String model_name, int model_year, String manufacturer, double price, int stock, String type,
		String megapixel, String optical_zoom, String digital_zoom, String screen_size) {
	super(code,model_name, model_year, manufacturer, price, stock, type);
	this.megapixel = megapixel;
	this.optical_zoom = optical_zoom;
	this.digital_zoom = digital_zoom;
	this.screen_size = screen_size;
}

public String getMegapixel() {
	return megapixel;
}

public String getOptical_zoom() {
	return optical_zoom;
}

public String getDigital_zoom() {
	return digital_zoom;
}

public String getScreen_size() {
	return screen_size;
}

public String getName() {
	return name;
}

@Override
public String toString() {
	return "����������� ������"+super.toString()+"\nMegapixel=" + megapixel + "\n������ zoom=" + optical_zoom + "\n������� zoom=" + digital_zoom
			+ "\n������� ������=" + screen_size;
}


}



