
public abstract class Sound_Image extends Appliance {

private final String type;
private double discount=0.25;


public Sound_Image(String code,String model_name, int model_year, String manufacturer, double price, int stock, String type) {
	super(code,model_name, model_year, manufacturer, price, stock);
	this.type = type;
}

public double getDiscount() {
	return discount;
}

public String getType() {
	return type;
}

@Override
public String toString() {
	return super.toString()+"\nΤύπος=" + type ;
}

}
