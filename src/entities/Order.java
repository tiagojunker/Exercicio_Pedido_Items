package entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	protected DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
	
	private LocalDateTime moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();
	private Client client;
	
	public Order() {
	}

	public Order(LocalDateTime moment, String status) {
		this.moment = moment;
		this.status = OrderStatus.valueOf(status);
	}

	public String getMoment() {
		return moment.format(formatter);
	}

	public void setMoment(String moment) {
		this.moment = LocalDateTime.parse(moment, formatter);
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = OrderStatus.valueOf(status);
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public void setClient(String name, String email, String birthDate) {
		client = new Client(name, email, birthDate);
	}
	
	public double total() {
		
		double sum = 0.00;
		
		for(OrderItem item: items) {
			sum += item.subTotal();
		}
		
		return sum;
		
	}
	
	public String ToString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("\nORDER SUMMARY: \n");
		sb.append("ORDER STATUS: " + status + "\n");
		sb.append("Client: " + client.getName());
		sb.append("(" + client.getBirthDate() + ") - ");
		sb.append(client.getEmail() + "\n");
		sb.append("Order Items: \n");
		
		for(OrderItem item: items) {
			sb.append(item.getProductName() + ", $");
			sb.append(item.getPrice() + ", Quantity: ");
			sb.append(item.getQuantity() + ", Subtotal: $" + item.subTotal() + "\n");
		}
		
		sb.append("Total Price: $" + total());
		
		return sb.toString();
		
	}

	
}
