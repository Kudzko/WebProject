package by.epam.javawebtraining.bean;

import by.epam.javawebtraining.dao.daointerface.IDdefinition;

import java.util.*;

public class Test extends Entity implements IDdefinition {
    private User author;
    private String testName;
    private String testTheme;
    private List<Question> test;

    public Test() {
        test = new ArrayList<>();
    }

    public Test(User author, String testName, List<Question> test) {
        this.author = author;
        this.testName = testName;
        this.test = test;
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

    public List<Question> getTest() {
        return test;
    }

    public void setTest(List<Question> test) {
        this.test = test;
    }

    public void addQuestion(Question question) {
        test.add(question);
    }

    public void deleteQuestion(Question question) {
        test.remove(question);
    }

    public void deleteQuestion(int index) {
        test.remove(index);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Test test1 = (Test) o;
        return Objects.equals(author, test1.author) &&
                Objects.equals(testName, test1.testName) &&
                Objects.equals(test, test1.test);
    }

    @Override
    public int hashCode() {

        return Objects.hash(author, testName, test);
    }

    @Override
    public String toString() {
        return "Test{" +
                "author=" + author +
                ", testName='" + testName + '\'' +
                ", test=" + test +
                '}';
    }
}


