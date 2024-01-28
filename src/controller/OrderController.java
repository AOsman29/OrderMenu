package controller;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import model.Order;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Menu;
import model.MenuItem;
//controller functionailty needs
//- Handling the event when the user selects an item.
//- Updating the order when the user presses the "Order" button.
//- Clearing the order or finalizing it when the user presses "Cancel" or "Confirm".
public class OrderController {
    // UI elements like CheckBoxes for menu items, TextArea for the bill, etc.
	private Order currentOrder;
	private Menu menu;
	private String lastCalculatedTotal;
	private MenuItem selectedDrink = null;
	private CheckBox foodItem1;  // Repeat for other food items
	private CheckBox foodItem2;
	private CheckBox foodItem3;
	private CheckBox foodItem4;
	private boolean isOrderPlaced = false;
	private TextArea orderSummaryTextArea;
	private List<CheckBox> foodCheckBoxes = new ArrayList<>();
	private ComboBox<String> drinkSelection;
	public CheckBox getFoodItem1() {
		return foodItem1;
	}
	public CheckBox getFoodItem2() {
		return foodItem2;
	}
	public CheckBox getFoodItem3() {
		return foodItem3;
	}
	public CheckBox getFoodItem4() {
		return foodItem4;
	}
	private List<MenuItem> getSelectedItemsFromUI(){
		List<MenuItem> selectedItems = new ArrayList<>();
	    if (foodItem1.isSelected()) {
	        MenuItem item = menu.findItemByName(foodItem1.getText());
	        if (item != null) {
	            selectedItems.add(item);
	        }
	    }
	    // Repeat for other food items
	    return selectedItems;
	    }
    public OrderController() {
        // Simple or no initialization
    	menu = new Menu();
    	currentOrder = new Order();
    	orderSummaryTextArea = new TextArea();
    	//set a defualt slection for food
    	//foodSelection.setPromptText("Select up to 4 Food Items");
    	foodItem1 = new CheckBox("Egg Sandwich");
    	foodItem2 = new CheckBox("Chicken Sandwich");
    	foodItem3 = new CheckBox("Bagel");
    	foodItem4 = new CheckBox("Potato salad");
    	foodCheckBoxes.addAll(Arrays.asList(foodItem1, foodItem2, foodItem3, foodItem4));
    	drinkSelection = new ComboBox<>();
    	//set a default selection or placeholder
        drinkSelection.setPromptText("Select a drink");
    	// Populate the ComboBox with drink options
        drinkSelection.getItems().addAll("Coffee", "Green Tea", "Black Tea", "Orange Juice");
    	
    }

    // Methods to handle UI events
    public void onOrderButtonClick() {
        // Clear the current order
    	 String total = currentOrder.calculateTotal();
    	    lastCalculatedTotal = total;
    	    orderSummaryTextArea.setText("Total: $" + total + "\nConfirm Order?");
    	    isOrderPlaced = true;
    }
	
    private String createOrderSummaryText(List<MenuItem> items) {
        StringBuilder summary = new StringBuilder();
        for (MenuItem item : items) {
            summary.append(item.getName()).append(" - $").append(String.format("%.2f", item.getPrice())).append("\n");
        }
        return summary.toString();
    }
    public void onCancelButtonClick(/* ... */) {
    	// Clear the current order
        currentOrder.clearOrder();
        //reset al UI compentets related to order
        for(CheckBox checkBox : foodCheckBoxes) {
        	checkBox.setSelected(false);
        }
        //reset the drink selection
        drinkSelection.setValue(null);
        //clear the order summary display
        orderSummaryTextArea.clear();
    }

    public void onConfirmButtonClick() {
        if (isOrderPlaced) {
            // Clear the current order and prepare for a new one
            currentOrder.clearOrder();
            resetOrderUI();
            orderSummaryTextArea.setText(lastCalculatedTotal + "\nOrder confirmed!" + "\nThank you!");
            isOrderPlaced = false;
        } else {
            // Display message if order is not placed
            orderSummaryTextArea.setText("Please place your order before confirming.");
        }
    }
    
    private void resetOrderUI() {
    for(CheckBox checkBox : foodCheckBoxes) {
    	checkBox.setSelected(false);
    	}	
    	//reset drink selection and UI componets
    	drinkSelection.setValue(null);
    }
    public ComboBox<String> getDrinkSelection(){
    	return drinkSelection;
    }
    public void setOrderSummaryTextArea(TextArea textArea) {
    	this.orderSummaryTextArea = textArea;
    }
    public void onItemSelect(CheckBox item) {
        MenuItem menuItem = menu.findItemByName(item.getText());
        if (menuItem != null) {
            if (item.isSelected()) {
                orderSummaryTextArea.appendText(menuItem.getName() + " - $" + menuItem.getPrice() + "\n");
                currentOrder.addItem(menuItem); // Add item to the order
            } else {
                String text = orderSummaryTextArea.getText().replace(menuItem.getName() + " - $" + menuItem.getPrice() + "\n", "");
                orderSummaryTextArea.setText(text);
                currentOrder.removeItem(menuItem); // Remove item from the order
            }
        }
    }
    public void onDrinkSelect(RadioButton selectedDrinkButton) {
        // Find the new drink item
        MenuItem newDrinkItem = menu.findItemByName(selectedDrinkButton.getText());
        
        if (newDrinkItem != null) {
            // If a drink was previously selected, remove it from the order
            if (selectedDrink != null) {
                currentOrder.removeItem(selectedDrink);
            }

            // Add the new drink to the order and update the selected drink
            currentOrder.addItem(newDrinkItem);
            selectedDrink = newDrinkItem;

            // Refresh the text area to reflect the current order
            refreshOrderSummaryTextArea();
        }
    }

	private void refreshOrderSummaryTextArea() {
    orderSummaryTextArea.clear();
    for (MenuItem item : currentOrder.getItems()) {
        orderSummaryTextArea.appendText(item.getName() + " - $" + String.format("%.2f", item.getPrice()) + "\n");
    		}
		}
	}

