package by.epam.javawebtraining.controller.Command.commandimplim.edit;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.QuestionService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class DeleteQuestionCommand implements Command {
    public static final String QUESTIONS_PAGE = PageAdressManager
            .getPageAdress("pageadress.edit_test_question_list");

    @Override
    public String execute(HttpServletRequest request) {
        Long questionId = Long.parseLong(request.getParameter("question_id"));

        QuestionService questionService = (QuestionService) ServiceFactory.getService
                (ServiceType.QUESTION_SERVICE);

        questionService.delete(questionId);

        HttpSession session = request.getSession();
        Test currentTest = (Test) session.getAttribute("currentTest");
        request.setAttribute("questionlist", questionService
                .getTestQuestionList(currentTest.getId()));

        return QUESTIONS_PAGE;
    }
}
