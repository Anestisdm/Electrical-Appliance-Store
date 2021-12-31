package MainApp;
import Appliances.Appliance;
import Processes.*;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class mainApp {

	public static void main(String[] args) {

		StoreAppliances app = new StoreAppliances();
		app.LoadFile("src/Text-Files/Products.txt");
		StoreOrders Ord = new StoreOrders();
		Ord.LoadFile("src/Text-Files/Orders.txt");
		StoreSales Sal = new StoreSales();
		Sal.LoadFile("src/Text-Files/Sales.txt");
		Update ch = new Update();
		Scanner scanner = new Scanner(System.in);
		int x = 1;
		while (x != JOptionPane.CLOSED_OPTION) {
			ImageIcon icon = new ImageIcon("src/images/shop.png");
			Image image = icon.getImage().getScaledInstance(40,40,0);
			JLabel title = new JLabel();
			title.setText("Select an option:"); title.setFont(new Font("Calibri", Font.BOLD, 18));
			Object[] options1 = {"Appliances", "Orders", "Sales"};
			x = JOptionPane.showOptionDialog(null, title, "Menu",
					JOptionPane.INFORMATION_MESSAGE, JOptionPane.PLAIN_MESSAGE, new ImageIcon(image),
					options1, null);

			switch (x) {
				case 0:
					Appliance.Overview_Appliances();
					break;
				case 1:
					Order.Overview_Orders();
					break;
				case 2:
					Sale.Overview_Sales();
					break;
				case -1:
					int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?","Exit",JOptionPane.WARNING_MESSAGE);
					 if (a == JOptionPane.CLOSED_OPTION || a == JOptionPane.CANCEL_OPTION) {
						 x=3;
						continue;
					}
				default:
					ch.UpdateProducts("src/Text-Files/Products.txt");
					ch.UpdateOrders("src/Text-Files/Orders.txt");
					ch.UpdateSales("src/Text-Files/Sales.txt");
			}
		}
	}
}

