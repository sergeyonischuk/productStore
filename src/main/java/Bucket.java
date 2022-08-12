import java.util.HashMap;

public class Bucket {
    private HashMap<Article, Integer> map;
    private Double totalPrice;

    public Bucket() {
        this.map = map = new HashMap<Article, Integer>();
        this.totalPrice = 0.0;
    }

    public HashMap<Article, Integer> getMap() {
        return map;
    }

    public void setMap(HashMap<Article, Integer> map) {
        this.map = map;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
