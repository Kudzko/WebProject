package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.utils.PageAdressManager;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.utils.TestBuilder;

import javax.servlet.http.HttpServletRequest;

public class LookThroughTestCommand implements Command {
    public static final String TEST_CONTENT = PageAdressManager
            .getPageAdress("pageadress.tutor_test_content");

    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");
    @Override
    public String execute(HttpServletRequest request) {
        long idTest = Long.parseLong(request.getParameter("test_id"));
        TestBuilder testBuilder = TestBuilder.getInstance();
        Test test = testBuilder.buildTest(idTest);
        request.setAttribute("whole_test", test);
        return TEST_CONTENT;
    }
}
