package studay.Thread_.Synchronised_;

/**
 * @author hxz
 * 释放锁的几种情况
 * 1、当前线程的同步方法、同步代码块执行结束
 * 2、当前线程在同步方法、同步代码块中遇到 break、return
 * 3、当前线程在同步方法、同步代码块中出现未处理的 Error或Exception，导致异常结束
 * 4、当前线程在同步方法、同步代码块中执行了 线程对象的 wait()、join()方法，当前线程暂停，并释放锁
 */
public class ReleaseLock {
}
