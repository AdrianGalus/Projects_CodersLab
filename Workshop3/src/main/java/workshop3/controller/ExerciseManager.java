package workshop3.controller;

import workshop2.Exercise;
import workshop3.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "ExerciseManager")
public class ExerciseManager extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String activity = request.getParameter("activity");
        if(activity == null) {
            response.sendRedirect("/panelAdmin");
        }
        int id;
        String title;
        String description;
        Exercise exercise;
        Connection conn;
        try {
            switch(activity) {
                case "add":
                    title = request.getParameter("title");
                    description = request.getParameter("description");
                    exercise = new Exercise(title, description);
                    conn = DbUtil.getConn();
                    exercise.saveToDB(conn);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    title = request.getParameter("title");
                    description = request.getParameter("description");
                    exercise = new Exercise(title, description);
                    exercise.setId(id);
                    conn = DbUtil.getConn();
                    exercise.saveToDB(conn);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    exercise = new Exercise();
                    exercise.setId(id);
                    conn = DbUtil.getConn();
                    exercise.delete(conn);
                    break;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/panelAdmin");
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SolutionManager.readActivity(request, response);
        getServletContext().getRequestDispatcher("/ExerciseForm.jsp").forward(request, response);
    }
}
