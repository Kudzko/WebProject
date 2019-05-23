package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.bean.TestTheme;
import by.epam.javawebtraining.configurationclasses.PageAdressManager;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.TestService;
import by.epam.javawebtraining.service.impementations.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ChooseTestThemeCommand implements Command {
    public static final String CURRENT_PAGE = PageAdressManager.getPageAdress("pageadress.tutor_main");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");


    @Override
    public String execute(HttpServletRequest request) {
        TestService testService = (TestService) ServiceFactory.getService
                (ServiceType.TEST_SERVICE);
        Long themeId = Long.parseLong(request.getParameter("test_theme"));
        List<Test> tests = testService.getTestByThemeId(themeId);
        request.setAttribute("testList", tests);
        return CURRENT_PAGE;
    }
}
