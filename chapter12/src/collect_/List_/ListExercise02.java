package collect_.List_;


import java.util.*;

/**
 * @author hxz
 */
public class ListExercise02 {
    public static void main(String[] args) {
        //List list = new ArrayList();
        List list = new LinkedList();
        //List list = new Vector();
        list.add(new Book("红楼梦", "曹雪芹", 100));
        list.add(new Book("西游记", "吴承恩", 10));
        list.add(new Book("水浒传", "施耐庵", 19));
        list.add(new Book("三国", "罗贯中", 80));
        //list.add(new Book("西游记", "吴承恩", 10));
        //如何对集合进行排序

        //遍历
        for (Object o : list) {
            System.out.println(o);
        }

        //冒泡排序 (这里用到了我们的定制排序 （匿名内部类+动态绑定+向上转型）)
        mysort(list, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Book b1 = (Book) o1;
                Book b2 = (Book) o2;
                double d = b1.getPrice() - b2.getPrice();
                if (d > 0){
                    return 1;
                }else if (d <0){
                    return -1;
                }else {
                    return 0;
                }
            }
        });
        System.out.println("==排序后==");
        for (Object o : list) {
            System.out.println(o);
        }


    }

    //静态方法
    //价格要求是从小到大
    public static void mysort(List list, Comparator comparator) {
        int listSize = list.size();
        for (int i = 0; i < listSize - 1; i++) {
            for (int j = 0; j < listSize - 1 - i; j++) {
                //取出对象 Book
                Book book1 = (Book) list.get(j);
                Book book2 = (Book) list.get(j + 1);
                if (comparator.compare(book1,book2) > 0) {//交换 从小到大
                    list.set(j, book2);
                    list.set(j + 1, book1);
                }
            }
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}