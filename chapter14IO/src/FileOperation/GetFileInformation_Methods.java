package FileOperation;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author hxz
 * 获取文件的信息
 * 1、文件名字
 * 2、文件绝对路径
 * 3、文件父级目录
 * 4、文件大小(字节)
 * 5、文件是否存在
 * 6、是不是一个文件
 * 7、是不是一个目录
 * <p>
 * 8、创建一级目录
 * 9、创建多级目录
 * 10、删除目录或文件
 */
public class GetFileInformation_Methods {
    public static void main(String[] args) {

    }

    //获取文件的信息
    @Test
    public void info() {
        //先创建文件对象
        File file = new File("d:\\news4.txt");
        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        //getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
        System.out.println("文件绝对路径=" + file.getAbsolutePath());
        System.out.println("文件父级目录=" + file.getParent());
        System.out.println("文件大小(字节)=" + file.length());
        System.out.println("文件是否存在=" + file.exists());//T
        System.out.println("是不是一个文件=" + file.isFile());//T
        System.out.println("是不是一个目录=" + file.isDirectory());//F
    }

    @Test
    public void modify() {
        String fileName1 = "d:\\RJ\\IDEA\\IO\\A";
        String fileName2 = "d:\\RJ\\IDEA\\IO\\A\\b";
        String fileName21 = "d:\\RJ\\IDEA\\IO\\A\\b\\hello.txt";
        String fileName3 = "d:\\RJ\\IDEA\\IO\\A\\b";
        //先创建文件对象
        File file1 = new File(fileName1);
        File file2 = new File(fileName2);
        File file3 = new File(fileName3);

        File file4 = new File(fileName21);

        if (file1.mkdirs()) { //创建多级目录
            System.out.println("创建多级目录" + fileName1 + " 成功~");
        }

        if (file2.mkdirs()) {//创建一级目录
            System.out.println("创建一级目录 " + fileName2 + " 成功~");
        }

        try {
            if (file4.createNewFile()) {
                System.out.println("创建文件成功~");
            } else {
                System.out.println("文件 " + fileName21 + " 已存在");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file3.delete()) {//删除目录或文件
            //当文件夹中包含子文件的时候都会删除失败，也就是说这四个方法只能删除空文件夹。
            System.out.println("删除目录或文件 " + fileName3 + " 成功~");
        } else {
            System.out.println("删除失败");
        }

    }
}
