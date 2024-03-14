package studay.Thread_.Synchronised_;

/**
 * @author hxz
 * 下面情况不会释放锁
 * 1、线程执行同步方法、同步代码块时，程序调用 Thread.sleep()、Thread.yield()方法暂停当前线程的执行，
 * 不会释放锁
 *
 * 2、线程执行同步方法、同步代码块时，其他线程调用了该线程的 suspend()方法将该线程挂起，不会释放锁
 *
 * 提示：应该尽量避免使用 suspend()和resume()来控制线程，方法不再被推荐
 */
public class NotReleaseLock {
}
