import org.junit.*;

import static org.junit.Assert.assertEquals;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() {
        basket = new Basket();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldBeWrongAmountToAdd() {
        basket.addItem(new Item("Phone", 1000), 0);
    }

    @Test
    public void ShouldBeCorrectAmountToAdd() {
        basket.addItem(new Item("Phone", 1000), 1);
    }

    @Test
    public void AmountShouldBeCorrectWhileAddingAlreadyExistingItem() {
        Item phone = new Item("Phone", 1000);
        basket.addItem(phone, 2);
        basket.addItem(phone, 1);
        assertEquals(3, (long)basket.orderedItems.get(phone));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldntRemoveZeroOrLessAmount() {
        basket.removeItem(new Item("Phone", 100), 0);
    }

    @Test
    public void AmountShouldBeCorrectWhileNotRemovingWholePosition() {
        Item phone = new Item("Phone", 1000);
        basket.addItem(phone, 4);
        basket.removeItem(phone, 3);
        assertEquals(1, (long)basket.orderedItems.get(phone));
    }

    @Test
    public void ShouldRemoveItemIfAmountEqualOrGreaterThanInBasket() {
        Item phone = new Item("Phone", 1000);
        basket.addItem(phone, 4);
        basket.removeItem(phone, 4);
        assertEquals(null, basket.orderedItems.get(phone));
    }

    @Test(expected = IllegalStateException.class)
    public void ShouldntRemoveTooManyItems() {
        Item phone = new Item("Phone", 1000);
        basket.addItem(phone, 4);
        basket.removeItem(phone, 5);
    }

    @Test
    public void totalOrderValueCorrectnessTest() {
        Item phone = new Item("Phone", 500);
        Item hat = new Item("Hat", 50);

        double expectedOrderVal = phone.getPrice() * 2 + hat.getPrice() * 5;

        basket.addItem(phone, 3);
        basket.addItem(hat, 5);
        basket.removeItem(phone, 1);
        assertEquals(expectedOrderVal, basket.getTotalOrderValue(), 0);
    }

    @Test
    public void toStringTest() {
        initExample();
        StringBuilder sb = new StringBuilder();
        sb.append("Hat 5\nPhone 3\nTotal value: 1750,00");
        assertEquals(sb.toString(), basket.toString());
        // System.out.println(basket.toString());
    }

    void initExample() {
        Item phone = new Item("Phone", 500);
        Item hat = new Item("Hat", 50);
        basket.addItem(phone, 3);
        basket.addItem(hat, 5);
    }
}