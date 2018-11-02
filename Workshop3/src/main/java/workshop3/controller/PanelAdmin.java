package workshop3.controller;

import workshop2.Solution;
import workshop2.User;
import workshop2.UserGroup;
import workshop3.utils.DbUtil;
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
            }
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        getServletContext().getRequestDispatcher("/PanelAdmin.jsp").forward(request, response);
    }
}
