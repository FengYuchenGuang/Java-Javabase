package ManHanLou.domain;

/**
 * @author hxz
 * 餐桌表
 * 	id int primary key auto_increment, -- 自增 餐桌编号
 * 	state varchar(20) not null default '', -- 餐桌状态
 * 	orderName varchar(50) not null default '', -- 预定人名字
 * 	orderPhone varchar(12) not null default '' -- 预定人电话
 */
public class DiningTable {
    private Integer id;
    private String state;
    private String orderName;
    private String orderPhone;

    public DiningTable() {
    }

    public DiningTable(Integer id, String state, String orderName, String orderPhone) {
        this.id = id;
        this.state = state;
        this.orderName = orderName;
        this.orderPhone = orderPhone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderPhone() {
        return orderPhone;
    }

    public void setOrderPhone(String orderPhone) {
        this.orderPhone = orderPhone;
    }

    @Override
    public String toString() {
        return "DiningTable{" +
                "id=" + id +
                ", state='" + state + '\'' +
                ", orderName='" + orderName + '\'' +
                ", orderPhone='" + orderPhone + '\'' +
                '}';
    }
}
