package Processes;

import Appliances.Appliance;
import Appliances.GamingAppliances.GamingConsole.GamingConsole;
import Appliances.HouseAppliances.Refrigerator.refrigerator;
import Appliances.HouseAppliances.WashingMachine.Washing_Machine;
import Appliances.SoundImageAppliances.Camera.Camera;
import Appliances.SoundImageAppliances.DVDplayer.DVD_player;
import Appliances.SoundImageAppliances.Television.Television;

import javax.swing.*;
import java.io.*;
import java.util.*;

public class StoreAppliances {

	
	public void LoadFile (String Products) {
		BufferedReader reader= null;
		Appliance item = null;
		String line;
		try {
			reader = new BufferedReader(new FileReader(new File(Products)));
			do {
			line = reader.readLine();
			}
			while (line.isEmpty());
			if (line.trim().equalsIgnoreCase("ITEM_LIST")){
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
								String Code=null;
								String Item_Type=null;
								String Model_Name=null;
								int Model_year=0;
								String Manufacturer=null;
								Double Price=0.0;
								String Type=null;
								String Dimension=null;
								String Resolution=null;
								String Interfaces=null;
								int Pieces=0;
								String Format_Playback=null;
								String Megapixel=null;
								String Optical_zoom=null;
								String Digital_zoom=null;
								String Screen_size=null;
								String Processor=null;
								String Graphics=null;
								String Sound=null;
								String Capacity_of_HDD=null;
								String Energy_Class=null;
								String Refrigerator_Capacity=null;
								String Freezer_Capacity=null;
								String Capacity=null;
								String Spins=null;
								if (line.trim().equalsIgnoreCase("ITEM")) {
									do {
									line = reader.readLine();
									}
									while (!line.trim().equals("{"));
											while(!line.trim().equals("}")) {
												line = reader.readLine().trim();
												StringTokenizer st=new StringTokenizer(line," ");
												if (st.hasMoreTokens()) {
													String token=st.nextToken();
													if (token.equalsIgnoreCase("CODE"))
														Code=line.trim().substring(5).trim();
													else if (token.equalsIgnoreCase("ITEM_TYPE")) 
														Item_Type =line.trim().substring(9).trim();
													else if(token.equalsIgnoreCase("MODEL")) 
														Model_Name=line.trim().substring(6).trim();
													else if(token.equalsIgnoreCase("MODEL_YEAR")) 
														Model_year=Integer.parseInt(line.trim().substring(11).trim());
													else if(token.equalsIgnoreCase("MANUFACTURER")) 
														Manufacturer=line.trim().substring(13).trim();
													else if(token.equalsIgnoreCase("PRICE")) 
														Price=Double.parseDouble(line.trim().substring(6).trim());
													else if(token.equalsIgnoreCase("PANEL_TYPE")) 
														Type=line.trim().substring(11).trim();
													else if(token.equalsIgnoreCase("DIMENSIONS")) 
														Dimension=line.trim().substring(11).trim();
													else if(token.equalsIgnoreCase("RESOLUTION")) 
														Resolution=line.trim().substring(11).trim();
													else if(token.equalsIgnoreCase("INTERFACES")) 
														Interfaces=line.trim().substring(11).trim();
													else if(token.equalsIgnoreCase("PIECES")) 
														Pieces=Integer.parseInt(line.trim().substring(7).trim());
													else if(token.equalsIgnoreCase("TYPE"))
														Type=line.trim().substring(4).trim();
													else if(token.equalsIgnoreCase("FORMAT_PLAYBACK"))
														Format_Playback=line.trim().substring(15).trim();
													else if(token.equalsIgnoreCase("MEGAPIXEL"))
														Megapixel=line.trim().substring(10).trim();
													else if(token.equalsIgnoreCase("OPTICAL_ZOOM"))
														Optical_zoom=line.trim().substring(13).trim();
													else if(token.equalsIgnoreCase("DIGITAL_ZOOM"))
														Digital_zoom=line.trim().substring(12).trim();
													else if(token.equalsIgnoreCase("SCREEN_SIZE"))
														Screen_size=line.trim().substring(11).trim();
													else if(token.equalsIgnoreCase("PROCESSOR"))
														Processor=line.trim().substring(10).trim();
													else if(token.equalsIgnoreCase("GRAPHICS"))
														Graphics=line.trim().substring(9).trim();
													else if(token.equalsIgnoreCase("SOUND"))
														Sound=line.trim().substring(6).trim();
													else if(token.equalsIgnoreCase("CAPACITY_OF_HDD"))
														Capacity_of_HDD=line.trim().substring(16).trim();
													else if(token.equalsIgnoreCase("ENERGY_CLASS"))
														Energy_Class=line.trim().substring(13).trim();
													else if(token.equalsIgnoreCase("REFRIGERATOR_CAPACITY"))
														Refrigerator_Capacity=line.trim().substring(22).trim();
													else if(token.equalsIgnoreCase("FREEZER_CAPACITY"))
														Freezer_Capacity=line.trim().substring(17).trim();
													else if(token.equalsIgnoreCase("CAPACITY"))
														Capacity=line.trim().substring(9).trim();
													else if(token.equalsIgnoreCase("SPINS"))
														Spins=line.trim().substring(6).trim();
														
												}
											}
											if (Code!=null && Item_Type!=null && Model_Name!=null) {
												if (Item_Type.equalsIgnoreCase("tv")) {
													item = new Television(Code,Model_Name,Model_year,Manufacturer,Price,Pieces,Type,Dimension,Resolution,Interfaces);
												}
												else if (Item_Type.equalsIgnoreCase("DVD player")) {
													item = new DVD_player(Code,Model_Name,Model_year,Manufacturer,Price,Pieces,Type,Resolution,Format_Playback);
												}
												else if (Item_Type.equalsIgnoreCase("Camera")) {
													item = new Camera(Code,Model_Name,Model_year,Manufacturer,Price,Pieces,Type,Megapixel,Optical_zoom,Digital_zoom,Screen_size);
												}
												else if (Item_Type.equalsIgnoreCase("Console")) {
													item = new GamingConsole(Code,Model_Name,Model_year,Manufacturer,Price,Pieces,Type,Processor,Graphics,Sound,Capacity_of_HDD);
												}
												else if (Item_Type.equalsIgnoreCase("Refrigerator")) {
													item = new refrigerator(Code,Model_Name,Model_year,Manufacturer,Price,Pieces,Energy_Class,Type,Refrigerator_Capacity,Freezer_Capacity);
												}
												else if (Item_Type.equalsIgnoreCase("Washing Machine")) {
													item = new Washing_Machine(Code,Model_Name,Model_year,Manufacturer,Price,Pieces,Energy_Class,Capacity,Spins);
												}
											}
											else {
												JOptionPane.showMessageDialog(null, "The CODE, ITEM_TYPE and MODEL fields must be filled in to complete the product registration! ", "Error", JOptionPane.ERROR_MESSAGE);
											}	
									}
									line = reader.readLine();
								}
						
						reader.close();	
				}
			}
			}
			catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Error reading file "+ Products, "Error", JOptionPane.ERROR_MESSAGE);
			}
			catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "The file "+Products+" is empty!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
}
