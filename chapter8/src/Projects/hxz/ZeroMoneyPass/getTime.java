package Projects.hxz.ZeroMoneyPass;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hxz
 * Date           第一代日期
 * Calendar       第二代日期
 * LocalDateTime  第三代日期
 */
public class getTime {
    public static void main(String[] args) {
        //两种获得当前时间的方法
        //方法一
        LocalDateTime dateTime = LocalDateTime.now(); // get the current date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(dateTime.format(formatter));
        //方法二
        Date date = new Date();
        // this object contains the current date value
        SimpleDateFormat formatter1 = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        System.out.println(formatter1.format(date));
    }
}
