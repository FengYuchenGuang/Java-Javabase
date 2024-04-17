package ManHanLou.service;

import ManHanLou.DAO.DiningTableDAO;
import ManHanLou.domain.DiningTable;

import java.util.List;

/**
 * @author hxz
 * 业务层:完成对 DiningTable 的各种操作--通过调用 DiningTableDAO 完成
 */
public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();
    private DiningTable diningTable = new DiningTable();

    /**
     * 查询显示所有点餐状态 返回（一般查到的数据返回业务层去显示）
     *
     * @param
     * @return List<DiningTable>
     **/
    public List<DiningTable> queryState() {
        String sqlStr = "SELECT id,state from diningTable";

        List<DiningTable> list = diningTableDAO.queryMulti(sqlStr, DiningTable.class);
        return list;
    }

    /**
     * 订座，1、查询餐桌状态
     *
     * @return void
     * @param: id
     **/
    public Object queryTableState(Integer id) {
        // 1.首先检查餐桌是否存在
        String sqlStr = "SELECT state FROM diningTable WHERE id = ?";
        Object o = diningTableDAO.queryScalar(sqlStr, id);
        return o;
    }

    /**
     * 订桌:修改 diningTable 表 的状态和订餐人等信息
     *
     * @return boolean
     * @param: id
     * @param: orderName
     * @param: orderPhone
     **/
    public void updateOrder(Integer id, String state, String orderName, String orderPhone) {
        String sqlStr = "update diningTable set state = ?,orderName = ?,orderPhone = ? where id = ?";
        diningTableDAO.update(sqlStr, state, orderName, orderPhone, id);
    }

    /**
     * 订桌:修改 diningTable 表 的状态
     *
     * @return boolean
     * @param: id
     * @param: orderName
     * @param: orderPhone
     **/
    public void updateOrderState(Integer id, String state) {
        String sqlStr = "update diningTable set state = ? where id = ?";
        diningTableDAO.update(sqlStr, state, id);
    }


    /**
     * 清理桌面:修改 diningTable 表 的状态 回 "空"
     *
     * @return boolean
     * @param: id
     * @param: orderName
     * @param: orderPhone
     **/
    public void returnTableState(Integer id) {
        String sqlStr = "update diningTable set state = ? ,orderName = '', orderPhone = '' where id = ?";
        diningTableDAO.update(sqlStr, TableState.STATE1, id);
    }
}
