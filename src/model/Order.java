package model;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private List<MenuItem> items;
	private static final double TAX_RATE = 0.07;
	
	public Order() {
		items = new ArrayList<>();
	}
	
	public void addItem(MenuItem item){
		items.add(item);
	}
	  public String calculateTotal() {
	        double subtotal = items.stream().mapToDouble(MenuItem::getPrice).sum();
	        double total = subtotal + (subtotal * TAX_RATE);
	        return "Subtotal: $" + String.format("%.2f", subtotal) 
	               + "\nTotal (with tax): $" + String.format("%.2f", total);
	    }
	//Additional methods if needed
	public void clearOrder() {
		items.clear();
	}
	public void removeItem(MenuItem item) {
		items.remove(item);
	}
	public List<MenuItem> getItems(){
		return items;
	}
}
