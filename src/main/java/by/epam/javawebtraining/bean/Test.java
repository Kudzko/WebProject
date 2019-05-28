package by.epam.javawebtraining.bean;

import by.epam.javawebtraining.dao.daointerface.IDdefinition;

import java.util.*;

public class Test extends Entity implements IDdefinition {
    private User author;
    private String testName;
    private String testTheme;
    private List<Question> questionList;

    public Test() {
        questionList = new ArrayList<>();
    }

    public Test(User author, String testName, List<Question> questionList) {
        this.author = author;
        this.testName = testName;
        this.questionList = questionList;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getTestTheme() {
        return testTheme;
    }

    public void setTestTheme(String testTheme) {
        this.testTheme = testTheme;
    }

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public void addQuestion(Question question) {
        questionList.add(question);
    }

    public void deleteQuestion(Question question) {
        questionList.remove(question);
    }

    public void deleteQuestion(int index) {
        questionList.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Test test1 = (Test) o;
        return Objects.equals(author, test1.author) &&
                Objects.equals(testName, test1.testName) &&
                Objects.equals(questionList, test1.questionList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, testName, questionList);
    }

    @Override
    public String toString() {
        return "Test{" +
                "author=" + author +
                ", testName='" + testName + '\'' +
                ", questionList=" + questionList +
                '}';
    }
}


