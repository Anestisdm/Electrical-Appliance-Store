package Appliances;

import Processes.Order;
import Processes.Sale;

import javax.swing.*;
import java.awt.*;
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
    static ImageIcon icon = new ImageIcon("src/images/shop.png");
    static Image image = icon.getImage().getScaledInstance(40,40,0);

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

    public static boolean Print_Appliances(String Device, String Title) {
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
            String input = JOptionPane.showInputDialog(null, Output + "Enter number: ",Title, JOptionPane.QUESTION_MESSAGE);
            if (input == null) {
                break;
            }
            else if  (Selected_Appliances.get(input) != null) {
                if (Selected_Appliances.get(input).stock > 0) {
                    boolean x = false;
                    do {
                        int input2 = JOptionPane.showConfirmDialog(null, Selected_Appliances.get(input).toString() + "\n\nThis model has stock in our store. Do you want to make a purchase? ","Purchase", JOptionPane.INFORMATION_MESSAGE);
                        if (input2 == 0) {
                            JTextField pieces = new JTextField();
                            JTextField name = new JTextField();
                            JTextField tel = new JTextField();
                            Object[] message = {
                                    "Pieces:", pieces,
                                    "Name:", name,
                                    "Telephone:", tel
                            };
                            int option = JOptionPane.showConfirmDialog(null, message, "Purchase", JOptionPane.OK_CANCEL_OPTION);
                            if (option == JOptionPane.OK_OPTION) {
                                if (Integer.parseInt(pieces.getText()) <= Selected_Appliances.get(input).stock ) {
                                    double sale_cost = (Selected_Appliances.get(input).getDiscountPrice()) * Integer.parseInt(pieces.getText());
                                    Sale s1 = new Sale(Selected_Appliances.get(input), name.getText(), LocalDate.now(), tel.getText(), sale_cost, Integer.parseInt(pieces.getText()));
                                    Selected_Appliances.get(input).stock -= Integer.parseInt(pieces.getText());
                                    JOptionPane.showMessageDialog(null,"Purchase completed successfully!\n\n"+s1.toString());
                                    x = true;
                                    r = x;
                                } else {
                                    JOptionPane.showMessageDialog(null,"There is not enough stock in our store to satisfy your purchase!","Error",JOptionPane.WARNING_MESSAGE);
                                    break;
                                }
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
                            int input2 = JOptionPane.showConfirmDialog(null, Selected_Appliances.get(input).toString() + "\n\nThere is no stock for this model in our store. Do you want to place an order? ","Order", JOptionPane.INFORMATION_MESSAGE);
                            if (input2 == 0) {
                                Scanner in = new Scanner(System.in);
                                System.out.print("Please enter the number of pieces where you want to order: (press 0 to exit)");
                                int pieces = scanner.nextInt();
                                if (pieces == 0) {
                                    break;
                                }
                                System.out.print("Please enter your name: [(eg Vassilis Papadopoulos) or press 0 to exit] ");
                                String name = in.nextLine();
                                if (name.equals("0")) {
                                    break;
                                }
                                System.out.print("Please enter your phone number: [(eg 6947452542) or press 0 to exit] ");
                                String tel = in.nextLine();
                                if (tel.equals("0")) {
                                    break;
                                }
                                System.out.print("Please enter the expected arrival date: [(eg 2020-05-11) or press 0 to exit] ");
                                LocalDate arrival_date = LocalDate.parse(in.nextLine(), formatter);
                                if (arrival_date.equals("0")) {
                                    break;
                                }
                                double order_cost = (Selected_Appliances.get(input).getDiscountPrice()) * pieces;
                                Order o1 = new Order(Selected_Appliances.get(input), name, tel, LocalDate.now(), arrival_date, order_cost, pieces, "EXPECTED");
                                System.out.println("The order was completed successfully!");
                                System.out.println("-----------------------------------------------------------");
                                System.out.println(o1);
                                x = true;
                                r = x;
                            } else if (input2 == 1) {
                                x = true;
                            } else {
                                break;
                            }
                        }
                        while (x == false);
                    } catch (DateTimeParseException ex) {
                        System.out.println("Wrong date format! Try again!");
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
                    "Appliances", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image), options,null);
            if (input==null) {
                break;
            }
            else if (input == "Sound & Video Devices") {
                x = true;
                y = false;
                do {
                    String[] options2 = {"Televisions", "Blue ray / DVD players", "Cameras"};
                    String input2 = (String) JOptionPane.showInputDialog(null, "Select category:",
                            "Sound & Video Devices", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image), options2,null);

                    if (input2 == null) {
                        x = false;
                        y = true;
                        break;
                    }
                    else if (input2 == "Televisions") {
                        y = Print_Appliances("tv", "Televisions");
                    }
                    else if (input2 == "Blue ray / DVD players") {
                        y = Print_Appliances("DVD player", "Blue ray / DVD players");
                    }
                    else if (input2 == "Cameras") {
                        y = Print_Appliances("Camera", "Cameras");
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
                            "Gaming Devices", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image), options2,null);
                    if (input2 == null) {
                        x = false;
                        y = true;
                        break;
                    }
                    else if (input2 == "Consoles / portable consoles") {
                        y = Print_Appliances("Console", "Consoles / portable consoles");
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
                            "Home Appliances", JOptionPane.QUESTION_MESSAGE,new ImageIcon(image), options2,null);
                    if (input2 == null) {
                        x = false;
                        y = true;
                        break;
                    }
                    else if (input2 == "Refrigerators") {
                        y = Print_Appliances("refrigerator", "Refrigerators");
                    }
                    else if (input2 == "Washing Machines") {
                        y = Print_Appliances("Washing Machine", "Washing Machines");
                    }
                }
                while (y == false);
            }
        }
        while (x == false);
    }


}



