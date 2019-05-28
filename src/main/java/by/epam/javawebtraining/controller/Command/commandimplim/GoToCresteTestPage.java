package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;

public class GoToCresteTestPage implements Command {
    public static final String NEW_TEST = PageAdressManager
            .getPageAdress("pageadress.new_test");

    @Override
    public String execute(HttpServletRequest request) {
        return NEW_TEST;
    }
}
