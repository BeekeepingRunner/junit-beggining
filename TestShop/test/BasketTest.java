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
        assertEquals((long)basket.orderedItems.get(phone), 3);
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
        assertEquals((long)basket.orderedItems.get(phone), 1);
    }

    @Test
    public void ShouldRemoveItemIfAmountEqualOrGreaterThanInBasket() {
        Item phone = new Item("Phone", 1000);
        basket.addItem(phone, 4);
        basket.removeItem(phone, 4);
        assertEquals(basket.orderedItems.get(phone), null);
    }

    @Test(expected = IllegalStateException.class)
    public void ShouldntRemoveTooManyItems() {
        Item phone = new Item("Phone", 1000);
        basket.addItem(phone, 4);
        basket.removeItem(phone, 5);
    }


}