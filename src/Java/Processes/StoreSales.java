package Processes;

import Appliances.Appliance;
import Processes.Sale;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.*;

public class StoreSales {
	public void LoadFile (String Sales) {
		BufferedReader reader= null;
		Sale item = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy").withLocale(Locale.ENGLISH);
		String line;
		try{
			reader = new BufferedReader(new FileReader(new File(Sales)));
			do {
			line = reader.readLine();
			}
			while (line.isEmpty());
				if (line.trim().equalsIgnoreCase("SALES_LIST")) {
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
								int Sale_Number=0;
								String Customer_Phone=null;
								String Customer_Name=null;
								LocalDate Sale_Date=null;
								int Pieces=0;
								if (line.trim().equals("SALE")) {
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
													else if(token.equalsIgnoreCase("SALES_NUMBER")) 
														Sale_Number=Integer.parseInt(line.trim().substring(13).trim());
													else if(token.equalsIgnoreCase("NAME")) 
														Customer_Name=line.trim().substring(5).trim();
													else if(token.equalsIgnoreCase("PHONE"))
														Customer_Phone=line.trim().substring(6).trim();
													else if(token.equalsIgnoreCase("DATE")) 
														Sale_Date=LocalDate.parse(line.trim().substring(5).trim(),formatter);
													else if(token.equalsIgnoreCase("PIECES")) 
														Pieces=Integer.parseInt(line.trim().substring(7).trim());
												}
											}
											for (Appliance a : Appliance.getAppliances().values()) {
												if (a.getModel_name().equals(Model_Name)) {
														item = new Sale(a,Sale_Number,Customer_Name,Sale_Date,Customer_Phone,Price,Pieces);
														x=true;
												}
											}
											if (x==false) {
												JOptionPane.showMessageDialog(null, "The "+ Model_Name +" product of the manufacturer "+ Manufacturer +" can not be added to the list of sales, because it is not in the list of products! ", "Error", JOptionPane.ERROR_MESSAGE);
											}	
										}
										line = reader.readLine();
									}
							}
							reader.close();	
						}
					}
					catch (IOException e) {
						JOptionPane.showMessageDialog(null, "Error reading file "+ Sales, "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (DateTimeParseException ex) {
						JOptionPane.showMessageDialog(null, "Wrong date format!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					catch (NullPointerException e) {
						JOptionPane.showMessageDialog(null, "The file "+Sales+" is empty!", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
}
