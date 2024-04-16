package ManHanLou.service;

import ManHanLou.DAO.EmployeeDAO;
import ManHanLou.domain.Employee;

/**
 * @author hxz
 * 业务层:完成对 Employee 的各种操作--通过调用 EmployeeDAO 完成
 */
public class EmployeeService {
    /**
     * 调用 EmployeeDAO 完成各种操作
     */
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    /**
     * 根据empId和pwd返回一个Employee对象
     * 如果查询不到，就返回空
     *
     * @return com.ManHanLou.domain.Employee
     * @param: empId
     * @param: pwd
     * @author hxz
     **/
    public Employee getEmployeeByEmpidAndPwd(String empId, String pwd) {
        Employee employee = null;

        String sqlStr = "select id,empId,pwd,name,job from employee where empId = ? and pwd = md5(?)";

        employee = employeeDAO.querySingle(sqlStr, Employee.class, empId, pwd);

        return employee;
    }
}
