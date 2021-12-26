package Appliances.HouseAppliances.WashingMachine;
import Appliances.HouseAppliances.House_Appliance;

public class Washing_Machine extends House_Appliance {

private final String capacity;
private final String spins;
private static final String name="Washing Machine";

public Washing_Machine(String code,String model_name, int model_year, String manufacturer, double price, int stock, String energy_class,
		String capacity, String spins) {
	super(code,model_name, model_year, manufacturer, price, stock, energy_class);
	this.capacity = capacity;
	this.spins = spins;
}

public String getName() {
	return name;
}

public String getCapacity() {
	return capacity;
}

public String getSpins() {
	return spins;
}

@Override
public String toString() {
	return "���������"+super.toString()+"\n������������=" + capacity + "\n�������=" + spins;
}


}
