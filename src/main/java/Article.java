public class Article {
    private double price;
    //not char because it will be limit - 26 articles (or 52 with uppercase);
    private String code;
    private int saleCount;
    private Double salePrice;

    public Article(double price, String code, int saleCount, double salePrice) {
        this.price = price;
        this.code = code;
        this.saleCount = saleCount;
        this.salePrice = salePrice;
    }

    public double getPrice() {
        return price;
    }

    public String getCode() {
        return code;
    }

    public int getSaleCount() {
        return saleCount;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    @Override
    public String toString() {
        return "Article{" +
                "price=" + price +
                ", code='" + code + '\'' +
                ", saleCount=" + saleCount +
                ", salePrice=" + salePrice +
                '}';
    }
}