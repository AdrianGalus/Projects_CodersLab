package workshop3.controller;

import workshop2.Solution;
import workshop3.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "SolutionManager", urlPatterns = {"/solutionManager"})
public class SolutionManager extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String activity = request.getParameter("activity");
        if(activity == null) {
            getServletContext().getRequestDispatcher("/panelAdmin").forward(request, response);
        }
        String description;
        int exerciseId;
        int usersId;
        Solution solution = new Solution();
        Connection conn;
        try {
            switch (activity) {
                case "add":
                    description = request.getParameter("description");
                    exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
                    usersId = Integer.parseInt(request.getParameter("usersId"));
                    solution.setDescription(description);
                    solution.setExerciseId(exerciseId);
                    solution.setUsersId(usersId);
                    conn = DbUtil.getConn();
                    solution.saveToDB(conn);
                    break;
                case "edit":
                    int id = Integer.parseInt(request.getParameter("id"));
                    description = request.getParameter("description");
                    exerciseId = Integer.parseInt(request.getParameter("exerciseId"));
                    usersId = Integer.parseInt(request.getParameter("usersId"));
                    solution.setId(id);
                    solution.setDescription(description);
                    solution.setExerciseId(exerciseId);
                    solution.setUsersId(usersId);
                    conn = DbUtil.getConn();
                    solution.saveToDB(conn);
                    break;
                case "delete":
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String activity = request.getParameter("activity");
        if(activity == null) {
            getServletContext().getRequestDispatcher("/panelAdmin").forward(request, response);
        }
        switch(activity) {
            case "add":
                request.setAttribute("activity", "add");
                break;
            case "edit":
                request.setAttribute("activity", "edit");
                break;
            case "delete":
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("activity", "delete");
                request.setAttribute("id", id);
                break;
        }
        getServletContext().getRequestDispatcher("/SolutionForm.jsp").forward(request, response);
    }
}
