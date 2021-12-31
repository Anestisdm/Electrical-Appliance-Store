package Appliances;

import Processes.Order;
import Processes.Sale;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.lang.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public abstract class Appliance {

    private static int count = 0;
    private final String code;
    private final String model_name;
    private final int model_year;
    private final String manufacturer;
    private double price;
    private int stock;
    static ImageIcon shop = new ImageIcon("src/images/shop.png");
    static Image image1 = shop.getImage().getScaledInstance(40,40,0);
    static ImageIcon video = new ImageIcon("src/images/smart-devices.png");
    static Image image2 = video.getImage().getScaledInstance(40,40,0);
    static ImageIcon gaming = new ImageIcon("src/images/game-console.png");
    static Image image3 = gaming.getImage().getScaledInstance(40,40,0);
    static ImageIcon appliance = new ImageIcon("src/images/electric-appliance.png");
    static Image image4 = appliance.getImage().getScaledInstance(40,40,0);
    static ImageIcon television = new ImageIcon("src/images/watch-tv.png");
    static Image image5 = television.getImage().getScaledInstance(40,40,0);
    static ImageIcon DVD = new ImageIcon("src/images/dvd-player.png");
    static Image image6 = DVD.getImage().getScaledInstance(40,40,0);
    static ImageIcon camera = new ImageIcon("src/images/camera.png");
    static Image image7 = camera.getImage().getScaledInstance(40,40,0);
    static ImageIcon refrigerator = new ImageIcon("src/images/smart-refrigerator.png");
    static Image image8 = refrigerator.getImage().getScaledInstance(40,40,0);
    static ImageIcon washing_machine = new ImageIcon("src/images/washing-machine.png");
    static Image image9 = washing_machine.getImage().getScaledInstance(40,40,0);


    private static HashMap<Integer, Appliance> Appliances = new HashMap<Integer, Appliance>();
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public Appliance(String code, String model_name, int model_year, String manufacturer, double price, int stock) {
        count++;
        Appliances.put(count, this);
        this.code = code;
        this.model_name = model_name;
        this.model_year = model_year;
        this.manufacturer = manufacturer;
        this.price = price;
        this.stock = stock;
    }

    public abstract double getDiscount();

    public abstract String getName();

    public String getModel_name() {
        return model_name;
    }

    public String getCode() {
        return code;
    }

    public int getStock() {
        return stock;
    }

    public double getPrice() {
        return price;
    }

    public int getModel_year() {
        return model_year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public double getDiscountPrice() {
        double discount_price = Math.round((this.price - (this.price * this.getDiscount())) * 100.0 / 100.0);
        return discount_price;
    }


    public static HashMap<Integer, Appliance> getAppliances() {
        return Appliances;
    }


    @Override
    public String toString() {
        return "\nProduct Code = " + code + " \nModel Name = " + model_name + " \nOriginal Price = " + price + " € " + " \nDiscount = " + Math.round(getDiscount() * 100) + "% " + "\nFinal Price =" + getDiscountPrice() + "€" + "\nStock =" + stock + "items" + "\nModel Year =" + model_year + "\nManufacturer ="
                + manufacturer;
    }

    public static boolean Print_Appliances(String Device, String Title, Image Icon) {
        boolean y = false;
        boolean r = false;
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Appliance> Selected_Appliances = new HashMap<String, Appliance>();
        while (y == false) {
            int c = 0;
            String Output = "";

            for (int i = 0; i <= Appliances.size(); i++) {
                if (Appliances.get(i) != null) {
                    if (Appliances.get(i).getName().equalsIgnoreCase(Device)) {
                        c++;
                        Selected_Appliances.put(String.valueOf(c), Appliances.get(i));
                        Output += c + ". "+Appliances.get(i).getModel_name()+ "\n";
                    }
                }
            }
            String input = (String) JOptionPane.showInputDialog(null, Output + "Enter number: ",Title,JOptionPane.QUESTION_MESSAGE,new ImageIcon(Icon),null,null);
            if (input == null) {
                break;
            }
            else if  (Selected_Appliances.get(input) != null) {
                if (Selected_Appliances.get(input).stock > 0) {
                    boolean x = false;
                    do {
                        int input2 = JOptionPane.showConfirmDialog(null, Selected_Appliances.get(input).toString() + "\n\nThis model has stock in our store. Do you want to make a purchase? ","Purchase", JOptionPane.INFORMATION_MESSAGE);
                        if (input2 == 0) {
                            JTextField  pieces = new JTextField ();
                            JTextField name = new JTextField();
                            JTextField tel = new JTextField();
                            Object[] message = {
                                    "Pieces:", pieces,
                                    "Name (eg Vassilios Papadopoulos):", name,
                                    "Telephone (eg 6947452542):", tel
                            };
                            try {
                                int option = JOptionPane.showConfirmDialog(null, message, "Purchase", JOptionPane.OK_CANCEL_OPTION);
                                if (option == JOptionPane.OK_OPTION) {
                                    if (Integer.parseInt(pieces.getText()) <= Selected_Appliances.get(input).stock) {
                                        double sale_cost = (Selected_Appliances.get(input).getDiscountPrice()) * Integer.parseInt(pieces.getText());
                                        Sale s1 = new Sale(Selected_Appliances.get(input), name.getText(), LocalDate.now(), tel.getText(), sale_cost, Integer.parseInt(pieces.getText()));
                                        Selected_Appliances.get(input).stock -= Integer.parseInt(pieces.getText());
                                        JOptionPane.showMessageDialog(null, "Purchase completed successfully!\n\n" + s1.toString());
                                        x = true;
                                        r = x;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "There is not enough stock in our store to satisfy your purchase!", "Error", JOptionPane.WARNING_MESSAGE);
                                        break;
                                    }
                                }
                            }
                            catch (NumberFormatException ex2){
                                JOptionPane.showMessageDialog(null, "Wrong number format! Try again!","Error",JOptionPane.WARNING_MESSAGE);

                            }
                        } else if (input2 == 1) {
                            x = true;
                        } else {
                            break;
                        }
                    }
                    while (x == false);
                } else {
                    try {
                        boolean x = false;
                        do {
                            int input2 = JOptionPane.showConfirmDialog(null, Selected_Appliances.get(input).toString() + "\n\nThere is no stock for this model in our store. Do you want to place an order? ", "Order", JOptionPane.INFORMATION_MESSAGE);
                            if (input2 == 0) {
                                JTextField pieces = new JTextField();
                                JTextField name = new JTextField();
                                JTextField tel = new JTextField();
                                JTextField arrival_date = new JTextField();
                                Object[] message = {
                                        "Pieces:", pieces,
                                        "Name (eg Vassilios Papadopoulos):", name,
                                        "Telephone (eg 6947452542):", tel,
                                        "Arrival Date (eg 2020-05-11):", arrival_date
                                };
                                try {
                                    int option = JOptionPane.showConfirmDialog(null, message, "Order", JOptionPane.OK_CANCEL_OPTION);
                                    if (option == JOptionPane.OK_OPTION) {
                                        double order_cost = (Selected_Appliances.get(input).getDiscountPrice()) * Integer.parseInt(pieces.getText());
                                        Order o1 = new Order(Selected_Appliances.get(input), name.getText(), tel.getText(), LocalDate.now(), LocalDate.parse(arrival_date.getText(), formatter), order_cost, Integer.parseInt(pieces.getText()), "EXPECTED");
                                        JOptionPane.showMessageDialog(null, "The order was completed successfully!\n\n" + o1.toString());
                                        x = true;
                                        r = x;
                                    }
                                }
                                    catch (NumberFormatException ex2){
                                        JOptionPane.showMessageDialog(null, "Wrong number format! Try again!","Error",JOptionPane.WARNING_MESSAGE);

                                    }
                            }else if (input2 == 1) {
                                x = true;
                            } else {
                                break;
                            }
                        } while (x == false) ;
                    }catch (DateTimeParseException ex) {
                        JOptionPane.showMessageDialog(null, "Wrong date format! Try again!","Error",JOptionPane.WARNING_MESSAGE);

                    }
                }
                break;
            } else {
                JOptionPane.showMessageDialog(null,"Wrong input! Try again","Error",JOptionPane.WARNING_MESSAGE);
            }
        }
        return r;
    }


    public static void Overview_Appliances() {
        boolean x = false;
        boolean y =false;
        do {String[] options = {"Sound & Video Devices", "Gaming Devices", "Home Appliances"};
            String input = (String) JOptionPane.showInputDialog(null, "Select category:",
                    "Appliances", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image1), options,null);
            if (input==null) {
                break;
            }
            else if (input == "Sound & Video Devices") {
                x = true;
                y = false;
                do {
                    String[] options2 = {"Televisions", "Blue ray / DVD players", "Cameras"};
                    String input2 = (String) JOptionPane.showInputDialog(null, "Select category:",
                            "Sound & Video Devices", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image2), options2,null);

                    if (input2 == null) {
                        x = false;
                        y = true;
                        break;
                    }
                    else if (input2 == "Televisions") {
                        y = Print_Appliances("tv", "Televisions",image5);
                    }
                    else if (input2 == "Blue ray / DVD players") {
                        y = Print_Appliances("DVD player", "Blue ray / DVD players",image6);
                    }
                    else if (input2 == "Cameras") {
                        y = Print_Appliances("Camera", "Cameras",image7);
                    }
                }
                while (y == false);
            }
                else if (input == "Gaming Devices") {
                x = true;
                y = false;
                do {
                    String[] options2 = {"Consoles / portable consoles"};
                    String input2 = (String) JOptionPane.showInputDialog(null, "Select category:",
                            "Gaming Devices", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image3), options2,null);
                    if (input2 == null) {
                        x = false;
                        y = true;
                        break;
                    }
                    else if (input2 == "Consoles / portable consoles") {
                        y = Print_Appliances("Console", "Consoles / portable consoles",image3);
                    }
                }
                while (y == false);
            }
            else if (input == "Home Appliances") {
                x = true;
                y = false;
                do {
                    String[] options2 = {"Refrigerators", "Washing Machines"};
                    String input2 = (String) JOptionPane.showInputDialog(null, "Select category:",
                            "Home Appliances", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image4), options2,null);
                    if (input2 == null) {
                        x = false;
                        y = true;
                        break;
                    }
                    else if (input2 == "Refrigerators") {
                        y = Print_Appliances("refrigerator", "Refrigerators",image8);
                    }
                    else if (input2 == "Washing Machines") {
                        y = Print_Appliances("Washing Machine", "Washing Machines",image9);
                    }
                }
                while (y == false);
            }
        }
        while (x == false);
    }


}



