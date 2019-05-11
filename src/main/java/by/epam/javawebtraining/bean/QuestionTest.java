package by.epam.javawebtraining.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class QuestionTest extends Entity{
    private String questionText;
    private AnswerTest answerTest;

    public QuestionTest() {
    }

    public QuestionTest(String questionText, List<Answer> answers) {
        this.questionText = questionText;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public AnswerTest getAnswerTest() {
        return answerTest;
    }

    public void setAnswerTest(AnswerTest answerTest) {
        this.answerTest = answerTest;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        if (this == o) return true;
        QuestionTest question = (QuestionTest) o;
        return Objects.equals(questionText, question.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionText);
    }
}
