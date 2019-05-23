package by.epam.javawebtraining.dao;

public class DBProperty {

    private DBProperty() {
    }

    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL
            = "jdbc:mysql://127.0.0.1:3306/testingproject?characterEncoding" +
            "=UTF-8&serverTimezone=UTC";
    public static final String USER_DB = "root";
    public static final String PASS_DB = "mysqlpass";
    public static final int AMOUNT_CONNECTIONS = 10;


   /* public static final String DB_URL ="jdbc:mysql://127.0.0.1:3306/testingproject" +
            "?verifyServerCertificate=false" +
            "&useSSL=false" +
            "&requireSSL=false" +
            "&useLegacyDatetimeCode=false" +
            "&amp" +
            "&serverTimezone=UTC";*/


}
