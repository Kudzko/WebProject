package by.epam.javawebtraining.controller.Command.commandimplim;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.TestService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;

public class DeleteTestCommand implements Command {
    public static final String CURRENT_PAGE = PageAdressManager
            .getPageAdress("pageadress.tutor_main");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");


    public String execute(HttpServletRequest request) {
        Test currentTest = (Test) request.getAttribute("currentTest");
        TestService testService = (TestService) ServiceFactory.getService(ServiceType.TEST_SERVICE);
        testService.deleteTest(currentTest);
        return null;
    }
}
