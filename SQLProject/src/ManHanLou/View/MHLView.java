package ManHanLou.View;

import ManHanLou.DAO.MultiTableBillDAO;
import ManHanLou.domain.*;
import ManHanLou.service.*;
import ManHanLou.utils.Utility;

import java.util.List;


/**
 * @author hxz
 */
public class MHLView {
    /**
     * 一级菜单的循环控制变量
     */
    private boolean firstMenuloop = true;
    /**
     * 一级菜单接收用户的输入
     */
    private String key;

    /**
     * 操作employee表
     */
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();
//    private EmployeeInfoService employeeInfoService = new EmployeeInfoService();

    public void showFirstMenu() {
        while (firstMenuloop) {
            System.out.println("\n===========满汉楼==========");
            System.out.println("\t\t1.登录满汉楼");
            System.out.println("\t\t2.退出满汉楼");
            System.out.print("请输入你的选择:");
            key = Utility.readString(1);

            if ("1".equals(key)) {
                /**
                 * 二级菜单的循环控制变量
                 */
                System.out.print("请输入员工号:");
                String empId = Utility.readString(50);
                System.out.print("请输入密  码:");
                String pwd = Utility.readString(50);

                if (VerifyLogin(empId, pwd)) {
                    boolean secondMenuloop = true;
                    while (secondMenuloop) {
                        System.out.println("\n===========满汉楼二级菜单==========");
                        System.out.println("\t\t1.显示餐桌状态");
                        System.out.println("\t\t2.预定餐桌");
                        System.out.println("\t\t3.显示所有菜品");
                        System.out.println("\t\t4.点餐服务");
                        System.out.println("\t\t5.查看账单");
                        System.out.println("\t\t6.结账");
                        System.out.println("\t\t7.多表联合查询");
                        System.out.println("\t\t8.人事管理");
                        System.out.println("\t\t9.退出满汉楼");
                        System.out.println("请输入你的选择:");
                        key = Utility.readString(1);

                        switch (key) {
                            case "1":
                                System.out.println("====1.显示餐桌状态====");
                                TableState();
                                System.out.println("====显示完毕====");
                                break;
                            case "2":
                                System.out.println("====2.预定餐桌====");
                                OrderTable();
                                break;
                            case "3":
                                System.out.println("====3.显示所有菜品====");
                                ShowMenu();
                                break;
                            case "4":
                                System.out.println("====4.点餐服务====");
                                OrderMenu();
                                break;
                            case "5":
                                System.out.println("====5.查看账单====");
                                ShowBill();
                                break;
                            case "6":
                                System.out.println("====6.结账服务====");
                                PayBills();
                                break;
                            case "7":
                                System.out.println("====7.多表联合查询====");
                                MultiQuery();
                                break;
                            case "8":
                                System.out.println("====7.人事管理====");
                                break;
                            case "9":
                                secondMenuloop = false;
                                firstMenuloop = false;
                                System.out.println("退出满汉楼系统!");
                                break;
                            default:
                                System.out.println("输入有误,请重新输入");
                        }
                    } // while

                } else {
                    System.out.println("---登录失败---");
                }

            } else if ("2".equals(key)) {
                firstMenuloop = false;
                System.out.println("退出满汉楼系统!");
            } else {
                System.out.println("输入有误，请重新输入");
            }
        }
    }

    /**
     * 验证登录名和密码
     *
     * @param
     * @return boolean
     * @param: empId
     * @param: pwd
     * @author hxz
     **/
    public boolean VerifyLogin(String empId, String pwd) {
        Employee employee = employeeService.getEmployeeByEmpidAndPwd(empId, pwd);
        if (null == employee) {
            return false;
        } else {
            System.out.println("---登录成功:" + employee.getName() + "---");
            return true;
        }
    }

    /**
     * 查询所有餐桌的状态
     */
    public void TableState() {
        System.out.println("餐桌编号\t\t餐桌状态");
        List<DiningTable> diningTables = diningTableService.queryState();
        for (DiningTable table : diningTables) {
//            System.out.println(table);
            System.out.println(table.getId() + "\t\t     " + table.getState());
        }
    }

    /**
     * 预定餐桌
     */
    public void OrderTable() {
        System.out.print("请选择要预定餐桌编号(-1)退出：");
        int i = Utility.readInt();
        //查询是否存在该餐桌
        String table = (String) diningTableService.queryTableState(i);

        if (i == -1) {
            System.out.println("退出预定~~~");
            return;
        } else if (table == null) {
            System.out.println("餐桌不存在~~~");
            return;
        } else if (!(TableState.STATE1.equals(table))) {
            System.out.println("餐桌不处于闲置状态~~~");
            return;
        }

        System.out.print("确认是否预定(Y/N)：");
        char c = Utility.readConfirmSelection();
        if ("N".equals(c)) {
            System.out.println("退出预定~~~");
            return;
        }

        System.out.print("预定人姓名：");
        String orderName = Utility.readString(50);
        System.out.print("预定人电话：");
        String orderPhone = Utility.readString(12);

        //保存预定信息
        diningTableService.updateOrder(i, TableState.STATE2, orderName, orderPhone);

        System.out.println("预定成功~~~");
    }

    /**
     * 显示菜谱
     */
    public void ShowMenu() {
        System.out.println("菜品编号\t菜名\t\t\t菜品类型\t\t价格");
        List<Menu> menuList = menuService.MenuList();
        for (Menu menu : menuList) {
//            System.out.println(menu);
            System.out.println(menu.getId() + "\t\t" + menu.getName() + "\t\t" + menu.getType() + "\t\t\t" + menu.getPrice());
        }
    }

    /**
     * 点餐
     */
    public void OrderMenu() {
        Integer tableId;
        String tableState;
        Integer menuId;
        Integer nums;
        String billId;
        int rows = 0;
        while (true) {
            System.out.print("请选择点餐的桌号(-1退出)：");
            tableId = Utility.readInt();
            if (-1 == tableId) {
                break;
            }
            tableState = (String) diningTableService.queryTableState(tableId);

            if (null == tableState) {
                System.out.println("输入的餐桌编号:" + tableId + "不存在");
            } else {

                System.out.print("请选择要菜品编号(-1退出)：");
                menuId = Utility.readInt();
                if (-1 == menuId) {
                    System.out.println("在菜品编号时取消~~~");
                    break;
                }
                Integer id = (Integer) menuService.queryMenuID(menuId);
                if (null == id) {
                    System.out.println("输入的菜品编号:" + menuId + "不存在");
                    continue;
                } else {
                    menuId = id;
                    System.out.print("请选择要菜品数量(-1退出)：");
                    nums = Utility.readInt();
                    if (-1 == nums) {
                        System.out.println("在菜品数量时取消~~~");
                        break;
                    }
                    if (nums <= 0) {
                        System.out.println("输入的菜品数量:" + nums + "不符合规范");
                        continue;
                    } else {
                        System.out.print("确认是否点这个菜(Y/N)：");
                        char choose = Utility.readConfirmSelection();

                        if ('Y' == choose) {
                            //获取该菜价格
                            Double price = (Double) menuService.queryMenuPrice(menuId);

                            //查询餐桌状态
                            //1、"空" 或 "已预订" 状态 下生产新的订单号
                            //2、"用餐中" 状态下 得到当前餐桌订单号，进行加菜
                            if (TableState.STATE3.equals(tableState)) {
        //=========================================================
                                //最近的一次点餐记录里的 订单号一定是当前账单订单号
                                billId = (String) billService.getBillIdLast(tableId);
                                rows = billService.AddMenu(billId, menuId, price, nums, tableId, BillState.STATE1);
                                System.out.println("点餐结果 = " + rows);
                            } else {
                                // 修改餐桌状态
                                diningTableService.updateOrderState(tableId, TableState.STATE3);
                                rows = billService.startOrderMenu(menuId, price, nums, tableId, BillState.STATE1);
                                System.out.println("点餐结果 = " + rows);
                            }
                            System.out.println("=====点餐成功=====");
                        }
                    } // nums else
                } // Menuid else
            } // DiningTableState else
        } // while
    }

    /**
     * 显示订单
     * 1、指定餐桌未支付订单
     * 2、指定餐桌所有订单
     * 3、所有订单
     */
    public void ShowBill() {
        System.out.print("请选择你要查看的订单类型(-1退出)：\n1、餐桌未支付账单" +
                "\n2、餐桌所有账单\n3、所有账单\n");
        int i = Utility.readInt();
        if (i <= 0 || i > 3) {
            System.out.println("账单选择出错（1~3）");
            return;
        }

        if (i == 1) {
            System.out.print("请选择你要查看的未支付账单餐桌编号(-1退出)：");
            Integer tableId = Utility.readInt();
            //检测餐桌状态 "用餐中"

            //查看账单
            System.out.println("订单编号\t\t\t账单编号\t\t\t\t\t\t\t\t菜品编号\t\t\t数量" +
                    "\t\t价格\t\t\t餐桌编号\t\t\t订单日期\t\t\t\t账单状态");
            String billId = (String) billService.getBillId(tableId, BillState.STATE1);
            List<Bill> bills = billService.queryTableUnpaidOrders(billId, tableId);
            for (Bill bill : bills) {
                System.out.println(bill);
            }

        } else if (i == 2) {
            System.out.print("请选择你要查看的餐桌编号(-1退出)：");
            Integer tableId = Utility.readInt();
            //检测餐桌状态 "用餐中"

            //查看账单
            System.out.println("订单编号\t\t\t账单编号\t\t\t\t\t\t\t\t菜品编号\t\t\t数量" +
                    "\t\t价格\t\t\t餐桌编号\t\t\t订单日期\t\t\t\t账单状态");
            List<Bill> bills = billService.queryTableAllOrders(tableId);
            for (Bill bill : bills) {
                System.out.println(bill);
            }
        } else if (i == 3) {
            System.out.println("=====查看所有账单：=====");
            System.out.println("订单编号\t\t\t账单编号\t\t\t\t\t\t\t\t菜品编号\t\t\t数量" +
                    "\t\t价格\t\t\t餐桌编号\t\t\t订单日期\t\t\t\t账单状态");
            List<Bill> bills = billService.queryAllOrders();
            for (Bill bill : bills) {
                System.out.println(bill);
            }
        }
    }

    /**
     * 支付账单
     */
    public void PayBills() {
        System.out.print("请选择你要支付的餐桌编号(-1退出)：");
        Integer tableId = Utility.readInt();
        //检测餐桌状态 "用餐中" 有 "未支付" 账单 才能支付
        String tableState = (String) diningTableService.queryTableState(tableId);

        if (TableState.STATE3.equals(tableState)) {
            String billId = (String) billService.getBillId(tableId, BillState.STATE1);
            List<Bill> bills = billService.queryTableUnpaidOrders(billId, tableId);
            if (bills == null) {
                System.out.println("所有账单已支付~~~");
            }
            //结账
            System.out.println("请选择支付类型(1.其他 2.现金 3.支付宝 4.微信 5.银行卡 6.挂单)：");
            char pay = Utility.readPay();

            //计算结账金额
            Double payMoney = payMoney(bills);

            switch (pay) {
                case '1':
                    //支付账单后 改变状态
                    billService.updateState(BillState.STATE2, billId);
                    break;
                case '2':
                    //支付账单后 改变状态
                    billService.updateState(BillState.STATE4, billId);
                    break;
                case '3':
                    //支付账单后 改变状态
                    billService.updateState(BillState.STATE5, billId);
                    break;
                case '4':
                    //支付账单后 改变状态
                    billService.updateState(BillState.STATE6, billId);
                    break;
                case '5':
                    //支付账单后 改变状态
                    billService.updateState(BillState.STATE7, billId);
                    break;
                case '6':
                    //支付账单后 改变状态
                    billService.updateState(BillState.STATE3, billId);
                    break;
            }
            System.out.println("账单支付完成，一共支付 " + payMoney + " 元~~~");
            //结账完毕，询问是否结束就餐，是的话清理餐桌
            System.out.println("是否结束就餐(Y/N)：");
            char selection = Utility.readConfirmSelection();
            if ('Y' == selection){
                diningTableService.returnTableState(tableId);
            }

        }
    }

    /**
     * 计算结账金额 6.结账中子功能
     */
    public Double payMoney(List<Bill> list) {
        Double money = 0.0;
        for (Bill bill : list) {
            money += bill.getMoney();
        }
        return money;
    }

    /**
     * 多表联合查询 账单
     */
    public void MultiQuery(){
        System.out.println("订单编号\t\t\t账单编号\t\t\t\t\t\t\t\t菜品编号\t\t菜名\t\t\t数量" +
                "\t\t价格\t\t\t餐桌编号\t\t\t订单日期\t\t\t\t账单状态");
        List<MultiTableBill> multiTableBills = billService.queryAllOrdersHasName();
        for (MultiTableBill multiTableBill : multiTableBills) {
            System.out.println(multiTableBill);
        }
    }


    public static void main(String[] args) {
        new MHLView().showFirstMenu();
    }
}
