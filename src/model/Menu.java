package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
	
	private List<MenuItem> items;
	
	public Menu(){
		
		items = new ArrayList<>();
		// Initialize with default items
		items.add(new MenuItem("Egg Sandwich", 7.99, "Food"));
		items.add(new MenuItem("Bagel", 2.50, "Food"));
		items.add(new MenuItem("Potato salad", 4.49, "Food"));
		items.add(new MenuItem("Chicken Sandwich", 9.99, "Food"));
		items.add(new MenuItem("Coffee", 1.99, "Drink"));
		items.add(new MenuItem("Green Tea", 7.99, "Drink"));
		items.add(new MenuItem("Black Tea", 7.99, "Drink"));
		items.add(new MenuItem("Orange Juice", 7.99, "Drink"));
	}
	public void addItem(MenuItem item) {
		items.add(item);
	}
	
	public void removeItem(MenuItem item) {
		items.remove(item);
	}
	public List<MenuItem> getItems(){
		return items;
	}
	public MenuItem findItemByName(String name) {
		for(MenuItem item : items) {
			if(item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}
	

}
