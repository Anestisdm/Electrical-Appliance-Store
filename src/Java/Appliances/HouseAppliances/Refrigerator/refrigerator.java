package Appliances.HouseAppliances.Refrigerator;

import Appliances.HouseAppliances.House_Appliance;

public class refrigerator extends House_Appliance {

private final String type;
private final String refrigerator_capacity;
private final String freezer_capacity;
private static final String name="refrigerator";


public refrigerator(String code,String model_name, int model_year, String manufacturer, double price, int stock, String energy_class,
		String type, String refrigerator_capacity, String freezer_capacity) {
	super(code,model_name, model_year, manufacturer, price, stock, energy_class);
	this.type = type;
	this.refrigerator_capacity = refrigerator_capacity;
	this.freezer_capacity = freezer_capacity;
}

public String getName() {
	return name;
}
public String getType() {
	return type;
}

public String getRefrigerator_capacity() {
	return refrigerator_capacity;
}

public String getFreezer_capacity() {
	return freezer_capacity;
}

@Override
public String toString() {
	return "������"+super.toString()+"\n�����=" + type + "\n������������ ����������=" + refrigerator_capacity + "\n������������ ���������="
			+ freezer_capacity;
}


}
