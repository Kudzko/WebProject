package by.epam.javawebtraining.utils;

import java.util.ResourceBundle;

public class PageAdressManager {
    private static final ResourceBundle resourceBundle = ResourceBundle
            .getBundle("page" +
                    "Adress");
    private PageAdressManager(){

    }

    public static String getPageAdress(String key){
        return resourceBundle.getString(key);
    }
}
