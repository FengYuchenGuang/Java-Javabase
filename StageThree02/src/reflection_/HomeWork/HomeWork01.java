package reflection_.HomeWork;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hxz
 */
public class HomeWork01 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        //方法一
        Class<?> aClass = Class.forName("reflection_.HomeWork.PrivateTest");
        //方法二
//        Class<PrivateTest> aClass = PrivateTest.class;

        Object o = aClass.newInstance();


        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);

        Method getName = aClass.getMethod("getName");
        System.out.println(getName.invoke(o));

        name.set(o,"hxz");
        System.out.println(getName.invoke(o));

    }
}

class PrivateTest{
    private String name = "hellokitty";

    public String getName() {
        return name;
    }
}
