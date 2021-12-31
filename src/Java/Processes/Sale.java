package Processes;

import Appliances.Appliance;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;


public class Sale {

private static int count=0;
private int sale_code;
private Appliance model;
private String customer_name;
private String customer_phone;
private LocalDate sale_date;
private double sale_cost;
private int sale_pieces;
private static HashMap<Integer,Sale> Sales = new HashMap<Integer,Sale>();
static ImageIcon icon = new ImageIcon("src/images/sales.png");
static Image image = icon.getImage().getScaledInstance(40,40,0);


public Sale(Appliance model,int sale_code, String customer_name, LocalDate sale_date, String customer_phone,double sale_cost,int sale_pieces) {
	count++;
	Sales.put(count, this);
	this.sale_code =sale_code;
	this.model = model;
	this.customer_name = customer_name;
	this.customer_phone = customer_phone;
	this.sale_date = sale_date;
	this.sale_cost = sale_cost;
	this.sale_pieces=sale_pieces;
}

public Sale(Appliance model, String customer_name, LocalDate sale_date, String customer_phone,double sale_cost,int sale_pieces) {
	count++;
	Sales.put(count, this);
	this.sale_code =count;
	this.model = model;
	this.customer_name = customer_name;
	this.customer_phone = customer_phone;
	this.sale_date = sale_date;
	this.sale_cost = sale_cost;
	this.sale_pieces=sale_pieces;
}


public static HashMap<Integer, Sale> getSales() {
	return Sales;
}


public Appliance getModel() {
	return model;
}

public String getCustomer_name() {
	return customer_name;
}

public String getCustomer_phone() {
	return customer_phone;
}

public LocalDate getSale_date() {
	return sale_date;
}

public int getSale_code() {
	return sale_code;
}

public double getSale_cost() {
	return sale_cost;
}

public int getSale_pieces() {
	return sale_pieces;
}

@Override
public String toString() {
	return "Sale Details \nSale Code = "+ sale_code +" \nDevice = "+ model +" \nCustomer Name = "+ customer_name
			+ "\nClient Phone =" + customer_phone + "\nDate of Sale =" + sale_date + "\nCost =" + sale_cost + "€" + "\nSales Pieces =" + sale_pieces;
}

public static void Overview_Sales() {
	String input = (String) JOptionPane.showInputDialog(null, "Please enter the sales code:",
			"Sales",JOptionPane.QUESTION_MESSAGE,new ImageIcon(image),null,null);
	if (input!=null) {
		try {
			boolean x = false;
			for (int i = 0; i <= Sales.size(); i++) {
				if (Sales.get(i) != null) {
					if (Sales.get(i).sale_code == Integer.parseInt(input)) {
						x = true;
						JOptionPane.showMessageDialog(null, Sales.get(i), "Sale", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));
					}
				}
			}
			if (x == false) {
				JOptionPane.showMessageDialog(null, "The sales code you entered is not registered!", "Error", JOptionPane.WARNING_MESSAGE);

			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Wrong number format! Try again!", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}


}
