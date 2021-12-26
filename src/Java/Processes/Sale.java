package Processes;

import Appliances.Appliance;

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
	return "�������� �������\n������� �������=" + sale_code + "\n�������=" + model + "\n������������� ������=" + customer_name
			+ "\n�������� ������=" + customer_phone + "\n���������� �������=" + sale_date + "\n������=" + sale_cost+"�"+"\n�������� �������="+sale_pieces;
}

public static void Overview_Sales() {
	Scanner scanner= new Scanner(System.in);
	System.out.println("-----------------------------------------------------------");
	System.out.print("�������� �������� ��� ������ �������: (������� 0 ��� �����) ");
	int input=scanner.nextInt();
	boolean x=false;
	for(int i=0;i<=Sales.size();i++) {
		if (input==0) {
			x=true;
			break;
		}
		if(Sales.get(i)!=null) {
			if(Sales.get(i).sale_code==input) {
				x=true;
				System.out.println("-----------------------------------------------------------");
				System.out.println(Sales.get(i));
			}
		}
	}
	if (x==false) {
		System.out.println("-----------------------------------------------------------");
		System.out.println("� ������� ������� ��� �������� ��� ����� �������������!");
	}
}


}
