import org.junit.Assert;
import org.junit.Test;

public class TestEngine {
    Article apple = new Article(2, "A", 3, 1.7);
    Article carrot = new Article(1, "C", 0, 0.8);
    Article pumpkin = new Article(1.5, "P", 6, 1.2);
    Article javelin = new Article(73600, "J", 0, 73300);

    Engine engine = new Engine();
    @Test
    public void testCalculateBucketTotalPrice() {
        Bucket bucket = new Bucket();
        bucket.getMap().put(apple, 7);
        bucket.getMap().put(carrot, 3);
        bucket.getMap().put(pumpkin, 7);
        bucket.getMap().put(javelin, 1);

        Double expected = 73623.9d;
        Double result = engine.calculateBucketTotalPrice(bucket);

        Assert.assertEquals(expected, result);
    }
}
