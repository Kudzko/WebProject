package by.epam.javawebtraining.controller.Command.commandimplim.create;

import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.bean.Test;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.QuestionService;
import by.epam.javawebtraining.utils.InputChecker;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CreateQuestionCommand implements Command {
    public static final String CREATE_ANSWERS_PAGE = PageAdressManager
            .getPageAdress("pageadress.new_test_create_answers");
    public static final String DEFAULTERRRORPAGE = PageAdressManager.getPageAdress("pageadress.defaulterrrorpage");


    @Override
    public String execute(HttpServletRequest request) {
        String questionText = request.getParameter("question_text");
        String answersAmount = request.getParameter ("answers_amount");
        HttpSession session = request.getSession();
        Test test = (Test) session.getAttribute("currentTest");


        QuestionService questionService = (QuestionService) ServiceFactory.getService
                (ServiceType.QUESTION_SERVICE);
        Question question = questionService.createQuestion(questionText,
                test.getId());

        request.setAttribute("newquestion_id", question.getId());

        InputChecker checker = InputChecker.getInstance();
        if (checker.isNumber(answersAmount)) {
            Integer answersAm = Integer.parseInt(answersAmount);
            request.setAttribute("answers_amount", answersAm);
        }else {
            request.setAttribute("wrong_number_answers","Error. Check number " +
                    "of questions. It is not a digit");
        }
        return CREATE_ANSWERS_PAGE;
    }
}
