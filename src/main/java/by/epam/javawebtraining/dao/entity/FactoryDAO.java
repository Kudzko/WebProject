package by.epam.javawebtraining.dao.entity;

public class FactoryDAO {
    private static final FactoryDAO factoryDAO = new FactoryDAO();
    private final UserDAO userDAO = new UserDAO();
    private final TestDAO testDAO = new TestDAO();
    private final ResultDAO resultDAO = new ResultDAO();
    private final QustionDAO qustionDAO = new QustionDAO();
    private final AnswerDAO answerDAO = new AnswerDAO();


    private FactoryDAO() {
    }

    public static FactoryDAO getInstance(){
        return factoryDAO;
    }

    public UserDAO getUserDAO(){
        return userDAO;
    }

    public TestDAO getTestDAO(){
        return testDAO;
    }

    public ResultDAO getResultDAO(){
        return resultDAO;
    }
    public QustionDAO getQustionDAO(){
        return qustionDAO;
    }
    public AnswerDAO getAnswerDAO(){
        return answerDAO;
    }

}
