package application;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Scanner;

import entities.Order;
import entities.OrderItem;
import entities.Product;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Client Data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.next();
		
		System.out.print("Brith Date: ");
		String birthDate = sc.next();
		
		System.out.println("\nEnter Order Data: ");
		System.out.print("Status: ");
		String status = sc.next();
		
		
		
		Order order = new Order(LocalDateTime.now(), status);
		order.setClient(name, email, birthDate);
		
		
		
		System.out.print("\nHow many items will be Ordered: ");
		int quantityToOrder = sc.nextInt();
		
		for(int i = 1; i <= quantityToOrder; i++) {
			System.out.println("\nEnter #"+ i + " Item data:");
			System.out.print("Product Name: ");
			String productName = sc.next();
			
			System.out.print("Product Price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			Product product = new Product(productName, productPrice);
			OrderItem item = new OrderItem(quantity, productPrice, product);
			order.addItem(item);
		}
		
		System.out.println(order.ToString());
		
		
		sc.close();
	}

}
