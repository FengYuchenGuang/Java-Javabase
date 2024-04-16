package ManHanLou.service;

import ManHanLou.DAO.MenuDAO;
import ManHanLou.domain.Menu;

import java.util.List;

/**
 * @author hxz
 * 业务层:完成对 Menu 的各种操作--通过调用 MenuDAO 完成
 */
public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();

    /**
     * 返回菜谱，所有菜的信息
     */
    public List<Menu> MenuList(){
        List<Menu> list = null;

        String sqlStr = "SELECT * FROM menu";

        list = menuDAO.queryMulti(sqlStr, Menu.class);

        return list;
    }

    /**
     * 查询菜品 id
     * 用于判断是否存在
     */
    public Object queryMenuID(Integer menuId){
        String sqlStr = "SELECT id FROM menu where id = ?";

        return menuDAO.queryScalar(sqlStr,menuId);
    }

    /**
     * 获取菜品价格 id
     * 用于判断是否存在
     */
    public Object queryMenuPrice(Integer menuId){
        String sqlStr = "SELECT price FROM menu where id = ?";

        return menuDAO.queryScalar(sqlStr,menuId);
    }

}
