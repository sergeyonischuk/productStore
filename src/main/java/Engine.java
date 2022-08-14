import java.util.ArrayList;
import java.util.List;

public class Engine {

    public void addToBucket(Cart cart, Article article, int count) {
        if (cart != null && article != null && count > 0) {
            cart.getMap().put(article, count);
        }
    }

    public double getTotalPricesByCode(String codes, List<Article> articles) {
        Cart cart = createCartByCodes(codes, articles);
        return calculateCartTotalPrice(cart);
    }

    public Cart createCartByCodes(String codes, List<Article> articles) {
        Cart cart = new Cart();
        String[] s = codes.split("");
        for (String value : s) {
            cart.getMap().put(getByCode(value, articles),
                    cart.getMap().getOrDefault(getByCode(value, articles), 0) + 1);
        }
        return cart;
    }

    public double calculateCartTotalPrice(Cart cart) {
        if (cart != null) {
            double result = 0.0;
            List<Article> keys = new ArrayList<>(cart.getMap().keySet());
            for (Article current : keys) {
                int discountIncrement = 0;
                int discountCount = 0;
                int normalPriceCount = 0;
                if (current.getSaleCount() > 0) {
                    discountIncrement = cart.getMap().get(current) / current.getSaleCount();
                    discountCount = current.getSaleCount() * discountIncrement;
                }
                normalPriceCount = cart.getMap().get(current) - discountCount;
                if (normalPriceCount > 0) {
                    result += normalPriceCount * current.getPrice();
                }
                if (discountCount > 0) {
                    result += discountCount * current.getSalePrice();
                }
            }
            return result;
        }
        throw new NullPointerException();
    }

    private Article getByCode(String code, List<Article> articles) {
        return articles.stream().filter(e -> e.getCode().equals(code))
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
