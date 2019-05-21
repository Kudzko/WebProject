package by.epam.javawebtraining.controller;

import javax.servlet.http.HttpSession;
import java.util.Map;

public class SuperParam {
    private Map<String, String[]> paramMap;
    private Map<String, Object> atribMap;
    private HttpSession session;

    public SuperParam(Map<String, String[]> paramMap, Map<String, Object> atribMap, HttpSession session) {
        this.paramMap = paramMap;
        this.atribMap = atribMap;
        this.session = session;
    }
}
