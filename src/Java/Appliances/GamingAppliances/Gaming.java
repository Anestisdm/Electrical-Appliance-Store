package Appliances.GamingAppliances;

import Appliances.Appliance;

public abstract class Gaming extends Appliance {
private final String type;
private final String processor;
private final String graphics;
private final String sound;
private final String capacity_of_HDD;
private double discount=0.10;


public Gaming(String code,String model_name, int model_year, String manufacturer, double price, int stock, String type,
		String processor, String graphics, String sound, String capacity_of_HDD) {
	super(code,model_name, model_year, manufacturer, price,stock);
	this.type = type;
	this.processor = processor;
	this.graphics = graphics;
	this.sound = sound;
	this.capacity_of_HDD = capacity_of_HDD;
}

public double getDiscount() {
	return discount;
}

public String getType() {
	return type;
}

public String getProcessor() {
	return processor;
}

public String getGraphics() {
	return graphics;
}

public String getSound() {
	return sound;
}

public String getCapacity_of_HDD() {
	return capacity_of_HDD;
}

@Override
public String toString() {
	return super.toString()+"\n�����=" + type + "\n������������=" + processor + "\n�������=" + graphics + "\n����=" + sound
			+ "\n������������ ������� ������=" + capacity_of_HDD ;
}


}
