package Projects.hxz.ZeroMoneyPass;

public class MoneyDetail {
    private String[] detail = new String[5]; //保留最近5条信息

    //根据输入的内容，将信息编制成字符串形式的明细返回
    public String informationIntegration(String str, double num, String time, double balance) {
        String str1 = String.format("%-12s", str);
        String str2 = String.format("%.2f", num);
        str2 = String.format("%-10s", str2);
        String str3 = String.format("%-20s", time);
        String str4 = String.format("%.2f", balance);

        return str1 + str2 + str3 + str4;
    }

    //将信息添加进明细列表中
    public void addDetail(String det) {
        boolean flag = false;
        int l = detail.length;

        for (int i = 0; i < l; i++) {
            if (detail[i] == null) {
                detail[i] = det;
                flag = true;
                break;
            }
        }

        //纪录已满，需要去掉最早记录，加入最新纪录
        if (!flag) {
            for (int i = 0; i < l - 1; i++) {
                detail[i] = detail[i + 1];
            }
            detail[l - 1] = det;
        }

    }

    public void showDetail() {
        System.out.println("============零钱通明细============");
        for (int i = 0; i < detail.length; i++) {
            if (detail[i] == null ) break;
            System.out.println(detail[i]);
        }
    }

    //定义一个数组扩容方法
    public void arrKuoRong(){

    }

    public String[] getDetail() {
        return detail;
    }

    public void setDetail(String[] detail) {
        this.detail = detail;
    }
}
