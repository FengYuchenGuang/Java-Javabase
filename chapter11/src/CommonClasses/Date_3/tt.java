package CommonClasses.Date_3;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author hxz
 */
public class tt {
    public static void main(String[] args) {
        //第三代日期
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy dd MM HH:mm:ss");

        System.out.println();
    }
}
