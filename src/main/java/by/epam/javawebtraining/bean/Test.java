package by.epam.javawebtraining.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Test extends Entity{
    private User author;
    private String testName;
    private String testTheme;
    private Map<Question, List<Answer>> test;

    public Test() {
        test = new HashMap<>();
    }

    public Test(User author, String testName, Map<Question, List<Answer>> test) {
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

    public Map<Question, List<Answer>> getTest() {
        return test;
    }

    public void setTest(Map<Question, List<Answer>> test) {
        this.test = test;
    }

    public void addQuestion(Question question, List<Answer> answers) {
        test.put(question, answers);
    }

    public void deleteQuestion(Question question) {
        test.remove(question);
    }

    public void deleteQuestion(Question question, List<Answer> answers) {
        test.remove(question, answers);
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


