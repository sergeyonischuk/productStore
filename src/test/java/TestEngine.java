import org.junit.Assert;
import org.junit.Test;

public class TestEngine {
    Article apple = new Article(2, "A", 3, 1.7);
    Article carrot = new Article(1, "C", 0, 0.8);
    Article pumpkin = new Article(1.5, "P", 6, 1.2);
    Article javelin = new Article(73600, "J", 0, 73300);

    Engine engine = new Engine();
    @Test
    public void testCalculateBucketTotalPriceIfArgumentsOk() {
        Bucket bucket = new Bucket();
        bucket.getMap().put(apple, 7);
        bucket.getMap().put(carrot, 3);
        bucket.getMap().put(pumpkin, 7);
        bucket.getMap().put(javelin, 1);

        Double expectedPrice = 73623.9d;
        Double resultPrice = engine.calculateBucketTotalPrice(bucket);

        Assert.assertEquals(expectedPrice, resultPrice);
    }

    @Test
    public void testAddToBucketSuccess() {
        Bucket bucket = new Bucket();
        String carrotCode = "C";
        double carrotPrice = 1d;
        int countOfCarrots = 5;
        engine.addToBucket(bucket, carrot, countOfCarrots);

        Assert.assertEquals(carrot.getCode(), carrotCode);
        Assert.assertTrue(carrot.getPrice() == carrotPrice);
        Assert.assertTrue(bucket.getMap().get(carrot) == countOfCarrots);
    }
}
