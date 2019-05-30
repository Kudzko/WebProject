package by.epam.javawebtraining.service.impementations;

import by.epam.javawebtraining.bean.Answer;
import by.epam.javawebtraining.dao.entity.AnswerDAO;
import by.epam.javawebtraining.dao.exception.DAOException;
import by.epam.javawebtraining.service.AbstractService;

import javax.lang.model.element.NestingKind;
import java.sql.Connection;
import java.util.List;

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
            } finally {
                if (answerDAO != null) {
                    connectionPool.returnConnection(answerDAO.releaseConnectionFromDAO());
                }
            }

        }
    }

    public void createAnswer(String answer, boolean right, long
            questionId) {
        AnswerDAO answerDAO = null;
        try {
            answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);
            Connection connection = connectionPool.getConnection();
            answerDAO.setConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace();
        } finally {
            if (answerDAO != null) {
                connectionPool.returnConnection(answerDAO.releaseConnectionFromDAO());
            }
        }
    }

    public List<Answer> getAnswers(Long questionId) {
        List<Answer> answerList = null;
        AnswerDAO answerDAO = null;
        Connection connection = null;
        try {
            answerDAO = (AnswerDAO) factoryDAO.getDAO(AnswerDAO.class);
            connection = connectionPool.getConnection();
            answerDAO.setConnection(connection);
            answerList = answerDAO.getAnswerByFK(questionId);

        } catch (DAOException e) {
            e.printStackTrace();
        }finally {
            if (answerDAO != null){
                connectionPool.returnConnection(answerDAO.releaseConnectionFromDAO());
            }
        }
        return answerList;
    }

    public void update (String[] answers, String[] answerKey, Long questionId){
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
                        answerDAO.update(answer);
                    }
                }
            } catch (DAOException e) {
                e.printStackTrace();
            } finally {
                if (answerDAO != null) {
                    connectionPool.returnConnection(answerDAO.releaseConnectionFromDAO());
                }
            }

        }
    }
}
