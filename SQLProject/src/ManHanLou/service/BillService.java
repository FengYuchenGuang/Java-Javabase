package ManHanLou.service;

import ManHanLou.DAO.BillDAO;
import ManHanLou.DAO.MultiTableBillDAO;
import ManHanLou.domain.Bill;
import ManHanLou.domain.MultiTableBill;

import java.util.List;
import java.util.UUID;

/**
 * @author hxz
 * 业务层:完成对 Bill 的各种操作--通过调用 BillDAO 完成
 */
public class BillService {
    private BillDAO billDAO = new BillDAO();
    private MultiTableBillDAO multiTableBill = new MultiTableBillDAO();


    /**
     * 创建新订单 订单号是 该餐桌当前餐的唯一识别标记
     */
    public int startOrderMenu(Integer menuId, Double price, Integer nums,
                               Integer tableId, String state) {
        //生成一个订单号
        String billId = UUID.randomUUID().toString();

        String sqlStr = "INSERT INTO bill VALUES(NULL,?,?,?,?,?,NOW(),?)";

        Double money = price * nums;
        int affectedRows = billDAO.update(sqlStr, billId, menuId, nums, money, tableId, state);
        return affectedRows;
    }

    /**
     * 得到 "未支付" 订单编号
     */
    public Object getBillId(Integer tableId,String state) {

        String sqlStr = "select distinct billId from bill where tableId = ? and state = ? limit 0,1";

        return billDAO.queryScalar(sqlStr, tableId,state);
    }

    public Object getBillIdLast(Integer tableId) {

        String sqlStr = "SELECT billId,billDate FROM bill WHERE tableId = ? ORDER BY billDate DESC limit 0,1";

        return billDAO.queryScalar(sqlStr, tableId);
    }

    /**
     * 加菜
     */
    public int AddMenu(String billId, Integer menuId, Double price, Integer nums,
                        Integer tableId, String state) {
        String sqlStr = "INSERT INTO bill VALUES(NULL,?,?,?,?,?,NOW(),?)";

        Double money = price * nums;
        int affectedRows = billDAO.update(sqlStr, billId, menuId, nums, money, tableId, state);
        return affectedRows;
    }

    /**
     * 查询餐桌未付订单 （餐桌号 和 订餐人 符合，并且当前账单状态处于 "未结账" 的订单才是当前餐桌 未付的账单）
     * 因为未开始订第一道菜时，账单编号还没有创建
     */
    public List<Bill> queryTableUnpaidOrders(String billId, Integer tableId) {
        List<Bill> list = null;

        String sqlStr = "select id,billId,menuId,nums,money,tableId,billDate,state from bill where billId = ? and state = ? and tableId = ?";

        list = billDAO.queryMulti(sqlStr, Bill.class, billId, BillState.STATE1, tableId);

        return list;
    }

    /**
     * 查询餐桌 当前所有订单 （餐桌号 和 订餐人 符合的所有订单）
     */
    public List<Bill> queryTableAllOrders(Integer tableId) {
        List<Bill> list = null;

        String sqlStr = "select id,billId,menuId,nums,money,tableId,billDate,state from bill where tableId = ?";

        list = billDAO.queryMulti(sqlStr, Bill.class, tableId);

        return list;
    }

    /**
     * 查询餐桌所有订单 （餐桌号 和 订餐人 符合的所有订单）
     */
    public List<Bill> queryAllOrders() {
        List<Bill> list = null;

        String sqlStr = "select id,billId,menuId,nums,money,tableId,billDate,state from bill";

        list = billDAO.queryMulti(sqlStr, Bill.class);

        return list;
    }



    /**
     * 更新订单状态  未结账 已结账 挂单 现金 支付宝 坏账
     */
    public void updateState(String state,String billId) {
        String sqlStr = "update bill set state = ? where billId = ? and state = ?";

        billDAO.update(sqlStr,state,billId,BillState.STATE1);
    }

    /**
     * 多表查询，有菜名
     */
    public List<MultiTableBill> queryAllOrdersHasName() {
        List<MultiTableBill> list = null;

        String sqlStr = "select bill.*, `name`\n" +
                "\tfrom bill,menu\n" +
                "\twhere bill.menuId = menu.id";

        list = multiTableBill.queryMulti(sqlStr, MultiTableBill.class);

        return list;
    }


}
