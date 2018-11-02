package workshop2.controllers;

import workshop2.models.Exercise;
import workshop2.models.Solution;
import workshop2.models.User;
import workshop2.models.UserGroup;
import workshop2.utils.DbUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "PanelAdmin", urlPatterns = {"/panelAdmin"})
public class PanelAdmin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String choice = request.getParameter("choice");
        if(choice == null) {
            getServletContext().getRequestDispatcher("/PanelAdmin.jsp").forward(request, response);
        }
        Connection conn;
        try {
            switch (choice) {
                case "solution":
                    conn = DbUtil.getConn();
                    Solution[] solutions = Solution.loadAllSolutions(conn);
                    request.setAttribute("solutions", solutions);
                    break;
                case "user":
                    conn = DbUtil.getConn();
                    User[] users = User.loadAllUsers(conn);
                    request.setAttribute("users", users);
                    break;
                case "userGroup":
                    conn = DbUtil.getConn();
                    UserGroup[] userGroups = UserGroup.loadAllGroups(conn);
                    request.setAttribute("userGroups", userGroups);
                    break;
                case "exercises":
                    conn = DbUtil.getConn();
                    Exercise[] exercises = Exercise.loadAllExercises(conn);
                    request.setAttribute("exercises", exercises);
                    break;
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/PanelAdmin.jsp").forward(request, response);
    }
}
