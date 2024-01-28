package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class MenuTest {

    @Test
    public void testAddAndRemoveMenuItem() {
        Menu menu = new Menu();
        MenuItem newItem = new MenuItem("Pancakes", 5.99, "Food");

        menu.addItem(newItem);
        assertTrue(menu.getItems().contains(newItem), "Menu should contain the added item");

        menu.removeItem(newItem);
        assertFalse(menu.getItems().contains(newItem), "Menu should not contain the removed item");
    }

    @Test
    public void testGetItems() {
        Menu menu = new Menu();
        List<MenuItem> items = menu.getItems();

        assertNotNull(items, "getItems should return a non-null list of items");
        assertFalse(items.isEmpty(), "getItems should return a non-empty list of items");
    }

    // Additional tests can include checking the initial menu items, etc.
}
