package com.await.chinema.da.dao;

import com.google.gson.Gson;
import com.await.chinema.bl.Json;
import com.await.chinema.da.entity.Response;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;
public class ResponseDao implements Dao<Response> {

    private List<Response> responsList;

    public ResponseDao(){
        responsList = Json.jsonResponseList();
    }

    @Override
    public Optional<Response> get(int id) {
        return Optional.empty();
    }
    @Override
    public List<Response> getAll() {
        return responsList;
    }

    Path path = Path.of("resource","ResponseList.json");

    public void saveResponse(Response response){
        responsList.add(response);
        Gson gson = new Gson();
        String jsonForResponse = gson.toJson(responsList);
        try{
            Json.writeString(path, jsonForResponse);
        }
        catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public void updateResponse(Response response, int userChoice){
        responsList.set(userChoice, response);
        Gson gson = new Gson();
        String jsonForResponse = gson.toJson(responsList);
        try{
            Json.writeString(path, jsonForResponse);
        }
        catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }

    public void deleteCategory(int userChoice) {
        Path path = Path.of("resource","ResponseList.json");
        responsList.remove(userChoice);
        Gson gson = new Gson();
        String jsonForResponse = gson.toJson(responsList);
        try{
            Json.writeString(path, jsonForResponse);
        }
        catch (IOException e){
            System.out.println("Помилка: " + e.getMessage());
        }
    }
}
