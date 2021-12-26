package Processes;

import Appliances.*;
import Appliances.GamingAppliances.GamingConsole.GamingConsole;
import Appliances.HouseAppliances.Refrigerator.refrigerator;
import Appliances.HouseAppliances.WashingMachine.Washing_Machine;
import Appliances.SoundImageAppliances.Camera.Camera;
import Appliances.SoundImageAppliances.DVDplayer.DVD_player;
import Appliances.SoundImageAppliances.Television.Television;


import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Update {

DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy").withLocale(Locale.ENGLISH);	
	
	public void UpdateProducts(String Products) {
		FileWriter writer=null;
		try {
			writer = new FileWriter(new File(Products));
			writer.write("ITEM_LIST\n{");
			for (Appliance a: Appliance.getAppliances().values()) {
				if (a instanceof Television) {
					writer.write("\n\tITEM"+"\n\t{"+"\n\t\tCODE "+a.getCode()+"\n\t\tITEM_TYPE "+a.getName()+"\n\t\tMODEL "+a.getModel_name()+" \n\t\tMODEL_YEAR "+a.getModel_year()+
					"\n\t\tMANUFACTURER "+a.getManufacturer()+"\n\t\tPRICE "+a.getPrice()+"\n\t\tPANEL_TYPE "+((Television)a).getType()+"\n\t\tDIMENSIONS "+((Television)a).getScreen_size()+ 
					"\n\t\tPIECES "+a.getStock()+"\n\t\tRESOLUTION "+((Television)a).getResolution()+"\n\t\tINTERFACES "+((Television)a).getPorts()+"\n\t}");
				}
				else if (a instanceof DVD_player) {
					writer.write("\n\tITEM"+"\n\t{"+"\n\t\tCODE "+a.getCode()+"\n\t\tITEM_TYPE "+a.getName()+"\n\t\tMODEL "+a.getModel_name()+" \n\t\tMODEL_YEAR "+a.getModel_year()+
					"\n\t\tMANUFACTURER "+a.getManufacturer()+"\n\t\tPRICE "+a.getPrice()+"\n\t\tTYPE "+((DVD_player)a).getType()+ "\n\t\tPIECES "+a.getStock()+
					"\n\t\tRESOLUTION "+((DVD_player)a).getResolution()+"\n\t\tFORMAT_PLAYBACK "+((DVD_player)a).getFormat_playback()+"\n\t}");
				}
				else if (a instanceof Camera) {
					writer.write("\n\tITEM"+"\n\t{"+"\n\t\tCODE "+a.getCode()+"\n\t\tITEM_TYPE "+a.getName()+"\n\t\tMODEL "+a.getModel_name()+" \n\t\tMODEL_YEAR "+a.getModel_year()+
					"\n\t\tMANUFACTURER "+a.getManufacturer()+"\n\t\tPRICE "+a.getPrice()+"\n\t\tTYPE "+((Camera)a).getType()+ "\n\t\tPIECES "+a.getStock()+
					"\n\t\tMEGAPIXEL "+((Camera)a).getMegapixel()+"\n\t\tOPTICAL_ZOOM "+((Camera)a).getOptical_zoom()+"\n\t\tDIGITAL_ZOOM "+((Camera)a).getDigital_zoom()+
					"\n\t\tSCREEN_SIZE "+((Camera)a).getScreen_size()+"\n\t}");
				}
				else if (a instanceof GamingConsole) {
					writer.write("\n\tITEM"+"\n\t{"+"\n\t\tCODE "+a.getCode()+"\n\t\tITEM_TYPE "+a.getName()+"\n\t\tMODEL "+a.getModel_name()+" \n\t\tMODEL_YEAR "+a.getModel_year()+
					"\n\t\tMANUFACTURER "+a.getManufacturer()+"\n\t\tPRICE "+a.getPrice()+"\n\t\tTYPE "+((GamingConsole)a).getType()+ "\n\t\tPIECES "+a.getStock()+
					"\n\t\tPROCESSOR "+((GamingConsole)a).getProcessor()+"\n\t\tGRAPHICS "+((GamingConsole)a).getGraphics()+"\n\t\tSOUND "+((GamingConsole)a).getSound()+
					"\n\t\tCAPACITY_OF_HDD "+((GamingConsole)a).getCapacity_of_HDD()+"\n\t}");
				}
				else if (a instanceof refrigerator) {
					writer.write("\n\tITEM"+"\n\t{"+"\n\t\tCODE "+a.getCode()+"\n\t\tITEM_TYPE "+a.getName()+"\n\t\tMODEL "+a.getModel_name()+" \n\t\tMODEL_YEAR "+a.getModel_year()+
					"\n\t\tMANUFACTURER "+a.getManufacturer()+"\n\t\tPRICE "+a.getPrice()+"\n\t\tTYPE "+((refrigerator)a).getType()+ "\n\t\tPIECES "+a.getStock()+
					"\n\t\tENERGY_CLASS "+((refrigerator)a).getEnergy_class()+"\n\t\tREFRIGERATOR_CAPACITY "+((refrigerator)a).getRefrigerator_capacity()+
					"\n\t\tFREEZER_CAPACITY "+((refrigerator)a).getFreezer_capacity()+"\n\t}");
				}
				else if (a instanceof Washing_Machine) {
					writer.write("\n\tITEM"+"\n\t{"+"\n\t\tCODE "+a.getCode()+"\n\t\tITEM_TYPE "+a.getName()+"\n\t\tMODEL "+a.getModel_name()+" \n\t\tMODEL_YEAR "+a.getModel_year()+
					"\n\t\tMANUFACTURER "+a.getManufacturer()+"\n\t\tPRICE "+a.getPrice()+"\n\t\tPIECES "+a.getStock()+"\n\t\tENERGY_CLASS "+((Washing_Machine)a).getEnergy_class()+
					"\n\t\tCAPACITY "+((Washing_Machine)a).getCapacity()+"\n\t\tSPINS "+((Washing_Machine)a).getSpins()+"\n\t}");
				}
			}
			writer.write("\n}");
			writer.close();
			}
			catch (IOException e) {
				System.out.println	("Error reading file "+ Products);
			}
	}
			
	public void UpdateOrders(String Orders){
		FileWriter writer=null;
		try {
			writer = new FileWriter(new File(Orders));
			writer.write("ORDER_LIST\n{");
			for (Order o: Order.getOrders().values()) {
				writer.write("\n\tORDER"+"\n\t{"+"\n\t\tITEM_TYPE "+o.getModel().getName()+"\n\t\tMODEL "+o.getModel().getModel_name()+"\n\t\tMANUFACTURER "+o.getModel().getManufacturer()+
				"\n\t\tORDER_NUMBER "+o.getOrder_code()+"\n\t\tNAME "+o.getCustomer_name()+"\n\t\tPHONE "+o.getCustomer_phone()+"\n\t\tORDER_DATE "+o.getOrder_date().format(formatter)+
				"\n\t\tDELIVERY_DATE "+o.getArrival_date().format(formatter)+"\n\t\tPRICE "+o.getOrder_cost()+"\n\t\tPIECES "+o.getOrder_pieces()+"\n\t\tSTATUS "+o.getOrder_status()+"\n\t}");
			}
			writer.write("\n}");
			writer.close();
		}
		catch (IOException e) {
			System.out.println	("Error reading file "+ Orders);
		}
	}
		
	public void UpdateSales(String Sales){
		FileWriter writer=null;
		try {
			writer = new FileWriter(new File(Sales));
			writer.write("SALES_LIST\n{");
			for (Sale s: Sale.getSales().values()) {
				writer.write("\n\tSALE"+"\n\t{"+"\n\t\tITEM_TYPE "+s.getModel().getName()+"\n\t\tMODEL "+s.getModel().getModel_name()+"\n\t\tMANUFACTURER "+s.getModel().getManufacturer()+
				"\n\t\tSALES_NUMBER "+s.getSale_code()+"\n\t\tNAME "+s.getCustomer_name()+"\n\t\tPHONE "+s.getCustomer_phone()+"\n\t\tDATE "+s.getSale_date().format(formatter)+
				"\n\t\tPRICE "+s.getSale_cost()+"\n\t\tPIECES "+s.getSale_pieces()+"\n\t}");
			}
			writer.write("\n}");
			writer.close();
		}
		catch (IOException e) {
			System.out.println	("Error reading file "+ Sales);
		}
	}
}
