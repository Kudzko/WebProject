package by.epam.javawebtraining.controller.Command.commandimplim.create;

import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;

public class AddQuestionCommand implements Command {
    public static final String CREATE_QUESTION_PAGE = PageAdressManager
            .getPageAdress("pageadress.new_test_create_question");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");

    @Override
    public String execute(HttpServletRequest request) {
//       String testId =  request.getParameter("newtest_id");
//       request.setAttribute("newtest_id", testId);
        return CREATE_QUESTION_PAGE;
    }
}
