import org.junit.Test;
import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void itemsShouldBeEqual() {
        assertEquals(new Item("item", 123.12), new Item("item", 123.12));
    }

    @Test
    public void ItemsWithDifferentNamesOrPriceArentEqual() {
        assertNotEquals(new Item("item", 123.12), new Item("item2", 123.12));
        assertNotEquals(new Item("item", 123.11), new Item("item", 123.12));
    }

    @Test
    public void sameNameAndPriceSameHashCode() {
        assertEquals(new Item("item", 123.12).hashCode(),
                new Item("item", 123.12).hashCode());
    }

    @Test
    public void differentNameOrPriceDifferentHashCode() {
        assertNotEquals(new Item("item1", 123.12).hashCode(),
                new Item("item2", 123.12).hashCode());
        assertNotEquals(new Item("item", 123.12).hashCode(),
                new Item("item", 123.13).hashCode());
    }

    @Test
    public void comparingTest() {
        // Items are compared by names first, then if they are equal, they are compared by the price.

        // same names, different prices
        assertEquals(-1, new Item("item1", 0.1).compareTo(new Item("item1", 0.2)));
        assertEquals(1, new Item("item1", 0.2).compareTo(new Item("item1", 0.1)));

        // same names, same prices
        assertEquals(0, new Item("item1", 0.2).compareTo(new Item("item1", 0.2)));

        // different names, same prices
        assertEquals(-1, new Item("item1", 0.2).compareTo(new Item("item2", 0.2)));
        assertEquals(1, new Item("item2", 0.2).compareTo(new Item("item1", 0.2)));
    }
}