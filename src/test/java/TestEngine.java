import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class TestEngine {
    Article apple = new Article(2, "A", 3, 1.7);
    Article carrot = new Article(1, "C", 0, 0.8);
    Article pumpkin = new Article(1.5, "P", 6, 1.2);
    Article javelin = new Article(73600, "J", 0, 73300);


    Engine engine = new Engine();
    @Test
    public void testCalculateBucketTotalPriceIfArgumentsOk() {
        Cart cart = new Cart();
        cart.getMap().put(apple, 7);
        cart.getMap().put(carrot, 3);
        cart.getMap().put(pumpkin, 7);
        cart.getMap().put(javelin, 1);

        Double expectedPrice = 73623.9d;
        Double resultPrice = engine.calculateCartTotalPrice(cart);

        Assert.assertEquals(expectedPrice, resultPrice);
    }

    @Test
    public void testAddToBucketSuccess() {
        Cart cart = new Cart();
        String carrotCode = "C";
        double carrotPrice = 1d;
        int countOfCarrots = 5;
        engine.addToBucket(cart, carrot, countOfCarrots);

        Assert.assertEquals(carrot.getCode(), carrotCode);
        Assert.assertTrue(carrot.getPrice() == carrotPrice);
        Assert.assertTrue(cart.getMap().get(carrot) == countOfCarrots);
    }

    @Test
    public void testCreateCartByCodesOk() {
        String goods = "AACACPAJ";

        ArrayList<Article> list = new ArrayList<>();
        list.add(apple);
        list.add(carrot);
        list.add(pumpkin);
        list.add(javelin);

        Cart expected = new Cart();
        expected.getMap().put(apple, 4);
        expected.getMap().put(carrot, 2);
        expected.getMap().put(pumpkin, 1);
        expected.getMap().put(javelin, 1);

        Cart actual = engine.createCartByCodes(goods, list);

        Assert.assertEquals(expected, actual);
    }
}
