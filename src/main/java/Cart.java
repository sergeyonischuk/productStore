import java.util.HashMap;
import java.util.Objects;

public class Cart {
    private HashMap<Article, Integer> map;
    private Double totalPrice;

    public Cart() {
        this.map = map = new HashMap<Article, Integer>();
        this.totalPrice = 0.0;
    }

    public HashMap<Article, Integer> getMap() {
        return map;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                ", totalPrice=" + totalPrice +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return Objects.equals(map, cart.map) && Objects.equals(totalPrice, cart.totalPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map, totalPrice);
    }
}
