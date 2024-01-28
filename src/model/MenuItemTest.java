package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MenuItemTest {

    @Test
    public void testMenuItemConstructorAndGetters() {
        MenuItem item = new MenuItem("Coffee", 1.99, "Drink");
        assertEquals("Coffee", item.getName(), "Name should be Coffee");
        assertEquals(1.99, item.getPrice(), "Price should be 1.99");
    }

    @Test
    public void testSetters() {
        MenuItem item = new MenuItem("Tea", 0.99, "Drink");
        item.setName("Green Tea");
        item.setPrice(1.29);

        assertEquals("Green Tea", item.getName(), "Name should be updated to Green Tea");
        assertEquals(1.29, item.getPrice(), "Price should be updated to 1.29");
    }
}
