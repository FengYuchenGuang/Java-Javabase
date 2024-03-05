package hxz.interface_;

public class Interface03 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        t(mysqlDB);

        System.out.println("=======================");
        OracleDB oracleDB = new OracleDB();
        t(oracleDB);
    }

    public static void t(Inter03 db) {
        db.connect();
        db.close();
    }
}
