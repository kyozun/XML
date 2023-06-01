package org.MyToDo.Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    public static Connection getMySQlConnection() throws Exception {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://LAPTOP-5GA3GV2H\\SQLEXPRESS;database=TodoList;encrypt=true;trustServerCertificate=true","cuong","123456");
            return connection;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
