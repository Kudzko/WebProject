package by.epam.javawebtraining.bean;

import by.epam.javawebtraining.dao.daointerface.IDdefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question extends Entity implements IDdefinition {
    private String questionText;
    private List<Answer> answers;
    private long testID;

       public Question() {
           answers = new ArrayList<>();
            }

    public Question(String questionText, List<Answer> answers) {
        this.questionText = questionText;
        this.answers = answers;
            }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer(Answer answer){
           answers.add(answer);
    }

    public void deleteAnswer(int index){
           answers.remove(index);
    }

    public void deleteAnswer(Answer answer){
        answers.remove(answer);
    }

    public long getTestID() {
        return testID;
    }

    public void setTestID(long testID) {
        this.testID = testID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        Question question = (Question) o;
        return Objects.equals(questionText, question.questionText) &&
                Objects.equals(answers, question.answers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(questionText, answers);
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionText='" + questionText + '\'' +
                ", answers=" + answers +
                '}';
    }
}
