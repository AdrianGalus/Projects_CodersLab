package workshop3.controller;

import workshop2.User;
import workshop3.utils.DbUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "UserGroupDetails", urlPatterns = {"/UserGroupDetails"})
public class UserGroupDetails extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String maybeId = request.getParameter("id");
        User[] users = new User[0];
        if(!maybeId.matches("[1-9]+[0-9]*")) {
            response.getWriter().append("Błędne id");
        }
        int groupId = Integer.parseInt(maybeId);
        try {
            Connection conn = DbUtil.getConn();
            users = User.loadAllByGroupId(conn, groupId);
        }
        catch(SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("users", users);
        getServletContext().getRequestDispatcher("/GroupDetails.jsp").forward(request, response);
    }
}
