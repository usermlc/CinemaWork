package com.await.chinema.bl;

import com.google.gson.Gson;
import com.await.chinema.da.entity.Response;
import com.await.chinema.da.entity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Json {
    static Gson gson = new Gson();

    public static String readString(Path path) throws IOException {
        return Files.readString(path);
    }

    public static void writeString(Path path, String data) throws IOException {
        Files.writeString(path, data, StandardOpenOption.TRUNCATE_EXISTING,
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);
    }

    private static String responseToJson(){
        Response response = new Response("Admin","У вас дуже крутий кінотеатр.");
        Gson gson = new Gson();
        List<Response> responseList = new ArrayList<>();
        responseList.add(response);
        return gson.toJson(responseList);
    }

    public static List<Response> jsonResponseList(){
        Path pathToFile = Path.of("resource", "ResponseList.json");
        String jsonToArray = null;
        try {
            if(readString(pathToFile).length() == 0){
                writeString(pathToFile, responseToJson());
            }
            jsonToArray = readString(pathToFile);
        }
        catch (IOException e){
            System.out.println("Error is: " + e.getMessage());
        }
        Response[] categories = gson.fromJson(jsonToArray, Response[].class);
        return new ArrayList<>(Arrays.asList(categories));
    }

    public static List<User> jsonUserList(){
        Path pathToFile = Path.of("resource", "User.json");
        String jsonToArray = null;
        try {
            if(readString(pathToFile).length() == 0){
                writeString(pathToFile, responseToJson());
            }
            jsonToArray = readString(pathToFile);
        }
        catch (IOException e){
            System.out.println("Error is: " + e.getMessage());
        }
        User[] users = gson.fromJson(jsonToArray, User[].class);
        return new ArrayList<>(Arrays.asList(users));
    }

    public static void userAdd(List<User> userList){
        Path pathToFile = Path.of("resource", "User.json");
        Gson gson = new Gson();
        String usersToStr = gson.toJson(userList);
        try {
            writeString(pathToFile, usersToStr);
        }
        catch (IOException e){
            System.out.println("Помилка" + e.getMessage());
        }
    }
}
