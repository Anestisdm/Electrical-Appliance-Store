
public class Television extends Sound_Image {

private final String screen_size;
private final String resolution;
private final String ports;
private static final String name="tv";


public Television(String code,String model_name, int model_year, String manufacturer, double price, int stock, String type,
		String screen_size, String resolution, String ports) {
	super(code,model_name, model_year, manufacturer, price, stock, type);
	this.screen_size = screen_size;
	this.resolution = resolution;
	this.ports = ports;
}
public String getName() {
	return name;
}

public String getScreen_size() {
	return screen_size;
}
public String getResolution() {
	return resolution;
}
public String getPorts() {
	return ports;
}
@Override
public String toString() {
	return "Τηλεόραση"+super.toString()+"\nΔιάσταση Οθόνης=" + screen_size + "\nΑνάλυση=" + resolution + "\nΘύρες=" + ports;
}



}
