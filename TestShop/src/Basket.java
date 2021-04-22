import java.util.*;

public class Basket {

    Map<Item, Integer> orderedItems;

    public Basket() {
        this.orderedItems = new TreeMap<>();
    }

    public void addItem(Item item, Integer amount) {

        if (amount < 1) {
            throw new IllegalArgumentException("Item amount lower than 1");
        }
        if (orderedItems.containsKey(item)) {
            amount = orderedItems.get(item) + amount;
        }
        orderedItems.put(item, amount);
    }

    public void removeItem(Item item, int amount) {

        if (amount <= 0) {
            throw new IllegalArgumentException("Item amount lower than 1");
        }
        amount = orderedItems.get(item) - amount;
        if (amount == 0) {
            orderedItems.remove(item);
        }
        else if (amount < 0) {
            throw new IllegalStateException("Too many items to be removed");
        }
        else {
            orderedItems.replace(item, amount);
        }
    }

    public double getTotalOrderValue() {

        double totalValue = 0;
        for (Map.Entry<Item, Integer> entry : orderedItems.entrySet()) {

            totalValue += entry.getKey().getPrice() * entry.getValue();
        }

        return totalValue;
    }

    @Override
    public String toString() {
        StringBuilder outString = new StringBuilder();

        for (Map.Entry<Item, Integer> entry : orderedItems.entrySet()) {

            outString.append(entry.getKey().getName())
                    .append(" ")
                    .append(entry.getValue())
                    .append("\n");
        }

        outString.append(String.format("Total value: %.2f", getTotalOrderValue()));
        return outString.toString();
    }
}
