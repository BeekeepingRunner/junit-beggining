import java.util.Objects;

public class Item implements Comparable<Item> {

    String name;
    double price;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

    @Override
    public int compareTo(Item o) {
        if (o == null) {
            return 1;
        }
        int comparison = this.getName().compareTo(o.getName());
        if (comparison != 0) {
            return comparison;
        }
        return Double.compare(this.getPrice(), o.getPrice());
    }
}
