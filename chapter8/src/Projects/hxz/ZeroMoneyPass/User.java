package Projects.hxz.ZeroMoneyPass;

public class User {
    private String name;
    private long Id; //8位
    private long password; //8位  //后续要求含有数字、大小写字母以及特殊符号

    public User() {
    }

    public User(String name) {
        this.name = name;
    }

    public User(String name, long id, long password) {
        this.name = name;
        Id = id;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }
}
