package hxz.Exception_.throws_;

/**
 * @author hxz
 */
public class throws02 {
}

class Father { //父类
    public void method() throws RuntimeException {
    }
}
class Son extends Father {//子类
    //3. 子类重写父类的方法时，对抛出异常的规定:子类重写的方法，
    // 所抛出的异常类型要么和父类抛出的异常一致，要么为父类抛出的异常类型的子类型
    //4. 在 throws 过程中，如果有方法 try-catch , 就相当于处理异常，就可以不必 throws
    @Override
    public void method() throws ArithmeticException {
    }
}