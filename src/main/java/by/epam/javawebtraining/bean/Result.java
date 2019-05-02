package by.epam.javawebtraining.bean;

import java.util.List;
import java.util.Map;

public class Result extends Entity{
    private Test test;
    private Map<Question, List<Boolean>> studentAnswers;
}
