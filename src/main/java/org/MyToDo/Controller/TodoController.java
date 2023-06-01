package org.MyToDo.Controller;

import org.MyToDo.Model.Todo;
import org.MyToDo.Util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TodoController {
    String INSERT_POST = "INSERT INTO Todo(userId, id, title, completed) VALUES(?,?,?,?)";

    public boolean insertNewTodo(Todo todo) throws Exception {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        try {
            conn = DBUtil.getMySQlConnection();
            preparedStatement = conn.prepareStatement(INSERT_POST);

            preparedStatement.setInt(1, todo.getUserId());
            preparedStatement.setInt(2, todo.getId());
            preparedStatement.setString(3, todo.getTitle());
            preparedStatement.setString(4, todo.getCompleted());

            return ( preparedStatement.executeUpdate() > 0 );

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                preparedStatement.close();
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
        return false;
    }
}
