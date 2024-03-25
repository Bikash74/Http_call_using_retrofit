package org.example;


import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

import java.io.IOException;
import retrofit2.converter.gson.GsonConverterFactory;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException{
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("https://jsonplaceholder.typicode.com/todos/1")
//                .build();
//        try (Response response = client.newCall(request).execute()) {
//            System.out.println(response.body().string());
//        }
//        catch(IOException ex){
//            ex.printStackTrace();
//        }
        // GsonConverterFactory = null;
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TodoService service = retrofit.create(TodoService.class);
        try {
            Call<Todo> todo = service.getTodoById("1");
            Response<Todo> response = todo.execute();

            if (response.isSuccessful()) {
                System.out.println(response.body());
            }
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}