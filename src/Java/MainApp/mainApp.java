package MainApp;
import Appliances.Appliance;
import Processes.*;

import java.util.Scanner;
public class mainApp {

	public static void main(String[] args) {
				StoreAppliances app = new StoreAppliances();
				app.LoadFile("src/Text-Files/Products.txt");
				StoreOrders Ord = new StoreOrders();
				Ord.LoadFile("src/Text-Files/Orders.txt");
				StoreSales Sal = new StoreSales();
				Sal.LoadFile("src/Text-Files/Sales.txt");
				Update ch= new Update();
				Scanner scanner= new Scanner(System.in);
				int x=1;
				while (x!=0) {	
					System.out.println("-----------------------------------------------------------");
					System.out.println("0.Stop Application");
					System.out.println("1.Overview of all available appliances");
					System.out.println("2.Overview of all orders");
					System.out.println("3.Overview of all sales");
					System.out.print("   Enter number [0-3] :  ");
					x= scanner.nextInt();

					switch(x) {
					case 0 :
						ch.UpdateProducts("src/Text-Files/Products.txt");
						ch.UpdateOrders("src/Text-Files/Orders.txt");
						ch.UpdateSales("src/Text-Files/Sales.txt");
						break;
					case 1:
						Appliance.Overview_Appliances();
						break;
					case 2:
						Order.Overview_Orders();
						break;
					case 3:
						Sale.Overview_Sales();
						break;

					default:
						System.out.println("-----------------------------------------------------------");
						System.out.println("Wrong input!");

				}
			}
		}
}

