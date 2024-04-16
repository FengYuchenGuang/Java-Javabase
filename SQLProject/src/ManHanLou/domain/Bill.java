package ManHanLou.domain;

import java.util.Date;

/**
 * @author hxz
 * 	id int primary key auto_increment, -- 自增 作为账单编号
 * 	billId varchar(50) not null default '',
 * 	menuId int not null, -- 菜谱编号
 * 	nums int not null DEFAULT 0, -- 菜品数量
 * 	money double not null default 0, -- 价格
 * 	tableId int not null default 0, -- 桌号
 * 	billDate datetime not null, -- 账单日期
 * 	state varchar(50) not null default '' -- 账单状态 未结账 已结账 挂单
 */
public class Bill {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer tableId;
    private Date billDate;
    private String state;

    public Bill() {
    }

    public Bill(Integer id, String billId, Integer menuId, Integer nums,
                Double money, Integer tableId, Date billDate, String state) {
        this.id = id;
        this.billId = billId;
        this.menuId = menuId;
        this.nums = nums;
        this.money = money;
        this.tableId = tableId;
        this.billDate = billDate;
        this.state = state;
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
        return "Bill{" +
                "id=" + id +
                ", billId='" + billId + '\'' +
                ", menuId=" + menuId +
                ", nums=" + nums +
                ", money=" + money +
                ", tableId=" + tableId +
                ", billDate=" + billDate +
                ", state='" + state + '\'' +
                '}';
    }
}
