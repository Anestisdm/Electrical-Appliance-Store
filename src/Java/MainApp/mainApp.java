package MainApp;
import Appliances.Appliance;
import Processes.*;

import java.util.Scanner;
public class mainApp {

	public static void main(String[] args) {
				StoreAppliances app = new StoreAppliances();
				app.LoadFile("Products.txt");
				StoreOrders Ord = new StoreOrders();
				Ord.LoadFile("Orders.txt");
				StoreSales Sal = new StoreSales();
				Sal.LoadFile("Sales.txt");
				Update ch= new Update();
				Scanner scanner= new Scanner(System.in);
				int x=1;
				while (x!=0) {	
					System.out.println("-----------------------------------------------------------");
					System.out.println("0.����������� ���������");
					System.out.println("1.���������� ���� ��� ���������� ��������");
					System.out.println("2.���������� ���� ��� �����������");
					System.out.println("3.���������� ���� ��� ��������");
					System.out.print("   �������� ������� [0-3] : ");
					x= scanner.nextInt();

					switch(x) {
					case 0 :
						ch.UpdateProducts("Products.txt");
						ch.UpdateOrders("Orders.txt");
						ch.UpdateSales("Sales.txt");
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
						System.out.println("����� ��������");

				}
			}
		}
}

