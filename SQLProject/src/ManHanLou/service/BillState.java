package ManHanLou.service;

/**
 * @author hxz
 */
public interface BillState {
    //在接口中定义一些常量，用于标识
    //未结账 已结账 挂单 现金 支付宝 坏账
    String STATE1 = "未结账";
    String STATE2 = "已结账";
    String STATE3 = "挂单";
    String STATE4 = "现金";
    String STATE5 = "支付宝";
    String STATE6 = "微信";
    String STATE7 = "银行卡";
    String STATE8 = "坏账";
}
