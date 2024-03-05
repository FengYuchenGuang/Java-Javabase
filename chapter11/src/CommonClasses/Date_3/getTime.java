package CommonClasses.Date_3;

//第一代日期
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
//第二代日期
import java.util.Calendar;
//第三代日期
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author hxz
 * Date           第一代日期
 * Calendar       第二代日期
 * LocalDateTime  第三代日期  没有new 都是静态方法
 */
public class getTime {
    public static void main(String[] args) throws ParseException {
        //三种获得当前时间的方法
        //方法一 new Date();   获取当前时间
        //      SimpleDateFormat  进行规范化
        //老韩解读
        //1. 获取当前系统时间
        //2. 这里的 Date 类是在 java.util 包
        //3. 默认输出的日期格式是国外的方式, 因此通常需要对格式进行转换
        System.out.println("=====方法一 Date 获取当前时间=====");
        Date date = new Date();
        // this object contains the current date value
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy年 MM月 dd日 HH:mm:ss");
        System.out.println(formatter1.format(date));
        System.out.println(formatter2.format(date));

        //老韩解读
        //1. 可以把一个格式化的 String 转成对应的 Date
        //2. 得到 Date 仍然在输出时，还是按照国外的形式，如果希望指定格式输出，需要转换
        //3. 在把 String -> Date ， 使用的 sdf 格式需要和你给的 String 的格式一样，否则会抛出转换
        String s = "2024年 03月 02日 21:24:51";
        Date parse = formatter2.parse(s);
        System.out.println(parse);

        //方法二
        System.out.println("=====方法二 Calendar 获取当前时间=====");
        //1. Calendar 是一个抽象类， 并且构造器是 private
        //2. 可以通过 getInstance() 来获取实例
        //3. 提供大量的方法和字段提供给程序员
        //4. Calendar 没有提供对应的格式化的类，因此需要程序员自己组合来输出(灵活)
        //5. 如果我们需要按照 24 小时进制来获取时间， Calendar.HOUR ==改成=> Calendar.HOUR_OF_DAY
        Calendar c = Calendar.getInstance(); //创建日历类对象//比较简单，自由
        System.out.println("c=" + c);
        //2.获取日历对象的某个日历字段
        System.out.println("年：" + c.get(Calendar.YEAR));
        // 这里为什么要 + 1, 因为 Calendar 返回月时候，是按照 0 开始编号
        System.out.println("月：" + (c.get(Calendar.MONTH) + 1));
        System.out.println("日：" + c.get(Calendar.DAY_OF_MONTH));
        System.out.println("小时：" + c.get(Calendar.HOUR));
        System.out.println("分钟：" + c.get(Calendar.MINUTE));
        System.out.println("秒：" + c.get(Calendar.SECOND));
        //Calender 没有专门的格式化方法，所以需要程序员自己来组合显示
        System.out.println(c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH) + 1) + "-" +
                c.get(Calendar.DAY_OF_MONTH) + " " + c.get(Calendar.HOUR_OF_DAY) + ":" +
                c.get(Calendar.MINUTE) + ":" + c.get(Calendar.SECOND) );


        //方法三 LocalDateTime.now();   获取当前时间
        //      DateTimeFormatter      进行规范化
        //========== 没有 new ===============
        System.out.println("=====方法三 LocalDateTime 获取当前时间=====");
        LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time
        DateTimeFormatter formatter5 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        DateTimeFormatter formatter6 = DateTimeFormatter.ofPattern("yyyy年 MM月 dd日 HH:mm:ss");
        System.out.println(dateTime.format(formatter5));
        System.out.println(dateTime.format(formatter6));

        //1. 使用 now() 返回表示当前日期时间的 对象
        LocalDateTime ldt = LocalDateTime.now(); //LocalDate.now();//LocalTime.now()
        System.out.println(ldt);
        //2. 使用 DateTimeFormatter 对象来进行格式化
        // 创建 DateTimeFormatter 对象
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(ldt);
        System.out.println("格式化的日期=" + format);
        System.out.println("年=" + ldt.getYear());
        System.out.println("月=" + ldt.getMonth());
        System.out.println("月=" + ldt.getMonthValue());
        System.out.println("日=" + ldt.getDayOfMonth());
        System.out.println("时=" + ldt.getHour());
        System.out.println("分=" + ldt.getMinute());
        System.out.println("秒=" + ldt.getSecond());

        LocalDate now = LocalDate.now(); //可以获取年月日
        LocalTime now2 = LocalTime.now();//获取到时分秒

        //提供 plus 和 minus 方法可以对当前时间进行加或者减
        //看看 890 天后，是什么时候 把 年月日-时分秒
        LocalDateTime localDateTime = ldt.plusDays(890);
        System.out.println("890 天后=" + dateTimeFormatter.format(localDateTime));

        //看看在 3456 分钟前是什么时候，把 年月日-时分秒输出
        LocalDateTime localDateTime2 = ldt.minusMinutes(3456);
        System.out.println("3456 分钟前 日期=" + dateTimeFormatter.format(localDateTime2));


    }
}
