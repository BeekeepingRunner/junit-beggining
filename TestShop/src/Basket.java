import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Basket {

    Map<Item, Integer> orderedItems;

    public Basket() {
        this.orderedItems = new HashMap<>();
    }

    public void addItem(Item item, Integer amount) {

        if (item == null) {
            throw new NullPointerException("Item to add is null");
        }
        if (amount < 1) {
            throw new IllegalArgumentException("Item amount lower than 1");
        }
        orderedItems.put(item, amount);
    }

    public void removeItem(Item item) {

        if (item == null) {
            throw new NullPointerException("Item to remove is null");
        }
        if (orderedItems.remove(item) == null) {
            throw new NoSuchElementException("Item doesn't exist already");
        }
    }

    public void removeItemAmount(Item item, Integer amount) {

        if (amount < 1) {
            throw new IllegalArgumentException("Amount to remove is lower than 1");
        }
        Integer basketAmount = orderedItems.get(item);

        if (basketAmount == null) {
            throw new NoSuchElementException("Item doesn't exist already");
        }
        else if (basketAmount >= amount) {
            orderedItems.remove(item);
        } else {
            basketAmount = basketAmount - amount;
            orderedItems.replace(item, basketAmount);
        }
    }

    public double getTotalOrderValue() {

        double unitPrice = 0;
        Integer amount = 0;
        double totalValue = 0;

        for (Map.Entry<Item, Integer> entry : orderedItems.entrySet()) {

            unitPrice = entry.getKey().getPrice();
            amount = entry.getValue();
            totalValue += unitPrice * amount;
        }

        return totalValue;
    }

    public void displayContents() {

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Item, Integer> entry : orderedItems.entrySet()) {

            sb.append(entry.getKey().getName())
                    .append("\t")
                    .append(entry.getValue())
                    .append("\n");
        }

        System.out.println(sb.toString());
    }
}
