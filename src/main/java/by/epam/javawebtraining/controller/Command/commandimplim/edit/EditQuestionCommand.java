package by.epam.javawebtraining.controller.Command.commandimplim.edit;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.bean.Question;
import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.service.ServiceFactory;
import by.epam.javawebtraining.service.ServiceType;
import by.epam.javawebtraining.service.impementations.AnswerService;
import by.epam.javawebtraining.service.impementations.QuestionService;
import by.epam.javawebtraining.utils.PageAdressManager;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class EditQuestionCommand implements Command {
    public static final String EDIT_QUESTION_PAGE = PageAdressManager
            .getPageAdress("pageadress.edit_test_edit_question");

    @Override
    public String execute(HttpServletRequest request) {
        Long questionId = Long.parseLong(request.getParameter("question_id"));
        request.setAttribute("question_id", questionId);

        QuestionService questionService = (QuestionService) ServiceFactory.getService
                (ServiceType
                        .QUESTION_SERVICE);
        Question currentQuestion = questionService.getByPK(questionId);
        AnswerService answerService = (AnswerService) ServiceFactory.getService(ServiceType
                .ANSWER_SERVICE);
        List<Answer> answerList = answerService.getAnswers(questionId);
        HttpSession session = request.getSession();

        session.setAttribute("answerList", answerList);
        session.setAttribute("currentQuestion", currentQuestion);

        return EDIT_QUESTION_PAGE;
    }
}
