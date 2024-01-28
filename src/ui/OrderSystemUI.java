package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label; // JavaFX Label
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.awt.Font;

import controller.OrderController;

public class OrderSystemUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        OrderController controller = new OrderController();

        // Create and initialize CheckBoxes for food items
        CheckBox item1 = controller.getFoodItem1();
        CheckBox item2 = controller.getFoodItem2();
        CheckBox item3 = controller.getFoodItem3();
        CheckBox item4 = controller.getFoodItem4();
        
        
        // Create RadioButtons for drinks
        ToggleGroup drinkGroup = new ToggleGroup();
        RadioButton coffeeOption = new RadioButton("Coffee");
        coffeeOption.setToggleGroup(drinkGroup);

        RadioButton greenTeaOption = new RadioButton("Green Tea");
        greenTeaOption.setToggleGroup(drinkGroup);

        RadioButton blackTeaOption = new RadioButton("Black Tea");
        blackTeaOption.setToggleGroup(drinkGroup);

        RadioButton orangeJuiceOption = new RadioButton("Orange Juice");
        orangeJuiceOption.setToggleGroup(drinkGroup);

        // Layout for food items
        Label titleLabel = new Label("Joe's Deli");
        HBox titleBox = new HBox();
        titleBox.setAlignment(Pos.CENTER); // Align the title in the center
        titleBox.getChildren().add(titleLabel);
        Label foodLabel = new Label("Food:");
        VBox foodLayout = new VBox(10);
        foodLayout.getChildren().addAll(foodLabel, item1, item2, item3, item4);

        // Layout for drink items
        Label drinkLabel = new Label("Drink:");
        VBox drinkLayout = new VBox(10);
        drinkLayout.getChildren().addAll(drinkLabel, coffeeOption, greenTeaOption, blackTeaOption, orangeJuiceOption);
        
        // Bill Section (Right)
        VBox billSection = new VBox(10);
        billSection.setPadding(new Insets(10, 10, 10, 10));
        Label billLabel = new Label("Bill");
        TextArea billTextArea = new TextArea();
        billTextArea.setPrefHeight(100);
        billTextArea.setEditable(false);
        billTextArea.setPrefHeight(100);
        controller.setOrderSummaryTextArea(billTextArea);
        billSection.getChildren().addAll(billLabel, billTextArea);
        

        // Initialize other UI components
        Button orderButton = new Button("Order");
        Button cancelButton = new Button("Cancel");
        Button confirmButton = new Button("Confirm");
        TextArea orderSummary = new TextArea();

        // Set event handlers
        orderButton.setOnAction(e -> controller.onOrderButtonClick());
        cancelButton.setOnAction(e -> controller.onCancelButtonClick());
        confirmButton.setOnAction(e -> controller.onConfirmButtonClick());
        

        // ... (Event handlers)
        item1.setOnAction(e -> controller.onItemSelect(item1));
        item2.setOnAction(e -> controller.onItemSelect(item2));
        item3.setOnAction(e -> controller.onItemSelect(item3));
        item4.setOnAction(e -> controller.onItemSelect(item4));
        
        coffeeOption.setOnAction(e -> controller.onDrinkSelect(coffeeOption));
        greenTeaOption.setOnAction(e -> controller.onDrinkSelect(greenTeaOption));
        blackTeaOption.setOnAction(e -> controller.onDrinkSelect(blackTeaOption));
        orangeJuiceOption.setOnAction(e -> controller.onDrinkSelect(orangeJuiceOption));


        // Main layout with two columns: one for food and one for drinks
        HBox mainLayout = new HBox(20);
        mainLayout.getChildren().addAll(foodLayout, drinkLayout, billSection);
        HBox.setHgrow(foodLayout, Priority.ALWAYS);
        HBox.setHgrow(drinkLayout, Priority.ALWAYS);

        // Layout for order buttons
        HBox bottomLayout = new HBox(10);
        bottomLayout.setAlignment(Pos.CENTER);
        bottomLayout.getChildren().addAll(orderButton, cancelButton, confirmButton);

        // Final layout
        VBox finalLayout = new VBox(10);
        finalLayout.getChildren().addAll(titleBox,mainLayout, bottomLayout);

        // Scene and Stage setup
        Scene scene = new Scene(finalLayout, 1000, 500); // Adjust the size as needed
        primaryStage.setTitle("Order System");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}