import java.util.ArrayList;
import java.util.List;

public class Engine {

    public void addToBucket(Bucket bucket, Article article, int count) {
        if (bucket != null && article != null && count > 0) {
            bucket.getMap().put(article, count);
        }
    }

    public double calculateBucketTotalPrice(Bucket bucket) {
        if (bucket != null) {
            double result = 0.0;
            List<Article> keys = new ArrayList<>(bucket.getMap().keySet());
            for (Article current : keys) {
                int discountIncrement = 0;
                int discountCount = 0;
                int normalPriceCount = 0;
                if (current.getSaleCount() > 0) {
                    discountIncrement = bucket.getMap().get(current) / current.getSaleCount();
                    discountCount = current.getSaleCount() * discountIncrement;
                }
                normalPriceCount = bucket.getMap().get(current) - discountCount;
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
}
