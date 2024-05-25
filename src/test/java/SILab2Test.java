import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class SILab2Test {
    @Test
    public void everyBranchTest() {
        //test case 1
        List<Item> allItems1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems1, 100));
        assertTrue(ex.getMessage().contains("allItems list can't be null!"));

        //test case 2
        List<Item> allItems2 = new ArrayList<>();
        allItems2.add(new Item("cheese", "180s", 100, 0f));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems2, 100));
        assertTrue(ex.getMessage().contains("Invalid character in item barcode!"));

        //test case 3
        List<Item> allItems3 = new ArrayList<>();
        allItems3.add(new Item("cheese", null, 100, 0f));
        ex = assertThrows(RuntimeException.class, () -> SILab2.checkCart(allItems3, 100));
        assertTrue(ex.getMessage().contains("No barcode!"));

        //test case 4
        List<Item> allItems4 = new ArrayList<>();
        allItems4.add(new Item(null, "0612", 350, 0.2f));
        allItems4.add(new Item("cheese", "0804", 400, 0.3f));
        assertTrue(SILab2.checkCart(allItems4, 1000));

        //test case 5
        List<Item> allItems5 = new ArrayList<>();
        allItems5.add(new Item("ham", "1312", 350, 0f));
        allItems5.add(new Item("cheese", "1804", 400, 0f));
        assertFalse(SILab2.checkCart(allItems5, 100));

    }

    @Test
    public void multipleConditionTest() {
        //test case 1: F && X && X
        List<Item> allItems1 = new ArrayList<>();
        allItems1.add(new Item("cheese", "1804", 200, 0.3f));
        assertFalse(SILab2.checkCart(allItems1, 10));

        //test case 2: T && F && X
        List<Item> allItems2 = new ArrayList<>();
        allItems2.add(new Item("cheese", "1804", 400, 0f));
        assertFalse(SILab2.checkCart(allItems2, 10));

        //test case 3: T && T && F
        List<Item> allItems3 = new ArrayList<>();
        allItems3.add(new Item("cheese", "1804", 400, 0.3f));
        assertFalse(SILab2.checkCart(allItems3, 10));

        //test case 4: T && T && T
        List<Item> allItems4 = new ArrayList<>();
        allItems4.add(new Item("cheese", "0804", 400, 0.3f));
        assertTrue(SILab2.checkCart(allItems4, 1000));

    }

}
