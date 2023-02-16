package designpatterns;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

enum Size {
    SMALL, MEDIUM, LARGE, HUGE
}

enum Color {
    BLUE, GREEN, RED, YELLOW
}

interface Specification<T> {
    boolean isSatisfied(T item);
}

interface Filter<T> {
    Stream<T> filter(List<T> items, Specification<T> spec);

}

class PriceSpecification implements Specification<Product> {

    private int price;

    public PriceSpecification(int price) {
        this.price = price;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.price == price;
    }
}

class SizeSpecification implements Specification<Product> {

    private Size size;

    public SizeSpecification(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return this.size == item.size;
    }
}

class ColorSpecification implements Specification<Product> {

    private Color color;

    public ColorSpecification(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == this.color;
    }
}

class AndSpecification<T> implements Specification<T> {

    private Specification<T> first, second;

    public AndSpecification(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}

class BetterFilter implements Filter<Product> {

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

public class OpenClosedPrinciple {

    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.GREEN, Size.SMALL, 120);
        Product tree = new Product("Tree", Color.GREEN, Size.SMALL, 120);
        Product house = new Product("House", Color.BLUE, Size.LARGE, 10);
        List<Product> products = Arrays.asList(apple, tree, house);
        ProductFilter pf = new ProductFilter();
        System.out.println("Green Products (old) :");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" -  " + p.name + " is green"));

        System.out.println("Green Products (New) :");
        BetterFilter bf = new BetterFilter();
        bf.filter(products, new ColorSpecification(Color.GREEN)).forEach(p -> System.out.println(" -  " + p.name + " is green"));

        System.out.println("Products with small size and green color");
        bf.filter(products, new AndSpecification<>(new SizeSpecification(Size.SMALL), new ColorSpecification(Color.GREEN)))
                .forEach(p -> System.out.println(" -  " + p.name + " is green and small"));
    }
}

class ProductFilter {

    public Stream<Product> filterByColor(List<Product> products, Color color) {
        return products.stream().filter(p -> p.color == color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size) {
        return products.stream().filter(p -> p.size == size);
    }

    public Stream<Product> filterBySizeAndColor(
            List<Product> products,
            Color color,
            Size size
    ) {
        return products.stream().filter(p -> p.color == color && p.size == size);
    }

    public Stream<Product> filterBySize(List<Product> products, int price) {
        return products.stream().filter(p -> p.price == price);

    }

}

class Product {
    public String name;
    public Color color;
    public Size size;
    public int price;

    public Product(String name, Color color, Size size, int price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
    }
}

