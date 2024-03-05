
public class ArrayTest {
    public static void main(String[] args) {
        MyTool t1 = new MyTool();
        int[] arr = {1, 5, 9, 3, 44, 58, 12, 0, 56};

        t1.showArray(arr);
        t1.bubble(arr);
        t1.showArray(arr);

    }
}

class MyTool {

    public void bubble(int[] arr) {
        //冒泡排序
        int temp = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void showArray(int[] arr) {
        System.out.println("数组如下：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println();
    }
}

