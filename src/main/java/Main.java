import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Article apple = new Article(2, "A", 3, 1.7);
        Article carrot = new Article(1, "C", 0, 0.8);
        Article pumpkin = new Article(1.5, "P", 6, 1.2);
        Article javelin = new Article(73600, "J", 0, 73300);
        ArrayList<Article> list = new ArrayList<>();
        list.add(apple);
        list.add(carrot);
        list.add(pumpkin);
        list.add(javelin);

        Engine engine = new Engine();
        String codes = "APJCAPAAA";

        System.out.println(engine.createCartByCodes(codes, list).getMap().get(apple));
        System.out.println(engine.createCartByCodes(codes, list).getMap().size());
        System.out.println(engine.getTotalPricesByCode(codes, list));

    }
}
