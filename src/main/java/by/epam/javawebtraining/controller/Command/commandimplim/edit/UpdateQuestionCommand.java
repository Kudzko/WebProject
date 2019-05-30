package by.epam.javawebtraining.controller.Command.commandimplim.edit;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.AnswerService;
import by.epam.javawebtraining.service.impementations.QuestionService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UpdateQuestionCommand implements Command {
    public static final String EDIT_ANSWERS_PAGE = PageAdressManager
            .getPageAdress("pageadress.edit_test_edit_answers");

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String questionText = request.getParameter("question_text");
        Long questionId = Long.parseLong(request.getParameter("question_id"));
        Test currentTest = (Test) session.getAttribute("currentTest");
        Long currentTestId = currentTest.getId();
        QuestionService questionService = (QuestionService) ServiceFactory.getService(ServiceType.QUESTION_SERVICE);

        questionService.update(questionId, questionText, currentTestId);
        request.setAttribute("question_id",questionId);



        return EDIT_ANSWERS_PAGE;
    }
}
