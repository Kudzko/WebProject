package by.epam.javawebtraining.controller;

import by.epam.javawebtraining.controller.Command.Command;
import by.epam.javawebtraining.utils.DBInitializator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class Controller extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request,
                                  HttpServletResponse response) throws ServletException, IOException {
        String cmd = request.getParameter("command");

        Command command = CommandManager.getCommand(cmd);
        String page = command.execute(request);

        RequestDispatcher dispatcher = request.getRequestDispatcher(page);
        dispatcher.forward(request, response);
    }

//    @Override
//    public void init() throws ServletException {
//        super.init();
//        DBInitializator dbInitializator = new DBInitializator();
//        dbInitializator.initDB();
//        System.out.println("Init Controller");
//    }
}
