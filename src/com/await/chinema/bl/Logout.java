package com.await.chinema.bl;

import com.await.chinema.ui.Menu;

public class Logout {
    public static void logout(){
        System.out.println("Ви успiшно вийшли з аккаунту");
        Menu.startMenu();
    }
}
