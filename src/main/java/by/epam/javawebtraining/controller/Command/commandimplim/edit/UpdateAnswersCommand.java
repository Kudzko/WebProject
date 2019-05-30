package by.epam.javawebtraining.controller.Command.commandimplim.edit;

import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.AnswerService;
import by.epam.javawebtraining.service.impementations.QuestionService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class UpdateAnswersCommand implements Command {
    public static final String QUESTIONS = PageAdressManager
            .getPageAdress("pageadress.edit_test_question_list");

    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");

    @Override
    public String execute(HttpServletRequest request) {
        String[] answers = request.getParameterValues("answer_text");
        String[] right = request.getParameterValues("right_answer");
        Long questionId = Long.parseLong(request.getParameter("question_id"));

        AnswerService answerService = (AnswerService) ServiceFactory.getService(ServiceType.ANSWER_SERVICE);
        answerService.update(answers, right, questionId);

        QuestionService questionService = (QuestionService) ServiceFactory.getService(ServiceType.QUESTION_SERVICE);
        HttpSession session = request.getSession();
        Test currentTest = (Test) session.getAttribute("currentTest");

        session.removeAttribute("questionList");
        session.removeAttribute("answerList");
        request.setAttribute("questionList", questionService
                .getTestQuestionList(currentTest.getId()));


        return QUESTIONS;
    }
}
