package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.dao.FactoryDAO;
import by.epam.javawebtraining.dao.entity.AnswerDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;

import java.sql.Connection;

public class AnswerService extends AbstractService {

    public void createAnswers(String[] answers, String[] answerKey, long
            questionId) {
        if ((answers != null) && (answerKey != null)) {

            AnswerDAO answerDAO = null;
            Connection connection = connectionPool.getConnection();

            try {
                answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);
                answerDAO.setConnection(connection);
                for (int i = 0; i < answers.length; i++) {
                    if (validator.isThereText(answers[i])) {
                        Answer answer = new Answer();
                        answer.setAnswerText(answers[i]);
                        answer.setRight(false);
                        answer.setQuestoinID(questionId);

                        int j = 0;
                        while (j < answerKey.length) {
                            if (Integer.parseInt(answerKey[j]) == i) {
                                answer.setRight(true);
                                break;
                            }
                            j++;
                        }
                        answerDAO.persist(answer);
                    }
                }
            } catch (DAOException e) {
                e.printStackTrace();
            }finally {
                if (answerDAO != null){
                 connectionPool.returnConnection( answerDAO.relizeConnectionFromDAO());
                }
            }

        }
    }

    public void createAnswer(String answer, boolean right, long
            questionId) {
        AnswerDAO answerDAO;
        try {
            answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);
            Connection connection = connectionPool.getConnection();
            answerDAO.setConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace();
        }
    }
}
