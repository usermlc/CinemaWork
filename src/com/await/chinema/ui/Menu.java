package com.await.chinema.ui;

import com.await.chinema.bl.*;
import com.await.chinema.da.ResponseFunctionality;

import java.util.Scanner;

public class Menu {
    public static void startMenu() {
        int menuChoice = 0;
        Scanner choice = new Scanner(System.in);
        do {
            System.out.println();
            System.out.println("Вiтаємо в книзі відгуків кінотеатра");
            System.out.println("Щоб додати відгук авторизуйтесь, або створіть аккаунт");
            System.out.println("[1] Авторизацiя");
            System.out.println("[2] Реєстрацiя");
            System.out.println("[3] Перегляд книги вігуків");
            System.out.println("[4] Вихiд");
            menuChoice = choice.nextInt();
            switch (menuChoice) {
                case 1:
                    Authorization.authorization();
                    break;
                case 2:
                    Registration.registration();
                    break;
                case 3:
                    try {
                        ResponseFunctionality.viewResponseList();
                    }
                    catch (Exception e){
                        System.out.println("Помилка, файл пустий");
                    }
                    break;
                case 4:
                    System.out.println("Дякуємо що скористалися нашими послугами");
                    System.exit(4);
                    break;
            }
            if(menuChoice > 4){
                System.out.println();
                System.out.println("Введено хибнi данi");
            }
        }while (menuChoice != 4) ;
    }

    public static void menuMain(String userName){
        int mainMenu;
        Scanner mainInput = new Scanner(System.in);
        do{
            System.out.println();
            System.out.println("Вiтаємо в книзі вігуків кінотеатра."
                    + "\t" + " Ви авторизувалися як: " + userName);
            System.out.println("[1] Переглянути книги відгуків");
            System.out.println("[2] Додати відгук");
            System.out.println("[3] Редагувати відгук");
            System.out.println("[4] Видалити відгук");
            System.out.println("[5] Вийти з аккаунту");
            System.out.println("[6] Вихiд");
            mainMenu = mainInput.nextInt();
            switch (mainMenu){
                case 1:
                    try {
                    ResponseFunctionality.viewResponseList();
                    }
                    catch (Exception e){
                    System.out.println("Помилка, файл пустий");
                    }
                    break;
                case 2:
                    ResponseFunctionality.createResponse(userName);
                    break;
                case 3:
                    ResponseFunctionality.editCategory(userName);
                    break;
                case 4:
                    ResponseFunctionality.deleteCategory(userName);
                    break;
                case 5:
                    Logout.logout();
                    break;
                case 6:
                    System.out.println("Дякуємо що скористалися нашими послугами");
                    System.exit(7);
                    break;
            }
            if(mainMenu > 6){
                System.out.println();
                System.out.println("Введено хибнi данi");
            }
        }while (mainMenu != 6);
    }
}
