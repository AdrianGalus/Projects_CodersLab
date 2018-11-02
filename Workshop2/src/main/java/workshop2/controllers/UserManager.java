package workshop2.controllers;

import workshop2.models.User;
import workshop2.utils.DbUtil;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UserManager", urlPatterns = {"/userManager"})
public class UserManager extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String activity = request.getParameter("activity");
        if(activity == null) {
            response.sendRedirect("/panelAdmin");
        }
        int id;
        String userName;
        String email;
        String password;
        int userGroupId;
        User user;
        Connection conn;
        try {
            switch(activity) {
                case "add":
                    userName = request.getParameter("userName");
                    email = request.getParameter("email");
                    password = request.getParameter("password");
                    userGroupId = Integer.parseInt(request.getParameter("userGroupId"));
                    user = new User(userName, email, password, userGroupId);
                    conn = DbUtil.getConn();
                    user.saveToDB(conn);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    userName = request.getParameter("userName");
                    email = request.getParameter("email");
                    password = request.getParameter("password");
                    userGroupId = Integer.parseInt(request.getParameter("userGroupId"));
                    user = new User(userName, email, password, userGroupId);
                    user.setId(id);
                    conn = DbUtil.getConn();
                    user.saveToDB(conn);
                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    user = new User();
                    user.setId(id);
                    conn = DbUtil.getConn();
                    user.delete(conn);
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
        getServletContext().getRequestDispatcher("/UserForm.jsp").forward(request, response);
    }
}
