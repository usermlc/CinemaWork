package com.await.chinema.da;

import com.await.chinema.bl.Json;
import com.await.chinema.da.dao.ResponseDao;
import com.await.chinema.da.entity.Response;
import com.await.chinema.ui.Menu;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ResponseFunctionality {

    static ResponseDao responseDao = new ResponseDao();

    public static void viewResponseList(){
        List<Response> responseList = responseDao.getAll();
        try{
            if(responseList.isEmpty()){
                throw new IOException();
            }
            for (int i = 0; i < responseList.size(); i++){
                System.out.println("[" + i  + "]" + ". Користувач: " + responseList.get(i).getNameUser() + "\n Відгук: "
                        + responseList.get(i).getResponse());
            }
        }catch (IOException e){
            System.out.println("Виникла помилка список пустий");
        }
    }

    public static void createResponse(String userName){
        try {
            System.out.println("Залиште свій відгук: ");
            Scanner responseWrite = new Scanner(System.in);
            String response = responseWrite.nextLine();

            Response newResponse = new Response(userName, response);
            responseDao.saveResponse(newResponse);
            System.out.println("Відгук додано");

        }catch (Exception e){
            System.out.println("Виникла помилка");
        }
    }

    public static void editCategory(String userName) {
        while (true) {
            try {
                viewResponseList();
            } catch (Exception e) {
                System.out.println("Файл не знайдено");
                break;
            }
            try {
                System.out.println("Оберiть номер відгука: ");

                Scanner chooseInputCategory = new Scanner(System.in);
                int userChoose = chooseInputCategory.nextInt();

                String numberNameUser = Json.jsonResponseList().get(userChoose).getNameUser();

                if(!Objects.equals(userName, numberNameUser)){
                    System.out.println("Цей відгук не належить вам, ви не можете його змінювати. \n");
                    Menu.menuMain(userName);
                }else {
                    System.out.println("Введiть новий відгук: ");
                    Scanner responseWrite = new Scanner(System.in);

                    String response = responseWrite.nextLine();

                    Response newResponse = new Response(userName, response);
                    responseDao.updateResponse(newResponse, userChoose);

                    System.out.println("Відгук відредагований");
                    break;
                }
            }catch (Exception e){
                System.out.println("Помилка, спробуйте ще раз");
                break;
            }
        }
    }

    public static void deleteCategory(String userName){
        while (true) {
            try {
                viewResponseList();
            }
            catch (Exception e){
                System.out.println("Помилка, файл пустий");
                break;
            }
            System.out.println("Оберiть номер відгука: ");

            Scanner chooseInputCategory = new Scanner(System.in);
            int userChoose = chooseInputCategory.nextInt();

            String numberNameUser = Json.jsonResponseList().get(userChoose).getNameUser();

            if(!Objects.equals(userName, numberNameUser)){
                System.out.println("Цей відгук не належить вам, ви не можете його видалити. \n");
                Menu.menuMain(userName);
            }else {
                try {
                    responseDao.deleteCategory(userChoose);
                    System.out.println("Категорiя видалена");
                    break;
                } catch (Exception e) {
                    System.out.println("Помилка, спробуйте ще раз");
                    break;
                }
            }
        }
    }
}
