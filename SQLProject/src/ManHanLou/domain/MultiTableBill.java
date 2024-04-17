package ManHanLou.domain;

import java.util.Date;

/**
 * @author hxz
 */
public class MultiTableBill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer tableId;
    private Date billDate;
    private String state;
    //多表查询，菜单表的菜名
    private String name;

    public MultiTableBill() {
    }

    public MultiTableBill(Integer id, String billId, Integer menuId, Integer nums,
                          Double money, Integer tableId, Date billDate,
                          String state, String name) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.tableId = tableId;
        this.billDate = billDate;
        this.state = state;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t" + billId +
                "\t\t" + menuId +
                "\t\t\t" + name +
                "\t\t" + nums +
                "\t\t" + money +
                "\t\t" + tableId +
                "\t\t" + billDate +
                "\t\t" + state;
    }
}
