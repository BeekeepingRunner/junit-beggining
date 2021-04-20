import org.junit.*;

public class BasketTest {

    private Basket basket;

    @Before
    public void setUp() {
        basket = new Basket();
    }

    @Test(expected = IllegalArgumentException.class)
    public void ShouldSayWrongAmount() {
        basket.addItem(new Item("Phone", 1000), 0);
    }

    @Test(expected = NullPointerException.class)
    public void ShouldSayNullItem() {
        basket.addItem(null, 1);
    }
}