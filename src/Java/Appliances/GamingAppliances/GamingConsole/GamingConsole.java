package Appliances.GamingAppliances.GamingConsole;

import Appliances.GamingAppliances.Gaming;

public class GamingConsole extends Gaming {

private static final String name="Console";

	public GamingConsole(String code, String model_name, int model_year, String manufacturer, double price, int stock, String type,
						 String processor, String graphics, String sound, String capacity_of_HDD) {
		super(code,model_name, model_year, manufacturer, price, stock, type, processor, graphics, sound, capacity_of_HDD);

	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "�������"+super.toString();
	}


}
