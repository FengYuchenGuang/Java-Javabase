package collect_.HomeWork;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * @author hxz
 */
@SuppressWarnings("all")
public class HomeWork01 {
    public static void main(String[] args) {
        News01 news01 = new News01("新冠确诊病例超千万，数百万印度教信徒赴恒河\"圣浴\"引民众担忧");
        News01 news02 = new News01("男子突然想起两个月前钓的鱼还在网兜里，捞起一看赶紧放生");
        News01 news03 = new News01("广东一男子吃5元早餐滑倒致手臂骨折索赔20万，店家称被讹诈！判了");
        News01 news04 = new News01("姑娘灌水测汽车油箱容积 网友质疑：一升油和一升水体积一样吗");
        News01 news05 = new News01("多位宝莱坞女星发声，炮轰印度，声援西班牙女网红被性侵事件");
        News01 news06 = new News01("泰国第一美女mai，长沙压轴出场，美艳万分，成浪姐5最强选手");

        News01[] news = {news01, news02, news03, news04, news05, news06};
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < news.length; i++) {
            arrayList.add(news[i]);
        }

        //倒序遍历1,根据索引，从后往前一个个输出
        System.out.println("=====倒序遍历1=====");
        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            News01 getNew = (News01) arrayList.get(i);//向下转型以后才能用News01的方法
            System.out.println(processTitle(getNew.getTitle()));
        }

        //倒序遍历2,先将数列反转，在迭代器遍历
        System.out.println("=====倒序遍历2=====");
        //使用Collections工具类中的 reverse 方法进行 数列反转
        Collections.reverse(arrayList);
        //迭代器遍历
        Iterator iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            News01 next = (News01) iterator.next();
            System.out.println(processTitle(next.getTitle()));
        }
    }

    public static String processTitle(String str) {
        if (str == null) {
            return "title为空";
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        if (len > 15) {
            //超过15个字符，返回前15个
            //substring 截取是包括第一个索引，但不包括最后一个
            // substring(0,15) 是截取 0 - 14 一个十五个字符
            return "title=" + str.substring(0, 15) + "...";
        }
        //未超过15个字符，全部显示
        return "title=" + str;
    }
}

class News01 {
    private String title;
    private String content;

    public News01(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "title=" + title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
