package by.epam.javawebtraining.controller.Command.commandimplim.edit;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class EditTestCommand implements Command {
    public static final String EDIT_PAGE = PageAdressManager
            .getPageAdress("pageadress.edit_test");

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Test test =(Test) session.getAttribute("currentTest");

        session.setAttribute("state","edit" );

        request.setAttribute("test_theme",test.getTestTheme());
        request.setAttribute("test_name",test.getTestName());

        return EDIT_PAGE;
    }
}
