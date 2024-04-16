package ManHanLou.domain;

/**
 * @author hxz
 * 	id int primary key auto_increment, -- 自增
 * 	empId varchar(50) not null default '' unique,
 * 	pwd char(32) not null default '', -- 密码MD5
 * 	`name` varchar(50) not null default '',
 * 	sex char(1) not null,
 * 	job VARCHAR(50) NOT NULL DEFAULT '',
 * 	phone varchar(12) NOT NULL
 */
public class EmployeeInfo {
    private Integer id;
    private String empId;
    private String pwd;
    private String name;
    private char sex;
    private String job;
    private String phone;

    /**
     * 这里定义无参构造器用于反射
     *
     */
    public EmployeeInfo() {
    }

    public EmployeeInfo(Integer id, String empId, String pwd, String name,
                        char sex, String job, String phone) {
        this.id = id;
        this.empId = empId;
        this.pwd = pwd;
        this.name = name;
        this.sex = sex;
        this.job = job;
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", job='" + job + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
