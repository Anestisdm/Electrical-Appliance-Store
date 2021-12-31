package Processes;

import Appliances.Appliance;
import Processes.Order;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.*;

public class StoreOrders{

public void LoadFile (String Orders) {
	BufferedReader reader= null;
	Order item = null;
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy").withLocale(Locale.ENGLISH);
	String line;
	try{
		reader = new BufferedReader(new FileReader(new File(Orders)));
		do {
		line = reader.readLine();
		}
		while (line.isEmpty());
			if (line.trim().equalsIgnoreCase("ORDER_LIST")) {
				do {
				line = reader.readLine();
				}
				while (line.isEmpty());
					if(line.trim().equals("{")) {
						do {
							line = reader.readLine();
						}
						while (line.isEmpty());
						while(!line.trim().equals("}")) {
							boolean x = false;
							String Item_Type=null;
							String Model_Name=null;
							String Manufacturer=null;
							Double Price=0.0;
							int Order_Number=0;
							String Customer_Phone=null;
							String Customer_Name=null;
							LocalDate Order_Date=null;
							LocalDate Delivery_Date=null;
							String Status=null;
							int Pieces=0;
							if (line.trim().equalsIgnoreCase("ORDER")) {
								do {
								line = reader.readLine();
								}
								while (!line.trim().equals("{"));
										while(!line.trim().equals("}")) {
											line = reader.readLine().trim();
											StringTokenizer st=new StringTokenizer(line," ");
											if (st.hasMoreTokens()) {
												String token=st.nextToken();
												if (token.equalsIgnoreCase("ITEM_TYPE")) 
													Item_Type=line.trim().substring(10).trim();
												else if(token.equalsIgnoreCase("MODEL")) 
													Model_Name=line.trim().substring(6).trim();
												else if(token.equalsIgnoreCase("MANUFACTURER")) 
													Manufacturer=line.trim().substring(13).trim();
												else if(token.equalsIgnoreCase("PRICE")) 
													Price=Double.parseDouble(line.trim().substring(6).trim());
												else if(token.equalsIgnoreCase("ORDER_NUMBER")) 
													Order_Number=Integer.parseInt(line.trim().substring(12).trim());
												else if(token.equalsIgnoreCase("NAME")) 
													Customer_Name=line.trim().substring(5).trim();
												else if(token.equalsIgnoreCase("PHONE"))
													Customer_Phone=line.trim().substring(6).trim();
												else if(token.equalsIgnoreCase("ORDER_DATE")) 
													Order_Date=LocalDate.parse(line.trim().substring(11).trim(),formatter);
												else if(token.equalsIgnoreCase("DELIVERY_DATE")) 
													Delivery_Date=LocalDate.parse(line.trim().substring(14).trim(),formatter);
												else if(token.equalsIgnoreCase("PIECES")) 
													Pieces=Integer.parseInt(line.trim().substring(7).trim());
												else if(token.equalsIgnoreCase("STATUS"))
													Status=line.trim().substring(7).trim();
											}
										}
										for (Appliance a : Appliance.getAppliances().values()) {
											if (a.getModel_name().equals(Model_Name)) {
													item = new Order(a,Order_Number,Customer_Name,Customer_Phone,Order_Date,Delivery_Date,Price,Pieces,Status);
													x=true;
											}
										}
										if (x==false) {
											JOptionPane.showMessageDialog(null, "The "+ Model_Name +" product of the manufacturer "+ Manufacturer +" can not be added to the list of orders, because it is not in the list of products! ", "Error", JOptionPane.ERROR_MESSAGE);
										}	
									}
									line = reader.readLine();
								}
						}
						reader.close();	
					}
				}
				catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Error reading file "+ Orders, "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (DateTimeParseException ex) {
					JOptionPane.showMessageDialog(null, "Wrong date format!", "Error", JOptionPane.ERROR_MESSAGE);
				}
				catch (NullPointerException e) {
					JOptionPane.showMessageDialog(null, "The file "+Orders+" is empty!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}

}
