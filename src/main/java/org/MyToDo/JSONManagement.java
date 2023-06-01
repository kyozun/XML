package org.MyToDo;

import org.MyToDo.Controller.TodoController;
import org.MyToDo.Model.Todo;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class JSONManagement {
    TodoController todoController = new TodoController();

    public void readJSONFromApijsonplaceholder() throws Exception {
        try {
            String apiURL = "https://jsonplaceholder.typicode.com/todos";
            URL url = new URL(apiURL);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            JSONArray JSONArray = new JSONArray(response.toString());
            System.out.println("Inserting.......");
            for (int i = 0; i < JSONArray.length(); i++) {
                JSONObject todo = (JSONObject) JSONArray.get(i);
                Todo newTodo = new Todo(Integer.parseInt(todo.get("userId").toString()), Integer.parseInt(todo.get("id").toString()), todo.get("title").toString(), todo.get("completed").toString());
                todoController.insertNewTodo(newTodo);
            }
            System.out.println("OK");
            System.out.println("====");


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
    }
}



