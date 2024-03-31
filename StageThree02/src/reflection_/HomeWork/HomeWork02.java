package reflection_.HomeWork;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author hxz
 */
public class HomeWork02 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        String name = "java.io.File";
        String FileName = "d:\\new.txt";


        Class<?> aClass = Class.forName(name);

        Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println(name + " 的所有构造器 = " + declaredConstructor);
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("该构造器的形参类型=" + parameterType);
            }
        }

        Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
        Object o = declaredConstructor.newInstance(FileName);
        Method exists = aClass.getMethod("exists");
        Method createNewFile = aClass.getMethod("createNewFile");
        if ( !(boolean)(exists.invoke(o))){//文件不存在时，创建
            createNewFile.invoke(o);
            System.out.println("文件创建成功~~");
        }else {
            System.out.println("文件已经存在~~");
        }


    }
}
