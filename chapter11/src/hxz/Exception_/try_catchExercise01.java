package hxz.Exception_;

/**
 * @author hxz
 */
public class try_catchExercise01 {
    public static int method1() {

        try {
            String[] strings = new String[3];
            if (strings[1].equals("tom")) { //NullPointerException
                System.out.println(strings[1]);
            } else {
                strings[3] = "hxz"; //ArrayIndexOutOfBoundsException
            }
            return 1;
        } catch (NullPointerException e) {
            System.out.println("NullPointerException异常");
            return 2;
        } catch (ArrayIndexOutOfBoundsException e) {
            return 3;
        } catch (Exception e) {
            e.printStackTrace();
        } finally { //必须执行
            return 4;
        }
    }

    public static int method2() {
        int i = 1;
        try {
            i++; //i=2
            String[] strings = new String[3];
            if (strings[1].equals("tom")) { //NullPointerException
                System.out.println(strings[1]);
            } else {
                strings[3] = "hxz"; //ArrayIndexOutOfBoundsException
            }
            return 1;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBoundsException 异常");
            return 2;
        }catch (NullPointerException e) {
            System.out.println("NullPointerException 异常");
            return ++i;  // i = 3; => 保存临时变量temp =3;
        }  finally { //必须执行
            ++i;
            System.out.println("i = " + i);
        }
    }

    public static void main(String[] args) {
        //try_catch_finally //必须执行
        //所以不能return 3;
        System.out.println(method1());

        System.out.println("=================");
        System.out.println("return = " + method2());
    }
}
