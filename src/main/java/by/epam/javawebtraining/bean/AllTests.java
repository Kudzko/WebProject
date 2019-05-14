package by.epam.javawebtraining.bean;

import java.util.ArrayList;
import java.util.List;

public class AllTests {
    private List<Test> tests;

    public AllTests() {
        tests = new ArrayList<>();
    }

    public List<Test> getTestOlds() {
        return tests;
    }

    public void setTestOlds(List<Test> testOlds) {
        this.tests = testOlds;
    }

    public void addTest(Test testOld) {
        tests.add(testOld);
    }

    public void deleteTest(int index) {
        tests.remove(index);
    }

    public void deleteTest(Test testOld) {
        tests.remove(testOld);
    }

    @Override
    public String toString() {
        return "AllTests{" +
                "tests=" + tests +
                '}';
    }
}
