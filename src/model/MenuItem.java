package model;

public class MenuItem {
	
	private String name;
	private double price;
	private String category;
	
	public MenuItem(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}
	//setters and getters
	public String getCatagory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	  // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return this.price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }
    
}
