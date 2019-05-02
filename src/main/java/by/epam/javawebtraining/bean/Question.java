package by.epam.javawebtraining.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Question extends Entity{
    private String questionText;

       public Question() {
            }

    public Question(String questionText, List<Answer> answers) {
        this.questionText = questionText;
            }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }


    @Override
    public boolean equals(Object o) {
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        if (this == o) return true;
        Question question = (Question) o;
        return Objects.equals(questionText, question.questionText);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionText);
    }
}
