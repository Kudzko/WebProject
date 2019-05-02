package by.epam.javawebtraining.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TestResults {
    private Map <User, List<Result>> testResults;


    public TestResults() {
    }

    public TestResults(Map<User, List<Result>> results) {
        this.testResults = results;
    }

    public void addTestResult(User student, List<Result> results){
        testResults.put(student, results);

    }

    public void deleteTestResult(User student, List<Result> results){
        testResults.remove(student, results);

    }

    public void deleteTestResult(User student){
        testResults.remove(student);

    }

    public void addResult (User student, Result result){
        if (testResults.containsKey(student)){
            testResults.get(student).add(result);
        }else {
            List<Result> results = new ArrayList<>();
            results.add(result);
            addTestResult(student,results );
        }
    }

    public void deleteResult(User student, Result result){
        if (testResults.containsKey(student)){
            testResults.get(student).remove(result);
        }
    }

    public Map<User, List<Result>> getResults() {
        return testResults;
    }

    public void setResults(Map<User, List<Result>> results) {
        this.testResults = results;
    }


    @Override
    public String toString() {
        return "TestResults{" +
                "testResults=" + testResults +
                '}';
    }
}
