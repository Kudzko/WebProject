package by.epam.javawebtraining.bean;

import by.epam.javawebtraining.dao.daointerface.IDdefinition;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Result extends Entity implements IDdefinition {
    private User student;
    private Test test;
    private double mark;

    public Result() {

    }

    public Result(User student, Test test, double mark) {
        this.student = student;
        this.test = test;
        this.mark = mark;
    }

    public Result(int id, User student, Test test, double mark) {
        super(id);
        this.student = student;
        this.test = test;
        this.mark = mark;
    }


    public User getStudent() {
        return student;
    }

    public void setStudent(User student) {
        this.student = student;
    }

    public Test getTest() {
        return test;
    }

    public void setTest(Test test) {
        this.test = test;
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        this.mark = mark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (o.getClass() != this.getClass())) return false;
        Result result = (Result) o;
        return Double.compare(result.mark, mark) == 0 &&
                Objects.equals(student, result.student) &&
                Objects.equals(test, result.test);
    }

    @Override
    public int hashCode() {

        return Objects.hash(student, test, mark);
            }

    @Override
    public String toString() {
        return "Result{" +
                "student=" + student +
                ", test=" + test +
                ", mark=" + mark +
                '}';
    }
}
