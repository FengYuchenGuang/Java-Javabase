package studay.Thread_;

/**
 * @author hxz
 */
public class CPUNum {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        int cpuNum = runtime.availableProcessors();

        System.out.println("µçÄÔCPU¸öÊı£º" + cpuNum);
    }
}
