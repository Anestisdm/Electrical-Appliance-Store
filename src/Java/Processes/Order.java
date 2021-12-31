package Processes;

import Appliances.Appliance;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;
import java.time.LocalDate;


public class Order {

private static int count=0;
private int order_code;
private Appliance model;
private String customer_name;
private String customer_phone;
private LocalDate order_date;
private LocalDate arrival_date;
private double order_cost;
private int order_pieces;
private String order_status;
private static HashMap<Integer, Order> Orders = new HashMap<Integer, Order>();
static ImageIcon icon = new ImageIcon("src/images/orders.png");
static Image image = icon.getImage().getScaledInstance(40,40,0);

public Order(Appliance model,int order_code, String customer_name, String customer_phone,LocalDate order_date, LocalDate arrival_date,
		double order_cost,int order_pieces, String order_status) {
	count++;
	Orders.put(count,this);
	this.order_code=order_code;
	this.model = model;
	this.customer_name = customer_name;
	this.customer_phone = customer_phone;
	this.order_date = order_date;
	this.arrival_date = arrival_date;
	this.order_cost = order_cost;
	this.order_pieces=order_pieces;
	this.order_status = order_status;
}

//Constructor without order_code
public Order(Appliance model, String customer_name, String customer_phone,LocalDate order_date, LocalDate arrival_date,
		double order_cost,int order_pieces, String order_status) {
	count++;
	Orders.put(count,this);
	this.order_code=count;
	this.model = model;
	this.customer_name = customer_name;
	this.customer_phone = customer_phone;
	this.order_date =order_date;
	this.arrival_date = arrival_date;
	this.order_cost = order_cost;
	this.order_pieces=order_pieces;
	this.order_status = order_status;
}

public static HashMap<Integer, Order> getOrders() {
	return Orders;
}

public int getOrder_code() {
	return order_code;
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

public LocalDate getOrder_date() {
	return order_date;
}

public LocalDate getArrival_date() {
	return arrival_date;
}

public double getOrder_cost() {
	return order_cost;
}

public int getOrder_pieces() {
	return order_pieces;
}

public String getOrder_status() {
	return order_status;
}

@Override
public String toString() {
	return "Order Details \nOrder Code =" + order_code + "\nDevice Model =" + model + "\nCustomerName =" + customer_name
			+ "\nCustomer Phone =" + customer_phone + "\nOrder Date =" + order_date + "\nOrder Arrival Date =" + arrival_date
			+ "\nCost =" + order_cost + "€" + "\nOrder Parts =" + order_pieces + "\nOrder Status =" + order_status;
}

public static void Overview_Orders() {
	String input = (String) JOptionPane.showInputDialog(null, "Please enter the order code:",
			"Orders",JOptionPane.QUESTION_MESSAGE,new ImageIcon(image),null,null);
	if (input!=null) {
		try {
			boolean x = false;
			for (int i = 0; i <= Orders.size(); i++) {
				if (Orders.get(i) != null) {
					if (Orders.get(i).order_code == (Integer.parseInt(input))) {
						x = true;
						boolean y = false;
						if (Orders.get(i).order_status.equals("EXPECTED")) {
							do {
								int input1 = JOptionPane.showConfirmDialog(null, Orders.get(i).toString() + "\n\nDo you want to place order & sell:",
										"Order", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));
								if (input1 == 0) {
									y = true;
									Orders.get(i).order_status = "EXECUTED";
									Sale s = new Sale(Orders.get(i).model, Orders.get(i).customer_name, Orders.get(i).order_date, Orders.get(i).customer_phone, Orders.get(i).order_cost, Orders.get(i).order_pieces);
									JOptionPane.showMessageDialog(null, "The status of the order has been updated!\nThe sales code is: " + s.getSale_code());
								} else if (input1 == 1) {
									break;
								} else {
									JOptionPane.showMessageDialog(null, "Wrong input!", "Error", JOptionPane.WARNING_MESSAGE);

								}
							}
							while (y == false);
						} else {
							JOptionPane.showMessageDialog(null, Orders.get(i).toString() + "\n\nThe order has been executed!","Order", JOptionPane.INFORMATION_MESSAGE, new ImageIcon(image));

						}
					}
				}
			}
			if (x == false) {
				JOptionPane.showMessageDialog(null, "The order code you entered is not registered!", "Error", JOptionPane.WARNING_MESSAGE);

			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "Wrong number format! Try again!", "Error", JOptionPane.WARNING_MESSAGE);
		}
	}
}



}
