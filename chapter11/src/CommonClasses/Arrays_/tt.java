package CommonClasses.Arrays_;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author hxz
 * 自己写复习
 */
public class tt {
    public static void main(String[] args) {
        Book[] books = new Book[4];
        books[0] = new Book("红楼梦", 100);
        books[1] = new Book("金瓶梅新", 90);
        books[2] = new Book("青年文摘 20 年", 5);
        books[3] = new Book("java 从入门到放弃~", 300);

        System.out.println(Arrays.toString(books));

        Arrays.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double priceVal = o1.getPrice() - o2.getPrice();

                if (priceVal > 0) return -1;
                else if (priceVal < 0) return 1;
                else return 0;
            }
        });
        System.out.println(Arrays.toString(books));

    }
}

class books{
    private String name;
    private double price;

    public books(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "books{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}'+"\n";
    }
}
