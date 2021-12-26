package Appliances.HouseAppliances;

import Appliances.Appliance;

public abstract class House_Appliance extends Appliance {
private final String energy_class;
private double discount=0.20;

public House_Appliance(String code,String model_name, int model_year, String manufacturer, double price, int stock,
		String energy_class) {
	super(code,model_name, model_year, manufacturer, price,stock);
	this.energy_class = energy_class;
}

public double getDiscount() {
	return discount;
}

public String getEnergy_class() {
	return energy_class;
}


@Override
public String toString() {
	return super.toString()+"\n���������� �����=" + energy_class;
}


}
