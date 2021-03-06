package by.epam.javawebtraining.bean;


import by.epam.javawebtraining.dao.daointerface.IDdefinition;

import java.util.Objects;

public class Answer  extends Entity implements IDdefinition {
    private String answerText;
    private boolean right;
    private long questoinID;

    public Answer() {
    }

    public Answer(String answerText, boolean right) {
        this.answerText = answerText;
        this.right = right;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public long getQuestoinID() {
        return questoinID;
    }

    public void setQuestoinID(long questoinID) {
        this.questoinID = questoinID;
    }

    @Override
    public boolean equals(Object o) {
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        if (this == o) return true;
        Answer answer = (Answer) o;
        return right == answer.right &&
                Objects.equals(answerText, answer.answerText);
    }

    @Override
    public int hashCode() {

        return Objects.hash(answerText, right);
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerText='" + answerText + '\'' +
                ", right=" + right +
                '}';
    }
}
